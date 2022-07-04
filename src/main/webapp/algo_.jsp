<%@page import="com.ismail.algo.controller.PageInfo"%>
<%@page import="com.ismail.algo.config.AlgoClientConfig"%>
<%@page import="com.ismail.algo.AppClientServices"%>
<%@page import="com.ismail.algo.AlgoUtil"%>
<%@page import="com.ismail.algo.model.AlgoParamValidValue"%>
<%@page import="com.ismail.algo.model.AlgoParamDef"%>
<%@page import="com.ismail.algo.config.ColorThemeConfig"%>
<%@page import="com.ismail.algo.model.Algo"%>
<%@page import="java.util.List"%>
<%@page import="com.ismail.algo.service.AlgoClientApiService"%>
<%@page import="com.ismail.algo.AlgoClientApp"%>

<%
AppClientServices appServices = AppClientServices.getInstance();
ColorThemeConfig theme = appServices.colorTheme;
AlgoClientApiService apiService = appServices.apiService;
AlgoClientConfig algoConfig = appServices.config;


Algo algo = (Algo) request.getAttribute("algo");


%>

<br>

<% if (algo != null) { %>

<table width="100%" cellpadding=5 align="center">


<tr bgcolor="<%=theme.rawHighlight %>">
	<td align="left">
	<a href="algo.jsp?strategyID=<%=algo.getStrategyID() %>" target='_blank'>
	<font size="+1">
	<%=algo.getStrategyID() %>
	</font>	
	</a>
	</td>
</tr>

<tr>
	<td>
	<%=AlgoUtil.toHtmlFormat(algo.getShortDesc()) %>	
	</td>
</tr>


<% if (algo.getParamsCount() > 0) { %>
<!-- spacer 
<tr><td>&nbsp;</td></tr>
-->
<!-- Strategy Parameters -->
<tr><td><b>Strategy Parameters</b></td></tr>

<tr>
<td>

	<table width="100%" cellspacing=1 cellpadding=10 border=1 align="center">
	
	<tr bgcolor="<%=theme.rawHighlight %>">
		<td width="130" nowrap><b>Name</b></td>
		<td width="80%"><b>Description</b></td>
		<td  align="center"><b>Mandatory</b></td>
		<td  align="center"><b>Type</b></td>
		<td align="center"><b>Default Value</b></td>
		<td width="150"><b>Valid Values</b></td>	
	</tr>
	
	<% for (int i=0; i<algo.getParamsCount(); i++) { 
	    AlgoParamDef param = algo.getParams().get(i);
	%>
	
	<tr>
		<td valign="top" title="<%=param.getName() %>" nowrap><%=param.getLabel() %></td>
		<td valign="top">
			<%=AlgoUtil.toHtmlFormat(param.getShortDesc()) %>
			<% if (param.getDesc() != null && param.getDesc().length() > 0) { %>
				<br>
				<br>
				<%=AlgoUtil.toHtmlFormat(param.getDesc()) %>
			<% } %>
		</td>
		<td valign="top"  align="center"><%=param.isMandatory() ? "Yes" : "" %></td>
		<td valign="top"  align="center">
			<%=AlgoUtil.isDefined(param.getTypeFormat()) ? param.getTypeFormat() : param.getType() %>
		</td>
		<td valign="top"  align="center">
			<% if (AlgoUtil.isDefined(param.getDefaultValueDesc())) { %>
				<%=param.getDefaultValueDesc() %>
			<% } else if (AlgoUtil.isDefined(param.getDefaultValue())) { %>
				<%=param.getDefaultValue() %>
			<% } %>
		</td>
		
		<td valign="top" nowrap>
			<% for (int c=0; c<param.getValidValuesCount(); c++) { 
			    AlgoParamValidValue validValue = param.getValidValues().get(c);
			%>
				<li><%=validValue.getValue() %><%=AlgoUtil.isDefined(validValue.getShortDesc()) ? " - " + validValue.getShortDesc() : "" %><br> 
			<% } %>
			
		</td>
	</tr>	
	
	<% } %>
	
	</table>

</td>
</tr>
<% } %>

<!-- Execution Styles -->

<% if (algo.getParameterByName("ExecStyle") != null) {
    AlgoParamDef param = algo.getParameterByName("ExecStyle");
    %>

<!-- spacer 
<tr><td>&nbsp;</td></tr>
-->

<tr><td><b>Execution Styles</b></td></tr>

<tr>
<td>
	<% if (param.getDesc() != null && param.getDesc().trim().length() > 0) { %>
	<table width="100%" cellspacing=1 cellpadding=10 border=0 align="center">
	<tr>
		<td valign="top">
			<%=AlgoUtil.toHtmlFormat(param.getDesc().trim()) %>
		</td>
	</tr>
	</table>
	<br>
	<% } %>
	
	<table width="100%" cellspacing=1 cellpadding=10 border=1 align="center">
			
	<% for (int c=0; c<param.getValidValuesCount(); c++) { 
	    AlgoParamValidValue validValue = param.getValidValues().get(c);
	%>
	
	<tr>
		<td width="15%" valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
			<%=validValue.getShortDesc() %>
		</td>
		<td width="85%" valign="top">
			<%=AlgoUtil.toHtmlFormat(validValue.getDesc()) %>
		</td>
	</tr>	
	
	<% } %>
	
	</table>

</td>
</tr>

<% } %>


<!-- Liquidity -->

<% if (algo.getParameterByName("Liquidity") != null) {
    AlgoParamDef param = algo.getParameterByName("Liquidity");
    %>

<tr><td><b>Liquidity</b></td></tr>

<tr>
<td>
	<table width="100%" cellspacing=1 cellpadding=10 border=1 align="center">
			
	<% for (int c=0; c<param.getValidValuesCount(); c++) { 
	    AlgoParamValidValue validValue = param.getValidValues().get(c);
	%>
	
	<tr>
		<td width="15%" valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
			<%=validValue.getValue() %>
		</td>
		<td width="85%" valign="top">
			<%=AlgoUtil.toHtmlFormat(validValue.getDesc()) %>
		</td>
	</tr>	
	
	<% } %>
	
	</table>

</td>
</tr>

<% } %>


<!-- Detail Description -->

<% if (algo.getDesc() != null && algo.getDesc().trim().length() > 0) {
    %>
 
<!-- spacer -->
<tr><td>&nbsp;</td></tr>

<tr><td><b>Description</b></td></tr>

<tr>
	<td>
	<%=AlgoUtil.toHtmlFormat(algo.getDesc()) %>
	
	</td>
</tr>

<% } %>

</table>

<% } %>

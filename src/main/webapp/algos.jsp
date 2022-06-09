<%@page import="com.ismail.algo.config.AlgoClientConfig"%>
<%@page import="com.ismail.algo.controller.PageInfo"%>
<%@page import="com.ismail.algo.AppClientServices"%>
<%@page import="com.ismail.algo.AlgoUtil"%>
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

// set this page title
PageInfo pageInfo = AlgoUtil.getPageInfo(request);
pageInfo.appTitle = algoConfig.getWebMainTitle();
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Algos";

List<Algo> algoList = null;

try
{
    algoList = apiService.getAlgos();
}
catch (Throwable t)
{    
	pageInfo.setError(t);    
}
%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<br>

<% if (algoList != null) { %>

<table width="1100" align="center">

<% for (int i=0; i<algoList.size(); i++) 
{ 
Algo algo = algoList.get(i);
%>
<tr bgcolor="<%=theme.rawHighlight %>" height=25 onClick="document.location='algo.jsp?strategyID=<%=algo.getStrategyID() %>';">
	<td align="left">
	<a href="algo.jsp?strategyID=<%=algo.getStrategyID() %>">
	<b><%=algo.getStrategyID() %></b>	
	</a>
	</td>
</tr>

<tr>
	<td>
	<%=AlgoUtil.toHtmlFormat(algo.getShortDesc()) %>	
	</td>
</tr>

<tr><td>&nbsp;</td></tr>

<% } %>

</table>

<% } %>

<jsp:include page="_footer.jsp" flush="true" />


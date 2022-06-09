<%@page import="com.ismail.algo.config.AlgoClientConfig"%>
<%@page import="com.ismail.algo.controller.PageInfo"%>
<%@page import="com.ismail.algo.AlgoUtil"%>
<%@page import="com.ismail.algo.config.ColorThemeConfig"%>
<%@page import="com.ismail.algo.AppClientServices"%>
<%
AppClientServices appServices = AppClientServices.getInstance();
AlgoClientConfig algoConfig = appServices.config;
ColorThemeConfig theme = appServices.colorTheme;

PageInfo pageInfo = AlgoUtil.getPageInfo(request);

String spath = request.getServletPath();

%>

<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title><%=pageInfo.pageTitle == null ? "" : pageInfo.pageTitle %></title>
	
	<link type="image/png" sizes="16x16" rel="icon" href="images/icons/icons8-puzzle-16.png">
	
	<link type="text/css" rel="StyleSheet" media="all" href="/css/combined-<%=algoConfig.getWebColorTheme() %>.css" />

  	<script type="text/javaScript" src="/js/common.js"></script>
  		
	<style>
	.footer 
	{
		position:fixed;
		left: 0;
		bottom: 0;
		width: 100%;
		background-color: <%=theme.rawHighlight %>;
		color: white;
		height: 40px;
		text-align: center; 
		vertical-align: middle;
	}
	</style>	
</head>

<body bgcolor="<%=theme.bodyBg %>" link="<%=theme.bodyLink %>" vlink="<%=theme.bodyVisitedLink %>" alink="<%=theme.bodyActiveLink %>"
    leftmargin="0" topmargin="0"  marginwidth="0" marginheight="0"                
      >
      

<table width="100%" align="center">


<tr>
	<td style="color: <%=theme.bodyTextLight %>; background-color:<%=theme.tab0 %>; font-size: 15px;" align="center">		
		<b><%=pageInfo.appTitle %></b>
	</td>
</tr>



<!-- Success / Error messages -->            

<% if (AlgoUtil.isDefined(pageInfo.successMsg)) { %>
	<tr>
		<td align="center" style="color: <%=theme.positive %>">
			<%=pageInfo.successMsg %>
		</td>
	</tr>
<% } else if (AlgoUtil.isDefined(pageInfo.errorMsg)) { %>

	<tr>
		<td colspan=3 align="center" style="color: <%=theme.negative %>">
			<%=pageInfo.errorMsg %>
		</td>
	</tr>
	
<% } else { %>

	<tr>
		<td align="center">
		&nbsp;
		</td>
	</tr>
	
<% } %>
</table>

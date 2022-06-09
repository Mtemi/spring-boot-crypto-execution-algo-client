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

String strategyID = AlgoUtil.getParameter(request, "strategyID", "TWAP");

Algo algo = null;

//set this page title
PageInfo pageInfo = AlgoUtil.getPageInfo(request);
pageInfo.appTitle = algoConfig.getWebMainTitle();
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - " + strategyID;

try
{
    algo = apiService.getAlgoByStrategyID(strategyID);
    
    if (algo != null)
        request.setAttribute("algo", algo);
}
catch (Throwable t)
{    
	pageInfo.setError(t);    
}

%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<br>

<table width="1100" cellpadding=5 align="center">
<tr>
<td align="center">

<jsp:include page="algo_.jsp" flush="true" />

</td>
</tr>
</table>


<jsp:include page="_footer.jsp" flush="true" />


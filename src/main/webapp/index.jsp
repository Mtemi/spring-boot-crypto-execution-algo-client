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

//set this page title
PageInfo pageInfo = AlgoUtil.getPageInfo(request);
pageInfo.appTitle = algoConfig.getWebMainTitle();
pageInfo.pageTitle = algoConfig.getWebMainTitle();

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


<table width="1100" align="center">

<tr>
<td>


<h3>Welcome to <b>Algorithmic Execution Microservices Project</b></h3>	

<br>
A fullstack Algorithmic Execution Trading Application; that trades any financial market.
<p>

In this showcase; we are using Crypto Markets as the market data and trade data needed to run such an application; are freely available.
<p>

<h3>Algorithms</h3>
<p>
Execution Algos are listed in the <b>Algos</b> tab; showing:<br>
<li>Full list of available algos (new algos are added over time)
<li>Short and detailed description of the algo
<li>Strategy parameter, default values, and valid values
<li>Strategy objectives
<p>
Click on an algo to see full details.

<h3>Orders</h3>
You can try any algo by submitting a <b>New Order Request</b> and specify the algo parameters.
<p>
You can then watch the order getting filled over time; until it is done.
<p>
You can cancel and place a new order.
<p>
Orders are executed on a simulated exchange; using real live market data.


<h3>Instruments</h3>
<p>
We are providing a selected list of crypto instruments for testing purposes.
<p>
Market data is live from crypto brokers.
<p>
You can watch live market data in the <b>Top Of Book Live</b> tab.
<p>

<h3>Algo Suggestions</h3>
If you have a suggestion on a new algo; or tweaking existing algo; send us your recommendations; and we will assess and implement it.

<p>
<p>

<h3>Github Code base</h3>
Source code for this project is available on my GitHub:
<p>
<a href="https://github.com/ismailfer/algo-client-springboot" target="_blank">
https://github.com/ismailfer/algo-client-springboot
</a>

</td>
</tr>



</table>


<jsp:include page="_footer.jsp" flush="true" />


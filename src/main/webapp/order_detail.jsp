<%@page import="com.ismail.algo.DateUtil"%>
<%@page import="com.ismail.algo.model.OrderCancelResponse"%>
<%@page import="com.ismail.algo.model.OrderCancelRequest"%>
<%@page import="com.ismail.algo.controller.PageInfo"%>
<%@page import="com.ismail.algo.model.TopOfBook"%>
<%@page import="com.ismail.algo.model.AlgoParamValue"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ismail.algo.model.Order"%>
<%@page import="com.ismail.algo.model.Instrument"%>
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

long orderID = AlgoUtil.getParameterAsLong(request, "orderID");

String act = AlgoUtil.getParameter(request, "act", null);

//set this page title
PageInfo pageInfo = AlgoUtil.getPageInfo(request);
pageInfo.appTitle = algoConfig.getWebMainTitle();
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Order Detail ";

Order order = null;
Instrument inst = null;

SimpleDateFormat formatter = DateUtil.getFormatter("yyyyMMdd HH:mm:ss", "GMT");

try
{
	order = apiService.getOrderByOrderID(orderID);
	
	if (order != null)
	{
	    inst = apiService.getInstrumentByInsID(order.getInstrumentID());
	   
	    request.setAttribute("order", order);
	    request.setAttribute("instrument", inst);
	}
	
	if ("cancel".equals(act))
	{
	    // Cancel this order

        OrderCancelResponse cancelResp = apiService.cancelOrder(order.getClientID(), order.getClientOrderID(), order.getOrderID());

        if (cancelResp.isSuccess())
        {
            pageInfo.successMsg = "Order Cancel Request sent successfully";
        }
        else
        {
            pageInfo.errorMsg = "Cancel request rejected: " + cancelResp.getCancelRejectReason();
        }

	}
}
catch (Throwable t)
{    
	pageInfo.setError(t);    
}


%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<% if (order != null) { %>

<jsp:include page="order_header.jsp" flush="true" />

<br>


<!--  Algo Params -->

<table width="600" cellspacing=2>
<tr bgcolor="<%=theme.headerBg %>" height="25">
	<td colspan=2 align="center">Algo Parameters</td>
</tr>    

<tr>
    <td bgcolor="<%=theme.rawHighlight %>" width="200"><b>Strategy ID</b></td>
    <td> <%=order.getAlgoStrategyID() %> </td>
</tr>
    
<% if (order.getAlgoParams() != null) { %>    
    
    <% for (AlgoParamValue param : order.getAlgoParams()) { %>
    <tr>
        <td bgcolor="<%=theme.rawHighlight %>"><b><%=param.getName() %></b></td>
        <td>
        	<%=param.getValue() %>
        	<% if (param.getValueDesc() != null && !param.getValueDesc().equals(param.getValue())) { %>
        		- <%=param.getValueDesc() %>
        	<% } %>
        </td>        
    </tr>
    <% } %>
      
<% } %> 

</table>
    
    
    
<% } %>
	



<jsp:include page="_footer.jsp" flush="true" />


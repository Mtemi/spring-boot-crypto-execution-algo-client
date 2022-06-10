<%@page import="com.ismail.algo.model.Trade"%>
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

//set this page title
PageInfo pageInfo = AlgoUtil.getPageInfo(request);
pageInfo.appTitle = algoConfig.getWebMainTitle();
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Order Trades";

Order order = null;
Instrument inst = null;

List<Trade> trades = null;

SimpleDateFormat formatter = AlgoUtil.getFormatter("yyyyMMdd HH:mm:ss", "GMT");

try
{
	order = apiService.getOrderByOrderID(orderID);
	
	if (order != null)
	{
	    inst = apiService.getInstrumentByInsID(order.getInstrumentID());
		   
	    request.setAttribute("order", order);
	    request.setAttribute("instrument", inst);
		
	    trades = apiService.getTradesByParentOrderID(orderID, 1000);
	}
}
catch (Throwable t)
{    
	pageInfo.setError(t);    
}


%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<% 
if (order != null) 
{    
    TopOfBook tob = inst.getTopOfBook();
    
    double doneQtyPct = order.getQuantity() > 0.0 ? (100.0 * order.getQuantityFilled() / order.getQuantity()) : 0.0;
        
        
%>

<jsp:include page="order_header.jsp" flush="true" />

<br>

<table width="1000" cellpadding=5 align="center">

<tr>
	<td colspan="9" align="center" style="font-size: 20px;">
		<b>Trades</b>
	</td>
</tr>

<tr bgcolor="<%=theme.headerBg %>">
	<td><b>#</b></td>
	<td><b>Trade Time</b></td>
	<td><b>TradeID</b></td>
	<td><b>Instrument</b></td>
	<td><b>Side</b></td>	
	<td align="right"><b>Quantity</b></td>
	<td align="right"><b>Price</b></td>
	<td align="right"><b>%<br>of Order</b></td>
	<td align="right"><b>Trading Venue</b></td>
</tr>

<% 
for (int i=0; i<trades.size(); i++) 
{
	Trade trade = trades.get(i);    
	
	int rowNum = trades.size() - i;
	
	double pctOfOrder = 100.0 * trade.getQuantity() / order.getQuantity();
%>

<tr bgcolor="<%=(i % 2 == 1) ? theme.rawHighlight : theme.raw %>">

	<td ><%=rowNum %></td>
	<td ><%=formatter.format(trade.getTradeTime()) %></td>
	<td ><%=trade.getTradeID() %></td>
	
	<td ><%=trade.getInstrumentID() %></td>
	
	<td ><%=trade.getSide() %></td>
	
	<td align="right"><%=AlgoUtil.numericFormat(trade.getQuantity(), inst.getQuantityDecimals()) %></td>
	<td align="right"><%=AlgoUtil.numericFormat(trade.getPrice(), inst.getPriceDecimals()) %></td>

	<td align="right"><%=AlgoUtil.numericFormat(pctOfOrder, 2) %></td>

	<td align="right"><%=trade.getVenue() == null ? "" : trade.getVenue() %></td>

</tr>	

<% } %>

</table>

<% } %>

<jsp:include page="_footer.jsp" flush="true" />


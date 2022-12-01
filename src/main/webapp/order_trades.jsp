<%@page import="com.ismail.algo.DateUtil"%>
<%@page import="org.apache.http.client.utils.DateUtils"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.ismail.algo.model.TradesResult"%>
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

int[] PAGE_SIZE_LIST = {10, 20, 50, 100, 200};
int pageNum = AlgoUtil.getParameterAsInt(request, "pageNum", 1);
int pageSize = AlgoUtil.getParameterAsInt(request, "pageSize", 20);

long orderID = AlgoUtil.getParameterAsLong(request, "orderID");

//set this page title
PageInfo pageInfo = AlgoUtil.getPageInfo(request);
pageInfo.appTitle = algoConfig.getWebMainTitle();
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Order Trades";


Order order = null;
Instrument inst = null;

TradesResult result = null;
int pageCount = 1;

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss.SSSSSS").withZone(ZoneId.systemDefault());

try
{
	order = apiService.getOrderByOrderID(orderID);
	
	if (order != null)
	{
	    inst = apiService.getInstrumentByInsID(order.getInstrumentID());
		   
	    request.setAttribute("order", order);
	    request.setAttribute("instrument", inst);
		
	    result = apiService.getTradesByParentOrderID(orderID, pageNum, pageSize);
	    
	    pageCount = (result == null ? 1 : result.pageCount);
	    
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

<table width="80%" cellpadding=5 align="center">
<form name="frm">
<tr>
	<td width="30%">
	<b><%=AlgoUtil.decimal(order.getTradesCount(), 0) %></b> trades
	</td>
	
	<td width="40%" align="center" style="font-size: 20px;">
		<b>Trades</b>
	</td>
	
	<td width="30%" align="right" title="Max Records to fetch">
		<b>Page Number: </b>
		<select name="pageNum" style="width: 80px;" onChange="fnReload();">
		<% for (int item=1; item<=pageCount; item++) { %>
			<option value="<%=item %>" <%=item == pageNum ? "selected" : "" %>><%=item %>
		<% } %>
		</select>
		
		
		<b>Page Size: </b>
		<select name="pageSize" style="width: 80px;" onChange="fnReload();">
		<% for (int item : PAGE_SIZE_LIST) { %>
			<option value="<%=item %>" <%=item == pageSize ? "selected" : "" %>><%=item %>
		<% } %>
		</select>
	</td>
</tr>
</form>
</table>

<table width="80%" cellpadding=5 align="center">

<tr bgcolor="<%=theme.headerBg %>">
	<td><b>Trade Time</b></td>
	<td align="center"><b>TradeID</b></td>
	<td align="center"><b>Child OrderID</b></td>
	
	<td><b>Instrument</b></td>
	<td><b>Side</b></td>	
	<td align="right"><b>Quantity</b></td>
	<td align="right"><b>Price</b></td>
	<td align="right"><b>% of Order</b></td>
	<td align="right"><b>Trading Venue</b></td>
</tr>

<% 
for (int i=0; result != null && i<result.pageRecordCount; i++) 
{
	Trade trade = result.trades.get(i);    
	
	int rowNum = result.pageRecordCount - i;
	
	double pctOfOrder = 100.0 * trade.getQuantity() / order.getQuantity();
%>

<tr bgcolor="<%=(i % 2 == 1) ? theme.rawHighlight : theme.raw %>">

	<td ><%=DateUtil.formatNano(trade.getTradeTime(), formatter) %></td>
	
	<td align="center"><%=trade.getTradeID() %></td>

	<td align="center"><%=trade.getChildOrderID() %></td>
	
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


<script type="text/javascript">
function fnReload()
{
	var url = '<%=request.getServletPath() %>?orderID=<%=orderID %>';
	url += '&pageSize=' + frm.pageSize.value;
	url += '&pageNum=' + frm.pageNum.value;
	
	document.location = url;
}
</script>

<jsp:include page="_footer.jsp" flush="true" />


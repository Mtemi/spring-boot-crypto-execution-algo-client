<%@page import="java.time.ZoneId"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.ismail.algo.model.ChildOrdersResult"%>
<%@page import="com.ismail.algo.model.ChildOrder"%>
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
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Order Childs";


Order order = null;
Instrument inst = null;

ChildOrdersResult result = null;
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
		
	    result = apiService.getChildOrdersByParentOrderID(orderID, pageNum, pageSize);
	    
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

<table width="100%" cellpadding=5 align="center">
<form name="frm">
<tr>
	<td width="25%">
	<b><%=AlgoUtil.decimal(order.getChildOrdersCount(), 0) %></b> child orders
	</td>
	
	<td width="50%" align="center" style="font-size: 20px;">
		<b>Child Orders</b>
	</td>
	
	<td width="25%" align="right" title="Max Records to fetch">
		<b>Page Number: </b>
		<select name="pageNum" style="width: 100px;" onChange="fnReload();">
		<% for (int item=1; item<=pageCount; item++) { %>
			<option value="<%=item %>" <%=item == pageNum ? "selected" : "" %>><%=item %>
		<% } %>
		</select>
		
		
		<b>Page Size: </b>
		<select name="pageSize" style="width: 100px;" onChange="fnReload();">
		<% for (int item : PAGE_SIZE_LIST) { %>
			<option value="<%=item %>" <%=item == pageSize ? "selected" : "" %>><%=item %>
		<% } %>
		</select>
	</td>
</tr>
</form>
</table>

<table width="100%" cellpadding=5 align="center">

<tr bgcolor="<%=theme.headerBg %>">
	<td rowspan="2" align="center"><b>Child<br>OrderID</b></td>
	
	<td rowspan="2" ><b>Order Time</b></td>
	

	<td rowspan="2" ><b>Primary<br>Status</b></td>
	<td rowspan="2" ><b>Secondary<br>Status</b></td>	
	<td rowspan="2" ><b>Instrument</b></td>
	<td rowspan="2" ><b>Side</b></td>	
	<td rowspan="2" ><b>Order Type</b></td>
	<td rowspan="2" ><b>Time in Force</b></td>
	<td rowspan="2" align="right"><b>Quantity</b></td>
	<td rowspan="2" align="right"><b>Price</b></td>
	<td rowspan="2" align="right"><b>%<br>of Order</b></td>

	<td rowspan="2" align="right"><b>Quantity<br>Filled</b></td>
	<td rowspan="2" align="right"><b>Average<br>Price</b></td>

	<td rowspan="2" align="right"><b>Trading Venue</b></td>

	<td rowspan="2" align="right"><b>Order<br>Age</b></td>
	<td rowspan="1" colspan="3" align="right"><b>Latency Stats</b></td>
	
</tr>

<tr bgcolor="<%=theme.headerBg %>">



	<!--  Latency Stats -->
	<td align="right"><b>Ack</b></td>	
	<td align="right"><b>First<br>Trade</b></td>
		
</tr>

<% 
for (int i=0; result != null && i<result.pageRecordCount; i++) 
{
    ChildOrder child = result.childOrders.get(i);    
	
	int rowCount = result.pageRecordCount - i;
	
	double pctOfOrder = 100.0 * child.getQuantity() / order.getQuantity();

    String rowColorBg = (rowCount % 2 == 0) ? theme.rawHighlight : theme.raw;
    
    //String primaryStatusBgColor = AlgoUtil.getBgColorByPrimaryStatus(child.isActive());
    String primaryStatusColor = theme.getBgColorByPrimaryStatus(child.isActive()); 
    String primaryStatusBgColor = rowColorBg;

    String secStatusColor = theme.getBgColorBySecondaryStatus(child.getStatus(), theme.bodyText);
    String secStatusBgColor = rowColorBg;

    long orderAgeNanos = child.updatedTime - child.createdTime;

    long ackLatency = child.acceptedTime == 0L ?  0L : child.acceptedTime - child.createdTime;
    long firstTradeLatency = child.firstTradeTime == 0L ?  0L : child.firstTradeTime - child.createdTime;
    
    //System.out.println(child);
%>

<tr bgcolor="<%=rowColorBg %>">

	<td align="center"><%=child.getChildOrderID() %></td>

	<td ><%=AlgoUtil.formatNano(child.getCreatedTime(), formatter) %></td>


	

	<td align="center" bgcolor="<%=primaryStatusBgColor %>" style="color: <%=primaryStatusColor %>;">	
		<%=child.isActive() ? "Active" : "Closed" %>
	</td>
			
	<td align="center" bgcolor="<%=secStatusBgColor %>" style="color: <%=secStatusColor %>;" >
		<%=child.getStatus() %>
	</td>
	
	<td ><%=child.getInstrumentID() %></td>


	<td ><%=child.getSide() %></td>

	<td >
		<%=child.getOrderTypeDesc() %>
	</td>
	
	<td >
		<%=child.getTimeInForceDesc() %>
	</td>
		
	<td align="right"><%=AlgoUtil.numericFormat(child.getQuantity(), inst.getQuantityDecimals()) %></td>
	<td align="right"><%=child.getPrice() == 0.0 ? "" : AlgoUtil.numericFormat(child.getPrice(), inst.getPriceDecimals()) %></td>

	<td align="right"><%=AlgoUtil.numericFormat(pctOfOrder, 2) %></td>

	<td align="right"><%=child.getQuantityFilled() == 0.0 ? "" : AlgoUtil.numericFormat(child.getQuantityFilled(), inst.getQuantityDecimals()) %></td>
	<td align="right"><%=child.getQuantityFilled() == 0.0 ? "" : AlgoUtil.numericFormat(child.getAveragePrice(), inst.getPriceDecimals()) %></td>


	<td align="right"><%=child.getLastTradeVenue() == null ? "" : child.getLastTradeVenue() %></td>

	<td align="right">
		<% if (orderAgeNanos < 1000000L) { %>
			<%=orderAgeNanos == 0 ? "" : AlgoUtil.numericFormat(orderAgeNanos / 1000.0, 0) + "us" %>
		<% } else { %>
			<%=AlgoUtil.getOrderAge(orderAgeNanos / 1000000L) %>
		<% } %>
	</td>
	
	
	<td align="right" title="<%=AlgoUtil.numericFormat(ackLatency / 1000.0, 3) %> Microseconds">
		<% if (ackLatency < 1000000L) { %>
			<%=ackLatency == 0 ? "" : AlgoUtil.numericFormat(ackLatency / 1000.0, 0) + "us" %>
		<% } else { %>
			<%=AlgoUtil.getOrderAge(ackLatency / 1000000L) %>
		<% } %>
	</td>
	
	<td align="right" title="<%=AlgoUtil.numericFormat(firstTradeLatency / 1000.0, 3) %> Microseconds">
		<% if (firstTradeLatency < 1000000L) { %>
			<%=firstTradeLatency == 0 ? "" : AlgoUtil.numericFormat(firstTradeLatency / 1000.0, 0) + "us" %>
		<% } else { %>
			<%=AlgoUtil.getOrderAge(firstTradeLatency / 1000000L) %>
		<% } %>
	</td>
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


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

List<ChildOrder> childOrders = null;
int pageCount = 1;

SimpleDateFormat formatter = AlgoUtil.getFormatter("yyyyMMdd HH:mm:ss", "GMT");

try
{
	order = apiService.getOrderByOrderID(orderID);
	
	if (order != null)
	{
	    if (pageSize > 0)
	    	pageCount = (int) Math.ceil((double) order.getChildOrdersCount() / (double) pageSize);
	    
	    inst = apiService.getInstrumentByInsID(order.getInstrumentID());
		   
	    request.setAttribute("order", order);
	    request.setAttribute("instrument", inst);
		
	    childOrders = apiService.getChildOrdersByParentOrderID(orderID, pageNum, pageSize);
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
	<%=order.getChildOrdersCount() %> child orders
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
	<td><b>Order Time</b></td>
	<td align="right"><b>Order<br>Age</b></td>	
	<td align="center"><b>Child<br>OrderID</b></td>
	<td><b>Primary<br>Status</b></td>
	<td><b>Secondary<br>Status</b></td>	
	<td><b>Instrument</b></td>
	<td><b>Side</b></td>	
	<td><b>Order Type</b></td>
	<td><b>Time in Force</b></td>
	<td align="right"><b>Quantity</b></td>
	<td align="right"><b>Price</b></td>
	<td align="right"><b>%<br>of Order</b></td>

	<td align="right"><b>Quantity<br>Filled</b></td>
	<td align="right"><b>Average<br>Price</b></td>

	<td align="right"><b>Trading Venue</b></td>
</tr>

<% 
for (int i=0; childOrders != null && i<childOrders.size(); i++) 
{
    ChildOrder child = childOrders.get(i);    
	
	int rowCount = childOrders.size() - i;
	
	double pctOfOrder = 100.0 * child.getQuantity() / order.getQuantity();

    String rowColorBg = (rowCount % 2 == 0) ? theme.rawHighlight : theme.raw;
    
    //String primaryStatusBgColor = AlgoUtil.getBgColorByPrimaryStatus(child.isActive());
    String primaryStatusColor = theme.getBgColorByPrimaryStatus(child.isActive()); 
    String primaryStatusBgColor = rowColorBg;

    String secStatusColor = theme.getBgColorBySecondaryStatus(child.getStatus(), theme.bodyText);
    String secStatusBgColor = rowColorBg;

%>

<tr bgcolor="<%=rowColorBg %>">

	<td ><%=formatter.format(child.getCreatedTime()) %></td>

	<td align="right">
		<%=AlgoUtil.getOrderAge(child.getUpdatedTime() - child.getCreatedTime()) %>
	</td>
	
	<td align="center"><%=child.getChildOrderID() %></td>

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


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

//set this page title
PageInfo pageInfo = AlgoUtil.getPageInfo(request);
pageInfo.appTitle = algoConfig.getWebMainTitle();
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Orders";


int maxRecs = 100;

List<Order> orders = null;

Map<String,Instrument> instrumentsMap = null;

SimpleDateFormat formatter = AlgoUtil.getFormatter("yyyyMMdd HH:mm:ss", "GMT");

try
{
    orders = apiService.getOrders(maxRecs);

	// sort by descending order
    if (orders.size() > 1)
        Collections.sort(orders, (o1, o2) -> -1 * Long.compare(o1.getCreatedTime(), o2.getCreatedTime()));

	if (orders.size() > 0)
    	instrumentsMap = apiService.getInstrumentsMapByID();
}
catch (Throwable t)
{    
	pageInfo.setError(t);    
}
%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<br>

<table width="100%" cellpadding=5 align="center">


<% if (orders != null) { %>


<tr bgcolor="<%=theme.headerBg %>">
	<td rowspan="2"><b>OrderID</b></td>
	<td rowspan="2"><b>Received<br>Time</b></td>
	<td rowspan="2" align="right"><b>Order<br>Age</b></td>
	<td rowspan="2"><b>ClientID</b></td>
	<td rowspan="2"><b>Client<br>OrderID</b></td>
	
	<td colspan="3" rowspan="1" align="center"><b>Instrument</b></td>
	<td rowspan="2" align="center"><b>Primary<br>State</b></td>
	<td rowspan="2" align="center"><b>Secondary<br>State</b></td>


	<td colspan=2 rowspan="1" align="center"><b>Algo</b></td>



	<td colspan="5" rowspan="1" align="center"><b>Order Request</b></td>
	
	<td colspan="6" rowspan="1" align="center"><b>Execution</b></td>

</tr>

<tr bgcolor="<%=theme.headerBg %>">

	<td align="left"><b>ID</b></td>
	<td align="right"><b>Bid</b></td>
	<td align="right"><b>Ask</b></td>
	
	<!--  Algo -->
	
	<td align="center"><b>StrategyID</b></td>	
	<td align="center"><b>Execution<br>Style</b></td>
		
	<!--  request -->
	
	<td><b>Side</b></td>	
	<td><b>OrderType</b></td>
	<td><b>TIF</b></td>
	<td align="right"><b>Quantity</b></td>
	<td align="right"><b>Price</b></td>

	<!--  Execution -->
	
	<td align="right"><b>Average<br>Price</b></td>
	<td align="right"><b>Done<br>Quantity</b></td>
	<td align="right"><b>Done<br>%</b></td>
	<td align="center"><b>Trades<br>Count</b></td>
	<td align="center"><b>Child<br>Orders</b></td>
	<td align="center"><b>Trading<br>Venue</b></td>

</tr>


<% 
int rowCount=0;
for (int i=0; i<orders.size(); i++) 
{ 
    Order order = orders.get(i);
    
    // get instrument for this order
    Instrument inst = instrumentsMap.get(order.getInstrumentID());
    TopOfBook tob = order.getTopOfBook();
            
    double doneQtyPct = order.getQuantity() > 0.0 ? (100.0 * order.getQuantityFilled() / order.getQuantity()) : 0.0;
    
    rowCount++;
    
    String rowColorBg = (rowCount % 2 == 0) ? theme.rawHighlight : theme.raw;
    
    //String primaryStatusBgColor = AlgoUtil.getBgColorByPrimaryStatus(order.isActive());
    String primaryStatusColor = theme.getBgColorByPrimaryStatus(order.isActive()); 
    String primaryStatusBgColor = rowColorBg;

    String secStatusColor = theme.getBgColorBySecondaryStatus(order.getStatus(), theme.bodyText);
    String secStatusBgColor = rowColorBg;

    //String primaryStatusColor = theme.bodyBg;
    //String primaryStatusBgColor = order.isActive() ? theme.bgPositive : theme.bodyTextLight2;
    
    //String secStatusColor = theme.bodyBg;
    //String secStatusBgColor = AlgoUtil.getBgColorBySecondaryStatus(order.getStatus(), theme.bodyText);
    
    AlgoParamValue execStyleParam = order.getParamByName("ExecStyle");
    
    String orderDetailLink = "order_detail.jsp?orderID=" + order.getOrderID();
%>

<tr bgcolor="<%=rowColorBg %>">

	<td >
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getOrderID() %>
		</a>
	</td>
	<td >
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=formatter.format(order.getCreatedTime()) %>
		</a>
	</td>

	<td align="right" title="<%=order.getUpdatedTime() - order.getCreatedTime() %> ms">
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=AlgoUtil.getOrderAge(order.getUpdatedTime() - order.getCreatedTime()) %>
		</a>
	</td>
			
	<td >
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getClientID() %>
		</a>
	</td>

	<td >
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getClientOrderID() %>
		</a>
	</td>
		
	<td >
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getInstrumentID() %>
		</a>
	</td>
	<td align="right">
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bid %>;" target="_blank">
		<%=AlgoUtil.numericFormat(tob.getBid(), inst.getPriceDecimals()) %>
		</a>
	</td>
	<td align="right">
		<a href="<%=orderDetailLink %>" style="color: <%=theme.ask %>;" target="_blank">		
		<%=AlgoUtil.numericFormat(tob.getAsk(), inst.getPriceDecimals()) %>
		</a>
	</td>
	
	
	<td align="center" bgcolor="<%=primaryStatusBgColor %>">
	
		<a href="<%=orderDetailLink %>" style="color: <%=primaryStatusColor %>;" target="_blank">
		<%=order.isActive() ? "Active" : "Closed" %>
		</a>
	</td>
		
	<td align="center" bgcolor="<%=secStatusBgColor %>" >
		<a href="<%=orderDetailLink %>" style="color: <%=secStatusColor %>;" target="_blank">
		<%=order.getStatus() %>
		</a>
	</td>

	<!--  Algo detail -->
	
	<td align="center">
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getAlgoStrategyID() %>
		</a>
	</td>

	<td align="center">
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;"  target="_blank">
		<%=(execStyleParam == null || execStyleParam.getValueDesc() == null) ? "" : execStyleParam.getValueDesc() %>
		</a>
	</td>
	
	
	
	
	<!--  order request -->

	<td >
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getSide() %>
		</a>
	</td>
	
	<td >
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getOrderTypeDesc() %>
		</a>
	</td>
	
	<td >
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getTimeInForceDesc() %>
		</a>
	</td>
	
	<td align="right">
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=AlgoUtil.numericFormat(order.getQuantity(), inst.getQuantityDecimals()) %>
		</a>
	</td>
	<td align="right">
		<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
		<%=order.getPrice() == 0.0 ? "" : AlgoUtil.numericFormat(order.getPrice(), inst.getPriceDecimals()) %>
		</a>
	</td>

	<!--  execution detail -->
	<% if ("Rejected".equals(order.getStatus())) { %>
		<td align="left" colspan="6">
			<a href="<%=orderDetailLink %>" style="color: <%=theme.negative %>;" target="_blank">
			<%=order.getRejectReason() == null ? "" : order.getRejectReason() %>
			</a>
		</td>	
	<% } else { %>
		<td align="right">
			<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
			<%=order.getAveragePrice() == 0.0 ? "" : AlgoUtil.numericFormat(order.getAveragePrice(), inst.getPriceDecimals() + 2) %>
			</a>
		</td>
		<td align="right">
			<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
			<%=order.getQuantityFilled() == 0.0 ? "" : AlgoUtil.numericFormat(order.getQuantityFilled(), inst.getQuantityDecimals()) %>
			</a>
		</td>
		<td align="right">
			<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
			<%=doneQtyPct == 0.0 ? "" : AlgoUtil.numericFormat(doneQtyPct, 2) %>
			</a>
		</td>
		<td align="center">
			<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
			<%=order.getTradesCount() == 0 ? "" : order.getTradesCount() %>
			</a>
		</td>
		<td align="center">
			<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
			<%=order.getChildOrdersCount() == 0 ? "" : order.getChildOrdersCount() %>
			</a>
		</td>
		
		<td align="center">
			<a href="<%=orderDetailLink %>" style="color: <%=theme.bodyText %>;" target="_blank">
			<%=order.getLastTradeVenue() == null ? "" : order.getLastTradeVenue() %>
			</a>
		</td>		
	<% } %>

</tr>	

<% } %>

</table>

<% } %>


<jsp:include page="_footer.jsp" flush="true" />


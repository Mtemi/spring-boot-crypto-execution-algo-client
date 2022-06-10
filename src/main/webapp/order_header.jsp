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

PageInfo pageInfo = AlgoUtil.getPageInfo(request);

Order order = (Order) request.getAttribute("order");
Instrument inst = (Instrument) request.getAttribute("instrument");

String spath = request.getServletPath();

SimpleDateFormat formatter = AlgoUtil.getFormatter("yyyyMMdd HH:mm:ss", "GMT");

try
{
	
}
catch (Throwable t)
{    
	pageInfo.setError(t);    
}

%>


<br>

<% if (order != null) { %>

<!-- Parent View Menu -->

<table width="1200" align="center" cellspacing=0 cellpadding=2>
<tr><td height=4></td>

<tr height="25">
    <td width="30%">
    	<b>#<%=order.getOrderID() %></b>
    </td>

    <td width=2></td>   
    <td align="center" bgcolor=<%=spath.equals("/order_detail.jsp") ? theme.tabs : theme.tab %> >
        &nbsp;&nbsp;<a href="/order_detail.jsp?orderID=<%=order.getOrderID() %>" style="color: <%=theme.tab0Text %>;">Order Detail</a>&nbsp;&nbsp;       
    </td>

                    
    <td width=2></td>   
    <td align="center" bgcolor=<%=spath.equals("/order_trades.jsp") ? theme.tabs : theme.tab %> >
        <a href="/order_trades.jsp?orderID=<%=order.getOrderID() %>" style="color: <%=theme.tab0Text %>;">Trades (<%=order.getTradesCount() %>)</a>       
    </td>

	<% if (order.isActive()) { %>
    <td width=2></td>   
    <td align="center" bgcolor=<%=spath.equals("/order_detail.jsp?act=cancel") ? theme.tabs : theme.tab %> >
        &nbsp;&nbsp;<a href="javascript:fnCancelParent();" style="color: <%=theme.tab0Text %>;">Cancel Order</a>&nbsp;&nbsp;       
    </td>
    <% } %>
        
            
    <td width=30%></td>         
</tr>

<tr><td colspan="20" height=4 bgcolor=<%=theme.tabs %>></td>

</table>

<br>

<!--  Show summary row -->

<% 
TopOfBook tob = inst.getTopOfBook();

double doneQtyPct = order.getQuantity() > 0.0 ? (100.0 * order.getQuantityFilled() / order.getQuantity()) : 0.0;

String primaryStatusColor = theme.getBgColorByPrimaryStatus(order.isActive());
String primaryStatusBgColor = theme.bodyBg;

String secStatusColor = theme.getBgColorBySecondaryStatus(order.getStatus(), theme.bodyText);
String secStatusBgColor = theme.bodyBg;

AlgoParamValue execStyleParam = order.getParamByName("ExecStyle");
        
%>

<table width="100%" cellpadding=5 align="center">

<tr bgcolor="<%=theme.headerBg %>">
	<td rowspan="2"><b>OrderID</b></td>
	<td rowspan="2"><b>Received<br>Time</b></td>
	<td rowspan="2" align="right"><b>Order<br>Age</b></td>
	
	<td rowspan="2"><b>ClientID</b></td>
	<td colspan="3" rowspan="1" align="center"><b>Instrument</b></td>
	
	<td rowspan="2" align="center"><b>Primary<br>Status</b></td>
	<td rowspan="2" align="center"><b>Secondary<br>Status</b></td>

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



<tr>

	<td ><%=order.getOrderID() %></td>
	<td ><%=formatter.format(order.getCreatedTime()) %></td>
	
	<td align="right" title="<%=order.getUpdatedTime() - order.getCreatedTime() %> ms">
		<%=AlgoUtil.getOrderAge(order.getUpdatedTime() - order.getCreatedTime()) %>
	</td>
		
	<td ><%=order.getClientID() %></td>
	
	<td ><%=order.getInstrumentID() %></td>
	<td align="right" style="color: <%=theme.bid %>;">
		<%=AlgoUtil.numericFormat(tob.getBid(), inst.getPriceDecimals()) %>
	</td>
	<td align="right" style="color: <%=theme.ask %>;">
		<%=AlgoUtil.numericFormat(tob.getAsk(), inst.getPriceDecimals()) %>
	</td>
	
	
	<td align="center" style="color: <%=primaryStatusColor %>; background-color: <%=primaryStatusBgColor %>;">
		<%=order.isActive() ? "Active" : "Closed" %>
	</td>
	
	<td align="center" style="color: <%=secStatusColor %>; background-color: <%=secStatusBgColor %>;">
		<%=order.getStatus() %>
	</td>

	<!--  Algo detail -->
	
	<td align="center">
		<%=order.getAlgoStrategyID() %>
	</td>

	<td align="center">
		<%=(execStyleParam == null || execStyleParam.getValueDesc() == null) ? "" : execStyleParam.getValueDesc() %>
	</td>
	
	
	
	
	<!--  order request -->

	<td ><%=order.getSide() %></td>
	
	<td ><%=order.getOrderTypeDesc() %></td>
	<td ><%=order.getTimeInForceDesc() %></td>
	
	<td align="right"><%=AlgoUtil.numericFormat(order.getQuantity(), inst.getQuantityDecimals()) %></td>
	<td align="right"><%=order.getPrice() == 0.0 ? "" : AlgoUtil.numericFormat(order.getPrice(), inst.getPriceDecimals()) %></td>

	<!--  execution detail -->
	<% if ("Rejected".equals(order.getStatus())) { %>
		<td align="left" colspan="6" style="color: <%=theme.negative %>;">
			<%=order.getRejectReason() == null ? "" : order.getRejectReason() %>
		</td>	
	<% } else { %>
		<td align="right"><%=order.getAveragePrice() == 0.0 ? "" : AlgoUtil.numericFormat(order.getAveragePrice(), inst.getPriceDecimals() + 2) %></td>
		<td align="right"><%=order.getQuantityFilled() == 0.0 ? "" : AlgoUtil.numericFormat(order.getQuantityFilled(), inst.getQuantityDecimals()) %></td>
		<td align="right"><%=doneQtyPct == 0.0 ? "" : AlgoUtil.numericFormat(doneQtyPct, 2) %></td>
		<td align="center"><%=order.getTradesCount() == 0 ? "" : order.getTradesCount() %></td>
		<td align="center"><%=order.getChildOrdersCount() == 0 ? "" : order.getChildOrdersCount() %></td>
		
		<td align="center">
			<%=order.getLastTradeVenue() == null ? "" : order.getLastTradeVenue() %>
		</td>
				
	<% } %>

</tr>	

</table>


<script type="text/javascript">
function fnCancelParent()
{
	if (window.confirm('Are you sure to cancel order #<%=order.getOrderID() %> ?'))
	{
		document.location='order_detail.jsp?orderID=<%=order.getOrderID() %>&act=cancel';	
	}
}
</script>


<% } %>




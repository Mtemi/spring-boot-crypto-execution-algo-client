<%@page import="com.ismail.algo.DateUtil"%>
<%@page import="com.ismail.algo.model.TopOfBook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ismail.algo.controller.PageInfo"%>
<%@page import="java.util.Map"%>
<%@page import="com.ismail.algo.AppClientServices"%>
<%@page import="com.ismail.algo.model.BusinessApiException"%>
<%@page import="com.ismail.algo.model.NewOrderResponse"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ismail.algo.model.AlgoParamValue"%>
<%@page import="com.ismail.algo.model.OrderSide"%>
<%@page import="com.ismail.algo.model.TimeInForce"%>
<%@page import="com.ismail.algo.model.OrderType"%>
<%@page import="com.ismail.algo.config.AlgoClientConfig"%>
<%@page import="com.ismail.algo.model.NewOrderRequest"%>
<%@page import="com.ismail.algo.model.Instrument"%>
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
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - New Order";


String strategyID = AlgoUtil.getParameter(request, "strategyID", "SOR");
String instrumentID = null;
String act = AlgoUtil.getParameter(request, "act", null);

boolean showAlgo = AlgoUtil.getParameterAsBoolean(request, "showAlgo", false);

List<Algo> algoList = null;
List<Instrument> instrumentList = null;

Algo algo = null;
Instrument inst = null;

double qtyDefault = 0.0;
double displayQtyDefault = 0.0;

// Create an order request; with some pre-populated values
NewOrderRequest orderReq = null;

SimpleDateFormat timeFormatter = DateUtil.getFormatter("yyyyMMdd HH:mm:ss", "GMT");

String spath = request.getServletPath();

try
{
    algoList = apiService.getAlgos();
    
    instrumentList = apiService.getInstruments();

    // set default instrument to BTCBUSD
    String instID_Default = (instrumentList.size() > 0 ? instrumentList.get(0).getInstrumentID() : "");
    
    for (Instrument item : instrumentList)
    {
        if (item.getInstrumentID().startsWith("BTC"))
        {
            instID_Default = item.getInstrumentID();
            break;
        }
    }
    
    instrumentID = AlgoUtil.getParameter(request, "instrumentID", instID_Default);
    
    
    
    
    algo = apiService.getAlgoByStrategyID(strategyID);
    
    if (algo != null)
        request.setAttribute("algo", algo);
    
 	// get instrumentID; and if not specified; get default first one in the list
    if (AlgoUtil.isDefined(instrumentID) == false && instrumentList != null && instrumentList.size() > 0)
        instrumentID = instrumentList.get(0).getInstrumentID();

    if (AlgoUtil.isDefined(instrumentID))
    	inst = apiService.getInstrumentByInsID(instrumentID);

 	// work out default qty to populate
    qtyDefault = inst.getTickSizeQty();
    if (inst != null)
    {
        qtyDefault = (inst.getTopOfBook().getBidQty() + inst.getTopOfBook().getAskQty()) / 2.0;
    }
    displayQtyDefault = qtyDefault;

    // Create new order request with some default values
    orderReq = new NewOrderRequest();

    orderReq.setClientID(algoConfig.getClientId());
    orderReq.setInstrumentID(inst.getInstrumentID());
    orderReq.setSide(OrderSide.Buy.getCode());
    orderReq.setOrderType(OrderType.Market.getCode());
    orderReq.setTimeInForce(TimeInForce.Good_till_cancel.getCode());

    // set default algo
    orderReq.setAlgoStrategyID(algo.getStrategyID());

    
    
	if ("refresh".equals(act) || "submit".equals(act))
	{

        // read submitted values
        orderReq.setClientID(AlgoUtil.getParameter(request, "clientID"));
        
        orderReq.setInstrumentID(AlgoUtil.getParameter(request, "instrumentID"));

        orderReq.setSide(AlgoUtil.getParameterAsChar(request, "side"));

        orderReq.setOrderType(AlgoUtil.getParameterAsChar(request, "orderType"));
        
        orderReq.setTimeInForce(AlgoUtil.getParameterAsChar(request, "timeInForce"));

        orderReq.setQuantity(AlgoUtil.getParameterAsDouble(request, "quantity", 0.0));

        orderReq.setPrice(AlgoUtil.getParameterAsDouble(request, "price", 0.0));

        orderReq.setAlgoStrategyID(AlgoUtil.getParameter(request, "strategyID"));

        
        // parse Algo params
        

 		for (AlgoParamDef paramDef : algo.getParams()) 
 		{
 		    if (paramDef.isShowOnForm() == false)
 		        continue;
 		    
			AlgoParamValue paramVal = orderReq.getAlgoParamByName(paramDef.getName());
	
		    String val = AlgoUtil.getParameter(request, "algo_" + paramDef.getName(), null);
		    
			if (AlgoUtil.isDefined(val))
			{
			    if (paramVal == null)
			    {
			        paramVal = new AlgoParamValue();
			        
			        paramVal.setName(paramDef.getName());
			        
			        orderReq.addAlgoParam(paramVal);
			    }
			    
		        paramVal.setValue(val);

			}
			else
			{
		    
			    // set default value (if defined in the param definition)
			    if (AlgoUtil.isDefined(paramDef.getDefaultValue()))
			    {
				    if (paramVal == null)
				    {
				        paramVal = new AlgoParamValue();			        
				        paramVal.setName(paramDef.getName());	
				        orderReq.addAlgoParam(paramVal);
				    }
	
			        paramVal.setValue(paramDef.getDefaultValue());
			    }
			    else
			    {
				    // remove if set
				    if (paramVal != null)
				        orderReq.removeAlgoParamByName(paramDef.getName());
			    }
			}
     	}
     	        
        
        
 		if ("submit".equals(act))
 		{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
            
            String clientOrderID = ""+System.currentTimeMillis();

            orderReq.setClOrdID(clientOrderID);
            
            orderReq.setRequestTime(System.currentTimeMillis());

            orderReq.setSubAccount(request.getRemoteAddr());
            
            NewOrderResponse resp = apiService.submitNewOrderRequest(orderReq);

            if (resp.isSuccess())
            {
                pageInfo.successMsg = "New Order submitted successfully [clientOrderID=" + clientOrderID + "]; Response OrderID=[" + resp.getOrderID() + "]";
            }
            else
            {
                pageInfo.errorMsg = "New Order rejected: " + resp.getRejectReason();
            }
 		}

	}
}
catch (BusinessApiException e)
{
    pageInfo.setError(e);
}
catch (Throwable e)
{
    pageInfo.setError(e);
}


%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<br>

<% if (orderReq != null) { %>

<table width="1100" cellpadding=2 align="center">

<form name="frm" action="<%=spath %>" method="post">
<input type="hidden" name="act" value="" />
<input type="hidden" name="showAlgo" value="<%=showAlgo %>" />

<input type="hidden" name="lastPx" value="" />
<input type="hidden" name="bidPx" value="" />
<input type="hidden" name="askPx" value="" />
<input type="hidden" name="bidQty" value="" />
<input type="hidden" name="askQty" value="" />
<input type="hidden" name="qtyDefault" value="<%=qtyDefault %>" />
<input type="hidden" name="displayQtyDefault" value="<%=displayQtyDefault %>" />


<tr bgcolor="<%=theme.rawHighlight %>" height="25" >
	<td align="center" colspan=3 onClick="frm.act.value='refresh'; frm.submit();">
	<font size="+1">New Order Request</font>	
	</td>
</tr>


<!--  Instrument -->
<!-- spacer -->
<tr>
<td colspan=3>

	<table width="100%" cellpadding=5 align="center">
	
	<tr>
		<td colspan="11" align="right">

			<input type="button" name="btnRefresh" 
				value="Refresh" style="width: 100px;"
				onClick="frm.act.value='refresh'; frm.submit();"
				/>

		</td>
	</tr>
	
	
	<tr bgcolor="<%=theme.rawHighlight %>">
		<td colspan=1 rowspan=2 width="200"><b>InstrumentID</b></td>
		<td colspan=1 rowspan=2 width="100"><b>Source</b></td>
		<td colspan=1 rowspan=2 width="100" align="right"><b>Last Px</b></td>
		<td colspan=1 rowspan=2 width="100" align="right"><b>Bid Qty</b></td>
		<td colspan=1 rowspan=2 width="100" align="right"><b>Bid Px</b></td>
		<td colspan=1 rowspan=2 width="100" align="right"><b>Ask Px</b></td>
		<td colspan=1 rowspan=2 width="100" align="right"><b>Ask Qty</b></td>

		<td colspan=2 rowspan=1 width="100" align="center"><b>Spread</b></td>		

		<td colspan=1 rowspan=2 width="60" align="center"><b>Live</b></td>

		<td colspan=1 rowspan=2 width="150" align="right"><b>Time</b></td>

	</tr>
	
	<tr bgcolor="<%=theme.rawHighlight %>">

		<td colspan=1 rowspan=1 width="100" align="right"><b>$</b></td>		
		<td colspan=1 rowspan=1 width="100" align="right"><b>Bps</b></td>		

	</tr>
	
	<tr>
		<td valign="top">
			<select id="instrumentID" name="instrumentID" style="width: 200px;" onChange="frm.act.value='refresh'; frm.submit();">
			<% for (Instrument item : instrumentList) { %>
				<option value="<%=item.getInstrumentID() %>" <%=item.getInstrumentID().equals(orderReq.getInstrumentID()) ? "selected" : "" %> ><%=item.getInstrumentID() %>
			<% } %>
			</select>
		</td>

		<td id="mdSource" valign="top" align="left">
			<%=inst.topOfBook.mdSource %>
		</td>
		
				
		<td id="lastPx" valign="top" align="right">
			<%=AlgoUtil.numericFormat(inst.topOfBook.last, inst.getPriceDecimals()) %>
		</td>
		
		<td id="bidQty" valign="top" align="right">
			<%=AlgoUtil.numericFormat(inst.getTopOfBook().getBidQty(), inst.getQuantityDecimals()) %>
		</td>
		
		<td id="bidPx" valign="top" align="right" style="color: <%=theme.bid %>;">
			<%=AlgoUtil.numericFormat(inst.getTopOfBook().getBid(), inst.getPriceDecimals()) %>
		</td>
		
		<td id="askPx" valign="top" align="right" style="color: <%=theme.ask %>;">
			<%=AlgoUtil.numericFormat(inst.getTopOfBook().getAsk(), inst.getPriceDecimals()) %>
		</td>
		
		<td id="askQty" valign="top" align="right">
			<%=AlgoUtil.numericFormat(inst.getTopOfBook().getAskQty(), inst.getQuantityDecimals()) %>
		</td>

		<td id="spread" valign="top" align="right">
			<%=AlgoUtil.numericFormat(inst.getTopOfBook().getSpread(), inst.getPriceDecimals()) %>
		</td>
		
		<td id="spreadBps" valign="top" align="right">
			<%=AlgoUtil.numericFormat(inst.getTopOfBook().getSpreadBps(), 3) %>
		</td>

		<td id="live" valign="top" align="center" style="color: <%=inst.getTopOfBook().isLive() ? theme.bodyText : theme.negative %>;">
			<%=inst.getTopOfBook().isLive() ? "Y" : "N" %>
		</td>
	
	    <td id="utime" valign="top" align="right">
	    	<%=timeFormatter.format(inst.getTopOfBook().getUpdateTime()) %>
	    </td>
	
	</tr>	

	<!--  status fields -->
	<tr height="25">
	    <td id="msgStatus" colspan=11 align="right">&nbsp;</td>
	</tr>
	
	</table>

</td>
</tr>


<tr height=1>
	<td width="15%"></td>
	<td width="30%"></td>
	<td width="55%"></td>
</tr>	
	
<tr>
	<td valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
		<b>ClientID</b>
	</td>
	<td valign="top">
		<input type="text" name="clientID" value="<%=orderReq.getClientID() %>" size="30" />
	</td>
	<td>
	
	</td>
</tr>	



<tr>
	<td valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
		<b>Side</b>
	</td>
	<td valign="top">
		<select name="side" style="width: 150px;">
		<% for (OrderSide item : OrderSide.getAllValues()) { %>
			<option value="<%=item.getCode() %>" <%=item.getCode() == orderReq.getSide() ? "selected" : "" %> ><%=item %>
		<% } %>
		</select>
	</td>
	<td>
	
	</td>
</tr>

<tr>
	<td valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
		<b>Order Type</b>
	</td>
	<td valign="top">
		<select name="orderType" style="width: 150px;">
		<% for (OrderType item : OrderType.getAllValues()) { %>
			<option value="<%=item.getCode() %>" <%=item.getCode() == orderReq.getOrderType() ? "selected" : "" %> ><%=item %>
		<% } %>
		</select>
	</td>
	<td>
	
	</td>
</tr>

<tr>
	<td valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
		<b>Time in force</b>
	</td>
	<td valign="top">
		<select name="timeInForce" style="width: 150px;">
		<% for (TimeInForce item : TimeInForce.getAllValues()) { %>
			<option value="<%=item.getCode() %>" <%=item.getCode() == orderReq.getTimeInForce() ? "selected" : "" %> ><%=item %>
		<% } %>
		</select>
	</td>
	<td>
	
	</td>
</tr>

<tr>
	<td valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
		<b>Quantity</b>
	</td>
	<td valign="top">
		<input type="text" name="quantity" 
				value="<%=AlgoUtil.numericFormat(orderReq.getQuantity(), inst.getQuantityDecimals())  %>"
				size="20" />

       	<input type="button" name="btnSetQty" value="?" 
        		onClick="javascript: frm.quantity.value = frm.qtyDefault.value;" />
				
	</td>
	<td>
	
	</td>
</tr>

<tr>
	<td valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
		<b>Price</b>
	</td>
	<td valign="top">
		<input type="text" name="price" 
			value="<%=AlgoUtil.numericFormat(orderReq.getPrice(), inst.getPriceDecimals())  %>" 
			size="20" />
			
       	<input type="button" name="btnSetPx" value="?" 
        		onClick="javascript: frm.price.value=frm.lastPx.value;" />
			
	</td>
	<td>
	
	</td>
</tr>

<!--  Spacer -->
<tr><td colspan=3></td></tr>

<tr>
	<td colspan=3 align="center" bgcolor="<%=theme.rawHighlight %>">
		<b>Algo Parameters</b>
	</td>
</tr>

<tr>
	<td valign="top" nowrap bgcolor="<%=theme.rawHighlight %>">
		<b>StrategyID</b>
	</td>
	<td valign="top">
		<select name="strategyID" style="width: 250px; height: 30px; font-size: 20px;" onChange="frm.act.value='refresh'; frm.submit();">
		<% for (Algo item : algoList) { %>
			<option value="<%=item.getStrategyID() %>" <%=item.getStrategyID().equals(orderReq.getAlgoStrategyID()) ? "selected" : "" %> ><%=item.getStrategyID() %>
		<% } %>
		</select>
	</td>
	
	<td>
	<%=algo.getShortDesc() %>
	</td>
</tr>

<% for (AlgoParamDef paramDef : algo.getParams()) {

    if (paramDef.isShowOnForm() == false)
        continue;
    
	int fieldSize=20;
	int selectFieldWidth=150;
	
	AlgoParamValue paramVal = orderReq.getAlgoParamByName(paramDef.getName());
	
    %>


   <tr>
        <td nowrap bgcolor="<%=theme.rawHighlight %>" title="<%=paramDef.getShortDesc() %>">
        	<b><%=paramDef.getLabel() %></b>
        </td>
        <td title="<%=paramDef.getDesc() %>" colspan=2>
        
        	<% if ("Double".equalsIgnoreCase(paramDef.getType()) && "Price".equalsIgnoreCase(paramDef.getTypeFormat())) { %>
        	
	            <input type="text" id="algo_<%=paramDef.getName() %>" name="algo_<%=paramDef.getName() %>" 
	            	value="<%=paramVal==null ? "" : AlgoUtil.numericFormat(paramVal.getValueAsDouble(), inst.getPriceDecimals()) %>"
	                size="<%=fieldSize %>"
	                style="text-align: right;">
	                 
	           	<input type="button" name="btnSetPx" value="?" 
	           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value=frm.lastPx.value;" " />

        
        	<% } else if ("Double".equalsIgnoreCase(paramDef.getType()) && "Quantity".equalsIgnoreCase(paramDef.getTypeFormat())) { %>
        	
	            <input type="text" id="algo_<%=paramDef.getName() %>" name="algo_<%=paramDef.getName() %>" 
	            	value="<%=paramVal == null ? "" : AlgoUtil.numericFormat(paramVal.getValueAsDouble(), inst.getQuantityDecimals()) %>"
	                size="<%=fieldSize %>"
	                style="text-align: right;">
	                 
	            <% if ("DisplayQuantity".equals(paramDef.getName())) { %>
	                 
	           		<input type="button" name="btnSetPx" value="?" 
	           			onClick="javascript: frm.algo_<%=paramDef.getName() %>.value=frm.displayQtyDefault.value;" />

				<% } else { %>

	           		<input type="button" name="btnSetPx" value="?" 
	           			onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='<%=AlgoUtil.numericFormat(inst.getTickSizeQty() , inst.getQuantityDecimals()) %>';" />
				
				<% } %>

        	<% } else if ("Double".equalsIgnoreCase(paramDef.getType()) && "Percent".equalsIgnoreCase(paramDef.getTypeFormat())) { %>
        	
	            <input type="text" id="algo_<%=paramDef.getName() %>" name="algo_<%=paramDef.getName() %>" 
	            	value="<%=paramVal == null ? "" : AlgoUtil.numericFormat(paramVal.getValueAsDouble(), 2) %>"
	                size="<%=fieldSize %>"
	                style="text-align: right;">
	                 
	           	<input type="button" name="btnSetPx" value="?" 
	           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='10.00';" />

        	<% } else if ("Double".equalsIgnoreCase(paramDef.getType()) && "Bps".equalsIgnoreCase(paramDef.getTypeFormat())) { %>
        	
	            <input type="text" id="algo_<%=paramDef.getName() %>" name="algo_<%=paramDef.getName() %>" 
	            	value="<%=paramVal == null ? "" : AlgoUtil.numericFormat(paramVal.getValueAsDouble(), 2) %>"
	                size="<%=fieldSize %>"
	                style="text-align: right;">
	                 
	           	<input type="button" name="btnSetPx" value="?" 
	           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='10.00';" />
	           			   	 
	           			   	 	           			   	           			           	      
        	<% } else if ("Double".equalsIgnoreCase(paramDef.getType())) { %>
        	
	            <input type="text" id="algo_<%=paramDef.getName() %>" name="algo_<%=paramDef.getName() %>" 
	            	value="<%=paramVal == null ? "" : paramVal.getValue() %>"
	                size="<%=fieldSize %>"
	                style="text-align: right;">
	                 
	            <% if ("Price".equals(paramDef.getTypeFormat())) { %>
	           	<input type="button" name="btnSetPx" value="?" 
	           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='<%=AlgoUtil.numericFormat(inst.getLastPrice(), inst.getPriceDecimals()) %>';" />
	           	<% } %>   
	           	                
        	<% } else if ("enum".equalsIgnoreCase(paramDef.getType()) && "Integer".equalsIgnoreCase(paramDef.getTypeFormat())) { %>
        	
		        <select name="algo_<%=paramDef.getName() %>" style="width: <%=selectFieldWidth %>px;">	        	        
        		<% if (paramDef.isMandatory() && false) { %>
        			<option value="" <%="".equals("") ? "selected" : "" %>>
        		<% } %>

		        <% for (AlgoParamValidValue item : paramDef.getValidValues()) {
		            
		            boolean selected = false;

		            if (paramVal != null)
		            {    
		                selected = item.getValue().equals(paramVal.getValue());		            
		            }
		            else
		            {
		             	selected = item.getValue().equals(paramDef.getDefaultValue());   
		            }
		            		            
		        %> 
		        	<option value="<%=item.getValue() %>" <%=selected ? "selected" : "" %>><%=item.getValue() %> - <%=item.getShortDesc() %>
		        <% } %>         
		        </select>

			<!--  Liquidity -->
        	<% } else if ("enum".equalsIgnoreCase(paramDef.getType()) && "Liquidity".equalsIgnoreCase(paramDef.getName())) { %>
        	
		        <select name="algo_<%=paramDef.getName() %>" style="width: <%=selectFieldWidth %>px;">	        	        

		        <% 
		        // build up valid values for this instrument
		        ArrayList<String> validVals = new ArrayList<>();

		        for (AlgoParamValidValue item : paramDef.getValidValues()) 
		        {
		            validVals.add(item.getValue());
		        }
		        
		        if (strategyID.equals("DARK") == false && inst.getTopOfBooks() != null)
		        {
		            for (TopOfBook book : inst.getTopOfBooks())
		            {
		                if (book.isLive())
		                	validVals.add(book.getMdSource());
		            }
		        }
		        
		        for (String item : validVals) 
		        {
		            boolean selected = false;
		            
		            if (paramVal != null)
		            {    
		                selected = item.equals(paramVal.getValue());		            
		            }
		            else
		            {
		             	selected = item.equals(paramDef.getDefaultValue());   
		            }
		            
		            %> 
		        	<option value="<%=item %>" <%=selected ? "selected" : "" %>><%=item %>
		        <% } %>          
		        </select>
		        
		        

        	<% } else if ("enum".equalsIgnoreCase(paramDef.getType()) && "Text".equalsIgnoreCase(paramDef.getTypeFormat())) { %>
        	
		        <select name="algo_<%=paramDef.getName() %>" style="width: <%=selectFieldWidth %>px;">	        	        
        		<% if (paramDef.isMandatory() == false) { %>
        			<option value="" <%="".equals("") ? "selected" : "" %>>
        		<% } %>

		        <% for (AlgoParamValidValue item : paramDef.getValidValues()) { 
		        
		            boolean selected = false;
		            
		            if (paramVal != null)
		            {    
		                selected = item.getValue().equals(paramVal.getValue());		            
		            }
		            else
		            {
		             	selected = item.getValue().equals(paramDef.getDefaultValue());   
		            }
		        %> 
		        	<option value="<%=item.getValue() %>" <%=selected ? "selected" : "" %>><%=item.getValue() %><%=AlgoUtil.isDefined(item.getShortDesc()) ? " - " + item.getShortDesc() : "" %>
		        <% } %>          
		        </select>
		        		        
        	<% } else if ("enum".equalsIgnoreCase(paramDef.getType())) { %>
        	
		        <select name="algo_<%=paramDef.getName() %>" style="width: <%=selectFieldWidth %>px;">	        	        
        		<% if (paramDef.isMandatory() == false) { %>
        			<option value="" <%="".equals("") ? "selected" : "" %>>
        		<% } %>

		        <% for (AlgoParamValidValue item : paramDef.getValidValues()) { %> 
		        	<option value="<%=item.getValue() %>" <%=paramVal != null && item.getValue().equals(paramVal.getValue()) ? "selected" : "" %>><%=item.getValue() %> - <%=item.getShortDesc() %>
		        <% } %>          
		        </select>


        	<% } else if ("time".equalsIgnoreCase(paramDef.getType()) && "Long".equalsIgnoreCase(paramDef.getTypeFormat()) == false) { 
        		SimpleDateFormat algoParamFormatter = DateUtil.getFormatter("HH:mm:ss", inst.getTimezone());
        	%>
        	
	            <input type="text" id="algo_<%=paramDef.getName() %>" name="algo_<%=paramDef.getName() %>" 
	            	value="<%=paramVal == null ? "" : paramVal.getValue() %>"
	                size="<%=fieldSize %>"
	                style="text-align: right;">
	                 	           			  
				<% if ("StartTime".equals(paramDef.getName())) { %>

		           	<input type="button" name="btnSetTime" value="?" 
		           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='<%=algoParamFormatter.format(System.currentTimeMillis()) %>';" />

		           	<input type="button" name="btnSetTime" value="Now" 
		           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='Now';" />

				<% } else if ("EndTime".equals(paramDef.getName())) { %>

		           	<input type="button" name="btnSetTime" value="?" 
		           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='<%=algoParamFormatter.format(System.currentTimeMillis()) %>';" />

		           	<input type="button" name="btnSetTime" value="EOD" 
		           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='EOD';" />

		           	<input type="button" name="btnSetTime" value="2h" 
		           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='2h';" />

		           	<input type="button" name="btnSetTime" value="1h" 
		           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='1h';" />

		           	<input type="button" name="btnSetTime" value="15m" 
		           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='15m';" />

		           	<input type="button" name="btnSetTime" value="5m" 
		           		onClick="javascript: frm.algo_<%=paramDef.getName() %>.value='5m';" />

				<% } %>
					           			  		        
        	<% } else { %>
        	
	            <input type="text" name="algo_<%=paramDef.getName() %>" 
	            	value="<%=paramVal == null ? "" : paramVal.getValue() %>"
	                size="<%=fieldSize %>"
	                style="text-align: right;">
            
            <% } %>
        </td>

    </tr>


<% } %>


<!--  Spacer -->
<tr height=25><td colspan=3></td></tr>

<tr><td colspan=3></td></tr>

<tr bgcolor="<%=theme.rawHighlight %>">
	<td colspan=3 align="center" valign="top">
	
		<input type="button" name="btnSubmit" 
				value="Submit Order" style="width: 200px;"
				onClick="frm.act.value='submit'; frm.submit();"
				/>
				
	</td>
</tr>

</form>

</table>


<!--  Algo detail -->
<br>
<table width="1100" align=center>
<tr bgcolor="<%=theme.rawHighlight %>" height="30">
	<td align="center" onClick="javascript: toggleShowAlgo();">
		<b>View Algo Strategy Detail</b>
	</td>
</tr>
<tr>
    <td align="center">        
    <div id="algoDetail" style="display: <%=showAlgo ? "block" : "none" %>;">

		<jsp:include page="algo_.jsp" flush="true" />

    </div>
    </td>
</tr>
</table> 


<% } %>




<script type="text/javascript">
function toggleShowAlgo(divID) 
{
	frm.act.value='refresh';
	frm.showAlgo.value = !(frm.showAlgo.value == 'true');
	frm.submit();
}
</script>



<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<%
String wsURL = algoConfig.getUrlPrefixWebsockets() + algoConfig.getWsTopOfBookUrl();
wsURL += "?instID=" + instrumentID;
wsURL += "&interval=100";
wsURL += "&formatted=t";

//if (StringUtil.isDefined(instID))
//	wsURL += "?instID=" + instID;
%>

<script type="text/javascript" charset="utf-8">

'use strict';

var msgStatus = document.querySelector('#msgStatus');
var cxtTime = document.querySelector('#cxtTime');

var socket = new WebSocket('<%=wsURL %>');
 
var instrumentSelectBox = document.getElementById('instrumentID');

//console.log(instrumentSelectBox);

var idMdSource = document.querySelector('#mdSource');
var idLastPx = document.querySelector('#lastPx');
var idBidQty = document.querySelector('#bidQty');
var idBidPx = document.querySelector('#bidPx');
var idAskQty = document.querySelector('#askQty');
var idAskPx = document.querySelector('#askPx');
var idLive = document.querySelector('#live');
var idUtime = document.querySelector('#utime');
var idSpread = document.querySelector('#spread');
var idSpreadBps = document.querySelector('#spreadBps');


socket.onopen = function(e) 
{
	//msgStatus.textContent = '';
    //msgStatus.style.color = 'green';
};

socket.onclose = function(event) 
{
	if (event.wasClean) 
	{
	 	console.log(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
	} 
	else 
	{
  		console.log('[close] Connection died');
	}
	
	//msgStatus.textContent = 'Disconnected';
	//msgStatus.style.color = 'red';	  
};
	
socket.onerror = function(error) 
{
	console.log('error received : ' + error.message);
	
    msgStatus.textContent = 'Unable to connect. Please refresh this page to try again!';
    msgStatus.style.color = 'red';
};


socket.onmessage = function(event) 
{
	
    var message = JSON.parse(event.data);

    //console.log(event.data);
    
    // replace the dot; as it causes issues with JS
    //var elemID = message.instrumentID.replace('.', '_');    
    
			
    //instrumentSelectBox.value = message.instrumentID;
    
    idMdSource.textContent = message.mds;
	idLastPx.textContent = message.ls;
	idBidQty.textContent = message.bqs;
	idBidPx.textContent = message.bs;
	idAskQty.textContent = message.aqs;
	idAskPx.textContent = message.as;
	
	frm.lastPx.value = message.ls;
	frm.bidQty.value = message.bqs;
	frm.bidPx.value = message.bs;
	frm.askQty.value = message.aqs;
	frm.askPx.value = message.as;
	frm.qtyDefault.value = (message.bq + message.aq) / 2.0;
	frm.displayQtyDefault.value = (message.bq + message.aq) / 2.0;
	
	
	idSpread.textContent = message.sprs;
	idSpreadBps.textContent = message.sprbs;

	idLive.textContent = message.lv ? "Y" : "N";
	
	idUtime.textContent = message.us;
	
	
	
};

</script>



<jsp:include page="_footer.jsp" flush="true" />


<%@page import="com.ismail.algo.controller.PageInfo"%>
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
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Top Of Books";

List<Instrument> instruments = null;

try
{
    instruments = apiService.getInstruments();
}
catch (Throwable t)
{    
	pageInfo.setError(t);    
}
%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<br>

<% if (instruments != null) { %>

<table width="1100" cellpadding=5 align="center">

<tr bgcolor="<%=theme.headerBg %>">
	<td colspan=1 rowspan=2><b>InstrumentID</b></td>
	<td colspan=1 rowspan=2><b>Description</b></td>
	<td colspan=1 rowspan=2><b>Type</b></td>

	<td colspan=1 rowspan=2 align="right"><b>Bid Qty</b></td>
	<td colspan=1 rowspan=2 align="right"><b>Bid Px</b></td>
	<td colspan=1 rowspan=2 align="right"><b>Ask Px</b></td>
	<td colspan=1 rowspan=2 align="right"><b>Ask Qty</b></td>

	<td colspan=2 rowspan=1 align="center"><b>Spread</b></td>
	
	<td colspan=1 rowspan=2 align="right"><b>Update Time</b></td>

</tr>

<tr bgcolor="<%=theme.headerBg %>">
	
	<td colspan=1 rowspan=1 align="right"><b>$</b></td>
	<td colspan=1 rowspan=1 align="right"><b>Bps</b></td>

</tr>

<% for (int i=0; i<instruments.size(); i++) { 
    Instrument inst = instruments.get(i);
%>

<tr bgcolor="<%=(i % 2 == 1) ? theme.rawHighlight : theme.raw %>">
	<td id="symbol_<%=inst.getSymbol() %>" valign="top"><%=inst.getInstrumentID() %></td>
	<td valign="top"><%=inst.getDesc() %></td>
	<td valign="top"><%=inst.getInstType() %></td>


	<td id="bidQty_<%=inst.getSymbol() %>" valign="top" align="right"></td>
	<td id="bidPx_<%=inst.getSymbol() %>" valign="top" align="right" style="color: <%=theme.bid %>;"></td>
	<td id="askPx_<%=inst.getSymbol() %>" valign="top" align="right" style="color: <%=theme.ask %>;"></td>
	<td id="askQty_<%=inst.getSymbol() %>" valign="top" align="right"></td>

	<td id="spread_<%=inst.getSymbol() %>" valign="top" align="right"></td>
	<td id="spreadBps_<%=inst.getSymbol() %>" valign="top" align="right"></td>

	<td id="utime_<%=inst.getSymbol() %>" valign="top" align="right"></td>

</tr>	

<% } %>

<!--  status fields -->
<tr>
    <td id="cxtTime" colspan=5 align="left" style="color: <%=theme.bodyTextLight2 %>">
    	
    </td>
    <td id="msgStatus" colspan=6 align="right"></td>
    
</tr>

</table>







<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<%
String wsURL = algoConfig.getUrlPrefixWebsockets() + "/ws_depthm/";

//if (StringUtil.isDefined(instID))
//	wsURL += "?instID=" + instID;
%>

<script type="text/javascript" charset="utf-8">

'use strict';

var msgStatus = document.querySelector('#msgStatus');
var cxtTime = document.querySelector('#cxtTime');


var socket = new WebSocket('<%=wsURL %>');
 
socket.onopen = function(e) 
{
	socket.send("test message");
	
	msgStatus.textContent = 'Connected';
    msgStatus.style.color = 'green';
    
    // Subscribe to the Public Topic
    //stompClient.subscribe('/topic/public', onMessageReceived);

    // Tell your username to the server
    //stompClient.send("/app/ws.register", {}, JSON.stringify({username: 'user_xyz'}) );

};

socket.onclose = function(event) 
{
	if (event.wasClean) 
	{
	  console.log(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
	} 
	else 
	{
	  // e.g. server process killed or network down
	  // event.code is usually 1006 in this case
	  console.log('[close] Connection died');
	}
	
	msgStatus.textContent = 'Disconnected';
	msgStatus.style.color = 'red';	  
};
	
socket.onerror = function(error) 
{
	console.log('error received : ' + error.message);
	
    msgStatus.textContent = 'Unable to connect. Please refresh this page to try again!';
    msgStatus.style.color = 'red';
};


socket.onmessage = function(event) 
{
	console.log("onMessageReceived() " + event.data);	
	
    var message = JSON.parse(event.data);

    var idSymbol = document.querySelector('#symbol_'+message.symbol);
    var idBidQty = document.querySelector('#bidQty_'+message.symbol);
    var idBidPx = document.querySelector('#bidPx_'+message.symbol);
    var idAskQty = document.querySelector('#askQty_'+message.symbol);
    var idAskPx = document.querySelector('#askPx_'+message.symbol);
    var idUtime = document.querySelector('#utime_'+message.symbol);

    var idSpread = document.querySelector('#spread_'+message.symbol);
    var idSpreadBps = document.querySelector('#spreadBps_'+message.symbol);
    
    if (idSymbol == null)
    {
    	console.log("error; cannot find idSymbol");
    	return;
    }
    
	//idSymbol.textContent = message.symbol;
		
	idBidQty.textContent = message.bidQty;
	idBidPx.textContent = message.bidPx;
	idAskQty.textContent = message.askQty;
	idAskPx.textContent = message.askPx;
	
	idSpread.textContent = message.spr;
	idSpreadBps.textContent = message.sprBps;

	idUtime.textContent = message.timeStr;
    
	//cxtTime.textContent = message.cxtTime;
	
    //msgStatus.textContent = 'Connected';
    //msgStatus.style.color = 'green';
    
};

</script>

<% } %>


<jsp:include page="_footer.jsp" flush="true" />


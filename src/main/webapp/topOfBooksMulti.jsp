<%@page import="com.ismail.algo.model.TopOfBook"%>
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
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Top Of Books (Multi Sources)";

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
	<td colspan=1 rowspan=2 title="Market Data source"><b>Source</b></td>

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

<% 
for (int i=0; i<instruments.size(); i++) 
{ 
    Instrument inst = instruments.get(i);
    
    // replace the dots; as it causes issues with JS
    String elemID = inst.getInstrumentID().replaceAll("\\.", "_");
    
    String mdSource = inst.topOfBook.mdSource;
    

%>

<tr bgcolor="<%=theme.rawHighlight %>">
	<td id="symbol_<%=elemID %>_<%=mdSource %>" valign="top"><%=inst.getInstrumentID() %></td>
	<td valign="top"><%=inst.getDesc() %></td>
	<td valign="top"><%=inst.getInstType() %></td>

	<td id="mdSource_<%=elemID %>_<%=mdSource %>" valign="top"><%=mdSource %></td>

	<td id="bidQty_<%=elemID %>_<%=mdSource %>" valign="top" align="right"></td>
	<td id="bidPx_<%=elemID %>_<%=mdSource %>" valign="top" align="right" style="color: <%=theme.bid %>;"></td>
	<td id="askPx_<%=elemID %>_<%=mdSource %>" valign="top" align="right" style="color: <%=theme.ask %>;"></td>
	<td id="askQty_<%=elemID %>_<%=mdSource %>" valign="top" align="right"></td>

	<td id="spread_<%=elemID %>_<%=mdSource %>" valign="top" align="right"></td>
	<td id="spreadBps_<%=elemID %>_<%=mdSource %>" valign="top" align="right"></td>

	<td id="utime_<%=elemID %>_<%=mdSource %>" valign="top" align="right"></td>

</tr>	


<%

for (TopOfBook tob : inst.topOfBooks)
{
    if (tob.mdSource.equals(mdSource))
        continue;
        
%>

<tr>
	<td id="symbol_<%=elemID %>_<%=tob.mdSource %>" valign="top"></td>
	<td valign="top"></td>
	<td valign="top"></td>

	<td id="mdSource_<%=elemID %>_<%=tob.mdSource %>" valign="top"><%=tob.mdSource %></td>

	<td id="bidQty_<%=elemID %>_<%=tob.mdSource %>" valign="top" align="right"></td>
	<td id="bidPx_<%=elemID %>_<%=tob.mdSource %>" valign="top" align="right" style="color: <%=theme.bid %>;"></td>
	<td id="askPx_<%=elemID %>_<%=tob.mdSource %>" valign="top" align="right" style="color: <%=theme.ask %>;"></td>
	<td id="askQty_<%=elemID %>_<%=tob.mdSource %>" valign="top" align="right"></td>

	<td id="spread_<%=elemID %>_<%=tob.mdSource %>" valign="top" align="right"></td>
	<td id="spreadBps_<%=elemID %>_<%=tob.mdSource %>" valign="top" align="right"></td>

	<td id="utime_<%=elemID %>_<%=tob.mdSource %>" valign="top" align="right"></td>

</tr>	

<% } %>

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
String wsURL = algoConfig.getUrlPrefixWebsockets() + algoConfig.getWsTopOfBookUrl();

wsURL += "?multiSources=true";

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
	//console.log("onMessageReceived() " + event.data);	
	
    var message = JSON.parse(event.data);

    // replace the dot; as it causes issues with JS
    var elemID = message.instrumentID.replace('.', '_');
    
    var idSymbol = document.querySelector('#symbol_'+elemID+'_'+message.mdSource);
    var idMDSource = document.querySelector('#mdSource_'+elemID+'_'+message.mdSource);
    
    var idBidQty = document.querySelector('#bidQty_'+elemID+'_'+message.mdSource);
    var idBidPx = document.querySelector('#bidPx_'+elemID+'_'+message.mdSource);
    var idAskQty = document.querySelector('#askQty_'+elemID+'_'+message.mdSource);
    var idAskPx = document.querySelector('#askPx_'+elemID+'_'+message.mdSource);
    var idUtime = document.querySelector('#utime_'+elemID+'_'+message.mdSource);

    var idSpread = document.querySelector('#spread_'+elemID+'_'+message.mdSource);
    var idSpreadBps = document.querySelector('#spreadBps_'+elemID+'_'+message.mdSource);
    
    if (idSymbol == null)
    {
    	console.log("error; cannot find idSymbol");
    	return;
    }
    
	//idSymbol.textContent = msgSymbol;
		
	//idSymbol.textContent = message.instrumentID;
	//idMDSource.textContent = message.mdSource;
	
	idBidQty.textContent = message.bidQtyStr;
	idBidPx.textContent = message.bidStr;
	idAskQty.textContent = message.askQtyStr;
	idAskPx.textContent = message.askStr;
	
	idSpread.textContent = message.spreadStr;
	idSpreadBps.textContent = message.spreadBpsStr;

	idUtime.textContent = message.updateTimeDesc;
    
	//cxtTime.textContent = message.cxtTimeStr;
	
    //msgStatus.textContent = 'Connected';
    //msgStatus.style.color = 'green';
    
};

</script>

<% } %>


<jsp:include page="_footer.jsp" flush="true" />


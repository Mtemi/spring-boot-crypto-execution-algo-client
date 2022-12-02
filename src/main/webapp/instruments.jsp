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
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Instruments";

List<Instrument> instruments = null;

try
{
    instruments = apiService.getInstruments();
}
catch (Throwable t)
{    
	pageInfo.setError(t);    
}

String WIDTH="80%";

%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<br>

<% if (instruments != null) { %>

<table width="<%=WIDTH %>" cellpadding=5 align="center">

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
	
	<td colspan=1 rowspan=2 align="center"><b>Live</b></td>
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
    
    String color = inst.topOfBook != null && inst.topOfBook.live ? theme.bodyText : theme.bodyTextLight2;
    
    // replace the dots; as it causes issues with JS
    String elemID = inst.getInstrumentID().replaceAll("\\.", "_");
%>

<tr bgcolor="<%=(i % 2 == 1) ? theme.rawHighlight : theme.raw %>">
	<td id="symbol_<%=elemID %>" style="color: <%=color %>;" valign="top"><b><%=inst.instrumentID %></b></td>
	<td valign="top" style="color: <%=color %>;" ><b><%=inst.getDesc() %></b></td>
	<td valign="top" style="color: <%=color %>;" ><%=inst.getInstType() %></td>

	<td id="mdSource_<%=elemID %>" style="color: <%=color %>;" valign="top"><%=inst.topOfBook.mdSource %></td>

	<td id="bidQty_<%=elemID %>" valign="top" align="right" style="color: <%=color %>;" ></td>
	<td id="bidPx_<%=elemID %>" valign="top" align="right" style="color: <%=inst.topOfBook.live ? theme.bid : color %>;"></td>
	<td id="askPx_<%=elemID %>" valign="top" align="right" style="color: <%=inst.topOfBook.live ? theme.ask : color %>;"></td>
	<td id="askQty_<%=elemID %>" valign="top" align="right" style="color: <%=color %>;" ></td>

	<td id="spread_<%=elemID %>" valign="top" align="right" style="color: <%=color %>;" ></td>
	<td id="spreadBps_<%=elemID %>" valign="top" align="right" style="color: <%=color %>;" ></td>

	<td id="live_<%=elemID %>" valign="top" align="center" style="color: <%=inst.getTopOfBook().isLive() ? theme.positive : color %>;" ></td>
	<td id="utime_<%=elemID %>" valign="top" align="right" style="color: <%=color %>;" ></td>

</tr>	

<% } %>

<!--  status fields -->
<tr>
    <td id="cxtTime" colspan=5 align="left" style="color: <%=theme.bodyTextLight2 %>">
    	
    </td>
    <td id="msgStatus" colspan=7 align="right"></td>
    
</tr>

</table>







<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<%
String wsURL = algoConfig.getUrlPrefixWebsockets() + algoConfig.getWsTopOfBookUrl();
wsURL += "?formatted=t";
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
	msgStatus.textContent = 'Connected';
    msgStatus.style.color = 'green';
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
	
    var message = JSON.parse(event.data);

    //console.log(event.data);
    
    // replace the dot; as it causes issues with JS
    var elemID = message.i.replace('.', '_');    
    
    var idBidQty = document.querySelector('#bidQty_'+elemID);
    var idBidPx = document.querySelector('#bidPx_'+elemID);
    var idAskQty = document.querySelector('#askQty_'+elemID);
    var idAskPx = document.querySelector('#askPx_'+elemID);
    var idLive = document.querySelector('#live_'+elemID);
    var idUtime = document.querySelector('#utime_'+elemID);
    var idSpread = document.querySelector('#spread_'+elemID);
    var idSpreadBps = document.querySelector('#spreadBps_'+elemID);
			
	idBidQty.textContent = message.bqs;
	idBidPx.textContent = message.bs;
	idAskQty.textContent = message.aqs;
	idAskPx.textContent = message.as;
	
	idSpread.textContent = message.sprs;
	idSpreadBps.textContent = message.sprbs;

	idLive.textContent = message.lv ? "Y" : "N";
	
	idUtime.textContent = message.us;
};

</script>

<% } %>


<jsp:include page="_footer.jsp" flush="true" />


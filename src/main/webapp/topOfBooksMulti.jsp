<%@page import="com.ismail.algo.model.BusinessApiException"%>
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

int intervalDef = 1000;
int interval= AlgoUtil.getParameterAsInt(request, "interval", intervalDef);    

String instID = "";

List<Instrument> instruments = null;
Instrument inst = null;

try
{
    instruments = apiService.getInstruments();
    
    String instID_Default = (instruments.size() > 0 ? instruments.get(0).getInstrumentID() : "");
    
    for (Instrument item : instruments)
    {
        if (item.getInstrumentID().startsWith("BTC"))
        {
            instID_Default = item.getInstrumentID();
            break;
        }
    }
    
    
    instID = AlgoUtil.getParameter(request, "instID",  instID_Default);
    
    if (AlgoUtil.isDefined(instID) && instruments != null)
    {
        inst = apiService.getInstrumentByInsID(instID);
        if (inst == null)
			throw new BusinessApiException("Invalid instrumentID " + instID);
    }
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


<table width="1300" cellpadding=5 align="center">
<form name="frm">
<tr>
	<td colspan=13 align="center">

        <select name="instID" onChange="fnSubmit();" style="width: 200px; height: 30px; font-size: 20px;">
            <option value="">
            <% for (Instrument item : instruments) { %>
               <option value="<%=item.getInstrumentID() %>" <%=item.getInstrumentID().equals(instID) ? "selected" : "" %>><%=item.getInstrumentID() %> 
            <% } %>                 
        </select> 
            
        	
	</td>
</tr>
</form>

<tr bgcolor="<%=theme.headerBg %>">
	<td colspan=1 rowspan=2 width="120"><b>InstrumentID</b></td>
	<td colspan=1 rowspan=2 width="120"><b>Description</b></td>
	<td colspan=1 rowspan=2 width="90"><b>Type</b></td>
	<td colspan=1 rowspan=2  width="100" title="Market Data source"><b>Source</b></td>

	<td colspan=1 rowspan=2 align="right"  width="100"><b>Bid Qty</b></td>
	<td colspan=1 rowspan=2 align="right"  width="100"><b>Bid Px</b></td>
	<td colspan=1 rowspan=2 align="right"  width="100"><b>Ask Px</b></td>
	<td colspan=1 rowspan=2 align="right"  width="100"><b>Ask Qty</b></td>

	<td colspan=2 rowspan=1 align="center" width="120"><b>Spread</b></td>

	<td colspan=1 rowspan=2 align="center" ><b>Ticks</b></td>

	<td colspan=1 rowspan=2 align="center" ><b>Live</b></td>
	
	<td colspan=1 rowspan=2 align="right" width="140"><b>Update Time</b></td>

</tr>

<tr bgcolor="<%=theme.headerBg %>">
	
	<td colspan=1 rowspan=1 align="right" width="60"><b>$</b></td>
	<td colspan=1 rowspan=1 align="right" width="60"><b>Bps</b></td>

</tr>

<% 
if (inst != null) 
{    
    // replace the dots; as it causes issues with JS
    String elemID = inst.getInstrumentID().replaceAll("\\.", "_") + "_" + inst.topOfBook.mdSource.replaceAll("\\.", "_");

%>

<tr bgcolor="<%=theme.rawHighlight %>">
	<td id="symbol_<%=elemID %>" valign="top"><b><%=inst.getInstrumentID() %></b></td>
	<td valign="top"><%=inst.getDesc() %></td>
	<td valign="top"><%=inst.getInstType() %></td>

	<td id="mdSource_<%=elemID %>" valign="top">
		<%=inst.topOfBook.mdSource %>
	</td>

	<td id="bidQty_<%=elemID %>" valign="top" align="right"></td>
	<td id="bidPx_<%=elemID %>" valign="top" align="right" style="color: <%=theme.bid %>;"></td>
	<td id="askPx_<%=elemID %>" valign="top" align="right" style="color: <%=theme.ask %>;"></td>
	<td id="askQty_<%=elemID %>" valign="top" align="right"></td>

	<td id="spread_<%=elemID %>" valign="top" align="right"></td>
	<td id="spreadBps_<%=elemID %>" valign="top" align="right"></td>

	<td id="ticks_<%=elemID %>" valign="top" align="right"></td>

	<td id="live_<%=elemID %>" valign="top" align="center" style="color: <%=inst.getTopOfBook().isLive() ? theme.positive : theme.negative %>;"></td>

	<td id="utime_<%=elemID %>" valign="top" align="right"></td>

</tr>	


<%

for (TopOfBook tob : inst.topOfBooks)
{
    if (tob.mdSource.equals(inst.topOfBook.mdSource))
        continue;

    elemID = inst.getInstrumentID().replaceAll("\\.", "_") + "_" + tob.mdSource.replaceAll("\\.", "_");
    
%>

<tr>
	<td id="symbol_<%=elemID %>" valign="top"></td>
	<td valign="top"></td>
	<td valign="top"></td>

	<td id="mdSource_<%=elemID %>" valign="top">
		<%=tob.mdSource %>
	</td>

	<td id="bidQty_<%=elemID %>" valign="top" align="right"></td>
	<td id="bidPx_<%=elemID %>" valign="top" align="right" style="color: <%=theme.bid %>;"></td>
	<td id="askPx_<%=elemID %>" valign="top" align="right" style="color: <%=theme.ask %>;"></td>
	<td id="askQty_<%=elemID %>" valign="top" align="right"></td>

	<td id="spread_<%=elemID %>" valign="top" align="right"></td>
	<td id="spreadBps_<%=elemID %>" valign="top" align="right"></td>

	<td id="ticks_<%=elemID %>" valign="top" align="right"></td>

	<td id="live_<%=elemID %>" valign="top" align="center" style="color: <%=inst.getTopOfBook().isLive() ? theme.positive : theme.negative %>;"></td>

	<td id="utime_<%=elemID %>" valign="top" align="right"></td>

</tr>	

<% } %>

<% } %>

<!--  status fields -->

<tr>
    <td id="cxtTime" colspan=5 align="left" style="color: <%=theme.bodyTextLight2 %>">    	
    </td>
    <td id="msgStatus" colspan=8 align="right">
    </td>
    
</tr>

</table>



<script type="text/javascript" charset="utf-8">

function fnSubmit()
{
    var url = '<%=request.getServletPath() %>';
    url += '?instID=' + frm.instID.value;

    <% if (interval != intervalDef) { %>
    	url += '&interval=<%=interval %>';
    <% } %>
    
    document.location = url;
}
</script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

<%
if (AlgoUtil.isDefined(instID))
{
String wsURL = algoConfig.getUrlPrefixWebsockets() + algoConfig.getWsTopOfBookUrl();

wsURL += "?multiSources=true";
wsURL += "&formatted=true";
wsURL += "&instID=" + instID;
wsURL += "&interval=" + interval;

%>

<script type="text/javascript" charset="utf-8">

'use strict';

var msgStatus = document.querySelector('#msgStatus');
var cxtTime = document.querySelector('#cxtTime');


var socket = new WebSocket('<%=wsURL %>');
 
socket.onopen = function(e) 
{
	msgStatus.textContent = '';
	msgStatus.textContent = 'Connected';
    msgStatus.style.color = 'green';
};

socket.onclose = function(event) 
{
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
    var elemID = message.instrumentID.replace('.', '_') + '_' + message.mdSource.replace('.', '_');
    
    var idBidQty = document.querySelector('#bidQty_'+elemID);
    var idBidPx = document.querySelector('#bidPx_'+elemID);
    var idAskQty = document.querySelector('#askQty_'+elemID);
    var idAskPx = document.querySelector('#askPx_'+elemID);
    var idLive = document.querySelector('#live_'+elemID);
    var idUtime = document.querySelector('#utime_'+elemID);
    var idSpread = document.querySelector('#spread_'+elemID);
    var idSpreadBps = document.querySelector('#spreadBps_'+elemID);

    var idTicks = document.querySelector('#ticks_'+elemID);

	idBidQty.textContent = message.bidQtyStr;
	idBidPx.textContent = message.bidStr;
	idAskQty.textContent = message.askQtyStr;
	idAskPx.textContent = message.askStr;
	
	idSpread.textContent = message.spreadStr;
	idSpreadBps.textContent = message.spreadBpsStr;

	idTicks.textContent = message.updateNumber;

	idLive.textContent = message.live ? "Y" : "N";

	idUtime.textContent = message.updateTimeDesc;
    
};

</script>
<% } %>

<% } %>


<jsp:include page="_footer.jsp" flush="true" />


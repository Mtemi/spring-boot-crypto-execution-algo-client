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
%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />

<br>

<% if (instruments != null) { %>

<table width="90%" cellpadding=5 align="center">

<tr bgcolor="<%=theme.headerBg %>">
	<td colspan=1 rowspan=2><b>InstrumentID</b></td>
	<td colspan=1 rowspan=2><b>Symbol</b></td>
	<td colspan=1 rowspan=2><b>Exchange</b></td>
	<td colspan=1 rowspan=2><b>Description</b></td>
	<td colspan=1 rowspan=2><b>Type</b></td>
	<td colspan=1 rowspan=2><b>Base<br>Asset</b></td>
	<td colspan=1 rowspan=2><b>Quote<br>Asset</b></td>
	<td colspan=1 rowspan=2><b>TimeZone</b></td>
	<td colspan=1 rowspan=2 align="right"><b>Price<br>Tick Size</b></td>
	<td colspan=1 rowspan=2 align="right"><b>Quantity<br>Tick Size</b></td>
	<td colspan=1 rowspan=2 align="right"><b>Contract<br>Size</b></td>
	<td colspan=1 rowspan=2 align="right"><b>Lot<br>Size</b></td>
	
	<td colspan=1 rowspan=2 align="right"><b>Last<br>Price</b></td>

	<td colspan=4 rowspan=1 align="center"><b>Top Of Book</b></td>

</tr>

<tr bgcolor="<%=theme.headerBg %>">
	
	<td colspan=1 rowspan=1 align="right"><b>Bid Qty</b></td>
	<td colspan=1 rowspan=1 align="right"><b>Bid Px</b></td>
	<td colspan=1 rowspan=1 align="right"><b>Ask Px</b></td>
	<td colspan=1 rowspan=1 align="right"><b>Ask Qty</b></td>

</tr>

<% for (int i=0; i<instruments.size(); i++) { 
    Instrument inst = instruments.get(i);
%>

<tr bgcolor="<%=(i % 2 == 1) ? theme.rawHighlight : theme.raw %>">
	<td valign="top"><%=inst.getInstrumentID() %></td>
	<td valign="top"><%=inst.getSymbol() %></td>
	<td valign="top"><%=inst.getExchange() %></td>
	<td valign="top"><%=inst.getDesc() %></td>
	<td valign="top"><%=inst.getInstType() %></td>
	<td valign="top"><%=inst.getBaseAsset() %></td>
	<td valign="top"><%=inst.getQuoteAsset() %></td>
	<td valign="top"><%=inst.getTimezone() %></td>
	<td valign="top" align="right"><%=AlgoUtil.numericFormat(inst.getTickSize(), inst.getPriceDecimals()) %></td>
	<td valign="top" align="right"><%=AlgoUtil.numericFormat(inst.getTickSizeQty(), inst.getQuantityDecimals()) %></td>
	<td valign="top" align="right"><%=AlgoUtil.numericFormat(inst.getContractSize(), 2) %></td>
	<td valign="top" align="right"><%=AlgoUtil.numericFormat(inst.getLotSize(), 0) %></td>
	<td valign="top" align="right"><%=AlgoUtil.numericFormat(inst.getLastPrice(), inst.getPriceDecimals()) %></td>

	<td valign="top" align="right"><%=AlgoUtil.numericFormat(inst.getTopOfBook().getBidQty(), inst.getQuantityDecimals()) %></td>
	<td valign="top" align="right" style="color: <%=theme.bid %>;">
		<%=AlgoUtil.numericFormat(inst.getTopOfBook().getBid(), inst.getPriceDecimals()) %>
	</td>
	<td valign="top" align="right" style="color: <%=theme.ask %>;">
		<%=AlgoUtil.numericFormat(inst.getTopOfBook().getAsk(), inst.getPriceDecimals()) %>
	</td>
	<td valign="top" align="right"><%=AlgoUtil.numericFormat(inst.getTopOfBook().getAskQty(), inst.getQuantityDecimals()) %></td>

</tr>	

<% } %>

</table>

<% } %>


<jsp:include page="_footer.jsp" flush="true" />


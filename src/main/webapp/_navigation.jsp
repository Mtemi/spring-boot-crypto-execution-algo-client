<%@page import="com.ismail.algo.AppClientServices"%>
<%@page import="com.ismail.algo.AlgoUtil"%>
<%@page import="com.ismail.algo.AlgoClientApp"%>
<%@page import="com.ismail.algo.config.ColorThemeConfig"%>

<!--  Main Navigation -->

<%
AppClientServices appServices = AppClientServices.getInstance();
ColorThemeConfig theme = appServices.colorTheme;

String spath = request.getServletPath();

String strategyID = AlgoUtil.getParameter(request, "strategyID", "");

boolean selectedTab = false;

%>

<br>       
<table width="100%" align="center" cellspacing=0 cellpadding=1>
<tr height=30>
    <td width=20%></td>
    
    <% selectedTab = spath.contains("/index.jsp"); %>
    <td width=5></td>   
    <td class="tab_round<%=selectedTab ? "s" : "" %>" width=150 align="center" bgcolor="<%=selectedTab ? theme.tab0s : theme.tab0 %>"> 
        <a href="/" style="color: <%=theme.tab0Text %>;">Home</a>       
    </td>

    <% selectedTab = spath.contains("/algo"); %>
    <td width=5></td>   
    <td class="tab_round<%=selectedTab ? "s" : "" %>" width=150 align="center" bgcolor="<%=selectedTab ? theme.tab0s : theme.tab0 %>"
    	title="View Available Algorithms, their objectives, parameters and default values"> 
        <a href="/algos.jsp" style="color: <%=theme.tab0Text %>;">Algos</a>       
    </td>

    <% selectedTab = spath.equals("/new_order.jsp"); %>
    <td width=2></td>       
    <td class="tab_round<%=selectedTab ? "s" : "" %>" width=150 align="center" bgcolor="<%=spath.equals("/new_order.jsp") ? theme.tab0s : theme.tab0 %>"
    	title="Place a new Algo order; and watch it trade">
        <a href="/new_order.jsp<%=AlgoUtil.isDefined(strategyID) ? "?strategyID=" + strategyID : "" %>" 
        	style="color: <%=theme.tab0Text %>;">New Order Request</a>       
    </td>


    <% selectedTab = spath.equals("/orders.jsp") || spath.startsWith("/order_"); %>
    <td width=2></td>       
    <td class="tab_round<%=selectedTab ? "s" : "" %>" width=150 align="center" bgcolor="<%=(spath.equals("/orders.jsp") || spath.startsWith("/order_")) ? theme.tab0s : theme.tab0 %>"
    	title="View orders and trades">
        <a href="/orders.jsp" style="color: <%=theme.tab0Text %>;">Orders</a>       
    </td>

    <% selectedTab = spath.contains("/topOfBooks.jsp"); %>
    <td width=5></td>   
    <td class="tab_round<%=selectedTab ? "s" : "" %>" width=150 align="center" bgcolor="<%=spath.contains("/topOfBooks.jsp") ? theme.tab0s : theme.tab0 %>"
    	title="View live top of book">
        <a href="topOfBooks.jsp" style="color: <%=theme.tab0Text %>;">Top Of Book</a>     
    </td>
    
    <% selectedTab = spath.contains("/topOfBooksMulti.jsp"); %>
    <td width=5></td>   
    <td class="tab_round<%=selectedTab ? "s" : "" %>" width=150 align="center" bgcolor="<%=spath.contains("/topOfBooksMulti.jsp") ? theme.tab0s : theme.tab0 %>"
    	title="View live top of book; from multiple sources">
        <a href="topOfBooksMulti.jsp" style="color: <%=theme.tab0Text %>;">Top Of Book Multi</a>     
    </td>
    
    <% selectedTab = spath.contains("/instruments.jsp"); %>
    <td width=5></td>   
    <td class="tab_round<%=selectedTab ? "s" : "" %>" width=150 align="center" bgcolor="<%=spath.contains("/instruments.jsp") ? theme.tab0s : theme.tab0 %>"
    	title="View instrument list">
        <a href="/instruments.jsp" style="color: <%=theme.tab0Text %>;">Instruments</a>     
    </td>
    
    <% selectedTab = spath.contains("/support.jsp"); %>
    <td width=5></td>   
    <td class="tab_round<%=selectedTab ? "s" : "" %>" width=150 align="center" bgcolor="<%=spath.contains("/support.jsp") ? theme.tab0s : theme.tab0 %>"
    	title="Support">
        <a href="/support.jsp" style="color: <%=theme.tab0Text %>;">Support</a>     
    </td>
                                                       
    <td width=20%></td>         
</tr>

<tr><td colspan=31 height=4 bgcolor=<%=theme.tab0s %>></td>

</table>
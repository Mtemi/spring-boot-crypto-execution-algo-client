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

%>

<br>       
<table width="100%" align="center" cellspacing=0 cellpadding=1>
<tr height=30>
    <td width=20%></td>
    
    <td width=5></td>   
    <td width=150 align="center" bgcolor=<%=spath.contains("/index.jsp") ? theme.tab0s : theme.tab0 %>> 
        <a href="/" style="color: <%=theme.tab0Text %>;">Home</a>       
    </td>

    <td width=5></td>   
    <td width=150 align="center" bgcolor=<%=spath.contains("/algo") ? theme.tab0s : theme.tab0 %>> 
        <a href="/algos.jsp" style="color: <%=theme.tab0Text %>;">Algos</a>       
    </td>

    <td width=2></td>       
    <td width=150 align="center" bgcolor=<%=spath.equals("/new_order.jsp") ? theme.tab0s : theme.tab0 %>>
        <a href="/new_order.jsp<%=AlgoUtil.isDefined(strategyID) ? "?strategyID=" + strategyID : "" %>" 
        	style="color: <%=theme.tab0Text %>;">New Order Request</a>       
    </td>


    <td width=2></td>       
    <td width=150 align="center" bgcolor=<%=(spath.equals("/orders.jsp") || spath.startsWith("/order_")) ? theme.tab0s : theme.tab0 %>>
        <a href="/orders.jsp" style="color: <%=theme.tab0Text %>;">Orders</a>       
    </td>

    <td width=5></td>   
    <td width=150 align="center" bgcolor=<%=spath.contains("/topOfBooks.jsp") ? theme.tab0s : theme.tab0 %> >
        <a href="topOfBooks.jsp" style="color: <%=theme.tab0Text %>;">Top Of Book Live</a>     
    </td>
    

    <td width=5></td>   
    <td width=150 align="center" bgcolor=<%=spath.contains("/instruments.jsp") ? theme.tab0s : theme.tab0 %> >
        <a href="/instruments.jsp" style="color: <%=theme.tab0Text %>;">Instruments</a>     
    </td>
    

                                                       
    <td width=20%></td>         
</tr>

<tr><td colspan=31 height=4 bgcolor=<%=theme.tab0s %>></td>

</table>
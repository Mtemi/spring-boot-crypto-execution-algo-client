
<%@page import="com.ismail.algo.model.ContactUsRequest"%>
<%@page import="com.ismail.algo.model.BusinessApiException"%>
<%@page import="com.ismail.algo.AlgoUtil"%>
<%@page import="com.ismail.algo.controller.PageInfo"%>
<%@page import="com.ismail.algo.config.AlgoClientConfig"%>
<%@page import="com.ismail.algo.service.AlgoClientApiService"%>
<%@page import="com.ismail.algo.config.ColorThemeConfig"%>
<%@page import="com.ismail.algo.AppClientServices"%>
<%
AppClientServices appServices = AppClientServices.getInstance();
ColorThemeConfig theme = appServices.colorTheme;
AlgoClientApiService apiService = appServices.apiService;
AlgoClientConfig algoConfig = appServices.config;

//set this page title
PageInfo pageInfo = AlgoUtil.getPageInfo(request);
pageInfo.appTitle = algoConfig.getWebMainTitle();
pageInfo.pageTitle = algoConfig.getWebMainTitle() + " - Support";

int MESSAGE_MAX_LENGTH = 3000;

String a = AlgoUtil.getParameter(request, "a", null);

String name = AlgoUtil.getParameter(request, "name", null);
String email = AlgoUtil.getParameter(request, "email", null);
String subject = AlgoUtil.getParameter(request, "subject", null);
String message = AlgoUtil.getParameter(request, "message", null);


String spath = request.getServletPath();
String qs = request.getQueryString();



try
{   
	if ("contactUs".equals(a))
	{
	    if (AlgoUtil.isDefined(name) == false)
	        throw new BusinessApiException("Name is required");

	    if (AlgoUtil.isDefined(email) == false)
	        throw new BusinessApiException("Email is required");

	    if (email.contains("@") == false)
	        throw new BusinessApiException("Email is invalid");

	    if (AlgoUtil.isDefined(subject) == false)
	        throw new BusinessApiException("Subject is required");

	    if (AlgoUtil.isDefined(message) == false)
	        throw new BusinessApiException("Message body is required");

	    if (message.length() > MESSAGE_MAX_LENGTH)
	        throw new BusinessApiException("Message body is too long [" + message.length() + "], max Length is " + MESSAGE_MAX_LENGTH);

	    
	    ContactUsRequest contactReq = new ContactUsRequest();
	    contactReq.name = name;
	    contactReq.email = email;
	    contactReq.subject = subject;
	    contactReq.message = message;
	    
	    contactReq.ipAddr = request.getRemoteAddr();
	    contactReq.userAgent = request.getHeader("User-Agent");
	    
	    contactReq.appURL = request.getServerName() + ":" + request.getServerPort();
	    
	    apiService.contactUs(contactReq);
	                
	    pageInfo.successMsg = "Thanks for contacting us. Your message have been received.";
	}
}
catch (BusinessApiException e)
{
    pageInfo.errorMsg = e.getMessage();	
}
catch (Exception e)
{
    pageInfo.errorMsg = "Error submitting contact us detail";
    
    e.printStackTrace();
}

String WIDTH = "60%";

%>

<jsp:include page="_header.jsp" flush="true" />
<jsp:include page="_navigation.jsp" flush="true" />


<table width="<%=WIDTH %>" align="center" cellpadding="5">

<form name="frmEdit" action="<%=spath %>" method="post">
<input type="hidden" name="a" value="">
  
  
<tr >
    <td align="left" colspan=2>
    <h2>Contact Us</h2>
	<br>
	If you have any question or a query; please fill in the fields below.
	<br>
	We will get back to you as soon as we can.
    </td>
</tr>

<tr nowrap>
	<td bgcolor="<%=theme.rawHighlight %>" nowrap><b>Name (<font color="<%=theme.negative %>">*</font>)</b></td>
    <td>
        <input type="text" name="name" size=20 maxlength="60" value="<%=name==null ? "" : name %>" 
        	placeholder="Name" autocomplete="false"
        	style="width: 300px; height: 20px;">
    </td>
</tr>

<tr >
	<td bgcolor="<%=theme.rawHighlight %>" nowrap><b>Email (<font color="<%=theme.negative %>">*</font>)</b></td>
    <td>
        <input type="text" name="email" size=50 maxlength="100" value="<%=email==null ? "" : email %>" 
        	placeholder="Email" autocomplete="false"
        	style="width: 300px; height: 20px;">
    </td>
</tr>

<tr >
	<td bgcolor="<%=theme.rawHighlight %>" nowrap><b>Subject (<font color="<%=theme.negative %>">*</font>)</b></td>
    <td>
        <input type="text" name="subject" size=50 maxlength="200" value="<%=subject==null ? "" : subject %>" 
        	placeholder="Subject" autocomplete="false"
        	style="width: 80%; height: 20px;">
    </td>
</tr>

<tr >
	<td valign="top" bgcolor="<%=theme.rawHighlight %>" nowrap><b>Message (<font color="<%=theme.negative %>">*</font>)</b></td>
    <td  valign="top" >
    	<textarea name="message" cols="100" rows="5" style="width: 80%; height: 200px;"
    		placeholder="Message" ><%=message != null ? message : "" %></textarea>
    </td>
</tr>

			

<tr><td colspan="2"><i>(*) Required fields</i></td></tr>


<tr >
    <td align="right" colspan=2>
		<input type="button" name="btnSubmit" value="  Submit  " 
			style="width: 200px; height: 30px;"
			onClick="javascript: fnContactUs();" />
    </td>
</tr>

</form>

</table>

<script type="text/javascript">
function fnContactUs()
{
	frmEdit.a.value='contactUs';
	frmEdit.submit();
}

</script>



<jsp:include page="_footer.jsp" flush="true" />


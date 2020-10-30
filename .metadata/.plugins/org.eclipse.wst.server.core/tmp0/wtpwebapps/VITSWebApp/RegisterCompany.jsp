<%@page import="forms.CompanyForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }
td{font-size:17px;font-weight: bold}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Company</title>
</head>
<body>
<%
CompanyForm compform = (CompanyForm)session.getAttribute("companyForm");
if(compform != null){
System.out.println("JSP TEXT" + compform.getErrortext());
}else{
System.out.println("JSP TEXT NULL OBJECT");
}
 %>

<div align="center" style="margin-top: 50px;">
<FORM ID="companyform" NAME="companyform" METHOD="POST" ACTION="Company">
<TABLE cellpadding="0" cellspacing="0" border="1" bgcolor="#FFFFCC" width="100%">
<tr><td class="header" colspan="7" height="30px" align="center" style="font-size:13px;font-weight: bold">Register Company</td></tr>
	<TR>
		<TD class="text">&nbsp;&nbsp;Company Name</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="compname" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Company Address</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="compadd" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	<TR>
		<TD class="text" colspan="2" align="center"><INPUT TYPE="SUBMIT" NAME="Submit" class="text" value="" style="background:url(images/submit.jpg) no-repeat;width:55px;height:25px" /></TD>
	</TR>
	<%if(compform != null && compform.getErrortext()!=null){%>
	<TR>
		<TD class="text" colspan="2" align="center" style= "background-color: #ff3333";><%=compform.getErrortext()%></TD>
	</TR>
	<%} %>
</TABLE>
</form>
</div>
</body>
</html>


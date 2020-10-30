<%@page import="forms.SchemeForm"%>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.Set" %>
<%@page import="java.util.Iterator" %>

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
<title>Register Schemes</title>
</head>
<body>
<div align="center" style="margin-top: 50px;">
<FORM ID="schemeform" NAME="schemeform" METHOD="POST" ACTION="Scheme">
<TABLE cellpadding="0" cellspacing="0" border="1" bgcolor="#FFFFCC" width="100%">
<tr><td class="header" colspan="7" height="30px" align="center" style="font-size:13px;font-weight: bold">Register Scheme</td></tr>
	<TR>
		<TD class="text">&nbsp;&nbsp;Scheme Name</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="schemename" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
<% 
SchemeForm schemeform = (SchemeForm)session.getAttribute("schemeForm");
if(schemeform != null){
	System.out.println("JSP TEXT" + schemeform.getErrortext());
}else{
	System.out.println("JSP TEXT NULL OBJECT");
}

ServletContext app = getServletContext();
HashMap companyMap = (HashMap)app.getAttribute("CompanyList");
System.out.println("CompanyMap HashMap USED");

int mapSize = companyMap.size();
for(int i=1; i<=mapSize ; i++){
	System.out.println("VALUE ===>" + companyMap.get(new Integer(i)));				
}

%>
	<TR>
		<TD class="text">&nbsp;&nbsp;Company Name</TD>
		<TD valign="top">
		<select name="schemecompid">
		<%for(int i=1; i<=mapSize ; i++){%>
			<option value='<%=i%>'><%=companyMap.get(new Integer(i))%></option>
		<% } %>
		</select>
		</TD>
	</TR>
	<TR>
		<TD class="text" colspan="2" align="center"><INPUT TYPE="SUBMIT" NAME="Submit" class="text" value="" style="background:url(images/submit.jpg) no-repeat;width:55px;height:25px" /></TD>
	</TR>
	<% if(schemeform != null && schemeform.getErrortext()!=null){ %>
	<TR>
		<TD class="text" colspan="2" align="center" style= "background-color: #ff3333";><%=schemeform.getErrortext()%></TD>
	</TR>
	<% } %>
</TABLE>
</form>
</div>
</body>
</html>


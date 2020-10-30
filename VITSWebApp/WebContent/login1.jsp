<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login to Vehicle Insurance Tracking System</title>
</head>
<body>
<%String error = (String)request.getAttribute("error"); %>

<div align="center" style="margin-top: 50px;">
<FORM ID="mainform" NAME="loginform" METHOD="POST" ACTION="Login">
<TABLE cellpadding="0" cellspacing="0" border="1">
<%if(error != null && !("null".equals(error))){ %>
	<TR>
		<TD class="header" colspan="2" align="center"><%=error%></TD>
	</TR>
<%}%>
	<TR>
		<TD class="header" colspan="2" align="center">Existing users</TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;User Id</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="username" SIZE="18"
			MAXLENGTH="8" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Password</TD>
		<TD valign="top"><INPUT TYPE="password" NAME="password" SIZE="18"
			MAXLENGTH="16" class="text"></TD>
	</TR>
	<TR>
		<TD class="text" colspan="2"><INPUT TYPE="SUBMIT" NAME="Login"
			class="text" value="Login">
	</TR>
</TABLE>
</form>
</div>
</body>
</html>


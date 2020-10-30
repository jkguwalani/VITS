<%@page import="java.util.*" %>
<%@page import="forms.UserForm"%>
<%@page import="dto.UserTO"%>
<%@page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<% 
UserForm userForm = (UserForm)session.getAttribute("userForm");
if(userForm != null){
	System.out.println("JSP TEXT" + userForm.getErrortext());
}else{
	System.out.println("JSP TEXT NULL OBJECT");
}

ServletContext app = getServletContext();
HashMap functionalityMap=(HashMap)app.getAttribute("FunctionalityList");
System.out.println("CompanyMap HashMap USED");

int mapSize = functionalityMap.size();
for(int i=1; i<=mapSize ; i++){
	System.out.println("VALUE ===>" + functionalityMap.get(new Integer(i)));				
}

%>
<div align="center" style="margin-top: 50px;">
<FORM ID="userform" NAME="userform" METHOD="POST" ACTION="User">
<TABLE cellpadding="0" cellspacing="0" border="1" bgcolor="#FFFFCC" width="100%">
<tr><td class="header" colspan="7" height="30px" align="center" style="font-size:13px;font-weight: bold">Register User</td></tr>
	<TR>
		<TD class="text">&nbsp;&nbsp;User Name</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="username" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
		
	<TR>
		<TD class="text">&nbsp;&nbsp;User Type</TD>
		<TD valign="top">
			<select name="usertype">
			<option value="Agent">Agent</option>
			<option value="Client">Client</option>		
			</select>		
		</TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;User Password</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="userpassword" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;User Type</TD>
		<TD valign="top">
		<%
			Iterator entries = functionalityMap.entrySet().iterator();
			while (entries.hasNext()) {
				Map.Entry entry = (Map.Entry) entries.next();
			    Integer key = (Integer)entry.getKey();		
		%>
		<input type="checkbox" name="userFunctionality" value="<%=key%>"><%=functionalityMap.get(key)%></input></br>
		<% } %>		
		</TD>
	</TR>
	
	<TR>
		<TD class="text" colspan="2" align="center"><INPUT TYPE="SUBMIT" NAME="Submit" class="text" value="" style="background:url(images/submit.jpg) no-repeat;width:55px;height:25px" /></TD>
	</TR>
	
	<% if(userForm != null && userForm.getErrortext()!=null){ %>
	<TR>
		<TD class="text" colspan="2" align="center" style= "background-color: #ff3333";><%=userForm.getErrortext()%></TD>
	</TR>
	<% } %>
	
	
</TABLE>
</form>
</div>
</body>
</html>


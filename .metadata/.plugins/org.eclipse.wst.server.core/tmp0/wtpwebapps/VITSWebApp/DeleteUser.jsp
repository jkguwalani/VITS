<%@page import="forms.LogonForm"%>
<%@page import="java.util.*" %>
<%@page import="dto.UserTO"%>
<%@page import="forms.UserForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }
td{font-size:17px;font-weight: bold}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete User</title>
</head>
<body>
<%
ServletContext app = getServletContext();
HashMap DisplayUserList = (HashMap)app.getAttribute("DisplayUserListForDeletion");
HashMap map=(HashMap)app.getAttribute("FunctionalityList");

if(DisplayUserList != null)
	System.out.println("DisplayUserList is not null");
else
	System.out.println("DisplayUserList is null");


UserForm deleteUserForm=(UserForm)session.getAttribute("deleteUserForm");
if(deleteUserForm != null)
	System.out.println("deleteUserForm not null");


LogonForm logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM deleler user");

%>

<FORM ID="viewuserform" NAME="viewuserform" METHOD="POST" ACTION="DeleteUserAction">
<TABLE align="center" bgcolor="#FFFFCC" border="1" width="100%">

<% if(deleteUserForm != null && deleteUserForm.getErrortext()!=null){ %>
<TR>
	<TD class="text" colspan="6" align="center" style= "background-color: #ff3333";><%=deleteUserForm.getErrortext()%></TD>
</TR>
<% } %>


<tr><td class="header" colspan="12" height="30px" align="center" style="font-size:13px;font-weight: bold">User Id</td></tr>

	<TR>
		<TD class="text">User Id</TD>
		<TD class="text">User Name</TD>
		<TD class="text">User Type</TD>
		<TD class="text">Functionalities</TD>
		<TD class="text">Create Date</TD>
		<TD class="text">Delete User</TD>
		<!-- <TD class="text">Delete User</TD> -->
	</TR>
<%
	Iterator entries = DisplayUserList.entrySet().iterator();
	while (entries.hasNext()) {
	    Map.Entry entry = (Map.Entry) entries.next();
	    Integer key = (Integer)entry.getKey();
	    UserTO userTO = (UserTO)entry.getValue();
	    System.out.println("UserTO VALUE= " + userTO.getUsername() + "USER fun = " + userTO.getFunctionalities());
	    if(!logonForm.getUid().equals(userTO.getUserId().toString())){

%>
<TR>
<TD><%=userTO.getUserId()%></TD>
<TD><%=userTO.getUsername()%></TD>
<TD><%=userTO.getUserType()%></TD>

<TD>
<% 
	if (userTO.getFunctionalities().size() > 0){
    	ArrayList list = userTO.getFunctionalities();
    	for(int i=0; i<list.size();i++){
    		System.out.println("User = " + userTO.getUserId() + "Fun List" + list.get(i));
%>

<%=map.get(list.get(i))%>

<%} %>
</TD>
<TD><%=userTO.getCreateDate()%></TD>

<!-- <TD><input type="radio" name="updateuser" value="update^<%=userTO.getUserId()%>"></TD> -->
<TD><input type="radio" name="deleteuser" value="<%=userTO.getUserId()%>"></TD>
</TR>
<%}}}%>

<TR>
	<TD class="text" colspan="6" align="center"><INPUT TYPE="SUBMIT" NAME="Submit" class="text" value="" style="background:url(images/submit.jpg) no-repeat;width:55px;height:25px" /></TD>
</TR>
</TABLE>

</FORM> 
</body>
</html>

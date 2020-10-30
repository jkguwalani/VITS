<%@page import="forms.LogonForm"%>
<%@page import="java.util.*" %>
<%@page import="dto.UserTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }
td{font-size:17px;font-weight: bold}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Agent Details</title>
</head>
<body>
<%
ServletContext app = getServletContext();
HashMap DisplayUserList = (HashMap)app.getAttribute("DisplayUserList");
HashMap map=(HashMap)app.getAttribute("FunctionalityList");

if(DisplayUserList != null)
	System.out.println("DisplayUserList is not null");
else
	System.out.println("DisplayUserList is null");

%>

<FORM ID="viewuserform" NAME="viewuserform" METHOD="POST" ACTION="ViewUser">
<TABLE cellpadding="0" cellspacing="0" border="1" bgcolor="#FFFFCC">
<tr><td class="header" colspan="12" height="30px" align="center" style="font-size:13px;font-weight: bold">View Users</td></tr>

	<TR>
		<TD class="text">User Id</TD>
		<TD class="text">User Name</TD>
		<TD class="text">User Type</TD>
		<TD class="text">Functionalities</TD>
		<TD class="text">Create Date</TD>
	</TR>
<%
	Iterator entries = DisplayUserList.entrySet().iterator();
	while (entries.hasNext()) {
	    Map.Entry entry = (Map.Entry) entries.next();
	    Integer key = (Integer)entry.getKey();
	    UserTO userTO = (UserTO)entry.getValue();
	    System.out.println("UserTO VALUE= " + userTO.getUsername() + "USER fun = " + userTO.getFunctionalities());

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

<%} }%>
</TD>
<TD><%=userTO.getCreateDate()%></TD>
</TR>
<%}%>

</TABLE>


</body>
</html>

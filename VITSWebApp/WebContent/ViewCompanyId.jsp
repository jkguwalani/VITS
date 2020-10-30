<%@page import="forms.LogonForm"%>
<%@page import="java.util.*" %>
<%@page import="dto.AgentTO"%>
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
HashMap DisplayCompanyList = (HashMap)app.getAttribute("DisplayCompanyList");

if(DisplayCompanyList != null)
	System.out.println("DisplayCompanyList is not null");
else
	System.out.println("DisplayCompanyList is null");

%>

<FORM ID="viewagentform" NAME="viewcompanyform" METHOD="POST" ACTION="ViewCompany">
<TABLE align="center" bgcolor="#FFFFCC" border="1" width="100%">
<tr><td class="header" colspan="12" height="30px" align="center" style="font-size:13px;font-weight: bold">View Company</td></tr>

	<TR>
		<TD class="text">Company Id</TD>
		<TD class="text">Company Name</TD>
	</TR>
<% 
Iterator entries = DisplayCompanyList.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    String value = (String)entry.getValue();
    System.out.println("Company VALUE=" + value);
%>
<TR>
<TD><%=key%></TD>
<TD><%=value%></TD>
</TR>

<%} %>
</TABLE>


</body>
</html>

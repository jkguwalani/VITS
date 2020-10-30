<%@page import="forms.LogonForm"%>
<%@page import="java.util.*" %>
<%@page import="dto.SchemeTO"%>
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
HashMap DisplaySchemeList = (HashMap)app.getAttribute("DisplaySchemeList");

if(DisplaySchemeList != null)
	System.out.println("DisplaySchemeList is not null");
else
	System.out.println("DisplaySchemeList is null");

%>

<FORM ID="viewschemeform" NAME="viewschemeform" METHOD="POST" ACTION="ViewScheme">
<TABLE align="center" bgcolor="#FFFFCC" border="1" width="100%">
<tr><td class="header" colspan="12" height="30px" align="center" style="font-size:13px;font-weight: bold">View Scheme</td></tr>

	<TR>
		<TD class="text">Scheme Code</TD>
		<TD class="text">Scheme Name</TD>
		<TD class="text">Scheme Company Code</TD>
		<TD class="text">Scheme Company Name</TD>
	</TR>
<% 
Iterator entries = DisplaySchemeList.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    SchemeTO schemeTO = (SchemeTO)entry.getValue();
    System.out.println("SchemeTO VALUE=" + schemeTO.getSchemeName());
%>
<TR>
<TD><%=schemeTO.getSchemeId()%></TD>
<TD><%=schemeTO.getSchemeName()%></TD>
<TD><%=schemeTO.getSchemeCompId()%></TD>
<TD><%=schemeTO.getSchemeCompName()%></TD>
</TR>

<%} %>
</TABLE>


</body>
</html>

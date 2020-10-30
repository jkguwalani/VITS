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
HashMap DisplayAgentList = (HashMap)app.getAttribute("DisplayAgentList");

if(DisplayAgentList != null)
	System.out.println("DisplayAgentList is not null");
else
	System.out.println("DisplayAgentList is null");

%>

<FORM ID="viewagentform" NAME="viewagentform" METHOD="POST" ACTION="ViewAgent">
<TABLE align="center" bgcolor="#FFFFCC" border="1" width="100%">
<tr><td class="header" colspan="12" height="30px" align="center" style="font-size:13px;font-weight: bold">View Agent</td></tr>

	<TR>
		<TD class="text">Agent Id</TD>
		<TD class="text">Agent Name</TD>
		<TD class="text">Scheme Code</TD>
		<TD class="text">Scheme Name</TD>
		<TD class="text">Company Code</TD>
		<TD class="text">Company Name</TD>
		<TD class="text">Branch Code</TD>
		<TD class="text">Branch Name</TD>
		<TD class="text">SM Code</TD>
		<TD class="text">SM Name</TD>
		<TD class="text">Vendor Code</TD>
		<TD class="text">Vendor Name</TD>
	</TR>
<% 
Iterator entries = DisplayAgentList.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    AgentTO agentTO = (AgentTO)entry.getValue();
    System.out.println("AgentTO VALUE=" + agentTO.getAgentName());
%>
<TR>
<TD><%=agentTO.getAgentCode()%></TD>
<TD><%=agentTO.getAgentName()%></TD>
<TD><%=agentTO.getSchemeId()%></TD>
<TD><%=agentTO.getSchemeName()%></TD>
<TD><%=agentTO.getCompanyId()%></TD>
<TD><%=agentTO.getCompanyName()%></TD>
<TD><%=agentTO.getBranchCode()%></TD>
<TD><%=agentTO.getBranchName()%></TD>
<TD><%=agentTO.getSmCode()%></TD>
<TD><%=agentTO.getSmName()%></TD>
<TD><%=agentTO.getVendorCode()%></TD>
<TD><%=agentTO.getVendorName()%></TD>
</TR>

<%} %>
</TABLE>


</body>
</html>

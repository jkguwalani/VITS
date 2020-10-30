<%@page import="forms.LogonForm"%>
<%@page import="java.util.*" %>
<%@page import="dto.PolicyTO"%>
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
HashMap DisplayPolicyList = (HashMap)app.getAttribute("DisplayPolicyList");

if(DisplayPolicyList != null)
	System.out.println("DisplayPolicyList is not null");
else
	System.out.println("DisplayPolicyList is null");

%>

<FORM ID="viewpolicyform" NAME="viewpolicyform" METHOD="POST" ACTION="ViewPolicy">
<TABLE align="center" bgcolor="#FFFFCC" border="1" width="100%">
<tr><td class="header" colspan="21" height="30px" align="center" style="font-size:13px;font-weight: bold">View Policy</td></tr>

	<TR>
		<TD class="text">Policy Number</TD>
		<TD class="text">Policy Type</TD>
		<TD class="text">Policy Issued On</TD>
		<TD class="text">Policy Issuing Office</TD>
		<TD class="text">Proposer's Name</TD>
		<TD class="text">Address</TD>
		<TD class="text">Pincode</TD>
		<TD class="text">Email Address</TD>
		<TD class="text">Contact Number</TD>
		<TD class="text">Pancard</TD>
		<TD class="text">Type Of Vehicle</TD>
		<TD class="text">Model</TD>
		<!-- <TD class="text">User Id</TD> -->
		<!-- <TD class="text">Agent Id</TD> -->
		<TD class="text">Agent Name</TD>
		<TD class="text">Scheme Code</TD>
		<TD class="text">Scheme Name</TD>
		<TD class="text">Branch Code</TD>
		<TD class="text">Branch Name</TD>
		<TD class="text">SM Code</TD>
		<TD class="text">SM Name</TD>
		<TD class="text">Vendor Code</TD>
		<TD class="text">Vendor Name</TD>
	</TR>
<% 
Iterator entries = DisplayPolicyList.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    PolicyTO policyTO = (PolicyTO)entry.getValue();
    System.out.println("PolicyTO VALUE=" + policyTO.getPolicyNumber());
%>
<TR>
<TD><%=policyTO.getPolicyNumber()%></TD>
<TD><%=policyTO.getPolicyType()%></TD>
<TD><%=policyTO.getPolicyIssuedOn()%></TD>
<TD><%=policyTO.getPolicyInsuranceOffice()%></TD>
<TD><%=policyTO.getProposersName()%></TD>
<TD><%=policyTO.getAddress()%></TD>
<TD><%=policyTO.getPincode()%></TD>
<TD><%=policyTO.getEmailAddress()%></TD>
<TD><%=policyTO.getContactNumber()%></TD>
<TD><%=policyTO.getPancardNumber()%></TD>
<TD><%=policyTO.getTypeOfVehicle()%></TD>
<TD><%=policyTO.getModel()%></TD>
<!-- <TD><%=policyTO.getUserId()%></TD> -->
<!-- <TD><%=policyTO.getAgentCode()%></TD> -->
<TD><%=policyTO.getAgentName()%></TD>
<TD><%=policyTO.getSchemeId()%></TD>
<TD><%=policyTO.getSchemeName()%></TD>
<TD><%=policyTO.getBranchCode()%></TD>
<TD><%=policyTO.getBranchName()%></TD>
<TD><%=policyTO.getSmCode()%></TD>
<TD><%=policyTO.getSmName()%></TD>
<TD><%=policyTO.getVendorCode()%></TD>
<TD><%=policyTO.getVendorName()%></TD>
</TR>

<%} %>
</TABLE>


</body>
</html>

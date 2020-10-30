<%@page import="forms.PolicyForm"%>
<%@page import="dto.SchemeTO"%>
<%@page import="dto.AgentTO"%>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.*" %>
<%@page import="forms.LogonForm"%>
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
LogonForm logonForm=(LogonForm)request.getSession().getAttribute("logonform");
if(logonForm != null){
	System.out.println("LOGONFORM in PolicyServlet" + logonForm.getUid());
}else{
	System.out.println("LOGONFORM in PolicyServlet is null");
}

PolicyForm policyform = (PolicyForm)session.getAttribute("policyForm");
if(policyform != null){
	System.out.println("JSP TEXT" + policyform.getErrortext());
}else{
	System.out.println("JSP TEXT NULL OBJECT");
}

ServletContext app = getServletContext();

HashMap schemeMap = (HashMap)app.getAttribute("SchemeList");
System.out.println("SchemeMap HashMap USED");
int schememapSize = 0;
if(!schemeMap.isEmpty()){
schememapSize = schemeMap.size();
Iterator entries = schemeMap.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    SchemeTO schemeTO = (SchemeTO)entry.getValue();
    System.out.println("Scheme Key = " + key + ", SchemeValue = " + schemeTO.getSchemeName());
}
}

HashMap agentMap = (HashMap)app.getAttribute("AgentList");
System.out.println("Agent HashMap USED");

Iterator entries = agentMap.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    AgentTO agentTO = (AgentTO)entry.getValue();
    System.out.println("AgentKey = " + key + ", AgentValue = " + agentTO);
}

HashMap companyMap = (HashMap)app.getAttribute("CompanyList");
System.out.println("CompanyMap HashMap USED");
int companymapSize = companyMap.size();
for(int i=1; i<=companymapSize ; i++){
	System.out.println("COMPANY NAME VALUE ===>" + companyMap.get(new Integer(i)));				
}
%>

<div align="center" style="margin-top: 50px;">
<FORM ID="agentform" NAME="agentform" METHOD="POST" ACTION="Policy">

<TABLE cellpadding="0" cellspacing="0" border="1" bgcolor="#FFFFCC" width="100%">
<tr><td class="header" colspan="7" height="30px" align="center" style="font-size:13px;font-weight: bold">Register Policy</td></tr>
	<TR>
		<TD class="text">&nbsp;&nbsp;Policy Type</TD>
		<TD valign="top">
			<select name="policytype">
			<option value="Personal">Personal</option>
			<option value="Commercial">Commercial</option>		
			</select>		
		</TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;Scheme/Company/Agent Name</TD>
		<TD valign="top">
	<%
	entries = agentMap.entrySet().iterator();
	while (entries.hasNext()) {
	    Map.Entry entry = (Map.Entry) entries.next();
	    Integer key = (Integer)entry.getKey();
	    AgentTO agentTO = (AgentTO)entry.getValue();
	    System.out.println("AgentKey = " + key + ", AgentValue = " + agentTO);
	%>
		<input type="radio" name="agentid" value="<%=key%>"><%=agentTO.getSchemeName()%>/<%=agentTO.getCompanyName()%>/<%=agentTO.getAgentName()%></input>
		</br>	
	<%}%>	
	</TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Policy Issued On</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="policyissuedon" SIZE="50" MAXLENGTH="10" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Policy Issuing Office</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="policyissuingoffice" SIZE="50" MAXLENGTH="50" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Period of Insurance</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="periodofinsurance" SIZE="50" MAXLENGTH="50" class="text">months</TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;Type of Vehicle</TD>
		<TD valign="top">
			<select name="typeofvehicle">
			<option value="TwoWheeler">Two Wheeler</option>
			<option value="FourWheeler">Four Wheeler</option>		
			</select>		
		</TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;Model</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="model" SIZE="50" MAXLENGTH="50" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Proper's (Owner's) Name</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="proposersname" SIZE="50" MAXLENGTH="50" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Address</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="address" SIZE="50" MAXLENGTH="50" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Pincode</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="pincode" SIZE="50" MAXLENGTH="10" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Email Address</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="emailAddress" SIZE="50" MAXLENGTH="50" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;Contact Number</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="contactnumber" SIZE="50" MAXLENGTH="10" class="text"></TD>
	</TR>
	<TR>
		<TD class="text">&nbsp;&nbsp;PanCard Number</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="pancard" SIZE="50" MAXLENGTH="10" class="text"></TD>
	</TR>
	
	<TR><input type="hidden" name="userId" value="<%=logonForm.getUid()%>">
		<TD class="text" colspan="2" align="center">			
			<INPUT TYPE="SUBMIT" NAME="Submit" class="text" value="" style="background:url(images/submit.jpg) no-repeat;width:55px;height:25px" />
		</TD>
	</TR>
	
	<% if(policyform != null && policyform.getErrortext()!=null){ %>
	<TR>
		<TD class="text" colspan="2" align="center" style= "background-color: #ff3333";><%=policyform.getErrortext()%></TD>
	</TR>
	<% } %>
	
	
</TABLE>
</form>
</div>
</body>
</html>


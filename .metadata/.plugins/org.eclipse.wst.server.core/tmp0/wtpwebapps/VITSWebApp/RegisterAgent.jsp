<%@page import="forms.AgentForm"%>
<%@page import="dto.SchemeTO"%>
<%@page import="java.util.*" %>
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
AgentForm agentform = (AgentForm)session.getAttribute("agentForm");
if(agentform != null){
	System.out.println("JSP TEXT" + agentform.getErrortext());
}else{
	System.out.println("JSP TEXT NULL OBJECT");
}

ServletContext app = getServletContext();
HashMap companyMap = (HashMap)app.getAttribute("CompanyList");
System.out.println("CompanyMap HashMap USED");
int mapSize = 0;
if(!companyMap.isEmpty()){
mapSize = companyMap.size();
for(int i=1; i<=mapSize ; i++){
	System.out.println("VALUE ===>" + companyMap.get(new Integer(i)));				
}
}
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
%>
<div align="center" style="margin-top: 50px;">
<FORM ID="agentform" NAME="agentform" METHOD="POST" ACTION="Agent">
<TABLE cellpadding="0" cellspacing="0" border="1" bgcolor="#FFFFCC" width="100%">
<tr><td class="header" colspan="7" height="30px" align="center" style="font-size:13px;font-weight: bold">Register AgentID</td></tr>
	<TR>
		<TD class="text">&nbsp;&nbsp;Agent Name</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="agentname" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
		
	<TR>
		<TD class="text">&nbsp;&nbsp;Company Name</TD>
		<TD valign="top">
		<select name="compcode">
		<%for(int i=1; i<=mapSize ; i++){%>
			<option value='<%=i%>'><%=companyMap.get(new Integer(i))%></option>
		<% } %>
		</select>
		</TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;Scheme Name</TD>
		<TD valign="top">
			<select name="schemecode" id="schemecode">
			<%Iterator entries = schemeMap.entrySet().iterator();
			  while (entries.hasNext()) {
			    Map.Entry entry = (Map.Entry) entries.next();
			    Integer key = (Integer)entry.getKey();
			    SchemeTO schemeTO = (SchemeTO)entry.getValue();

			%>
			<option value='<%=schemeTO.getSchemeId()%>'><%=schemeTO.getSchemeName()%></option>
			<% } %>
			</select>
		</TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;Branch Code</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="branchcode" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;Branch Name</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="branchname" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;S M Code</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="smcode" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;S M Name</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="smname" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;Vendor Code</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="vendorcode" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	
	<TR>
		<TD class="text">&nbsp;&nbsp;Vendor Name</TD>
		<TD valign="top"><INPUT TYPE="TEXT" NAME="vendorname" SIZE="20" MAXLENGTH="20" class="text"></TD>
	</TR>
	
	<TR>
		<TD class="text" colspan="2" align="center"><INPUT TYPE="SUBMIT" NAME="Submit" class="text" value="" style="background:url(images/submit.jpg) no-repeat;width:55px;height:25px" /></TD>
	</TR>
	
	<% if(agentform != null && agentform.getErrortext()!=null){ %>
	<TR>
		<TD class="text" colspan="2" align="center" style= "background-color: #ff3333";><%=agentform.getErrortext()%></TD>
	</TR>
	<% } %>
	
	
</TABLE>
</form>
</div>
</body>
</html>


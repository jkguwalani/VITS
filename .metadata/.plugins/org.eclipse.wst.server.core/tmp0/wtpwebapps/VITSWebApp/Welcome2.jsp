<%@page import="forms.LogonForm"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View logonForm Details</title>
</head>
<body>

<%
LogonForm logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 2");

ServletContext app = getServletContext();
HashMap map=(HashMap)app.getAttribute("FunctionalityList");
if(map != null)
	System.out.println("HashMap");
%>

<table align="center" bgcolor="#FFFFCC" border="0" width="100%">
    <tr>
        <td colspan="2" align="center"><%="Welcome  !!!!. Your details Processed." %></td>
    </tr>
    <tr>
        <td>Name </td>
        <td></td>
    </tr>
    <tr>
    	<td>Functionality List	</td>
    	<td>
    	
    	</td>
    </tr>
    	
</table>
</body>
</html>

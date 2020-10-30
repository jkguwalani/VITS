<%@page import="forms.LogonForm"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }
</style>
<title>View logonForm Details</title>
</head>
<body>

<%
LogonForm logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 2");
	
ServletContext app = getServletContext();
HashMap map=(HashMap)app.getAttribute("FunctionalityList");
System.out.println("HashMap");
%>
<input type="hidden" name="userID" value="<%=logonForm.getUid()%>">
<table align="center" bgcolor="#FFFFCC" border="0" width="100%" height="100%">
    <tr>
        <td class="header" colspan="7" align="center" style="font-size:25px;font-weight: bold"><%="Welcome &nbsp;"+logonForm.getUname()+" !!!! Your details Processed..." %></td>
    </tr>
   
    <tr>
    <td class="text" colspan="6" style="font-size:17px;font-weight: bold">
    <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Following are the detailed activities which you can avail...
    </td>
    </tr>
    <tr>
    	<td align="center" class="text" colspan="6" style="font-size:17px;font-weight: bold">
    	
    	<% if (logonForm.getUfunctionality().size() > 0){
    		ArrayList list = logonForm.getUfunctionality();
    		for(int i=0; i<list.size();i++){
    			System.out.println(list.get(i));
    		%>
    		<br><br><%=map.get(list.get(i)) %>
    		<%
    		}
    	}
    	%>
    	</td>
    </tr>
    	
</table>
</body>
</html>

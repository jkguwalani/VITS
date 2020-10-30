<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle Insurance Tracking System</title>
</head>
<body>

<%
	//session = request.getSession(true);
	System.out.println("INVALIDATING SESSION");
	session.invalidate();
	System.out.println("SESSION INVALIDATED");	
	
	if(session!=null){  
		System.out.println("SESSION NOT NULL");
	}else{
		System.out.println("SESSION NULL");
	}
%>
<table width="" border="0" align="right" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
   
    <td>
      <table width="" border="0" cellpadding="0" cellspacing="0">
        <tr>
        
          <td>
             <table width="" border="0" cellspacing="0" cellpadding="0">
              <tr>
              
                <td width="2000" height="168" valign="top">
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="128" valign="bottom" ><img src="images/banner1.jpg" width="100%" height="228" /> </td>
                      <TR><TD class="text" align="center" style="font-size:30px;font-weight: bold"><br>Thank you for using e-VITS.</TD></TR>
	<tr><td  align="center" style="font-size:30px;font-weight: bold"><br>You have successfully logged off</TD></TR>
	<tr><td  align="center" style="font-size:30px;font-weight: bold"><br><A href="/VITSWebApp/index.jsp" >Click here to Login again</A></td></TR>

                    </table></td></tr>
                </table></td>
              </tr>
          </table>
        
  </table>
	



</body>
</html>
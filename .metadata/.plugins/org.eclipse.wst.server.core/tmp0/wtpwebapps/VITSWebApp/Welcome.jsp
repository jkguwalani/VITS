<%@page import="forms.LogonForm"%>
<html>

<head>

<title>VITS Web Application</title>

</head>
<% 
LogonForm logonForm=(LogonForm)request.getSession().getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 1");

logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 12");

%>




<frameset rows="18%,82%" frameborder="no">

    <frame src="bannerfile1.html" name="banner" scrolling="no">
   <frameset cols="20%,80%">

      <frame src="links.jsp" name="nav" noresize>

      <frame src="Welcome1.jsp" name="content" marginheight="50" marginwidth="50">

	</frameset>

</frameset>

</html>
<%@page import="forms.LogonForm"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>VITS Steady</title>
<link href="/VITSWebApp/css/VITS.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/VITSWebApp/css/style.css" type="text/css" />
<script type="text/javascript">
function whenClicked() 
{
	window.open('/VITSWebApp/VITSLogOff.jsp','_blank');
    window.top.close();
}
</script>
</head>
<body>
<%
LogonForm logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 2");
	
ServletContext app = getServletContext();
HashMap map=(HashMap)app.getAttribute("FunctionalityList");
System.out.println(" FunctionalityList HashMap USED");
%>
<div class="content-left">
          <div class="content-left-top"><div class="content-left-top1"><img src="/VITSWebApp/images/left-box-top.gif" width="242" height="9" /></div></div>
          <div class="content-left-mid">
            <ul class="acc" id="acc">
            
			<% if (logonForm.getUfunctionality().size() > 0){
    		ArrayList list = logonForm.getUfunctionality();
    		for(int i=0; i<list.size();i++){
    			System.out.println(list.get(i));
    		%>
    		
    		
            <li>
            <%if(map.get(list.get(i)) != null){ %>
            
            <div style="opacity: 1; height: auto;" class="acc-section">
            	<div class="acc-content">
            	<ul class="acc" id="acc" style="padding:0; margin:0; ">
            	
                      <li class="accordian-bullet"> 
						<a href="<%=request.getContextPath()%>/FunctionServlet?funid=<%=list.get(i)%>" target="content" onmouseover="window.status='<%=map.get(list.get(i)) %>';return true;"  >
            				<%=map.get(list.get(i))%> 
            			</a>
            		</li>
            		
            		
            	</div>
            </div>
            <%}%>	            
            </li>
<%	
	} 
%>
 	</ul>
<%
	
}
%>         
			<!-- 
			<div style="opacity: 1; height: auto;" class="acc-section">
            	<div class="acc-content">
             		<li class="accordian-bullet">
                    	<a href="/VITSWebApp/downloads.jsp" target="content" onmouseover="window.status='Download';">
                      		Downloads
                      	</a>
                	</li>                   
				</div>
			</div>
             -->
             


			
              <li class="accordian-bullet">
                <div style="opacity: 1; height: auto;" class="acc-section">
                  <div class="acc-content">                   
                      <a href="/VITSWebApp/faq.html" target="content" onmouseover="window.status='FAQ';">
                      	FAQ
                      </a>                   
                  </div>
                </div>
              </li>
             
             
			
              <li class="accordian-bullet">
                <div style="opacity: 1; height: auto;" class="acc-section">
                  <div class="acc-content">                   
                      <a href="" onmouseover="window.status='LogOut Of VITS';" onclick="whenClicked();return false;">
                     	Logoff
                      </a>                   
                  </div>
                </div>
              </li>
              
              </ul>
          
          <div class="content-left-bottom"><div class="content-left-bottom1"><img src="/VITSWebApp/images/spacer.gif"  /></div></div>    
</body>
</html>

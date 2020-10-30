package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.PolicyForm;
import dto.SchemeTO;
import dto.AgentTO;
import java.util.HashMap;
import java.util.*;
import forms.LogonForm;

public final class RegisterPolicy_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }\r\n");
      out.write("td{font-size:17px;font-weight: bold}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Register Schemes</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
 
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div align=\"center\" style=\"margin-top: 50px;\">\r\n");
      out.write("<FORM ID=\"agentform\" NAME=\"agentform\" METHOD=\"POST\" ACTION=\"Policy\">\r\n");
      out.write("\r\n");
      out.write("<TABLE cellpadding=\"0\" cellspacing=\"0\" border=\"1\" bgcolor=\"#FFFFCC\" width=\"100%\">\r\n");
      out.write("<tr><td class=\"header\" colspan=\"7\" height=\"30px\" align=\"center\" style=\"font-size:13px;font-weight: bold\">Register Policy</td></tr>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Policy Type</TD>\r\n");
      out.write("\t\t<TD valign=\"top\">\r\n");
      out.write("\t\t\t<select name=\"policytype\">\r\n");
      out.write("\t\t\t<option value=\"Personal\">Personal</option>\r\n");
      out.write("\t\t\t<option value=\"Commercial\">Commercial</option>\t\t\r\n");
      out.write("\t\t\t</select>\t\t\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Scheme/Company/Agent Name</TD>\r\n");
      out.write("\t\t<TD valign=\"top\">\r\n");
      out.write("\t");

	entries = agentMap.entrySet().iterator();
	while (entries.hasNext()) {
	    Map.Entry entry = (Map.Entry) entries.next();
	    Integer key = (Integer)entry.getKey();
	    AgentTO agentTO = (AgentTO)entry.getValue();
	    System.out.println("AgentKey = " + key + ", AgentValue = " + agentTO);
	
      out.write("\r\n");
      out.write("\t\t<input type=\"radio\" name=\"agentid\" value=\"");
      out.print(key);
      out.write('"');
      out.write('>');
      out.print(agentTO.getSchemeName());
      out.write('/');
      out.print(agentTO.getCompanyName());
      out.write('/');
      out.print(agentTO.getAgentName());
      out.write("</input>\r\n");
      out.write("\t\t</br>\t\r\n");
      out.write("\t");
}
      out.write("\t\r\n");
      out.write("\t</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Policy Issued On</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"policyissuedon\" SIZE=\"50\" MAXLENGTH=\"10\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Policy Issuing Office</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"policyissuingoffice\" SIZE=\"50\" MAXLENGTH=\"50\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Period of Insurance</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"periodofinsurance\" SIZE=\"50\" MAXLENGTH=\"50\" class=\"text\">months</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Type of Vehicle</TD>\r\n");
      out.write("\t\t<TD valign=\"top\">\r\n");
      out.write("\t\t\t<select name=\"typeofvehicle\">\r\n");
      out.write("\t\t\t<option value=\"TwoWheeler\">Two Wheeler</option>\r\n");
      out.write("\t\t\t<option value=\"FourWheeler\">Four Wheeler</option>\t\t\r\n");
      out.write("\t\t\t</select>\t\t\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Model</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"model\" SIZE=\"50\" MAXLENGTH=\"50\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Proper's (Owner's) Name</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"proposersname\" SIZE=\"50\" MAXLENGTH=\"50\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Address</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"address\" SIZE=\"50\" MAXLENGTH=\"50\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Pincode</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"pincode\" SIZE=\"50\" MAXLENGTH=\"10\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Email Address</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"emailAddress\" SIZE=\"50\" MAXLENGTH=\"50\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Contact Number</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"contactnumber\" SIZE=\"50\" MAXLENGTH=\"10\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;PanCard Number</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"pancard\" SIZE=\"50\" MAXLENGTH=\"10\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t\r\n");
      out.write("\t<TR><input type=\"hidden\" name=\"userId\" value=\"");
      out.print(logonForm.getUid());
      out.write("\">\r\n");
      out.write("\t\t<TD class=\"text\" colspan=\"2\" align=\"center\">\t\t\t\r\n");
      out.write("\t\t\t<INPUT TYPE=\"SUBMIT\" NAME=\"Submit\" class=\"text\" value=\"\" style=\"background:url(images/submit.jpg) no-repeat;width:55px;height:25px\" />\r\n");
      out.write("\t\t</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t\r\n");
      out.write("\t");
 if(policyform != null && policyform.getErrortext()!=null){ 
      out.write("\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\" colspan=\"2\" align=\"center\" style= \"background-color: #ff3333\";>");
      out.print(policyform.getErrortext());
      out.write("</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</TABLE>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

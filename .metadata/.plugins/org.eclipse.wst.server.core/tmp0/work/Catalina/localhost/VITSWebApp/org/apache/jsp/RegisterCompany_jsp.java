package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.CompanyForm;

public final class RegisterCompany_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }\r\n");
      out.write("td{font-size:17px;font-weight: bold}\r\n");
      out.write("</style>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Register Company</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

CompanyForm compform = (CompanyForm)session.getAttribute("companyForm");
if(compform != null){
System.out.println("JSP TEXT" + compform.getErrortext());
}else{
System.out.println("JSP TEXT NULL OBJECT");
}
 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div align=\"center\" style=\"margin-top: 50px;\">\r\n");
      out.write("<FORM ID=\"companyform\" NAME=\"companyform\" METHOD=\"POST\" ACTION=\"Company\">\r\n");
      out.write("<TABLE cellpadding=\"0\" cellspacing=\"0\" border=\"1\" bgcolor=\"#FFFFCC\" width=\"100%\">\r\n");
      out.write("<tr><td class=\"header\" colspan=\"7\" height=\"30px\" align=\"center\" style=\"font-size:13px;font-weight: bold\">Register Company</td></tr>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Company Name</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"compname\" SIZE=\"20\" MAXLENGTH=\"20\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">&nbsp;&nbsp;Company Address</TD>\r\n");
      out.write("\t\t<TD valign=\"top\"><INPUT TYPE=\"TEXT\" NAME=\"compadd\" SIZE=\"20\" MAXLENGTH=\"20\" class=\"text\"></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\" colspan=\"2\" align=\"center\"><INPUT TYPE=\"SUBMIT\" NAME=\"Submit\" class=\"text\" value=\"\" style=\"background:url(images/submit.jpg) no-repeat;width:55px;height:25px\" /></TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t");
if(compform != null && compform.getErrortext()!=null){
      out.write("\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\" colspan=\"2\" align=\"center\" style= \"background-color: #ff3333\";>");
      out.print(compform.getErrortext());
      out.write("</TD>\r\n");
      out.write("\t</TR>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
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

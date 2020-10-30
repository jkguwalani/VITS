package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.LogonForm;
import java.util.*;
import dto.SchemeTO;

public final class ViewSchemeId_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }\r\n");
      out.write("td{font-size:17px;font-weight: bold}\r\n");
      out.write("</style>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>View Agent Details</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

ServletContext app = getServletContext();
HashMap DisplaySchemeList = (HashMap)app.getAttribute("DisplaySchemeList");

if(DisplaySchemeList != null)
	System.out.println("DisplaySchemeList is not null");
else
	System.out.println("DisplaySchemeList is null");


      out.write("\r\n");
      out.write("\r\n");
      out.write("<FORM ID=\"viewschemeform\" NAME=\"viewschemeform\" METHOD=\"POST\" ACTION=\"ViewScheme\">\r\n");
      out.write("<TABLE align=\"center\" bgcolor=\"#FFFFCC\" border=\"1\" width=\"100%\">\r\n");
      out.write("<tr><td class=\"header\" colspan=\"12\" height=\"30px\" align=\"center\" style=\"font-size:13px;font-weight: bold\">View Scheme</td></tr>\r\n");
      out.write("\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">Scheme Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Scheme Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Scheme Company Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Scheme Company Name</TD>\r\n");
      out.write("\t</TR>\r\n");
 
Iterator entries = DisplaySchemeList.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    SchemeTO schemeTO = (SchemeTO)entry.getValue();
    System.out.println("SchemeTO VALUE=" + schemeTO.getSchemeName());

      out.write("\r\n");
      out.write("<TR>\r\n");
      out.write("<TD>");
      out.print(schemeTO.getSchemeId());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(schemeTO.getSchemeName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(schemeTO.getSchemeCompId());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(schemeTO.getSchemeCompName());
      out.write("</TD>\r\n");
      out.write("</TR>\r\n");
      out.write("\r\n");
} 
      out.write("\r\n");
      out.write("</TABLE>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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

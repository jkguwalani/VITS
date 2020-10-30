package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.LogonForm;
import java.util.*;
import dto.AgentTO;

public final class ViewAgentId_jsp extends org.apache.jasper.runtime.HttpJspBase
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
HashMap DisplayAgentList = (HashMap)app.getAttribute("DisplayAgentList");

if(DisplayAgentList != null)
	System.out.println("DisplayAgentList is not null");
else
	System.out.println("DisplayAgentList is null");


      out.write("\r\n");
      out.write("\r\n");
      out.write("<FORM ID=\"viewagentform\" NAME=\"viewagentform\" METHOD=\"POST\" ACTION=\"ViewAgent\">\r\n");
      out.write("<TABLE align=\"center\" bgcolor=\"#FFFFCC\" border=\"1\" width=\"100%\">\r\n");
      out.write("<tr><td class=\"header\" colspan=\"12\" height=\"30px\" align=\"center\" style=\"font-size:13px;font-weight: bold\">View Agent</td></tr>\r\n");
      out.write("\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">Agent Id</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Agent Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Scheme Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Scheme Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Company Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Company Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Branch Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Branch Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">SM Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">SM Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Vendor Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Vendor Name</TD>\r\n");
      out.write("\t</TR>\r\n");
 
Iterator entries = DisplayAgentList.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    AgentTO agentTO = (AgentTO)entry.getValue();
    System.out.println("AgentTO VALUE=" + agentTO.getAgentName());

      out.write("\r\n");
      out.write("<TR>\r\n");
      out.write("<TD>");
      out.print(agentTO.getAgentCode());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getAgentName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getSchemeId());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getSchemeName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getCompanyId());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getCompanyName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getBranchCode());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getBranchName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getSmCode());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getSmName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getVendorCode());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(agentTO.getVendorName());
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

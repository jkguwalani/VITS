package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.LogonForm;

public final class Welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>VITS Web Application</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
 
LogonForm logonForm=(LogonForm)request.getSession().getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 1");

logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 12");


      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<frameset rows=\"18%,82%\" frameborder=\"no\">\r\n");
      out.write("\r\n");
      out.write("    <frame src=\"bannerfile1.html\" name=\"banner\" scrolling=\"no\">\r\n");
      out.write("   <frameset cols=\"20%,80%\">\r\n");
      out.write("\r\n");
      out.write("      <frame src=\"links.jsp\" name=\"nav\" noresize>\r\n");
      out.write("\r\n");
      out.write("      <frame src=\"Welcome1.jsp\" name=\"content\" marginheight=\"50\" marginwidth=\"50\">\r\n");
      out.write("\r\n");
      out.write("\t</frameset>\r\n");
      out.write("\r\n");
      out.write("</frameset>\r\n");
      out.write("\r\n");
      out.write("</html>");
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

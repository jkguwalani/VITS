package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class VITSLogOff_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Vehicle Insurance Tracking System</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

	//session = request.getSession(true);
	System.out.println("INVALIDATING SESSION");
	session.invalidate();
	System.out.println("SESSION INVALIDATED");	
	
	if(session!=null){  
		System.out.println("SESSION NOT NULL");
	}else{
		System.out.println("SESSION NULL");
	}

      out.write("\r\n");
      out.write("<table width=\"\" border=\"0\" align=\"right\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("  <tr>\r\n");
      out.write("   \r\n");
      out.write("    <td>\r\n");
      out.write("      <table width=\"\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("        \r\n");
      out.write("          <td>\r\n");
      out.write("             <table width=\"\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("              <tr>\r\n");
      out.write("              \r\n");
      out.write("                <td width=\"2000\" height=\"168\" valign=\"top\">\r\n");
      out.write("                    <table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td height=\"128\" valign=\"bottom\" ><img src=\"images/banner1.jpg\" width=\"100%\" height=\"228\" /> </td>\r\n");
      out.write("                      <TR><TD class=\"text\" align=\"center\" style=\"font-size:30px;font-weight: bold\"><br>Thank you for using e-VITS.</TD></TR>\r\n");
      out.write("\t<tr><td  align=\"center\" style=\"font-size:30px;font-weight: bold\"><br>You have successfully logged off</TD></TR>\r\n");
      out.write("\t<tr><td  align=\"center\" style=\"font-size:30px;font-weight: bold\"><br><A href=\"/VITSWebApp/index.jsp\" >Click here to Login again</A></td></TR>\r\n");
      out.write("\r\n");
      out.write("                    </table></td></tr>\r\n");
      out.write("                </table></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("          </table>\r\n");
      out.write("        \r\n");
      out.write("  </table>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

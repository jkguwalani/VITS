package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.LogonForm;
import java.util.*;

public final class links_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n");
      out.write("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>VITS Steady</title>\r\n");
      out.write("<link href=\"/VITSWebApp/css/VITS.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/VITSWebApp/css/style.css\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function whenClicked() \r\n");
      out.write("{\r\n");
      out.write("\twindow.open('/VITSWebApp/VITSLogOff.jsp','_blank');\r\n");
      out.write("    window.top.close();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

LogonForm logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 2");
	
ServletContext app = getServletContext();
HashMap map=(HashMap)app.getAttribute("FunctionalityList");
System.out.println(" FunctionalityList HashMap USED");

      out.write("\r\n");
      out.write("<div class=\"content-left\">\r\n");
      out.write("          <div class=\"content-left-top\"><div class=\"content-left-top1\"><img src=\"/VITSWebApp/images/left-box-top.gif\" width=\"242\" height=\"9\" /></div></div>\r\n");
      out.write("          <div class=\"content-left-mid\">\r\n");
      out.write("            <ul class=\"acc\" id=\"acc\">\r\n");
      out.write("            \r\n");
      out.write("\t\t\t");
 if (logonForm.getUfunctionality().size() > 0){
    		ArrayList list = logonForm.getUfunctionality();
    		for(int i=0; i<list.size();i++){
    			System.out.println(list.get(i));
    		
      out.write("\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t\r\n");
      out.write("            <li>\r\n");
      out.write("            ");
if(map.get(list.get(i)) != null){ 
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <div style=\"opacity: 1; height: auto;\" class=\"acc-section\">\r\n");
      out.write("            \t<div class=\"acc-content\">\r\n");
      out.write("            \t<ul class=\"acc\" id=\"acc\" style=\"padding:0; margin:0; \">\r\n");
      out.write("            \t\r\n");
      out.write("                      <li class=\"accordian-bullet\"> \r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/FunctionServlet?funid=");
      out.print(list.get(i));
      out.write("\" target=\"content\" onmouseover=\"window.status='");
      out.print(map.get(list.get(i)) );
      out.write("';return true;\"  >\r\n");
      out.write("            \t\t\t\t");
      out.print(map.get(list.get(i)));
      out.write(" \r\n");
      out.write("            \t\t\t</a>\r\n");
      out.write("            \t\t</li>\r\n");
      out.write("            \t\t\r\n");
      out.write("            \t\t\r\n");
      out.write("            \t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
}
      out.write("\t            \r\n");
      out.write("            </li>\r\n");
	
	} 

      out.write("\r\n");
      out.write(" \t</ul>\r\n");

	
}

      out.write("         \r\n");
      out.write("\t\t\t<!-- \r\n");
      out.write("\t\t\t<div style=\"opacity: 1; height: auto;\" class=\"acc-section\">\r\n");
      out.write("            \t<div class=\"acc-content\">\r\n");
      out.write("             \t\t<li class=\"accordian-bullet\">\r\n");
      out.write("                    \t<a href=\"/VITSWebApp/downloads.jsp\" target=\"content\" onmouseover=\"window.status='Download';\">\r\n");
      out.write("                      \t\tDownloads\r\n");
      out.write("                      \t</a>\r\n");
      out.write("                \t</li>                   \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("             -->\r\n");
      out.write("             \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("              <li class=\"accordian-bullet\">\r\n");
      out.write("                <div style=\"opacity: 1; height: auto;\" class=\"acc-section\">\r\n");
      out.write("                  <div class=\"acc-content\">                   \r\n");
      out.write("                      <a href=\"/VITSWebApp/faq.html\" target=\"content\" onmouseover=\"window.status='FAQ';\">\r\n");
      out.write("                      \tFAQ\r\n");
      out.write("                      </a>                   \r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </li>\r\n");
      out.write("             \r\n");
      out.write("             \r\n");
      out.write("\t\t\t\r\n");
      out.write("              <li class=\"accordian-bullet\">\r\n");
      out.write("                <div style=\"opacity: 1; height: auto;\" class=\"acc-section\">\r\n");
      out.write("                  <div class=\"acc-content\">                   \r\n");
      out.write("                      <a href=\"\" onmouseover=\"window.status='LogOut Of VITS';\" onclick=\"whenClicked();return false;\">\r\n");
      out.write("                     \tLogoff\r\n");
      out.write("                      </a>                   \r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </li>\r\n");
      out.write("              \r\n");
      out.write("              </ul>\r\n");
      out.write("          \r\n");
      out.write("          <div class=\"content-left-bottom\"><div class=\"content-left-bottom1\"><img src=\"/VITSWebApp/images/spacer.gif\"  /></div></div>    \r\n");
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

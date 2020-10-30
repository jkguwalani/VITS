package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.LogonForm;
import java.util.*;

public final class Welcome1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<style>\r\n");
      out.write("td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }\r\n");
      out.write("</style>\r\n");
      out.write("<title>View logonForm Details</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

LogonForm logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM 2");
	
ServletContext app = getServletContext();
HashMap map=(HashMap)app.getAttribute("FunctionalityList");
System.out.println("HashMap");

      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"userID\" value=\"");
      out.print(logonForm.getUid());
      out.write("\">\n");
      out.write("<table align=\"center\" bgcolor=\"#FFFFCC\" border=\"0\" width=\"100%\" height=\"100%\">\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td class=\"header\" colspan=\"7\" align=\"center\" style=\"font-size:25px;font-weight: bold\">");
      out.print("Welcome &nbsp;"+logonForm.getUname()+" !!!! Your details Processed..." );
      out.write("</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("   \r\n");
      out.write("    <tr>\r\n");
      out.write("    <td class=\"text\" colspan=\"6\" style=\"font-size:17px;font-weight: bold\">\r\n");
      out.write("    <br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Following are the detailed activities which you can avail...\r\n");
      out.write("    </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td align=\"center\" class=\"text\" colspan=\"6\" style=\"font-size:17px;font-weight: bold\">\r\n");
      out.write("    \t\r\n");
      out.write("    \t");
 if (logonForm.getUfunctionality().size() > 0){
    		ArrayList list = logonForm.getUfunctionality();
    		for(int i=0; i<list.size();i++){
    			System.out.println(list.get(i));
    		
      out.write("\r\n");
      out.write("    \t\t<br><br>");
      out.print(map.get(list.get(i)) );
      out.write("\r\n");
      out.write("    \t\t");

    		}
    	}
    	
      out.write("\r\n");
      out.write("    \t</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    \t\r\n");
      out.write("</table>\r\n");
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

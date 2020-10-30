package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<title>Vehicle Insurance Tracking System</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".text {  font-family: Arial; font-size: 10px; color: #000000; text-decoration: none}\r\n");
      out.write(".error {  font-family: Arial; font-size: 10px; color: red; text-decoration: none}\r\n");
      out.write("body{padding-right: 0px; padding-left: 0px; padding-bottom: 0px; padding-top: 0px; \r\n");
      out.write("\t margin-left: 0px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px; }\r\n");
      out.write("td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }\r\n");
      out.write("td.subheader{ background-color:blue; color:white; font-weight:bold; font-family: Arial; font-size: 10px; text-decoration: none; }\r\n");
      out.write("td.logo {background-color:white;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"javascript:document.mainform.username.focus()\">\r\n");
      out.write("<script type=\"javascript\">\r\n");
      out.write("function SubmitForm(){\r\n");
      out.write("alert(\"HI\");\r\n");
      out.write("document.mainform.submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<table width=\"1003\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("      <table width=\"1003\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("            <table width=\"1003\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"282\" height=\"169\" bgcolor=\"#FFFFFF\"><div align=\"center\"><img src=\"images/logo.gif\" width=\"135\" height=\"139\" /></div></td>\r\n");
      out.write("                <td width=\"721\" height=\"168\" valign=\"top\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("                   <table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td height=\"128\" valign=\"bottom\"><img src=\"images/header-img.jpg\" width=\"720\" height=\"128\" />\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t  </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td height=\"48\" valign=\"top\">                \r\n");
      out.write("                              <table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td width=\"192\">&nbsp;</td>\r\n");
      out.write("                            <td width=\"176\" valign=\"top\" align=\"right\"><div align=\"right\"><a href=\"About.html\"><img src=\"images/bt-aboutus1.gif\" alt=\"About Us\" title=\"About Us\" width=\"175\" height=\"41\" border=\"0\" /></a></div></td>\r\n");
      out.write("                            <td width=\"176\" valign=\"top\" align=\"right\"><div align=\"right\"><a href=\"home.html\"><img src=\"images/bt-vitshome1.gif\" alt=\"VITS Home\" title=\"VITS Home\" width=\"175\" height=\"41\" border=\"0\" /></a></div></td>\r\n");
      out.write("\r\n");
      out.write("                            <!--<td width=\"176\" valign=\"top\" align=\"right\"><div align=\"right\"><a href=\"Contact.html\"><img src=\"images/bt-contactus1.gif\" alt=\"Contact Us\" title=\"Contact Us\" width=\"175\" height=\"41\" border=\"0\" /></a></div></td>-->\r\n");
      out.write("\r\n");
      out.write("                            <td width=\"176\" valign=\"top\" align=\"right\"><div align=\"right\"><a href=\"Contact.html\"><img src=\"images/bt-contactus1.gif\" alt=\"Contact Us\" title=\"Contact Us\" width=\"175\" height=\"41\" border=\"0\" /></a></div></td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                      </table></td></tr>\r\n");
      out.write("                </table></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("          </table></td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td bgcolor=\"#FFFFFF\"><table width=\"1003\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"270\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"297\" valign=\"top\"><img src=\"images/header-img01.jpg\" alt=\"Internet and Mobile Initiatives\" title=\"Internet and Mobile Initiatives\" width=\"284\" height=\"265\" /></td>\r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("         <td valign=\"top\">\r\n");
      out.write("            <table width=\"407\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("              <tr><td valign=\"top\" height=\"7\"><img src=\"images/welcome-top-bg.gif\" width=\"407\" height=\"7\" style=\"display:block;\" /></td></tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td bgcolor=\"#FFFDE8\"><img src=\"images/welcome.gif\" width=\"125\" height=\"20\" /></td>\r\n");
      out.write("              </tr> \r\n");
      out.write("              <tr>\r\n");
      out.write("                <td bgcolor=\"#FFFDE8\"><table width=\"407\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td height=\"177\" background=\"images/content-bg.jpg\"><div class=\"scroll\">\r\n");
      out.write("                          <table width=\"390\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                            <tr>\r\n");
      out.write("                              <td valign=\"top\" class=\"scroll-text\"><p>Internet is increasingly becoming an important medium for dissemination of information and conducting business. A warm welcome and thank you for choosing to insure your car through us. Our aim at VITS Insurance\r\n");
      out.write("Services is to combine value for money with peace of mind, making Car Insurance as straightforward\r\n");
      out.write("as possible.Your policy booklet and statement of insurance include everything you need to know about your Car\r\n");
      out.write("Insurance cover. Alternatively, you can always contact our experienced customer service agents who\r\n");
      out.write("are there to help you with all your Car Insurance needs.\r\n");
      out.write("If youre unfortunate enough to have an accident regardless of fault, call us and our experienced\r\n");
      out.write("claims staff will be there to guide and assist you through every step of the claims process. \r\n");
      out.write("The VITS is able to offer you more than just great deals on Car Insurance. If you want more information\r\n");
      out.write("on our other products, we can help you. Either call us or visit our website on the VITS.com.The VITS is able to offer you more than just great deals on Car Insurance deails.</p>\r\n");
      out.write("</td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                          </table>\r\n");
      out.write("                      </div></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              \r\n");
      out.write("<tr>\r\n");
      out.write("                <td valign=\"top\"></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td valign=\"top\"><img src=\"images/welcome-bottom-bg.gif\" width=\"407\" height=\"9\" /></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("\t\t\t  \r\n");
      out.write("          </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <table><tr><td height=\"14\" width=\"199\"></td><td height=\"14\" width=\"204\"></td></tr><tr><td><div align=\"center\"></div></td></tr></table>\r\n");
      out.write("          </td>\r\n");
      out.write("          <td width=\"297\" valign=\"top\"><table width=\"297\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td width=\"145\"><table><tr><td height=\"62\" width=\"65\"></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("                <tr><td height=\"233\" width=\"65\"></td><td height=\"233\" width=\"45\"></td></tr></table></td>\r\n");
      out.write("                <td valign=\"top\" width=\"152\">\r\n");
      out.write("                <table width=\"194\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form id=\"mainform\" name=\"mainform\" method=\"post\" action=\"Login\">\r\n");
String error = (String)request.getAttribute("error"); 
      out.write("\r\n");
      out.write("<table cellpadding=\"8\" cellspacing=\"8\" border=\"1\" bgcolor=\"#FFFFCC\">\r\n");
      out.write("\t<tr><td class=\"header\" colspan=\"7\" align=\"center\" style=\"font-size:13px;font-weight: bold\">Existing Users Login Here</td></tr>\r\n");
      out.write("\r\n");
if(error != null && !("null".equals(error))){ 
      out.write("\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\" colspan=\"7\" align=\"center\" style=\"font-size:13px;background-color: #ff5c33\">");
      out.print(error);
      out.write("</TD>\r\n");
      out.write("\t</TR>\r\n");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<tr><td class=\"text\" colspan=\"6\" style=\"font-size:13px;font-weight: bold\">&nbsp;&nbsp;User Id</td><td valign=\"top\"><input style=\"font-size:13px\" type=\"text\" name=\"username\" size=\"20\" maxlength=\"8\" class=\"text\" /></td></tr>\r\n");
      out.write("\t<tr><td class=\"text\" colspan=\"6\" style=\"font-size:13px;font-weight: bold\">&nbsp;&nbsp;Password</td><td valign=\"top\"><input style=\"font-size:13px\" type=\"password\" name=\"password\" size=\"20\" maxlength=\"16\" class=\"text\" /></td></tr>\r\n");
      out.write("\t<tr><td class=\"text\" colspan=\"7\" align=\"center\" >\r\n");
      out.write("\t\t<input type=\"submit\" name=\"Login\" class=\"text\" value=\"\" style=\"background:url(images/login.gif) no-repeat;width:55px;height:25px\" />\r\n");
      out.write("\t\t\t<!-- <img src=\"images/login.gif\" alt=\"VITS Users\" title=\"VITS Users\"/> -->\r\n");
      out.write("\t</td></tr>       \r\n");
      out.write("\t \r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" </table>\r\n");
      out.write("         </td></tr>         </table></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <tr>\r\n");
      out.write("    <td height=\"30\" background=\"images/disclaimer-bg.gif\" bgcolor=\"#FFFFFF\" class=\"disclaimer-bold\">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp DISCLAIMER <span><span class=\"disclaimer-text\"> All information provided in e-VITS is obtained by Bajaj Vehicle Insurance from sources believed to be accurate and reliable. </centre></span></span> </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</td></tr></table></td></tr></table></body>\r\n");
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

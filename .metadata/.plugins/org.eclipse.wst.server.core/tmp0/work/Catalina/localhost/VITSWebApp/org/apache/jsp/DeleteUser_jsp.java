package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.LogonForm;
import java.util.*;
import dto.UserTO;
import forms.UserForm;

public final class DeleteUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("td.header{ background-color:#832625; color:white; font-weight:bold; font-family: Arial; font-size: 11px; text-decoration: none; }\r\n");
      out.write("td{font-size:17px;font-weight: bold}\r\n");
      out.write("</style>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Delete User</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

ServletContext app = getServletContext();
HashMap DisplayUserList = (HashMap)app.getAttribute("DisplayUserListForDeletion");
HashMap map=(HashMap)app.getAttribute("FunctionalityList");

if(DisplayUserList != null)
	System.out.println("DisplayUserList is not null");
else
	System.out.println("DisplayUserList is null");


UserForm deleteUserForm=(UserForm)session.getAttribute("deleteUserForm");
if(deleteUserForm != null)
	System.out.println("deleteUserForm not null");


LogonForm logonForm=(LogonForm)session.getAttribute("logonform");
if(logonForm != null)
	System.out.println("LOGONFORM deleler user");


      out.write("\r\n");
      out.write("\r\n");
      out.write("<FORM ID=\"viewuserform\" NAME=\"viewuserform\" METHOD=\"POST\" ACTION=\"DeleteUserAction\">\r\n");
      out.write("<TABLE align=\"center\" bgcolor=\"#FFFFCC\" border=\"1\" width=\"100%\">\r\n");
      out.write("\r\n");
 if(deleteUserForm != null && deleteUserForm.getErrortext()!=null){ 
      out.write("\r\n");
      out.write("<TR>\r\n");
      out.write("\t<TD class=\"text\" colspan=\"6\" align=\"center\" style= \"background-color: #ff3333\";>");
      out.print(deleteUserForm.getErrortext());
      out.write("</TD>\r\n");
      out.write("</TR>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr><td class=\"header\" colspan=\"12\" height=\"30px\" align=\"center\" style=\"font-size:13px;font-weight: bold\">User Id</td></tr>\r\n");
      out.write("\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">User Id</TD>\r\n");
      out.write("\t\t<TD class=\"text\">User Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">User Type</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Functionalities</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Create Date</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Delete User</TD>\r\n");
      out.write("\t\t<!-- <TD class=\"text\">Delete User</TD> -->\r\n");
      out.write("\t</TR>\r\n");

	Iterator entries = DisplayUserList.entrySet().iterator();
	while (entries.hasNext()) {
	    Map.Entry entry = (Map.Entry) entries.next();
	    Integer key = (Integer)entry.getKey();
	    UserTO userTO = (UserTO)entry.getValue();
	    System.out.println("UserTO VALUE= " + userTO.getUsername() + "USER fun = " + userTO.getFunctionalities());
	    if(!logonForm.getUid().equals(userTO.getUserId().toString())){


      out.write("\r\n");
      out.write("<TR>\r\n");
      out.write("<TD>");
      out.print(userTO.getUserId());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(userTO.getUsername());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(userTO.getUserType());
      out.write("</TD>\r\n");
      out.write("\r\n");
      out.write("<TD>\r\n");
 
	if (userTO.getFunctionalities().size() > 0){
    	ArrayList list = userTO.getFunctionalities();
    	for(int i=0; i<list.size();i++){
    		System.out.println("User = " + userTO.getUserId() + "Fun List" + list.get(i));

      out.write("\r\n");
      out.write("\r\n");
      out.print(map.get(list.get(i)));
      out.write("\r\n");
      out.write("\r\n");
} 
      out.write("\r\n");
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(userTO.getCreateDate());
      out.write("</TD>\r\n");
      out.write("\r\n");
      out.write("<!-- <TD><input type=\"radio\" name=\"updateuser\" value=\"update^");
      out.print(userTO.getUserId());
      out.write("\"></TD> -->\r\n");
      out.write("<TD><input type=\"radio\" name=\"deleteuser\" value=\"");
      out.print(userTO.getUserId());
      out.write("\"></TD>\r\n");
      out.write("</TR>\r\n");
}}}
      out.write("\r\n");
      out.write("\r\n");
      out.write("<TR>\r\n");
      out.write("\t<TD class=\"text\" colspan=\"6\" align=\"center\"><INPUT TYPE=\"SUBMIT\" NAME=\"Submit\" class=\"text\" value=\"\" style=\"background:url(images/submit.jpg) no-repeat;width:55px;height:25px\" /></TD>\r\n");
      out.write("</TR>\r\n");
      out.write("</TABLE>\r\n");
      out.write("\r\n");
      out.write("</FORM> \r\n");
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

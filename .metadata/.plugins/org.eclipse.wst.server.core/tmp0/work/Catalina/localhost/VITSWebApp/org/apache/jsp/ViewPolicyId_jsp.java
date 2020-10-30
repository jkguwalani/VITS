package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import forms.LogonForm;
import java.util.*;
import dto.PolicyTO;

public final class ViewPolicyId_jsp extends org.apache.jasper.runtime.HttpJspBase
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
HashMap DisplayPolicyList = (HashMap)app.getAttribute("DisplayPolicyList");

if(DisplayPolicyList != null)
	System.out.println("DisplayPolicyList is not null");
else
	System.out.println("DisplayPolicyList is null");


      out.write("\r\n");
      out.write("\r\n");
      out.write("<FORM ID=\"viewpolicyform\" NAME=\"viewpolicyform\" METHOD=\"POST\" ACTION=\"ViewPolicy\">\r\n");
      out.write("<TABLE align=\"center\" bgcolor=\"#FFFFCC\" border=\"1\" width=\"100%\">\r\n");
      out.write("<tr><td class=\"header\" colspan=\"21\" height=\"30px\" align=\"center\" style=\"font-size:13px;font-weight: bold\">View Policy</td></tr>\r\n");
      out.write("\r\n");
      out.write("\t<TR>\r\n");
      out.write("\t\t<TD class=\"text\">Policy Number</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Policy Type</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Policy Issued On</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Policy Issuing Office</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Proposer's Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Address</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Pincode</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Email Address</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Contact Number</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Pancard</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Type Of Vehicle</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Model</TD>\r\n");
      out.write("\t\t<!-- <TD class=\"text\">User Id</TD> -->\r\n");
      out.write("\t\t<!-- <TD class=\"text\">Agent Id</TD> -->\r\n");
      out.write("\t\t<TD class=\"text\">Agent Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Scheme Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Scheme Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Branch Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Branch Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">SM Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">SM Name</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Vendor Code</TD>\r\n");
      out.write("\t\t<TD class=\"text\">Vendor Name</TD>\r\n");
      out.write("\t</TR>\r\n");
 
Iterator entries = DisplayPolicyList.entrySet().iterator();
while (entries.hasNext()) {
    Map.Entry entry = (Map.Entry) entries.next();
    Integer key = (Integer)entry.getKey();
    PolicyTO policyTO = (PolicyTO)entry.getValue();
    System.out.println("PolicyTO VALUE=" + policyTO.getPolicyNumber());

      out.write("\r\n");
      out.write("<TR>\r\n");
      out.write("<TD>");
      out.print(policyTO.getPolicyNumber());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getPolicyType());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getPolicyIssuedOn());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getPolicyInsuranceOffice());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getProposersName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getAddress());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getPincode());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getEmailAddress());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getContactNumber());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getPancardNumber());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getTypeOfVehicle());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getModel());
      out.write("</TD>\r\n");
      out.write("<!-- <TD>");
      out.print(policyTO.getUserId());
      out.write("</TD> -->\r\n");
      out.write("<!-- <TD>");
      out.print(policyTO.getAgentCode());
      out.write("</TD> -->\r\n");
      out.write("<TD>");
      out.print(policyTO.getAgentName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getSchemeId());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getSchemeName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getBranchCode());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getBranchName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getSmCode());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getSmName());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getVendorCode());
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(policyTO.getVendorName());
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

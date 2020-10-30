package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.CompanyForm;
import validator.ValidateForm;

/**
 * Servlet implementation class LogonServlet
 */
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String companyName = request.getParameter("compname");
        String companyAdd = request.getParameter("compadd");
        
        System.out.println("CompanyServlet request.getParameter(companyName) = " + companyName);
        System.out.println("CompanyServlet request.getParameter(companyAdd) = " + companyAdd);
        
        CompanyForm companyForm = new CompanyForm();
        companyForm.setCompanyName(companyName);
        companyForm.setCompanyAdd(companyAdd);
        
        ValidateForm valFormobj = new ValidateForm();
        Boolean validOutput = valFormobj.validateAndInsertCompany(companyForm);
        System.out.println("CompanyServlet validOutput = " + validOutput);
        
 		RequestDispatcher dispatcher = request.getRequestDispatcher("/LoadDefaults");
 	    dispatcher.include(request, response);
 		
 		dispatcher = request.getRequestDispatcher("/RegisterCompany.jsp");
 		request.getSession().setAttribute("companyForm",companyForm);
        dispatcher.forward(request, response);
 
	}	
}

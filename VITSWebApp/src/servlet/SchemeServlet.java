package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.SchemeForm;
import validator.ValidateForm;

/**
 * Servlet implementation class SchemeServlet
 */
public class SchemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SchemeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request.getParameter(submit) =>" + request.getParameter("Submit"));
		
		
	        String schemeName = request.getParameter("schemename");
	        String schemeCompId = request.getParameter("schemecompid");
	        String schemeCompName = null;
	        
	        ServletContext app = getServletContext();
	        HashMap<Integer,String> companyMap = (HashMap)app.getAttribute("CompanyList");
	        	        
	        System.out.println("CONTAINS KEY = " + companyMap.containsKey(Integer.parseInt(schemeCompId)));
	        
	        if(companyMap.containsKey(Integer.parseInt(schemeCompId)))
	        	schemeCompName = (String)companyMap.get(Integer.parseInt(schemeCompId));
	        	        
	        System.out.println("SchemeServlet request.getParameter(schemename) = " + schemeName);
	        System.out.println("SchemeServlet request.getParameter(schemeCompId) = " + schemeCompId);
	        System.out.println("SchemeServlet request.getParameter(schemecompname) = " + schemeCompName);
	        	        
	        
	        SchemeForm schemeForm = new SchemeForm();
	        schemeForm.setSchemeName(schemeName);
	        schemeForm.setSchemeCompId(schemeCompId);
	        schemeForm.setSchemeCompName(schemeCompName);

	        
	        ValidateForm valFormobj = new ValidateForm();
	        Boolean validOutput = valFormobj.validateAndInsertScheme(schemeForm);
	        System.out.println("SchemeServlet validOutput = " + validOutput);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/LoadDefaults");
	 	    dispatcher.include(request, response);
	 		
	 		dispatcher = request.getRequestDispatcher("/RegisterScheme.jsp");
	        request.getSession().setAttribute("schemeForm",schemeForm);
	        dispatcher.forward(request, response);
		
	}	
}

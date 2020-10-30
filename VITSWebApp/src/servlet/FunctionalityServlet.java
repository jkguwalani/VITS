package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validator.CommonValidator;


/**
 * Servlet implementation class LogonServlet
 */
public class FunctionalityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FunctionalityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
		String funIdString = request.getParameter("funid");
		System.out.println("funIdString" + funIdString);
		String forwardPage = "/VITSError_404.jsp";
		if(CommonValidator.validateString(funIdString)){
		int funId = Integer.parseInt(funIdString);
		switch(funId){
			case 1:
				forwardPage = "/RegisterUser.jsp";
				break;
			case 2:
				forwardPage = "/RegisterAgent.jsp";
				break;
			case 3:
				forwardPage = "/RegisterCompany.jsp";
				break;
			case 4:
				forwardPage = "/RegisterScheme.jsp";
				break;
			case 5:
				forwardPage = "/RegisterPolicy.jsp";
				break;
			case 6:
				forwardPage = "/ViewUser";
				break;
			case 7:
				forwardPage = "/ViewAgent";
				break;
			case 8:
				forwardPage = "/ViewCompany";
				break;
			case 9:
				forwardPage = "/ViewScheme";
				break;
			case 10:
				forwardPage = "/ViewPolicy";
				break;				
			case 11:
				forwardPage = "/DeleteUser";
				break;				
			default:
				forwardPage = "/VITSError_404.jsp";
				request.setAttribute("error","Invalid Functionality Request");
				break;		
		}
		}else{
			forwardPage = "/VITSError_404.jsp";
			request.setAttribute("error","Invalid Login Credentials");
        	System.out.println(request.getAttribute("error"));
       }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPage);    	
    	dispatcher.forward(request, response);    	
	}	
}
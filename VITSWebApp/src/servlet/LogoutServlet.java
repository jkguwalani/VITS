package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import forms.LogonForm;
import validator.ValidateForm;

/**
 * Servlet implementation class LogonServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        LogonForm logonform = (LogonForm)request.getSession().getAttribute("logonform");
        
        if(logonform != null)
        	System.out.println("LoGONFORM NOT NULL");
        else
        	System.out.println("LoGONFORM IS NULL");
        
        //response.setContentType("text/html");  
        //PrintWriter out=response.getWriter();  
        
        request.getSession().removeAttribute("logonform");
        
        request.getRequestDispatcher("/VITSLogOff.jsp").include(request, response);  
        
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("/Welcome.jsp");
    	
    	dispatcher.forward(request, response);
    	*/
        								
        HttpSession session=request.getSession();  
        session.invalidate();  
          
        System.out.println("LOGGED OUT");
        //out.print("You are successfully logged out!");  
          
        //out.close(); 
       }	
}

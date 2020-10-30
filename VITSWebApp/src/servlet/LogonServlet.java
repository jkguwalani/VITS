package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.LogonForm;
import validator.ValidateForm;

/**
 * Servlet implementation class LogonServlet
 */
public class LogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("LogonServlet request.getParameter(username) = " + username);
        System.out.println("LogonServlet request.getParameter(password) = " + password);
        
        LogonForm logonform = new LogonForm();
        logonform.setUid(username);
        logonform.setUpass(password);
        
        ValidateForm valFormobj = new ValidateForm();
        Boolean validOutput = valFormobj.validateUser(logonform);
        System.out.println("LogonServlet validOutput = " + validOutput);
        
        if(validOutput){        
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/Welcome.jsp");
        	request.getSession().setAttribute("logonform",logonform);
        	dispatcher.forward(request, response);
        }else{
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        	request.setAttribute("error","Invalid Login Credentials");
        	System.out.println(request.getAttribute("error"));
        	dispatcher.forward(request, response);        		
        }
	}	
}

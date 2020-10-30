package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import processor.UserProcessor;
import dto.UserTO;


/**
 * Servlet implementation class LogonServlet
 */
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserProcessor up = new UserProcessor();
		HashMap<Integer, UserTO> DisplayUserList = up.fetchUserList();
		
		ServletContext application = getServletContext();
		application.setAttribute("DisplayUserList", DisplayUserList);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewUserId.jsp");
        dispatcher.forward(request, response);
 
	}	
}

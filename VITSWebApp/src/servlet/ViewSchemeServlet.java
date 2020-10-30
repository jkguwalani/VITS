package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import processor.SchemeProcessor;
import dto.SchemeTO;


/**
 * Servlet implementation class LogonServlet
 */
public class ViewSchemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewSchemeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SchemeProcessor sp = new SchemeProcessor();
		HashMap<Integer, SchemeTO> DisplaySchemeList = sp.fetchSchemeList();
		
		ServletContext application = getServletContext();
		application.setAttribute("DisplaySchemeList", DisplaySchemeList);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewSchemeId.jsp");
        dispatcher.forward(request, response);
 
	}	
}

package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import processor.CompanyProcessor;
import dto.AgentTO;


/**
 * Servlet implementation class LogonServlet
 */
public class ViewCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CompanyProcessor cp = new CompanyProcessor();
		HashMap<Integer, String> DisplayCompanyList = cp.fetchCompanyList();
		
		ServletContext application = getServletContext();
		application.setAttribute("DisplayCompanyList", DisplayCompanyList);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewCompanyId.jsp");
        dispatcher.forward(request, response);
 
	}	
}

package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import processor.AgentProcessor;
import dto.AgentTO;


/**
 * Servlet implementation class LogonServlet
 */
public class ViewAgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewAgentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AgentProcessor ap = new AgentProcessor();
		HashMap<Integer, AgentTO> DisplayAgentList = ap.fetchAgentList();
		
		ServletContext application = getServletContext();
		application.setAttribute("DisplayAgentList", DisplayAgentList);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewAgentId.jsp");
        dispatcher.forward(request, response);
 
	}	
}

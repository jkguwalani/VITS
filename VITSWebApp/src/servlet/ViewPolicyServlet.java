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
import processor.PolicyProcessor;
import dto.AgentTO;
import dto.PolicyTO;


/**
 * Servlet implementation class LogonServlet
 */
public class ViewPolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewPolicyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PolicyProcessor pp = new PolicyProcessor();
		HashMap<Integer, PolicyTO> DisplayPolicyList = pp.fetchPolicyList();
		
		ServletContext application = getServletContext();
		application.setAttribute("DisplayPolicyList", DisplayPolicyList);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewPolicyId.jsp");
        dispatcher.forward(request, response);
 
	}	
}

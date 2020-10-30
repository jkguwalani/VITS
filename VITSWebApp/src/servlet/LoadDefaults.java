package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import processor.AgentProcessor;
import processor.CompanyProcessor;
import processor.SchemeProcessor;
import dao.LoadFunctionalities;
import dto.AgentTO;
import dto.SchemeTO;


public class LoadDefaults extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {

		System.out.println("Inside LoadDefaults");
		
		ServletContext application = getServletContext();
		
		LoadFunctionalities loadFunctionality = new LoadFunctionalities();
		HashMap<Integer, String> functionalityList = loadFunctionality.getFunctioanlities();
		application.setAttribute("FunctionalityList", functionalityList);
		for (Map.Entry<Integer, String> entry : functionalityList.entrySet()) {
			System.out.print("Key = " + entry.getKey());
			System.out.println(" Value = " + entry.getValue());
		}
		
		CompanyProcessor cp = new CompanyProcessor();
		HashMap<Integer, String> companyMap = cp.fetchCompanyList();
		application.setAttribute("CompanyList", companyMap);
		
		SchemeProcessor sp = new SchemeProcessor();
		HashMap<Integer, SchemeTO> schemeMap = sp.fetchSchemeList();
		application.setAttribute("SchemeList", schemeMap);
		
		AgentProcessor ap = new AgentProcessor();
		HashMap<Integer, AgentTO> agentMap = ap.fetchAgentList();
		application.setAttribute("AgentList", agentMap);
		
		System.out.println("Out of init of LoadDefaults");
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet of LoadDefaults");
		init();
		System.out.println("Out of doGet of LoadDefaults");
		
	}
}
package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.SchemeTO;

import forms.AgentForm;
import validator.ValidateForm;

/**
 * Servlet implementation class AgentServlet
 */
public class AgentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AgentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request.getParameter(submit) =>" + request.getParameter("Submit"));
		
		
	        String agentName = request.getParameter("agentname");
	        String compCode = request.getParameter("compcode");
	        String schemeCode = request.getParameter("schemecode");
	        String schemeName = "";
	        System.out.println("COMP CODE =" +compCode);
	        
	        ServletContext app = getServletContext();
	        HashMap<Integer,String> companyMap = (HashMap)app.getAttribute("CompanyList");
	        String companyName = "";	        
	        System.out.println("CONTAINS KEY = " + companyMap.containsKey(Integer.parseInt(compCode)));	        
	        if(companyMap.containsKey(Integer.parseInt(compCode)))
	        	companyName = (String)companyMap.get(Integer.parseInt(compCode));
	        
	        /*HashMap schemeMap = (HashMap)app.getAttribute("SchemeList");
	        SchemeTO schemeTO = null;
	        String schemeName = "";
	        int schemeMapSize = schemeMap.size();
			for(int i=1; i<=schemeMapSize ; i++){
				schemeTO =  (SchemeTO) schemeMap.get(i);
				if(schemeCode.equals(schemeTO.getSchemeId().toString())){
					System.out.println("schemeTO.getSchemeId().toString()" + schemeTO.getSchemeId().toString());
					schemeName=schemeTO.getSchemeName(); 
					System.out.println("SCHEME NAME = " + schemeName);
				}
			}
			*/
			
	        HashMap schemeMap = (HashMap)app.getAttribute("SchemeList");
			System.out.println("SchemeMap HashMap USED");
			int schememapSize = 0;
			if(!schemeMap.isEmpty()){
			schememapSize = schemeMap.size();
			Iterator entries = schemeMap.entrySet().iterator();
				while (entries.hasNext()) {
				    Map.Entry entry = (Map.Entry) entries.next();
				    Integer key = (Integer)entry.getKey();
				    SchemeTO schemeTO = (SchemeTO)entry.getValue();
				    schemeName = schemeTO.getSchemeName();
				    System.out.println("Scheme Key = " + key + ", SchemeValue = " + schemeTO.getSchemeName());
				}
			}

			
	        
	        String branchCode = request.getParameter("branchcode");
	        String branchName = request.getParameter("branchname");
	        String smCode = request.getParameter("smcode");
	        String smName = request.getParameter("smname");
	        String vendorCode = request.getParameter("vendorcode");
	        String vendorName = request.getParameter("vendorname");
	     
	        System.out.println("AgentServlet request.getParameter(agentname) = " + agentName);
	        
	        	
	        AgentForm agentForm = new AgentForm();
	        agentForm.setAgentName(agentName.trim());
	        agentForm.setCompanyId(compCode.trim());
	        agentForm.setCompanyName(companyName.trim());
	        agentForm.setSchemeId(schemeCode.trim());
	        agentForm.setSchemeName(schemeName.trim());
	        agentForm.setBranchCode(branchCode.trim());
	        agentForm.setBranchName(branchName.trim());
	        agentForm.setSmCode(smCode.trim());
	        agentForm.setSmName(smName.trim());
	        agentForm.setVendorCode(vendorCode.trim());
	        agentForm.setVendorName(vendorName.trim());	        
	        
	        
	        ValidateForm valFormobj = new ValidateForm();
	        Boolean validOutput = valFormobj.validateAndInsertAgent(agentForm);
	        System.out.println("AgentServlet validOutput = " + validOutput);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/LoadDefaults");
	 	    dispatcher.include(request, response);
	 		
	 		dispatcher = request.getRequestDispatcher("/RegisterAgent.jsp");
	        request.getSession().setAttribute("agentForm",agentForm);
	        dispatcher.forward(request, response);
		
	}	
}

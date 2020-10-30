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

import dto.AgentTO;

import forms.LogonForm;
import forms.PolicyForm;

import validator.ValidateForm;

public class PolicyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PolicyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String policyType = request.getParameter("policytype");
		String agentId = request.getParameter("agentid");
		String policyIssuedOn = request.getParameter("policyissuedon");
		String policyIssuingOffice = request.getParameter("policyissuingoffice");
		String periodOfInsurance = request.getParameter("periodofinsurance");
		String proposersName = request.getParameter("proposersname");
		String address = request.getParameter("address");
		String pincode = request.getParameter("pincode");
		String emailAddress = request.getParameter("emailAddress");
		String contactNumber = request.getParameter("contactnumber");
		String pancard = request.getParameter("pancard");
		String typeOfVehicle = request.getParameter("typeofvehicle");
		String model = request.getParameter("model");
		String userId = request.getParameter("userId"); 
		
	
		System.out.println("agentId = " +agentId);
		System.out.println("policyType = " +policyType);
		System.out.println("policyIssuedOn = " +policyIssuedOn);
		System.out.println("policyIssuingOffice = " +policyIssuingOffice);
		System.out.println("periodOfInsurance = " +periodOfInsurance);
		
		
		PolicyForm policyForm = new PolicyForm();
				
		ServletContext app = getServletContext();
		HashMap agentMap = (HashMap)app.getAttribute("AgentList");
		Iterator entries = agentMap.entrySet().iterator();
		AgentTO agentTO = null;
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		    Integer key = (Integer)entry.getKey();
		    System.out.println("AgentKey = " + key + ", Key = "+ key );
		    if(agentId.equals(key.toString())){
		    	agentTO = (AgentTO)entry.getValue();	
		        System.out.println("AgentValue = " + agentTO.getAgentName());
		    }
		}
		
		if(agentTO != null){
			System.out.println("AgentName = " + agentTO.getAgentName());
			policyForm.setUserId(userId.trim());
			policyForm.setPolicyType(policyType.trim());
			policyForm.setAgentCode(agentId.trim());
			
			policyForm.setAgentName(agentTO.getAgentName().trim());
			policyForm.setCompanyId(agentTO.getCompanyId().toString());
			policyForm.setCompanyName(agentTO.getCompanyName().trim());
			policyForm.setSchemeId(agentTO.getSchemeId().toString());
			policyForm.setSchemeName(agentTO.getSchemeName().trim());
			policyForm.setBranchCode(agentTO.getBranchCode().toString());
			policyForm.setBranchName(agentTO.getBranchName().trim());
			policyForm.setSmCode(agentTO.getSmCode().toString());
			policyForm.setSmName(agentTO.getSmName().trim());
			policyForm.setVendorCode(agentTO.getVendorCode().toString());
			policyForm.setVendorName(agentTO.getVendorName().trim());
			
			policyForm.setProposersName(proposersName.trim());
			policyForm.setAddress(address.trim());
			policyForm.setPincode(pincode.trim());
			policyForm.setEmailAddress(emailAddress.trim());
			policyForm.setContactNumber(contactNumber.trim());
			policyForm.setPancard(pancard.trim());
			policyForm.setTypeOfVehicle(typeOfVehicle.trim());
			policyForm.setModel(model.trim());
			
			policyForm.setPolicyIssuedOn(policyIssuedOn.trim());
			policyForm.setPolicyIssuingOffice(policyIssuingOffice.trim());
			policyForm.setPeriodOfInsurance(periodOfInsurance.trim());
			
			ValidateForm valFormobj = new ValidateForm();
		    Boolean validOutput = valFormobj.validateAndInsertPolicy(policyForm);
		    System.out.println("PolicyServlet validOutput = " + validOutput);
		    if(validOutput)
		    	policyForm.setErrortext("Policy Inserted Successfully.");
		    else
		    	policyForm.setErrortext("Failed to Insert Policy.");
		    
		}else{
			policyForm.setErrortext("Failed to Insert Policy.");
		}
		    
		RequestDispatcher dispatcher = request.getRequestDispatcher("/LoadDefaults");
 	    dispatcher.include(request, response);
 		
 		dispatcher= request.getRequestDispatcher("/RegisterPolicy.jsp");
	    request.getSession().setAttribute("policyForm",policyForm);
	    dispatcher.forward(request, response);
		
	}	
}
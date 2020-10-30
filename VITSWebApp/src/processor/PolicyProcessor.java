package processor;

import java.util.HashMap;
import java.util.Map;

import dao.AgentDAO;
import dao.PolicyDAO;
import dao.DAOFactory;
import dto.AgentTO;
import dto.PolicyTO;

import enums.TableName;
import forms.PolicyForm;

public class PolicyProcessor {

	public PolicyTO insertPolicy(PolicyForm policyForm){
		PolicyTO policyTO = null;
		PolicyDAO policyDAO = (PolicyDAO) DAOFactory.create(TableName.Policy_Mstr);
		policyTO = policyDAO.insert(policyForm);
		
		if(policyTO != null){
			System.out.println("PolicyProcessor --> Policy inserted succesfully ");
		}else{
			System.out.println("PolicyProcessor --> Policy not inserted");
		}
		return policyTO;
	}
	
	public HashMap<Integer,PolicyTO> fetchPolicyList() {
		PolicyDAO policyDAO = (PolicyDAO) DAOFactory.create(TableName.Policy_Mstr);
		HashMap<Integer, PolicyTO> agentMap = policyDAO.getPolicyMap();
		
		if(agentMap.isEmpty()){
			System.out.println("No Policy Registered");
		}else{
			
			for (Map.Entry<Integer, PolicyTO> entry : agentMap.entrySet()) {
		        Integer key = entry.getKey();
		        PolicyTO value = entry.getValue();
		        System.out.println("Policy Key=>" + key);
		        System.out.println("Policy Value =>" + value);
		    }
			
			/*int agentMapSize = agentMap.size();
			for(int i=1; i<=agentMapSize ; i++){
				AgentTO agentTO=  agentMap.get(i);
				System.out.println("Agent Name =>" + agentTO.getAgentName());
				System.out.println("Company Name =>" + agentTO.getCompanyName());
				System.out.println("Scheme Name =>" + agentTO.getSchemeName());
			}*/			
		}
		return agentMap;
	}
	
}
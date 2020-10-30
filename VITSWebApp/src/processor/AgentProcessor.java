package processor;

import java.util.HashMap;
import java.util.Map;

import dao.AgentDAO;
import dao.DAOFactory;
import dto.AgentTO;
import dto.SchemeTO;
import enums.TableName;
import forms.AgentForm;

public class AgentProcessor {

	public AgentTO findAgentByName(AgentForm agentform) {

		AgentTO agentTO = null;
		AgentDAO agentDAO = (AgentDAO) DAOFactory.create(TableName.Agent_Mstr);
				
		agentTO = agentDAO.findAgentByName(agentform);
		if(agentTO != null){
			System.out.println("AgentProcessor agentName= " +agentTO.getAgentName());
		}else{
			System.out.println(agentform.getAgentName() + " Agent NOT FOUND");
		}

		return agentTO;

	}
	
	public AgentTO insertAgent(AgentForm agentForm){
		AgentTO agentTO = null;
		AgentDAO agentDAO = (AgentDAO) DAOFactory.create(TableName.Agent_Mstr);
		agentTO = agentDAO.insert(agentForm);
		
		if(agentTO != null){
			System.out.println("AgentProcessor --> Agent inserted succesfully ");
		}else{
			System.out.println("AgentProcessor --> Agent not inserted");
		}
		return agentTO;
	}
	
	public HashMap<Integer,AgentTO> fetchAgentList() {
		AgentDAO agentDAO = (AgentDAO) DAOFactory.create(TableName.Agent_Mstr);
		HashMap<Integer, AgentTO> agentMap = agentDAO.getAgentMap();
		
		if(agentMap.isEmpty()){
			System.out.println("No Agent Registered");
		}else{
			
			for (Map.Entry<Integer, AgentTO> entry : agentMap.entrySet()) {
		        Integer key = entry.getKey();
		        AgentTO value = entry.getValue();
		        System.out.println("Agent Key=>" + key);
		        System.out.println("Agent Value =>" + value);
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
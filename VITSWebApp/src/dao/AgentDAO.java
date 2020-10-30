package dao;

import java.util.HashMap;

import dto.AgentTO;
import forms.AgentForm;


public interface AgentDAO extends CommonDAO{

	public AgentTO findAgentByName(AgentForm agentform);
	public HashMap<Integer,AgentTO> getAgentMap();
	public AgentTO insert(AgentForm agentform);
	public AgentTO update(AgentForm agentform);
	public AgentTO delete(AgentForm agentform);

}

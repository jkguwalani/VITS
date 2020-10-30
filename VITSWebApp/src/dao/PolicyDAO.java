package dao;

import java.util.HashMap;

import dto.PolicyTO;
import forms.PolicyForm;


public interface PolicyDAO extends CommonDAO{
	public PolicyTO insert(PolicyForm policyForm);
	public HashMap<Integer,PolicyTO> getPolicyMap();
}

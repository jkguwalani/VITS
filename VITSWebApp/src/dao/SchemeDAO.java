package dao;

import java.util.HashMap;

import dto.SchemeTO;
import forms.SchemeForm;

public interface SchemeDAO extends CommonDAO{

	public SchemeTO findSchemeByName(SchemeForm schemeform);
//	public HashMap<Integer,SchemeTO> getSchemeCompanyMap(String schemeName);
	public HashMap<Integer,SchemeTO>  getSchemeMap();
	public SchemeTO insert(SchemeForm schemeform);
	public SchemeTO update(SchemeForm schemeform);
	public SchemeTO delete(SchemeForm schemeform);

}

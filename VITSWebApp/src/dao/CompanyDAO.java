package dao;

import java.util.HashMap;

import dto.CompanyTO;
import forms.CompanyForm;


public interface CompanyDAO extends CommonDAO{

	public CompanyTO findCmpByName(String companyName);
	public HashMap<Integer,String>  getCompaniesMap();
	public CompanyTO insert(CompanyForm companyForm);
	public CompanyTO update(CompanyForm companyForm);
	public CompanyTO delete(CompanyForm companyForm);

}

package processor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dao.CompanyDAO;
import dao.DAOFactory;
import dto.CompanyTO;

import enums.TableName;
import forms.CompanyForm;

public class CompanyProcessor {

	public CompanyTO findCompanyByName(String companyName) {

		CompanyTO compTO = null;
		System.out.println("CompanyProcessor companyName= " +companyName );
		CompanyDAO cmpDAO = (CompanyDAO) DAOFactory.create(TableName.Company_Mstr);
				
		compTO = cmpDAO.findCmpByName(companyName);
		if(compTO != null){
			System.out.println("CompanyProcessor companyName= " +compTO.getCompName());
		}else{
			System.out.println(companyName + " COMPANY NOT FOUND");
		}

		return compTO;

	}

	
	public CompanyTO insertCompany(CompanyForm companyForm){
		CompanyTO compTO = null;
		CompanyDAO cmpDAO = (CompanyDAO) DAOFactory.create(TableName.Company_Mstr);
		compTO = cmpDAO.insert(companyForm);
		
		if(compTO != null){
			System.out.println("CompanyProcessor --> Company inserted succesfully ");
		}else{
			System.out.println("CompanyProcessor --> Company not inserted");
		}
		return compTO;
	}
	
	public HashMap<Integer,String> fetchCompanyList() {

		CompanyDAO cmpDAO = (CompanyDAO) DAOFactory.create(TableName.Company_Mstr);
		HashMap<Integer, String> companyMap = cmpDAO.getCompaniesMap();
		
		if(companyMap.isEmpty()){
			System.out.println("No Company Registered");
		}else{		    
		    for (Map.Entry<Integer, String> entry : companyMap.entrySet()) {
		        Integer key = entry.getKey();
		        String value = entry.getValue();
		        System.out.println("Company Key=>" + key);
		        System.out.println("Company Name =>" + value);
		    }
			
			/*int mapSize = companyMap.size();
			for(int i=1; i<=mapSize ; i++){
				System.out.println("Company Name =>" + companyMap.get(i));				
			}*/
			
		}
		return companyMap;
	}

}
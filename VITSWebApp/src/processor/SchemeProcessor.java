package processor;

import java.util.HashMap;
import java.util.Map;

import dao.SchemeDAO;
import dao.DAOFactory;
import dto.SchemeTO;

import enums.TableName;
import forms.SchemeForm;

public class SchemeProcessor {

	public SchemeTO findSchemeByName(SchemeForm schemeform) {

		SchemeTO schemeTO = null;
		SchemeDAO schemeDAO = (SchemeDAO) DAOFactory.create(TableName.Scheme_Mstr);
				
		schemeTO = schemeDAO.findSchemeByName(schemeform);
		if(schemeTO != null){
			System.out.println("SchemeProcessor schemeName= " +schemeTO.getSchemeName());
		}else{
			System.out.println(schemeform.getSchemeName() + " Scheme NOT FOUND");
		}

		return schemeTO;

	}

	public SchemeTO insertScheme(SchemeForm schemeForm){
		SchemeTO schemeTO = null;
		SchemeDAO schemeDAO = (SchemeDAO) DAOFactory.create(TableName.Scheme_Mstr);
		schemeTO = schemeDAO.insert(schemeForm);
		
		if(schemeTO != null){
			System.out.println("SchemeProcessor --> Scheme inserted succesfully ");
		}else{
			System.out.println("SchemeProcessor --> Scheme not inserted");
		}
		return schemeTO;
	}
	
	public HashMap<Integer, SchemeTO> fetchSchemeList() {
		SchemeDAO schemeDAO = (SchemeDAO) DAOFactory.create(TableName.Scheme_Mstr);
		HashMap<Integer, SchemeTO> schemeMap = schemeDAO.getSchemeMap();
		
		if(schemeMap.isEmpty()){
			System.out.println("No Schemes Registered");
		}else{	
			
			for (Map.Entry<Integer, SchemeTO> entry : schemeMap.entrySet()) {
		        Integer key = entry.getKey();
		        SchemeTO value = entry.getValue();
		        System.out.println("Scheme Key=>" + key);
		        System.out.println("Scheme Value =>" + value);
		    }
			
			
			/*int schemeMapSize = schemeMap.size();
			for(int i=1; i<=schemeMapSize ; i++){
				SchemeTO schemeTO =  schemeMap.get(i);
				System.out.println("SchemeProcessor =" + schemeMapSize);
				System.out.println("schemeTO" + schemeTO);
				System.out.println("Scheme Name =>" + schemeTO.getSchemeName());
				System.out.println("Scheme Company Name=>" + schemeTO.getSchemeCompName());				
			}*/			
		}
		return schemeMap;
	}
	
	/*public HashMap<Integer,SchemeTO> fetchSchemeCompanyList(String schemeName) {
		SchemeDAO schemeDAO = (SchemeDAO) DAOFactory.create(TableName.Scheme_Mstr);
		HashMap<Integer, SchemeTO> schemeCompMap = schemeDAO.getSchemeCompanyMap(schemeName.trim().toLowerCase());
		
		if(schemeCompMap.isEmpty()){
			System.out.println("No Companies Registered with this Scheme");
		}else{			
			int schemeMapSize = schemeCompMap.size();
			for(int i=1; i<=schemeMapSize ; i++){
				SchemeTO schemeTO=  schemeCompMap.get(i);
				System.out.println("VALUE =>" + schemeTO.getSchemeCompName());				
			}			
		}
		return schemeCompMap;
	}*/
}
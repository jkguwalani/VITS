package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


import validator.CommonValidator;

import database.DBUtil;
import database.DatabaseConnectionFactory;
import dto.SchemeTO;
import forms.SchemeForm;

public class SchemeDAOImpl extends CommonDAOImpl implements SchemeDAO{
	
	Connection connection; 
	Statement statement; 
	PreparedStatement preparedStatement;
	ResultSet resultSet;    
  
	
	@Override
	public SchemeTO findSchemeByName(SchemeForm schemeform) {
		SchemeTO schemeTO = null;
		String SQL_QUERY = "Select SchemeName,SchemeCompName,SchemeId,SchemeCompId from SchemeMstr where SchemeName=?" ;
		
		try{
			
			if(CommonValidator.validateString(schemeform.getSchemeName().trim().toLowerCase())){
				System.out.println("SchemeDAOIMPL findSchemeByName = " + schemeform.getSchemeName());
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,schemeform.getSchemeName());
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				resultSet = preparedStatement.executeQuery();	
				
				while(resultSet.next()){
					schemeTO = new SchemeTO();
					schemeTO.setSchemeName(resultSet.getString("SchemeName"));
					schemeTO.setSchemeCompName(resultSet.getString("SchemeCompName"));
					schemeTO.setSchemeId(Integer.parseInt(resultSet.getString("SchemeId")));
					schemeTO.setSchemeCompId(Integer.parseInt(resultSet.getString("SchemeCompId")));
					
					System.out.println("SchemeTO schemeID = " + schemeTO.getSchemeId());
					System.out.println("SchemeTO schemeName = " + schemeTO.getSchemeName());
					System.out.println("SchemeTO schemeCompID = " + schemeTO.getSchemeCompId());
					System.out.println("SchemeTO schemeCompName = " + schemeTO.getSchemeCompName());				 	
				}	
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		 
		return schemeTO;

	}

	@Override
	public SchemeTO delete(SchemeForm schemeForm) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SchemeTO insert(SchemeForm schemeForm) {
		SchemeTO schemeTO = null;
		
		String SQL_QUERY = "insert into SchemeMstr (SchemeName,SchemeCompName,SchemeCompId)values(?,?,?)";
		try{
			if(CommonValidator.validateString(schemeForm.getSchemeName().trim().toLowerCase()) && CommonValidator.validateString(schemeForm.getSchemeCompName().trim().toLowerCase())){
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,schemeForm.getSchemeName());
				preparedStatement.setString(2,schemeForm.getSchemeCompName());
				preparedStatement.setString(3,schemeForm.getSchemeCompId());
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				int output = preparedStatement.executeUpdate();
				System.out.println("INSERTED SUCCESSFULLY");
				if (output > 0){
					schemeTO = new SchemeTO();
					schemeTO.setSchemeName(schemeForm.getSchemeName());
					schemeTO.setSchemeCompName(schemeForm.getSchemeCompName());
					schemeTO.setSchemeCompName(schemeForm.getSchemeCompId());
				}
			}
		}catch(SQLException e){
			e.printStackTrace();			
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return schemeTO;
	}

	public HashMap<Integer,SchemeTO>  getSchemeMap(){

		HashMap<Integer,SchemeTO>  map = new HashMap<Integer,SchemeTO>();
		String SQL_QUERY = "Select SchemeId,SchemeName,SchemeCompId,SchemeCompName from SchemeMstr" ; 
		try{
			connection = DatabaseConnectionFactory.getConnection();       
			statement = connection.createStatement();       
			resultSet = statement.executeQuery(SQL_QUERY);    
			
			System.out.println("SQL_QUERY = " + SQL_QUERY);
			int size = 0;
			String schemeId = null;
			String schemeName = null;
			String schemeCompName = null;
			String schemeCompId = null;
			

			while(resultSet.next()) { 
				schemeId = resultSet.getString("SchemeId");
				schemeName = resultSet.getString("SchemeName");
				schemeCompId = resultSet.getString("SchemeCompId");
				schemeCompName = resultSet.getString("SchemeCompName");	
								
				SchemeTO schemeTO= new SchemeTO();
				schemeTO.setSchemeId(Integer.parseInt(schemeId));
				schemeTO.setSchemeName(schemeName);
				schemeTO.setSchemeCompId(Integer.parseInt(schemeCompId));
				schemeTO.setSchemeCompName(schemeCompName);

				System.out.println("SchemeTO=" + schemeTO);
				
				size++;
				
				if(CommonValidator.validateString(schemeName) && CommonValidator.validateString(schemeCompName)){
					map.put(schemeTO.getSchemeId(), schemeTO);
				}
			 				 	
			}
			System.out.println("Size of Scheme Table = " + size);
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return map;   

	}
	
	/*public HashMap<Integer,SchemeTO>  getSchemeCompanyMap(String schemeName){

		HashMap<Integer,SchemeTO>  map = new HashMap<Integer,SchemeTO>();		
		String SQL_QUERY = "Select SchemeName,SchemeCompName,SchemeId,SchemeCompId from SchemeMstr where SchemeName=?" ;
		System.out.println("SchemeDAOIMPL getSchemeCompanyMap = " + schemeName);
		try{
			if(CommonValidator.validateString(schemeName.trim().toLowerCase())){				
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,schemeName.trim().toLowerCase());
	
				System.out.println("preparedStatement = " + SQL_QUERY);
				resultSet = preparedStatement.executeQuery();	
			
				System.out.println("SQL_QUERY = " + SQL_QUERY);
				int size = 0;
				String schemeId = null;
				String schemeName1 = null;
				String schemeCompName = null;
				String schemeCompId = null;
				

				while(resultSet.next()) { 
					schemeId = resultSet.getString("SchemeId");
					schemeName1 = resultSet.getString("SchemeName");
					schemeCompName = resultSet.getString("SchemeCompName");	
					schemeCompId = resultSet.getString("SchemeCompId");
					
					SchemeTO schemeTO= new SchemeTO();
					schemeTO.setSchemeId(Integer.parseInt(schemeId));
					schemeTO.setSchemeName(schemeName1);
					schemeTO.setSchemeCompName(schemeCompName);
					schemeTO.setSchemeCompId(Integer.parseInt(schemeCompId));
					
					if(CommonValidator.validateString(schemeName) && CommonValidator.validateString(schemeCompName)){
						map.put(schemeTO.getSchemeCompId(), schemeTO);
					}
				 	
				 	size++;
				}
				System.out.println("Size of Scheme Company Map = " + size);
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return map;   

	}
*/	
	@Override
	public SchemeTO update(SchemeForm schemeForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

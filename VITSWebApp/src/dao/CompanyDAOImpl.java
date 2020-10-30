package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import validator.CommonValidator;

import database.DBUtil;
import database.DatabaseConnectionFactory;
import dto.CompanyTO;
import dto.UserTO;
import forms.CompanyForm;

public class CompanyDAOImpl extends CommonDAOImpl implements CompanyDAO{
	
	Connection connection; 
	Statement statement; 
	PreparedStatement preparedStatement;
	ResultSet resultSet;    
  
	
	@Override
	public CompanyTO findCmpByName(String compname) {
		CompanyTO compTO = null;
		String SQL_QUERY = "Select CompName,CompAddress,CompId from CompanyMstr where CompName=?";
		
		try{
			System.out.println("CompDAOIMPL findCmpByName = " + compname);
			if(CommonValidator.validateString(compname.trim().toLowerCase())){
				
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,compname);
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				resultSet = preparedStatement.executeQuery();	
				
				while(resultSet.next()){
					compTO = new CompanyTO();
					compTO.setCompName(resultSet.getString("CompName"));
					compTO.setCompAddress(resultSet.getString("CompAddress"));
					compTO.setCompId(Integer.parseInt(resultSet.getString("CompId")));
					
					System.out.println("companyTO compName = " + compTO.getCompName());
				 	System.out.println("companyTO compAdd = " + compTO.getCompAddress());
				 	System.out.println("companyTO compID = " + compTO.getCompId());
				}	
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
		return compTO;

	}

	@Override
	public CompanyTO delete(CompanyForm companyForm) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CompanyTO insert(CompanyForm companyForm) {
		CompanyTO compTO = null;
		String SQL_QUERY = "insert into CompanyMstr (CompName,CompAddress)values(?,?)";
		try{
			if(CommonValidator.validateString(companyForm.getCompanyName().trim().toLowerCase()) && CommonValidator.validateString(companyForm.getCompanyAdd().trim().toLowerCase())){
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,companyForm.getCompanyName());
				preparedStatement.setString(2,companyForm.getCompanyAdd());
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				int output = preparedStatement.executeUpdate();
				System.out.println("INSERTED SUCCESSFULLY");
				if (output > 0){
					compTO = new CompanyTO();
					compTO.setCompName(companyForm.getCompanyName());
					compTO.setCompAddress(companyForm.getCompanyAdd());
				}
			}
		}catch(SQLException e){
			e.printStackTrace();			
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return compTO;
	}


	@Override
	public CompanyTO update(CompanyForm companyForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public HashMap<Integer,String>  getCompaniesMap(){

		HashMap<Integer,String>  map = new HashMap<Integer,String>();
		String SQL_QUERY = "Select CompName,CompId from CompanyMstr"; 
		try{
			connection = DatabaseConnectionFactory.getConnection();       
			statement = connection.createStatement();       
			resultSet = statement.executeQuery(SQL_QUERY);    
			
			System.out.println("SQL_QUERY = " + SQL_QUERY);
			int size = 0;
			String compId = null;
			String compName = null;

			while(resultSet.next()) { 
				compId = resultSet.getString("CompId");
				compName = resultSet.getString("CompName");
				
				if(CommonValidator.validateString(compId) && CommonValidator.validateString(compName)){
					map.put(Integer.parseInt(compId), compName);
				}
			 	
			 	size++;
			}
			System.out.println("Size of Company Table = " + size);
			
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
	
}

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
import dto.AgentTO;
import forms.AgentForm;

public class AgentDAOImpl extends CommonDAOImpl implements AgentDAO{
	
	Connection connection; 
	Statement statement; 
	PreparedStatement preparedStatement;
	ResultSet resultSet;    
  
	
	@Override
	public AgentTO findAgentByName(AgentForm agentform) {
		AgentTO agentTO = null;
		String SQL_QUERY = "Select AgentName,CompanyName,SchemeName,CompanyId,SchemeCode from AgentMstr where AgentName=? and CompanyId=? and SchemeCode=?" ;
		
		try{
			
			if(CommonValidator.validateString(agentform.getAgentName().trim().toLowerCase())){
				System.out.println("AgentDAOIMPL findAgentByName = " + agentform.getAgentName());
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,agentform.getAgentName());
				preparedStatement.setString(2,agentform.getCompanyId());
				preparedStatement.setString(3,agentform.getSchemeId());
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				resultSet = preparedStatement.executeQuery();	
				
				while(resultSet.next()){
					agentTO = new AgentTO();
					agentTO.setAgentName(resultSet.getString("AgentName"));
					agentTO.setCompanyName(resultSet.getString("CompanyName"));
					agentTO.setSchemeName(resultSet.getString("SchemeName"));
					agentTO.setCompanyId(new Integer(resultSet.getString("CompanyId")));
					agentTO.setSchemeId(new Integer(resultSet.getString("SchemeCode")));
				}	
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
		return agentTO;

	}

	@Override
	public AgentTO delete(AgentForm agentForm) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AgentTO insert(AgentForm agentForm) {
		AgentTO agentTO = null;
		
		String SQL_QUERY = "insert into AgentMstr (AgentName,BranchCode,BranchName,CompanyId,CompanyName,SMCode,SMName,VendorCode,VendorName,SchemeCode,SchemeName)values(?,?,?,?,?,?,?,?,?,?,?)";
		try{
			if(CommonValidator.validateString(agentForm.getAgentName().trim().toLowerCase())){
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,agentForm.getAgentName());
				preparedStatement.setString(2,agentForm.getBranchCode());
				preparedStatement.setString(3,agentForm.getBranchName());
				preparedStatement.setString(4,agentForm.getCompanyId());
				preparedStatement.setString(5,agentForm.getCompanyName());
				preparedStatement.setString(6,agentForm.getSmCode());
				preparedStatement.setString(7,agentForm.getSmName());
				preparedStatement.setString(8,agentForm.getVendorCode());
				preparedStatement.setString(9,agentForm.getVendorName());
				preparedStatement.setString(10,agentForm.getSchemeId());
				preparedStatement.setString(11,agentForm.getSchemeName());
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				int output = preparedStatement.executeUpdate();
				System.out.println("INSERTED SUCCESSFULLY");
				if (output > 0){
					agentTO = new AgentTO();
					agentTO.setAgentName(agentForm.getAgentName());
					if(agentForm.getBranchCode() != null)
						agentTO.setBranchCode(Integer.parseInt(agentForm.getBranchCode()));
					agentTO.setBranchName(agentForm.getBranchName());
					if(agentForm.getCompanyId() != null)
						agentTO.setCompanyId(Integer.parseInt(agentForm.getCompanyId()));
					agentTO.setCompanyName(agentForm.getCompanyName());
					if(agentForm.getSchemeId() != null)
						agentTO.setSchemeId(Integer.parseInt(agentForm.getSchemeId()));
					agentTO.setSchemeName(agentForm.getSchemeName());
					if(agentForm.getSmCode() != null)
						agentTO.setSmCode(Integer.parseInt(agentForm.getSmCode()));
					agentTO.setSmName(agentForm.getSmName());
					if(agentForm.getVendorCode() != null)
						agentTO.setVendorCode(Integer.parseInt(agentForm.getVendorCode()));
					agentTO.setVendorName(agentForm.getVendorName());
					
					
				}
			}
		}catch(SQLException e){
			e.printStackTrace();			
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return agentTO;
	}

	public HashMap<Integer,AgentTO> getAgentMap(){

		HashMap<Integer,AgentTO>  map = new HashMap<Integer,AgentTO>();
		String SQL_QUERY = "Select AgentCode,AgentName,BranchCode,BranchName,CompanyId,CompanyName,SMCode,SMName,VendorCode,VendorName,SchemeCode,SchemeName from AgentMstr" ; 
		try{
			connection = DatabaseConnectionFactory.getConnection();       
			statement = connection.createStatement();       
			resultSet = statement.executeQuery(SQL_QUERY);    
			
			System.out.println("SQL_QUERY = " + SQL_QUERY);
			int size = 0;
			String agentCode = null;
			String agentName = null;
			String branchCode = null;
			String branchName = null;
			String companyId = null;
			String companyName = null;
			String SMCode = null;
			String SMName = null;
			String VendorCode = null;
			String VendorName = null;
			String SchemeCode = null;
			String SchemeName = null;
			

			while(resultSet.next()) { 
				agentCode = resultSet.getString("AgentCode");
				agentName = resultSet.getString("AgentName");
				branchCode = resultSet.getString("BranchCode");	
				branchName = resultSet.getString("BranchName");
				companyId = resultSet.getString("CompanyId");
				companyName = resultSet.getString("CompanyName");
				SMCode = resultSet.getString("SMCode");
				SMName = resultSet.getString("SMName");
				VendorCode = resultSet.getString("VendorCode");
				VendorName = resultSet.getString("VendorName");
				SchemeCode = resultSet.getString("SchemeCode");
				SchemeName = resultSet.getString("SchemeName");
				
				
				AgentTO agentTO= new AgentTO();
				if(CommonValidator.validateString(agentCode))
					agentTO.setAgentCode(Integer.parseInt(agentCode));
				agentTO.setAgentName(agentName);
				if(CommonValidator.validateString(branchCode))
					agentTO.setBranchCode(new Integer(branchCode));
				agentTO.setBranchName(branchName);
				if(CommonValidator.validateString(companyId))
					agentTO.setCompanyId(new Integer(companyId));
				agentTO.setCompanyName(companyName);
				if(CommonValidator.validateString(SMCode))
					agentTO.setSmCode(new Integer(SMCode));
				agentTO.setSmName(SMName);
				if(CommonValidator.validateString(VendorCode))
					agentTO.setVendorCode(new Integer(VendorCode));
				agentTO.setVendorName(VendorName);
				if(CommonValidator.validateString(SchemeCode))
					agentTO.setSchemeId(new Integer(SchemeCode));
				agentTO.setSchemeName(SchemeName);
				
				if(CommonValidator.validateString(agentName)){
					map.put(agentTO.getAgentCode(), agentTO);
				}
			 	
				size++;
			}
			System.out.println("Size of Agent Table = " + size);
			
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
	@Override
	public AgentTO update(AgentForm agentForm) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

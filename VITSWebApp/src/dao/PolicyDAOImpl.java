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
import dto.PolicyTO;
import forms.PolicyForm;

public class PolicyDAOImpl extends CommonDAOImpl implements PolicyDAO{
	
	Connection connection; 
	Statement statement; 
	PreparedStatement preparedStatement;
	ResultSet resultSet;    
  
	@Override
	public PolicyTO insert(PolicyForm policyForm) {
		PolicyTO policyTO = null;
		String SQL_QUERY = "insert into PolicyMstr (PolicyType,PolicyIssuedOn,PeriodOfInsurance,PolicyIssuingOffice,SchemeId,SchemeName,AgentCode,AgentName,BranchCode,BranchName,SMCode,SMName,VendorCode,VendorName,UserId,ProposersName,Address,Pincode,EmailAddress,ContactNumber,Pancard,TypeOfVehicle,Model)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			if(CommonValidator.validateString(policyForm.getAgentCode().trim().toLowerCase())){
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,policyForm.getPolicyType());
				preparedStatement.setString(2,policyForm.getPolicyIssuedOn());
				preparedStatement.setString(3,policyForm.getPeriodOfInsurance());
				preparedStatement.setString(4,policyForm.getPolicyIssuingOffice());
				preparedStatement.setString(5,policyForm.getSchemeId());
				preparedStatement.setString(6,policyForm.getSchemeName());
				preparedStatement.setString(7,policyForm.getAgentCode());
				preparedStatement.setString(8,policyForm.getAgentName());
				preparedStatement.setString(9,policyForm.getBranchCode());
				preparedStatement.setString(10,policyForm.getBranchName());
				preparedStatement.setString(11,policyForm.getSmCode());
				preparedStatement.setString(12,policyForm.getSmName());
				preparedStatement.setString(13,policyForm.getVendorCode());
				preparedStatement.setString(14,policyForm.getVendorName());
				preparedStatement.setString(15,policyForm.getUserId());
				preparedStatement.setString(16,policyForm.getProposersName());
				preparedStatement.setString(17,policyForm.getAddress());
				preparedStatement.setString(18,policyForm.getPincode());
				preparedStatement.setString(19,policyForm.getEmailAddress());
				preparedStatement.setString(20,policyForm.getContactNumber());
				preparedStatement.setString(21,policyForm.getPancard());
				preparedStatement.setString(22,policyForm.getTypeOfVehicle());
				preparedStatement.setString(23,policyForm.getModel());
				
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				int output = preparedStatement.executeUpdate();
				System.out.println("INSERTED SUCCESSFULLY");
				if (output > 0){
					policyTO = new PolicyTO();
					policyTO.setPolicyType(policyForm.getPolicyType());
					policyTO.setPolicyIssuedOn(policyForm.getPolicyIssuedOn());
					policyTO.setPeriodOfInsurance(policyForm.getPeriodOfInsurance());
					policyTO.setPolicyInsuranceOffice(policyForm.getPolicyIssuingOffice());
					policyTO.setSchemeId(Integer.parseInt(policyForm.getSchemeId()));
					policyTO.setSchemeName(policyForm.getSchemeName());
					policyTO.setAgentCode(Integer.parseInt(policyForm.getAgentCode()));
					policyTO.setAgentName(policyForm.getAgentName());
					policyTO.setBranchCode(Integer.parseInt(policyForm.getBranchCode()));
					policyTO.setBranchName(policyForm.getBranchName());
					policyTO.setSmCode(Integer.parseInt(policyForm.getSmCode()));
					policyTO.setSmName(policyForm.getSmName());
					policyTO.setVendorCode(Integer.parseInt(policyForm.getVendorCode()));
					policyTO.setVendorName(policyForm.getVendorName());
					policyTO.setUserId(Integer.parseInt(policyForm.getUserId()));			
					policyTO.setProposersName(policyForm.getProposersName());
					policyTO.setAddress(policyForm.getAddress());
					policyTO.setPincode(policyForm.getPincode());
					policyTO.setEmailAddress(policyForm.getEmailAddress());
					policyTO.setContactNumber(policyForm.getContactNumber());
					policyTO.setPancardNumber(policyForm.getPancard());
					policyTO.setTypeOfVehicle(policyForm.getTypeOfVehicle());
					policyTO.setModel(policyForm.getModel());
				}else
					policyTO = null;
			}
		}catch(SQLException e){
			e.printStackTrace();			
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return policyTO;
	}

	@Override
	public HashMap<Integer, PolicyTO> getPolicyMap() {
		
		HashMap<Integer,PolicyTO>  map = new HashMap<Integer,PolicyTO>();
		String SQL_QUERY = "Select PolicyNumber,PolicyType,PolicyIssuedOn,PeriodOfInsurance,PolicyIssuingOffice,SchemeId,SchemeName,AgentCode,AgentName,BranchCode,BranchName,SMCode,SMName,VendorCode,VendorName,UserId,ProposersName,Address,Pincode,EmailAddress,ContactNumber,Pancard,TypeOfVehicle,Model from PolicyMstr";
		try{
			connection = DatabaseConnectionFactory.getConnection();       
			statement = connection.createStatement();       
			resultSet = statement.executeQuery(SQL_QUERY);    
			
			System.out.println("SQL_QUERY = " + SQL_QUERY);
			int size = 0;
			PolicyTO policyTO = new PolicyTO();

			while(resultSet.next()) { 
				policyTO = new PolicyTO();
				policyTO.setPolicyNumber(resultSet.getInt("PolicyNumber"));
				policyTO.setPolicyType(resultSet.getString("PolicyType"));
				policyTO.setPolicyIssuedOn(resultSet.getString("PolicyIssuedOn"));
				policyTO.setPeriodOfInsurance(resultSet.getString("PeriodOfInsurance"));
				policyTO.setPolicyInsuranceOffice(resultSet.getString("PolicyIssuingOffice"));
				policyTO.setSchemeId(resultSet.getInt("SchemeId"));
				policyTO.setSchemeName(resultSet.getString("SchemeName"));
				policyTO.setAgentCode(resultSet.getInt("AgentCode"));
				policyTO.setAgentName(resultSet.getString("AgentName"));
				policyTO.setBranchCode(resultSet.getInt("BranchCode"));
				policyTO.setBranchName(resultSet.getString("BranchName"));
				policyTO.setSmCode(resultSet.getInt("SMCode"));
				policyTO.setSmName(resultSet.getString("SMName"));
				policyTO.setVendorCode(resultSet.getInt("VendorCode"));
				policyTO.setVendorName(resultSet.getString("VendorName"));
				policyTO.setUserId(resultSet.getInt("UserId"));					
				policyTO.setProposersName(resultSet.getString("ProposersName"));
				policyTO.setAddress(resultSet.getString("Address"));
				policyTO.setPincode(resultSet.getString("Pincode"));
				policyTO.setEmailAddress(resultSet.getString("EmailAddress"));
				policyTO.setContactNumber(resultSet.getString("ContactNumber"));
				policyTO.setPancardNumber(resultSet.getString("Pancard"));
				policyTO.setTypeOfVehicle(resultSet.getString("TypeOfVehicle"));
				policyTO.setModel(resultSet.getString("Model"));
								
				map.put(policyTO.getPolicyNumber(), policyTO);
				
				System.out.println("Policy TO =>" + policyTO.getPolicyNumber());
			 	
			 	size++;
			}
			System.out.println("Size of Policy Table = " + size);
			
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

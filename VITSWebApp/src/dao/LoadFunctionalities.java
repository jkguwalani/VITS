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

public class LoadFunctionalities {
	
	Connection connection; 
	Statement statement; 
	PreparedStatement preparedStatement;
	ResultSet resultSet;    

	public HashMap getFunctioanlities() {
	HashMap<Integer,String>  map = new HashMap<Integer,String>();
	String SQL_QUERY = "Select FunctionalityNumber, FunctionalityName from Functionality"; 
	try{
		connection = DatabaseConnectionFactory.getConnection();       
		statement = connection.createStatement();       
		resultSet = statement.executeQuery(SQL_QUERY);    
		
		System.out.println("SQL_QUERY = " + SQL_QUERY);
		int size = 0;
		String funNum = null;
		String funName = null;

		while(resultSet.next()) { 
			funNum = resultSet.getString("FunctionalityNumber");
			funName = resultSet.getString("FunctionalityName");
			
			if(CommonValidator.validateString(funNum) && CommonValidator.validateString(funName)){
				map.put(Integer.parseInt(funNum), funName);
			}
		 	
		 	size++;
		}
		System.out.println("Size of Functionality Table = " + size);
		
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

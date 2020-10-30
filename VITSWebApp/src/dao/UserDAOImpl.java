package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import validator.CommonValidator;

import database.DBUtil;
import database.DatabaseConnectionFactory;
import dto.UserTO;
import forms.UserForm;

public class UserDAOImpl extends CommonDAOImpl implements UserDAO{
	
	Connection connection; 
	Statement statement; 
	PreparedStatement preparedStatement;
	ResultSet resultSet;    
  
	public List findAll() {       
		ArrayList<UserTO> UserTOList = new ArrayList<UserTO>(); 
		String SQL_QUERY = "Select Username, Password from UserMstr"; 
		try{
			connection = DatabaseConnectionFactory.getConnection();       
			statement = connection.createStatement();       
			resultSet = statement.executeQuery(SQL_QUERY);    
			UserTO userTO = null;
			int size = 0;

			while(resultSet.next()) { 
				userTO = new UserTO();
				userTO.setUsername(resultSet.getString("Username"));
				userTO.setPassword(resultSet.getString("Password"));
				UserTOList.add(userTO);
				
			 	System.out.println("userTO username = " + userTO.getUsername());
			 	System.out.println("userTO password = " + userTO.getPassword());	  
			 	
			 	size++;
			}
			System.out.println("Size of UserMstr = " + size);
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return UserTOList;   
	} 
	
	public UserTO findUserByName(String username){
		
		UserTO userTO = null;
		String SQL_QUERY = "Select UserId,Username,Password,UserType,Functionalities from UserMstr where Username=?";
		
		try{
			System.out.println("USERDAOIMPL findUserByName = " + username);
			if(CommonValidator.validateString(username.trim().toLowerCase())){
				userTO = new UserTO();
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,username);
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				resultSet = preparedStatement.executeQuery();
				
				String fun = null;
				final String delims = "^";
				ArrayList<Integer> userFunctionalities = new ArrayList<Integer>();
				
				while(resultSet.next()){
					userTO.setUserId(resultSet.getInt("UserId"));
					userTO.setUsername(resultSet.getString("Username"));
					userTO.setPassword(resultSet.getString("Password"));
					userTO.setUserType(resultSet.getString("UserType"));
					fun = resultSet.getString("Functionalities");
					
					StringTokenizer st = new StringTokenizer(fun, delims);
					while (st.hasMoreElements()) {
						userFunctionalities.add(Integer.parseInt(st.nextElement().toString()));						
					}
					userTO.setFunctionalities(userFunctionalities);
				}			
				
				System.out.println("userTO username = " + userTO.getUsername());
			 	System.out.println("userTO password = " + userTO.getPassword());
			 	if(userTO.getUsername()== null || userTO.getPassword() == null){
			 		userTO = null;
			 	}
				
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
		return userTO;
	}
		
	public UserTO findUserById(Integer userId){
		
		UserTO userTO = null;
		String SQL_QUERY = "Select UserId,Username,Password,UserType from UserMstr where UserId=?";
		
		try{
			System.out.println("USERDAOIMPL findUserById = " + userId);
			if(userId != null){
				userTO = new UserTO();
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setInt(1,userId);
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				resultSet = preparedStatement.executeQuery();
			
				while(resultSet.next()){
					userTO.setUserId(resultSet.getInt("UserId"));
					userTO.setUsername(resultSet.getString("Username"));
					userTO.setPassword(resultSet.getString("Password"));
					userTO.setUserType(resultSet.getString("UserType"));
				}
				
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		
		return userTO;
	}

	public HashMap<Integer,UserTO>  getUserMap(){

		HashMap<Integer,UserTO>  map = new HashMap<Integer,UserTO>();
		String SQL_QUERY = "Select UserId, Username, UserType, Functionalities, CreateDate from UserMstr order by UserId"; 
		try{
			connection = DatabaseConnectionFactory.getConnection();       
			statement = connection.createStatement();       
			resultSet = statement.executeQuery(SQL_QUERY);    
			
			System.out.println("SQL_QUERY = " + SQL_QUERY);
			int size = 0;
			String userId = null;
			String userName = null;
			String userType = null;
			String createDate = null;
			
			String fun = null;
			final String delims = "^";
			ArrayList<Integer> userFunctionalities = null;
			UserTO userTO = null;
			
			
			while(resultSet.next()) { 
				userFunctionalities = new ArrayList();
				
				userId = resultSet.getString("UserId");
				userName = resultSet.getString("Username");
				userType = resultSet.getString("UserType");
				fun = resultSet.getString("Functionalities");
				createDate = resultSet.getString("CreateDate");
				
				System.out.println("FUN =" + fun);
				System.out.println("userFunctionalities =" + userFunctionalities);
				
				StringTokenizer st = new StringTokenizer(fun, delims);
				while (st.hasMoreElements()) {
					userFunctionalities.add(Integer.parseInt(st.nextElement().toString()));						
				}
				
				System.out.println("userFunctionalities =" + userFunctionalities);
								
				userTO= new UserTO();
				userTO.setUserId(Integer.parseInt(userId));
				userTO.setUsername(userName);
				userTO.setUserType(userType);
				userTO.setFunctionalities(userFunctionalities);
				userTO.setCreateDate(createDate);
				
				size++;
				
				
				if(CommonValidator.validateString(userName)){
					map.put(userTO.getUserId(), userTO);
				}
				System.out.println("USERID = " +userTO.getUserId()+ " UserTO Name =" + userTO.getUsername() + " FUN =" + userTO.getFunctionalities());
				//userFunctionalities.clear();
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

	
	
	
	
	@Override
	public boolean delete(UserForm userForm) {
		
		boolean deleted = false;
		String SQL_QUERY = "delete from UserMstr where UserId=?";
		
		try{		
			if(userForm != null){
				System.out.println("USERDAOIMPL delete = " + userForm.getUserId());
		
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setInt(1,Integer.parseInt(userForm.getUserId()));
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				int output = preparedStatement.executeUpdate();
				System.out.println("USER DELETED SUCCESSFULLY = " + output);
				if (output > 0){
					deleted = true;
				}				
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}	
		return deleted;
	}

	@Override
	public UserTO insert(UserForm userForm) {
		UserTO userTO = null;
		String SQL_QUERY = "insert into UserMstr (Username, UserType, Functionalities, CreateDate, Password)values(?,?,?,?,?)";
		try{
			if(CommonValidator.validateString(userForm.getUserName().trim().toLowerCase()) && CommonValidator.validateString(userForm.getUserPass().trim().toLowerCase())){
				java.util.Date date = Calendar.getInstance().getTime();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				
				connection = DatabaseConnectionFactory.getConnection();       
				preparedStatement = connection.prepareStatement(SQL_QUERY);       
				preparedStatement.setString(1,userForm.getUserName());
				preparedStatement.setString(2,userForm.getUserType());
				preparedStatement.setString(3,userForm.getUserFunctionalities());
				preparedStatement.setDate(4,sqlDate);
				preparedStatement.setString(5, userForm.getUserPass());
				
				System.out.println("preparedStatement = " + SQL_QUERY);
				int output = preparedStatement.executeUpdate();
				System.out.println("INSERTED SUCCESSFULLY");
				if (output > 0){
					userTO = new UserTO();
					userTO.setUsername(userForm.getUserName());
					userTO.setUserType(userForm.getUserType());
					userTO.setPassword(userForm.getUserPass());
					//userTO.setFunctionalities(userForm.getUserFunctionalities());					
				}
			}
		}catch(SQLException e){
			e.printStackTrace();			
		}finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return userTO;

	}

	@Override
	public UserTO update(UserForm userForm) {
		// TODO Auto-generated method stub
		return null;
	}	
}

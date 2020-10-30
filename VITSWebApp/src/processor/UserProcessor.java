package processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dao.DAOFactory;
import dao.UserDAO;
import dto.UserTO;
import enums.TableName;
import forms.UserForm;

public class UserProcessor {

	public UserTO findUserByName(String username) {

		UserTO userTO = null;
		System.out.println("UserProcessor username= " +username );
		UserDAO userDAO = (UserDAO) DAOFactory.create(TableName.User_Mstr);
				
		userTO = userDAO.findUserByName(username);
		if(userTO != null)
			System.out.println("UserProcessor username= " +userTO.getUsername() );

		return userTO;

	}
	public UserTO findUserById(Integer userId) {

		UserTO userTO = null;
		System.out.println("UserProcessor userId= " +userId );
		UserDAO userDAO = (UserDAO) DAOFactory.create(TableName.User_Mstr);
				
		userTO = userDAO.findUserById(userId);
		if(userTO != null)
			System.out.println("UserProcessor findUserById username= " +userTO.getUsername());

		return userTO;

	}

	public List findAll() {

		ArrayList<UserTO>  userTOs = null;

		UserDAO userDAO = (UserDAO) DAOFactory.create(TableName.User_Mstr);
		userTOs = (ArrayList<UserTO>)userDAO.findAll();

		if(!userTOs.isEmpty()){
			 for(int i=0;i<userTOs.size();i++){
		        	System.out.println("Username" + userTOs.get(i).getUsername());
		        	System.out.println("Password" + userTOs.get(i).getPassword());
		      }
		}	
		return userTOs;

	}
	
	public HashMap<Integer, UserTO> fetchUserList() {
		UserDAO userDAO = (UserDAO) DAOFactory.create(TableName.User_Mstr);
		HashMap<Integer, UserTO> userMap = userDAO.getUserMap();
		
		if(userMap.isEmpty()){
			System.out.println("No Users Registered");
		}else{				
			/*for (Map.Entry<String, UserTO> entry : userMap.entrySet()) {
		        String key = entry.getKey();
		        UserTO value = (UserTO)entry.getValue();
		        System.out.println("User Key`=> " + key);
		        System.out.println("User Value =>" + value.getUsername());
		        System.out.println("User Value =>" + value.getUserType());
		        System.out.println("User Value =>" + value.getCreateDate());
		        System.out.println("User Value =>" + value.getFunctionalities().toString());
			}*/   
		        
		        /*int userMapSize = userMap.size();
				for(int i=1; i<=userMapSize ; i++){
					UserTO userTO=  (UserTO)userMap.get(i);
					 System.out.println("User Value =>" + userTO.getUsername());
				        System.out.println("User Value =>" + userTO.getUserType());
				        System.out.println("User Value =>" + userTO.getCreateDate());
				        System.out.println("User Value =>" + userTO.getFunctionalities().toString());
		    }	*/		
			
			int userMapSize = 0;
			if(!userMap.isEmpty()){
				userMapSize = userMap.size();
			Iterator entries = userMap.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry entry = (Map.Entry) entries.next();
			    Integer key = (Integer)entry.getKey();
			    UserTO userTO = (UserTO)entry.getValue();
			    System.out.println("User Key = " + key + ", UserValue = " + userTO.getUsername());
			}
			}
		}
		return userMap;
	}
	
	public UserTO insertUser(UserForm userForm){
		UserTO userTO = null;
		UserDAO userDAO = (UserDAO) DAOFactory.create(TableName.User_Mstr);
		userTO = userDAO.insert(userForm);
		
		if(userTO != null){
			System.out.println("UserProcessor --> User inserted succesfully ");
		}else{
			System.out.println("UserProcessor --> User not inserted");
		}
		return userTO;
	}
	
	public boolean deleteUser(UserForm userForm){
		boolean deletedUser = false;
		UserDAO userDAO = (UserDAO) DAOFactory.create(TableName.User_Mstr);
		deletedUser = userDAO.delete(userForm);
		
		if(deletedUser){
			System.out.println("UserProcessor --> User deleted succesfully ");
		}else{
			System.out.println("UserProcessor --> User not deleted");
		}
		return deletedUser;
	}
	

}
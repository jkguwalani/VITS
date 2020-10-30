package dto;

import java.util.ArrayList;

public class UserTO {

	private Integer userId = null;
	private String username = null;
	private String password = null;
	private String userType = null;
	private ArrayList<Integer> functionalities = null;
	private String createDate = null;
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String u) {
		this.username = u;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String p) {
		this.password = p;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public ArrayList<Integer> getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(ArrayList<Integer> functionalities) {
		this.functionalities = functionalities;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}	
}

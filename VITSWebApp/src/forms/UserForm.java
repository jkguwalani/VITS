package forms;

import java.util.ArrayList;

public class UserForm {

	private String userId = null;
	private String userName = null;
	private String userPass = null;
	private String userType = null;
	private String userFunctionalities = null;
	private String errortext = null;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserFunctionalities() {
		return userFunctionalities;
	}
	public void setUserFunctionalities(String userFunctionalities) {
		this.userFunctionalities = userFunctionalities;
	}
	public String getErrortext() {
		return errortext;
	}
	public void setErrortext(String errortext) {
		this.errortext = errortext;
	}
	
	
}
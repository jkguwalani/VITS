package forms;

import java.util.ArrayList;

public class LogonForm {

	private String uid = null;
	private String uname = null;
	private String upass = null;
	private String uType = null;
	private ArrayList<Integer> ufunctionality = null;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUType() {
		return uType;
	}
	public void setUType(String type) {
		uType = type;
	}
	public ArrayList<Integer> getUfunctionality() {
		return ufunctionality;
	}
	public void setUfunctionality(ArrayList<Integer> ufunctionality) {
		this.ufunctionality = ufunctionality;
	}

	
	
}

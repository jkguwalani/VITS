package validator;

import processor.AgentProcessor;
import processor.CompanyProcessor;
import processor.PolicyProcessor;
import processor.SchemeProcessor;
import processor.UserProcessor;
import forms.AgentForm;
import forms.CompanyForm;
import forms.LogonForm;
import forms.PolicyForm;
import forms.SchemeForm;
import forms.UserForm;
import dto.AgentTO;
import dto.CompanyTO;
import dto.PolicyTO;
import dto.SchemeTO;
import dto.UserTO;

public class ValidateForm {

	public boolean validateUser(LogonForm logonForm) {
		if (logonForm != null) {
			if (!CommonValidator.validateString(logonForm.getUid())){
				return false;
			} else if (!CommonValidator.validateString(logonForm.getUpass())){
				return false;
			} else {
				String username = logonForm.getUid();
				String password = logonForm.getUpass();

				System.out.println("ValidateForm.logonForm.username" + username);
		        System.out.println("Validate.logonForm.password" + password);
		        
		        UserProcessor up = new UserProcessor();
		        UserTO userTOobj = up.findUserByName(username);	        
	        
				if (userTOobj != null) {
					if (CommonValidator.equals(password, userTOobj.getPassword())) {
						logonForm.setUid(userTOobj.getUserId().toString());
						logonForm.setUname(userTOobj.getUsername());
						logonForm.setUpass(userTOobj.getPassword());
						logonForm.setUType(userTOobj.getUserType());
						logonForm.setUfunctionality(userTOobj.getFunctionalities());
						System.out.println("CommonValidator.equals = true");
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	
	public boolean validateAndDeleteUser(UserForm userForm){
		if (userForm != null) {
			if (!CommonValidator.validateString(userForm.getUserId())){
				return false;
			} else {
				String userId = userForm.getUserId();
				
				System.out.println("ValidateForm.deleteUserForm.userId" + userId);
		        
		        UserProcessor up = new UserProcessor();
		        UserTO userTOobj = up.findUserById(new Integer(userId));	        
	        
				if (userTOobj != null) {
					boolean deleteUser = up.deleteUser(userForm);
					if (deleteUser) {				
						userForm.setErrortext("User deleted successfully.");
						return true;
					}else{
						userForm.setErrortext("Issue occured while deleting user.");
						return false;
					}						
				} else {
					userForm.setErrortext("User not deleted...Please check and try again later.");
					return false;
				}
			}
		} else {
			return false;
		}
		
	}

	public boolean validateAndInsertUser(UserForm userForm) {
		if (userForm != null) {
			if (!CommonValidator.validateString(userForm.getUserName())){
				userForm.setErrortext("Enter Valid User Name");
				return false;
			} else if (!CommonValidator.validateString(userForm.getUserPass())){
				userForm.setErrortext("Enter Valid Password");
				return false;
			} else if (!CommonValidator.validateString(userForm.getUserType())){
				userForm.setErrortext("Enter Valid User Type");
				return false;
			} else if (!CommonValidator.validateString(userForm.getUserFunctionalities())){
				userForm.setErrortext("Enter Valid User Functionalities");
				return false;
			}else {
				String username = userForm.getUserName();
				String password = userForm.getUserPass();
				String userType = userForm.getUserType();
				String functionalities = userForm.getUserFunctionalities();

				System.out.println("ValidateForm.userForm.username" + username);
		        System.out.println("Validate.userForm.password" + password);
		        System.out.println("Validate.userForm.userType" + userType);
		        System.out.println("Validate.userForm.functionalities" + functionalities);
		        
		        UserProcessor up = new UserProcessor();
		        UserTO userTOobj = up.findUserByName(username);	        
		        
		        if (userTOobj != null) {
					if (CommonValidator.equals(username, userTOobj.getUsername())) {
						userForm.setErrortext("This user name already exists...Kindly enter differnt User Name.");
						return false;
					} else {
						userForm.setErrortext("Enter valid User Name");
						return false;
					}
				} else {
					System.out.println("INSERT User " + username);
					userTOobj = up.insertUser(userForm);
					userForm.setUserName(userTOobj.getUsername());
//					userForm.setUserId(userTOobj.getUserId().toString());
					userForm.setUserPass(userTOobj.getPassword());
					userForm.setUserType(userTOobj.getUserType());
//					userForm.setUserFunctionalities(userTOobj.getFunctionalities());
					userForm.setErrortext("User Details Processed Successfully");
					return true;
				}
			}
		} else {
			return false;
		}
	}

	
	public boolean validateAndInsertCompany(CompanyForm companyForm){
		if (companyForm != null) {
			if (!CommonValidator.validateString(companyForm.getCompanyName())){
				companyForm.setErrortext("Enter Valid Details for Processing");
				return false;
			} else if (!CommonValidator.validateString(companyForm.getCompanyAdd())){
				companyForm.setErrortext("Enter Valid Details for Processing");
				return false;
			} else {
				
				String companyName = companyForm.getCompanyName();
		        String companyAdd = companyForm.getCompanyAdd();
		    
		        CompanyProcessor cp = new CompanyProcessor();
		        CompanyTO cmpTOobj = cp.findCompanyByName(companyName);	        
	        
				if (cmpTOobj != null) {
					if (CommonValidator.equals(companyName, cmpTOobj.getCompName())) {
						companyForm.setErrortext("This company name already exists...Kindly enter differnt CompanyName.");
						return false;
					} else {
						companyForm.setErrortext("Enter valid Company Name");
						return false;
					}
				} else {
					System.out.println("INSERT COMPANY " + companyName);
					cmpTOobj = cp.insertCompany(companyForm);
					companyForm.setCompanyName(cmpTOobj.getCompName());
					companyForm.setCompanyAdd(cmpTOobj.getCompAddress());
					companyForm.setErrortext("Company Details Processed Successfully");
					return true;
				}
			}
		} else {
			companyForm.setErrortext("Enter Valid Details for Processing");
			return false;
		}
	}
	
	public boolean validateAndInsertScheme(SchemeForm schemeForm){
		if (schemeForm != null) {
			if (!CommonValidator.validateString(schemeForm.getSchemeName())){
				schemeForm.setErrortext("Enter Valid Scheme Name");
				return false;
			}else if (!CommonValidator.validateString(schemeForm.getSchemeCompId())){
				schemeForm.setErrortext("Enter Valid Company Id");
				return false;
			}else if (!CommonValidator.validateString(schemeForm.getSchemeCompName())){
				schemeForm.setErrortext("Enter Valid Company Name");
				return false;
			} else {
				
				String schemeName = schemeForm.getSchemeName();
				String schemeCode = schemeForm.getSchemeCompId();
		        String schemeCompName = schemeForm.getSchemeCompName();
		    
		        SchemeProcessor sp = new SchemeProcessor();
		        SchemeTO schemeToObj = sp.findSchemeByName(schemeForm);	        
	        
				if (schemeToObj != null) {
					if (CommonValidator.equals(schemeForm.getSchemeName(), schemeToObj.getSchemeName())) {
						schemeForm.setErrortext("This scheme name already exists...Kindly enter differnt SchemeName.");
						return false;
					} else {
						schemeForm.setErrortext("Enter valid Scheme Name");
						return false;
					}
				} else {
					System.out.println("INSERT Scheme " + schemeForm.getSchemeName());
					schemeToObj = sp.insertScheme(schemeForm);
					schemeForm.setSchemeName(schemeToObj.getSchemeName());
					schemeForm.setSchemeCompName(schemeToObj.getSchemeCompName());
					schemeForm.setErrortext("Scheme Details Processed Successfully");
					return true;
				}
			}
		} else {
			schemeForm.setErrortext("Enter Valid Details for Processing");
			return false;
		}
	}

	public boolean validateAndInsertAgent(AgentForm agentForm){
		if (agentForm != null) {
			if (!CommonValidator.validateString(agentForm.getAgentName())){
				agentForm.setErrortext("Enter Valid Agent Name");
				return false;
			} else if (!CommonValidator.validateString(agentForm.getCompanyId())){
				agentForm.setErrortext("Enter Valid Company Code");
				return false;
			}else if (!CommonValidator.validateString(agentForm.getCompanyName())){
				agentForm.setErrortext("Enter Valid Company Name");
				return false;
			}else if (!CommonValidator.validateString(agentForm.getSchemeId())){
				agentForm.setErrortext("Enter Valid Scheme Code");
				return false;
			}else if (!CommonValidator.validateString(agentForm.getSchemeName())){
				agentForm.setErrortext("Enter Valid Scheme Name");
				return false;
			}else if (!CommonValidator.validateString(agentForm.getBranchCode())){
				agentForm.setErrortext("Enter Valid Branch Code");
				return false;
			} else if (!CommonValidator.validateString(agentForm.getBranchName())){
				agentForm.setErrortext("Enter Valid Branch Name");
				return false;
			} else if (!CommonValidator.validateString(agentForm.getSmCode())){
				agentForm.setErrortext("Enter Valid S M Code");
				return false;
			} else if (!CommonValidator.validateString(agentForm.getSmName())){
				agentForm.setErrortext("Enter Valid S M Name");
				return false;
			} else if (!CommonValidator.validateString(agentForm.getVendorCode())){
				agentForm.setErrortext("Enter Valid Vendior Code");
				return false;
			} else if (!CommonValidator.validateString(agentForm.getVendorName())){
				agentForm.setErrortext("Enter Valid Vendor Name");
				return false;
			}
			else {
				SchemeProcessor sp = new SchemeProcessor();
				SchemeForm schemeform = new SchemeForm();
				schemeform.setSchemeName(agentForm.getSchemeName());
				SchemeTO schemeTO = sp.findSchemeByName(schemeform);
				if(!agentForm.getCompanyId().equals(schemeTO.getSchemeCompId().toString())){
					agentForm.setErrortext("Scheme does not exist for given company.");
					return false;
				}else{				
					AgentProcessor ap = new AgentProcessor();
			        AgentTO agentToObj = ap.findAgentByName(agentForm);	        
		        
					if (agentToObj != null) {
						if (CommonValidator.equals(agentForm.getAgentName(), agentToObj.getAgentName())) {
							agentForm.setErrortext("This agent is already registered for given scheme and company...Kindly enter differnt AgentName.");
							return false;
						} else {
							agentForm.setErrortext("Enter valid Agent Name");
							return false;
						}
					} else {
						System.out.println("INSERT Agent " + agentForm.getAgentName());
						agentToObj = ap.insertAgent(agentForm);
						agentForm.setAgentName(agentToObj.getAgentName());
						
						agentForm.setErrortext("Agent Details Processed Successfully");
						return true;
					}
				}
			}
		} else {
			agentForm.setErrortext("Enter Valid Details for Processing");
			return false;
		}
	}
	

	public boolean validateAndInsertPolicy(PolicyForm policyForm){
		if (policyForm != null) {
			if (!CommonValidator.validateString(policyForm.getAgentName())){
				policyForm.setErrortext("Enter Valid Agent Name");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getCompanyId())){
				policyForm.setErrortext("Enter Valid Company Code");
				return false;
			}else if (!CommonValidator.validateString(policyForm.getCompanyName())){
				policyForm.setErrortext("Enter Valid Company Name");
				return false;
			}else if (!CommonValidator.validateString(policyForm.getSchemeId())){
				policyForm.setErrortext("Enter Valid Scheme Code");
				return false;
			}else if (!CommonValidator.validateString(policyForm.getSchemeName())){
				policyForm.setErrortext("Enter Valid Scheme Name");
				return false;
			}else if (!CommonValidator.validateString(policyForm.getBranchCode())){
				policyForm.setErrortext("Enter Valid Branch Code");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getBranchName())){
				policyForm.setErrortext("Enter Valid Branch Name");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getSmCode())){
				policyForm.setErrortext("Enter Valid S M Code");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getSmName())){
				policyForm.setErrortext("Enter Valid S M Name");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getVendorCode())){
				policyForm.setErrortext("Enter Valid Vendior Code");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getVendorName())){
				policyForm.setErrortext("Enter Valid Vendor Name");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getPolicyType())){
				policyForm.setErrortext("Enter Valid Policy Type");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getPeriodOfInsurance())){
				policyForm.setErrortext("Enter Valid Period Of Insurance");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getPolicyIssuedOn())){
				policyForm.setErrortext("Enter Valid Policy Issued On");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getPolicyIssuingOffice())){
				policyForm.setErrortext("Enter Valid Policy Issuing Office");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getProposersName())){
				policyForm.setErrortext("Enter Valid Proporer's Name");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getAddress())){
				policyForm.setErrortext("Enter Valid Address ");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getPincode())){
				policyForm.setErrortext("Enter Valid Pincode");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getEmailAddress())){
				policyForm.setErrortext("Enter Valid Email Address");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getContactNumber())){
				policyForm.setErrortext("Enter Valid Contact Number");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getPancard())){
				policyForm.setErrortext("Enter Valid Pancard");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getTypeOfVehicle())){
				policyForm.setErrortext("Enter Valid Type Of Vehicle");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getModel())){
				policyForm.setErrortext("Enter Valid Model Details");
				return false;
			} else if (!CommonValidator.validateString(policyForm.getUserId())){
				policyForm.setErrortext("Enter Valid User ID");
				return false;
			} else {
					PolicyProcessor pp = new PolicyProcessor();	        
					PolicyTO policyTO = pp.insertPolicy(policyForm);
					return true;
			}
		} else {
			policyForm.setErrortext("Enter Valid Details for Processing");
			return false;
		}
	}		
}

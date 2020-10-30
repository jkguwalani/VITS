package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.compiler.FunctionTable;

import dto.AgentTO;

import forms.UserForm;

import validator.ValidateForm;

public class DeleteUserActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteUserActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String userId = request.getParameter("userid");
//		String userName = request.getParameter("username");
//		String userType = request.getParameter("usertype");
//		String userPass = request.getParameter("userpassword");
		String deleteUser = request.getParameter("deleteuser");
		
//		String[] userFunctionality = request.getParameterValues("userFunctionality");
//		StringBuilder functionalities = new StringBuilder();
		
//		System.out.println("userId = " +userId);
//		System.out.println("userName = " +userName);
//		System.out.println("userType = " +userType);
//		System.out.println("userPassword = " +userPass);
		System.out.println("deleteUser = " +deleteUser);
		/*if(userFunctionality != null)
			System.out.println("userFunctionality = " +userFunctionality.length);
		
		if(userFunctionality != null && userFunctionality.length > 0){
			for(int i=0;i<userFunctionality.length;i++){
				if(i == userFunctionality.length-1)
					functionalities.append(userFunctionality[i]);
				else{
					functionalities.append(userFunctionality[i]);
					functionalities.append("^");
				}			
			}
		}else if (userFunctionality != null){
			functionalities.append(userFunctionality[1]);
		}
		
		System.out.println("functionalities =" + functionalities);
		*/
		
		UserForm deleteUserForm = new UserForm();
		deleteUserForm.setUserId(deleteUser);
//		deleteUserForm.setUserName(userName);
//		deleteUserForm.setUserPass(userPass);
//		deleteUserForm.setUserType(userType);
//		userForm.setUserFunctionalities(functionalities.toString());
		

		
		ValidateForm valFormobj = new ValidateForm();
		Boolean validOutput = valFormobj.validateAndDeleteUser(deleteUserForm);
		System.out.println("UserServlet validOutput = " + validOutput);
		if(validOutput)
			deleteUserForm.setErrortext("User Deleted Successfully.");
		    
		    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/DeleteUser");
	    request.getSession().setAttribute("deleteUserForm",deleteUserForm);
	    dispatcher.forward(request, response);
		
	}	
}
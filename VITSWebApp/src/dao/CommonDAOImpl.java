package dao;

import java.util.List;

public class CommonDAOImpl implements CommonDAO{

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

/*
	Connection con;    ResultSet rs;    PreparedStatement stmt;    
	public Employee[] findAll() throws SQLException {       
		Employee[] employees;        
		String SQL_QUERY= “Select * from Employee”;       
		con=DatabaseConnectionFactory.getConnection();       
		stmt = con.prepareStatement(SQL_QUERY);       
		rs = stmt.executeQuery();       
		while(rs.next) {            //get columns and store in array       }
		}
		return employees;   
	} 
	
	public Employee findByPK(EmployeePK) throws SQL Exception {  
		//Implementation code   
		}    
	
	public Employee[] findbyemployeename(String EmployeeName) throws SQLException{ 
		//Implementation code   
	}    
	
	public boolean insert(Employee employee) throws SQLException{ 
		//Implementation code    
	}    
	public boolean update(Employee employee) throws SQLException{        //Implementation code    
		
	}   
	public boolean delete(Employee employee) throws SQLException{        //Implementation code    
		
	}
	}*/


}

package dao;

import java.util.List;

public interface CommonDAO {
	public List findAll();
	public boolean insert(Object obj);
	public boolean update(Object obj);
	public boolean delete(Object obj);
	
/*	public Employee[] findAll() throws SQLException;   
	public Employee findByPK(EmployeePK) throws SQL Exception;    
	public Employee[] findbyemployeename(String EmployeeName) throws SQLException;   
	public boolean insert(Employee employee) throws SQLException;   
	public boolean update(Employee employee) throws SQLException;   
	public boolean delete(Employee employee) throws SQLException;
*/
}

package database;

import java.sql.*;
import java.sql.Connection;



public class DatabaseConnectionFactory {

	 //static reference to itself
    private static DatabaseConnectionFactory dbinstance;
    public static final String URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=E:\\VITS\\VITSDB.accdb";
    public static final String DRIVER_CLASS = "sun.jdbc.odbc.JdbcOdbcDriver"; 
     
    //private constructor
    private DatabaseConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    public static Connection getConnection() {
    	if(dbinstance == null)
    	{
    		dbinstance = new DatabaseConnectionFactory();
    	}
    	
        return dbinstance.createConnection();
    }

	
	
/*	public static Connection getConnecion() {
		Connection conn = null;
		try {
			// Load MS accces driver class
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// Location of Database
			String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
					+ "D:\\VITS\\VITSDB.accdb";

			// specify url
			conn = DriverManager.getConnection(url);

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());

		}
		return conn;
	}
*/
}

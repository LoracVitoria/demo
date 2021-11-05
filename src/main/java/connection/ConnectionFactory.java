package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.DatabaseException;

public class ConnectionFactory {
	
	private static Connection connection = null;

	public static Connection getConnection(){
		
		if(connection == null) {
		
			try {
			
				connection = DriverManager.getConnection("jdbc:mysql://localhost/ifc_store", "root", "bancodedados");
			
				return connection;
				
			} catch (SQLException e) {
				throw new DatabaseException(e.getMessage());
			} 
		
		} else {
			return connection;
		}
		
	}
	
	public static void closeConnection() {
		try {
			
			connection.close();
		
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}

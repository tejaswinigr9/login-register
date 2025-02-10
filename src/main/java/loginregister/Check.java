package loginregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Check {

	public static void main(String[] args) {
		
		final String url = "jdbc:mysql://localhost:3306/gnv";
		final String user = "root";
		final String password = "root123";
		try {
		   Connection conn = DriverManager.getConnection(url, user, password);

		   if(conn != null) {
		   System.out.println("Connection successful");
		} 
		}catch (SQLException e) {
		    e.printStackTrace();
		}
		    }

	}


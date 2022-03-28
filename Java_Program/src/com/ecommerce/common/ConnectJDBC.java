package com.ecommerce.common;

import java.sql.*;

public class ConnectJDBC{
	public static Connection connection = null;
		public static Connection getConnection() throws SQLException {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","mh50k3320");
			} catch (Exception e) 
			{			
				e.printStackTrace();
			}
			/*finally {
				connection.close();
			}*/
			return connection;
	}
}

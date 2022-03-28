package com.ecommerce.abhinath;

import java.sql.*;

import com.ecommerce.validation.ConnectJDBC;

//Author: Abhinath Jadhav
//Date:   26/03/2022
public class UserNameCity {

	
	public static String City = null;	
	public static String customerName = null;	
	public static int userId = 0;	
	
	public void getUserNameCity(String username) {
		
		PreparedStatement preparedStatement = null;
		
		try {
			// Establish connection
			Connection connection = ConnectJDBC.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE UserName=?");
			//Execute statement
			preparedStatement.setString(1, username);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				UserNameCity.userId = rs.getInt(1);
				UserNameCity.customerName = rs.getString(2);
				UserNameCity.City = rs.getString(3);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

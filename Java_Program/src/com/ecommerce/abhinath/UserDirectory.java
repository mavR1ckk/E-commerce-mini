package com.ecommerce.abhinath;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ecommerce.validation.ConnectJDBC;

//Author: Abhinath Jadhav
//Date:   26/03/2022
public class UserDirectory {
	
	public static List<Integer> userId = new LinkedList<>();

	public void getUserDirectory() throws SQLException {
		// Required resources.
		
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		
		try {
			// To establish connection
			ps = ConnectJDBC.connection.prepareStatement("SELECT * FROM customers");
			resultSet = ps.executeQuery();
			
			// while loop to print dats
			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("                          ***User Directory***                            ");
			System.out.println("--------------------------------------------------------------------------");
			
			while(resultSet.next()) {
				
				
				userId.add(resultSet.getInt(1)); // To store all the users in list
				System.out.println("\t *User Id:            " + resultSet.getInt(1));
				System.out.println("\t  User Name:          " + resultSet.getString(2));
				System.out.println("\t  User City:          " + resultSet.getString(3));
				System.out.println("\t  Contact number:     " + resultSet.getString(4));
				System.out.println("                      ------------------------                            ");
				System.out.println();
			}	
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("User directory retrived successfully.");
			System.out.println("--------------------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {			
			ps.close();
			resultSet.close();
		}		
	}
}

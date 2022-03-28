package com.ecommerce.abhinath;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.validation.ConnectJDBC;
import com.ecommerce.validation.ValidateInput;

// Author: Abhinath Jadhav
// Date:   24/03/2022

public class RemoveUsers {

	// Method to remove user from database.
	public void removeUser() throws SQLException {	
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		UserDirectory user = new UserDirectory();
		
		try {
			// To establish connection			
			preparedStatement = ConnectJDBC.connection.prepareStatement("DELETE FROM customers WHERE userid=?");
			preparedStatement1 = ConnectJDBC.connection.prepareStatement("DELETE FROM usercredintial WHERE userid=?");
						
			// To take input from admin
			
			user.getUserDirectory();
			System.out.print("Enter User ID which you want to remove ->  ");
			
			//To validate user input
			ValidateInput checkInput =  new ValidateInput();
			int UserName = checkInput.getInput(UserDirectory.userId);
			
			// Prepare statement
			preparedStatement.setInt(1, UserName);
			preparedStatement1.setInt(1, UserName);
			
			// Execute statement
			preparedStatement.execute();	
			preparedStatement1.execute();			
			
			System.out.println("User " + UserName + " removed succssfully.");
			System.out.println("--------------------------------------------------------------------------");
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		finally {
			preparedStatement.close();
			preparedStatement1.close();
		}
	}
}

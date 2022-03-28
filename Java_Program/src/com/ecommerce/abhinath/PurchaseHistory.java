package com.ecommerce.abhinath;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ecommerce.common.ConnectJDBC;

// Author: Abhinath Jadhav
// Date  : 24/03/2022

public class PurchaseHistory {

	public void getPurchaseHistory() throws SQLException {
		
		// Establish connection.
		
		PreparedStatement preparedStatement = null;
		
		UserDirectory directory = new UserDirectory();
		
		try {
			// To connect
			//Prepare statement
			preparedStatement = ConnectJDBC.connection.prepareStatement("SELECT * FROM purchasehistory WHERE UserID = ?");
			
			// Take input from admin for user whose history admin wants to see.
			
			
			directory.getUserDirectory();
						
			System.out.print("Enter user ID whose purchase history you want to see ->  ");
			
			CheckInput checkInput = new CheckInput();
			int UserID = checkInput.getInput(20);
			System.out.println("--------------------------------------------------------------------------");
			
			// Pass input to statement and execute
			preparedStatement.setInt(1, UserID);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// User ID and name	
			System.out.println();
			System.out.println("               		 ***User ID: " + UserID + "***");	
			System.out.println("           	     ------------------------                            ");
			System.out.println(); // Print empty line
			
			float bill = 0;
			// Print data for user
			while(resultSet.next()) {	
				
				// Print purchase history				
				System.out.println("\t Order ID:                    " + resultSet.getInt(1));
				System.out.println("\t User Name:                   " + resultSet.getString(3));
				System.out.println("\t Product Name:                " + resultSet.getString(4));
				System.out.println("\t Product Qty:                 " + resultSet.getString(5));
				System.out.println("\t Bill:                        " + resultSet.getFloat(6));
				
				bill=bill+resultSet.getFloat(6);
				System.out.println(); //Print empty line
			}
			// To print the total purchase
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("\t Total purchase made by customer : "+bill);
			System.out.println("--------------------------------------------------------------------------");	
			System.out.println();
			System.out.println("                   ***Data retrived successfully***                 ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//Close the connection
			preparedStatement.close();
		}
	}
}

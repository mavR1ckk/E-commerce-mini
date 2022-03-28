package com.ecommerce.shivam;

import java.sql.*;
import java.util.*;

import com.ecommerce.common.ConnectJDBC;
import com.ecommerce.pooja.CustomerMenu;

//Author : Abhinath & shivam
public class LogIn {
	public static String username = null;
	public static String password = null;

	public void getLogIn() throws SQLException {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Map<String, String> map = new LinkedHashMap<>();
		Scanner scanner = new Scanner(System.in);
		
		try {
						//Prepare statement
			preparedStatement = ConnectJDBC.connection.prepareStatement("select * from usercredintial");
			//Execute statement
			resultSet = preparedStatement.executeQuery();
			//Get data
			while(resultSet.next()) {				
				map.put(resultSet.getString(2), resultSet.getString(3));
			}
			
			System.out.println("Enter username and password which you have entered during registration.");
			System.out.println();
			System.out.print("Enter the username : ");
			username = scanner.next();
			System.out.print("Enter the password : ");
			password = scanner.next();
			System.out.println("--------------------------------------------------------------------------");
			
			Set<String> set = map.keySet();
			if(set.contains(username)) {
				if(password.equals(map.get(username))) {
					System.out.println("Log in successfull.");
					System.out.println("--------------------------------------------------------------------------");
					System.out.println();
					CustomerMenu.dislayCustomerMenu();
				}
				else {
					System.out.println("Invalid password enetered. Please try again.");
					System.out.println("--------------------------------------------------------------------------");
					getLogIn();
				}
			}
			else {
				System.out.println("Invalid User ID. Please try again.");
				System.out.println("--------------------------------------------------------------------------");
				getLogIn();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			preparedStatement.close();
		}
	}
}

package com.ecommerce.validation;

import java.sql.*;
import java.util.*;

public class ValidateUserName {
	
	public String getUserName() {
		
		// To take input from user and store in variable
		Scanner scanner = new Scanner(System.in);
		System.out.print("Choose your username : ");
		String name = scanner.next();
		return name;		
	}

	public boolean varifyUserName(String name) {
		
		boolean check = true;
		
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		
		LinkedList<String> userList = new LinkedList<>();
		
		try {
			preparedStatement = ConnectJDBC.connection.prepareStatement("select * from usercredintial");
			//Execute statement
			resultSet = preparedStatement.executeQuery();
			//Get data
			while(resultSet.next()) {				
				userList.add(resultSet.getString(2));
			}
			if(userList.contains(name)) {
				check = false;
			}
//			for (String s: userList) {
//				System.out.println(s);
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
}

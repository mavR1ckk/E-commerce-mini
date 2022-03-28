package com.ecommerce.abhinath;

import java.sql.*;
import java.util.*;

import com.ecommerce.common.ConnectJDBC;

//Author: Abhinath Jadhav
//Date:   26/03/2022
public class CheckUserName {
	
	public String getUserName() {
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
	public static void main(String[] args) {
		CheckUserName checkUserName = new CheckUserName();
		
		System.out.println(checkUserName.varifyUserName("mavrickk"));
	}
}

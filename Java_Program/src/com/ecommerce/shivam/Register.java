package com.ecommerce.shivam;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ecommerce.abhinath.CheckUserName;
import com.ecommerce.common.ConnectJDBC;

//Author : Shivam and Abhinath
public class Register {
	
	public void getCustomerUserPass(String username, String password) throws SQLException {
		PreparedStatement preparedstatement=null;
		try {
			preparedstatement=ConnectJDBC.connection.prepareStatement("insert into usercredintial(username,password) values(?,?)");
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			preparedstatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			preparedstatement.close();
		}	
	}
	
	public void getCustomerData(String name, String city, String contactnumber, String username) throws SQLException {
		PreparedStatement preparedstatement1=null;
		try {
			//Prepare statement for user info
			preparedstatement1=ConnectJDBC.connection.prepareStatement("insert into customers(CustomerName,city,contactnumber,UserName)values(?,?,?,?)");
			// Take user information
			preparedstatement1.setString(1, name);
			preparedstatement1.setString(2, city);
			preparedstatement1.setString(3, contactnumber);
			preparedstatement1.setString(4, username);
			
			preparedstatement1.executeUpdate();		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			preparedstatement1.close();
		}		
	}
	public void registerUser() {
		
		System.out.println("Enter your Details for registartion...");
		System.out.println();
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter your name : ");
		String name=scanner.next();
		System.out.print("Enter your city : ");
		String city=scanner.next();
		System.out.print("Enter your contactnumber : ");
		String contactnumber=scanner.next();
		System.out.println("--------------------------------------------------------------------------");
		// Rake userId and Password
		
		System.out.println("Enter unique username and password.");
		System.out.println();
		
		CheckUserName checkUserName = new CheckUserName();
		String username = checkUserName.getUserName();
		
		while (checkUserName.varifyUserName(username)==false) {
			System.out.println("UserName not available. Try another Username.");
			username = checkUserName.getUserName();
			System.out.println();
		}
		
		System.out.print("Choose your password : ");
		String password=scanner.next();
		
		Register register= new Register();
		LogIn logIn = new LogIn();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		
		if (checkUserName.varifyUserName(username)) {
			try {
				register.getCustomerData(name,city,contactnumber,username);
				register.getCustomerUserPass(username,password);
				logIn.getLogIn();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
}

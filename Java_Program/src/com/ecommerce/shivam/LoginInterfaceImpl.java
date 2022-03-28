package com.ecommerce.shivam;

import java.sql.Connection;
import java.sql.SQLException;

import com.ecommerce.validation.ConnectJDBC;
import com.ecommerce.validation.ValidateInput;

//Author : Shivam
public class LoginInterfaceImpl implements LoginInterface {

	LogInOptions loginOptions = new LogInOptions();
	ValidateInput check = new ValidateInput();
	
	@Override
	public void getUserInput() {
		try {
			Connection connection = ConnectJDBC.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		loginOptions.getList();
		System.out.println("--------------------------------------------------------------------------");
		System.out.print("Enter hotKey to perform operation of your choice ->  ");
		int input=check.getInput(3);
		System.out.println("--------------------------------------------------------------------------");
		
		Register register = new Register();
		LogIn logIn = new LogIn();
		AdminLogin adminLogin = new AdminLogin();
		
		try {
			switch (input) {
	    	case 1:
	    		//register
	    		register.registerUser();
	    		break;
	    	case 2:
	    		//login
	    		logIn.getLogIn();	    		
	    		break;
	    	case 3:
	    		//admin login
	    		adminLogin.getAdminLogin();
	    		break;
	    	}			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}

package com.ecommerce.shivam;

//import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import com.ecommerce.abhinath.*;

// Author : Shivam
public class AdminLogin {
 
	public void getAdminLogin() throws IOException {
		
		//FileInputStream fileinputstream=null;
		Scanner scanner=null;
		AdminIdPass adminIdPass = new AdminIdPass();
		
		scanner=new Scanner(System.in);
		System.out.print("Enter username : ");
		String username=scanner.next();
		System.out.print("Enter password : ");
		String password=scanner.next();
		
		try {
			
			/*fileinputstream=new FileInputStream("https://drive.google.com/file/d/1Vukp3p0v0PMPXyxWS8OYGdJgqh0BHMiD/view?usp=sharing");
			 *properties=new Properties();
			 *properties.load(fileinputstream);
			 *String username1=properties.getProperty("username");
			 *String password1=properties.getProperty("password");
			*/
			
			String username1=adminIdPass.getUsername();
			String password1=adminIdPass.getPassword();
			
			System.out.println("--------------------------------------------------------------------------");
			
			if(username.equals(username1) ) {
				if(password.equals(password1)) {
					System.out.println("                       ***Login successful***           ");
					AdminRights adminrights = new AdminrightsImpl();
					adminrights.getAdminOptions();
				}
				else {
					System.out.println("Please enter valid password");
					System.out.println();
					getAdminLogin();					
				}							
			}
			else {
				System.out.println("Please enter valid username.");
				System.out.println();
				getAdminLogin();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//fileinputstream.close();
		    scanner.close();
		}
	}
	

}

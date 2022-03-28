package com.ecommerce.nishigandha;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ecommerce.abhinath.CheckInput;
import com.ecommerce.common.ConnectJDBC;


//Author : Nishigandha
public class ProductDetails {
	
	public void setProducts(String ProductName,String Descriptions,float Price,int QTY) throws SQLException {
		//Establish Connection	
	
		PreparedStatement preparedstatement = null;
		try {			
			
			//Add details into table
			// create the sql statement
			preparedstatement=ConnectJDBC.connection.prepareStatement("INSERT INTO productdetails( ProductName,Descriptions,Price,QTY) VALUES (?,?,?,?)");
			preparedstatement.setString(1,ProductName);//1 first parameter in query.
			preparedstatement.setString(2,Descriptions);
			preparedstatement.setFloat(3,Price);
			preparedstatement.setInt(4,QTY);
			// submit the sql statement to database..
			preparedstatement.executeUpdate();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("\t *** Record is inserted successfully ***");
			System.out.println("--------------------------------------------------------------------------");
		
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			// close the resources.
			preparedstatement.close();
		}
	} 
         // Add products into productDetails by admin
	public void addProducts() throws SQLException{
		Scanner sc = new Scanner(System.in);
		CheckInput checkInput = new CheckInput();
		System.out.print("1: \t \t \t Enter Product Name ->  ");
		String ProductName = sc.next();
		System.out.print("2: \t \t \t Enter Descriptions ->  ");
		String Descriptions= sc.next();
		System.out.print("3: \t \t \t Enter Price ->         ");
		float Price= checkInput.getInput(1000000);
		System.out.print("4: \t \t \t Enter Qty ->           ");		
		
	    int QTY = checkInput.getInput(100);
	    System.out.println("--------------------------------------------------------------------------");
	    //calling method setProducts to insertData into table.& pass user entry to Add the data into productdetails method
	    setProducts(ProductName,Descriptions,Price,QTY);
		
	}
}
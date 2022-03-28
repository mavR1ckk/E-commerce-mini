package com.ecommerce.nishigandha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.pooja.ProductList;
import com.ecommerce.validation.ConnectJDBC;
import com.ecommerce.validation.ValidateInput;

public class StockDetails {
	
	public void getStockDetails() throws SQLException {
		
		 //Establish Connection;		
		 PreparedStatement preparedstatement = null;
		
		 ProductList pr = new ProductList();
		
		 try {
			
			// create the SQL statement
			preparedstatement = ConnectJDBC.connection.prepareStatement("select * from  productdetails where ProductID=?");
			
			pr.productListtoCustomer();
			System.out.println("--------------------------------------------------------------------------");
		 	System.out.print(" Enter ProductID wich you want check : ");
		 	
		 	// To validate input
		 	ValidateInput validateInput = new ValidateInput();
			int id = validateInput.getInput(ProductList.pid);
			System.out.println("--------------------------------------------------------------------------");
			
			//Execute statement
			preparedstatement.setInt(1,id);
		
			ResultSet rs=preparedstatement.executeQuery();
			System.out.println();
			
			// To get product name and Quantity
		    while(rs.next()) {
		        	
				System.out.println(" Product Name         : "+rs.getString(2));
				System.out.println(" Quantity             : "+rs.getString(5));
		    }
		        
		    System.out.println("--------------------------------------------------------------------------");
			System.out.println(" \t \t ***Display Stock Successfully***");
			System.out.println("--------------------------------------------------------------------------");
				
		}catch(Exception e) {
			System.out.println(e);
			
		}finally{
			// close the resources.
			preparedstatement.close();
		}
	}
}
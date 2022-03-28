package com.ecommerce.nishigandha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.abhinath.CheckInput;
import com.ecommerce.common.ConnectJDBC;
import com.ecommerce.pooja.ProductList;

//Author : Nishigandha
public class StockDetails {
	
	public void getStockDetails() throws SQLException {
		 //Establish Connection;		
		 PreparedStatement preparedstatement = null;
		
		 ProductList pr = new ProductList();
		
		 try {
			
			// create the sql statement
			//retrive product name and Quantity
			preparedstatement = ConnectJDBC.connection.prepareStatement("select * from  productdetails where ProductID=?");
			
			pr.productListtoCustomer();
			System.out.println("--------------------------------------------------------------------------");
		 	System.out.print(" Enter ProductID wich you want check : ");
		 	
		 	CheckInput checkInput = new CheckInput();
			int id = checkInput.getInput(10);
			preparedstatement.setInt(1,id);
		
			ResultSet rs=preparedstatement.executeQuery();
			//retrive product name and Quantity
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
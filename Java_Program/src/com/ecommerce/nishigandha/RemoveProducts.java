package com.ecommerce.nishigandha;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecommerce.pooja.ProductList;
import com.ecommerce.validation.ConnectJDBC;
import com.ecommerce.validation.ValidateInput;

//Author : Nishigandha
public class RemoveProducts {
		public void getRemoveProducts() throws SQLException {
			
			//Establish Connection		
			PreparedStatement preparedstatement = null;					
			ProductList pr = new ProductList();
		  
		try {
			
			//delete the selected records from table.
			// create the sql statement
			preparedstatement = ConnectJDBC.connection.prepareStatement("delete from productdetails where ProductID=?");			
			
			pr.productListtoCustomer();
			System.out.println("--------------------------------------------------------------------------");			
		 	System.out.print("1: Enter ProductID ->");
		 	
		 	ValidateInput checkInput = new ValidateInput();
		 	
		 	// To validate product ID
			int id = checkInput.getInput(ProductList.pid);
			
			preparedstatement.setInt(1,id);
			// submit the sql statement to database..
			preparedstatement.executeUpdate();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println(" ***Record Deleted ***");	
			System.out.println("--------------------------------------------------------------------------");
			
		}catch(Exception e) {
			System.out.println(e);
			
		}finally{
			// close the resources.
			preparedstatement.close();
			
		} 
	
	}
}
package com.ecommerce.nishigandha;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.pooja.ProductList;
import com.ecommerce.validation.ConnectJDBC;
import com.ecommerce.validation.ValidateInput;

//Author : Nishigandha
public class UpdateQuantity {
	
	public void getUpdateQuantity() throws SQLException {
		//Establish Connection			
		 		
		 PreparedStatement preparedstatement = null;
		 PreparedStatement preparedstatement1 = null;
		 ProductList pr = new ProductList();
				  
		try {
			
			// update the quantity of product Id.add new quantity with existing quantity.
			// create the sql statement
			preparedstatement = ConnectJDBC.connection.prepareStatement("Update productdetails set QTY = QTY+? where ProductID=?");
			
			
			pr.productListtoCustomer();
			System.out.println("--------------------------------------------------------------------------");
		 	System.out.print(" Enter ProductID which QTY needs to be updated      : ");
		 	
		 	// To validate user input
		 	ValidateInput checkInput = new ValidateInput();
		 	int id= checkInput.getInput(ProductList.pid);	 
		 	
		 	System.out.print(" Enter Quantity to be added      : ");			
			int quantity= checkInput.getInput(100);
			System.out.println();
			
			preparedstatement.setInt(1,quantity);
			preparedstatement.setInt(2,id);
			preparedstatement1 = ConnectJDBC.connection.prepareStatement("select * from  productdetails where ProductID=?");
			preparedstatement1.setInt(1,id);
			ResultSet rs=preparedstatement1.executeQuery();
			
			 while(rs.next()) {
				 
					System.out.println(" Available Quantity   : "+rs.getString(5));
					int i=Integer.parseInt(rs.getString(5));  
					 int totalqty = quantity+i;
					System.out.println(" Total Quantity       : "+totalqty);
		        }	 
			//int totalqty=quantity+avlQuantity;
		
			preparedstatement.executeUpdate();
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("\t \t \t ***Quantity  Updated***");
			System.out.println("--------------------------------------------------------------------------");
			 
		}catch(Exception e) {
			System.out.println(e);
			
		}finally{
			// close the resources.
			
			preparedstatement.close();
			preparedstatement1.close();
		}
	}
}
package com.ecommerce.abhinath;

import java.sql.*;

import com.ecommerce.pooja.Purchase;
import com.ecommerce.validation.ConnectJDBC;

// Author : Abhinath Jadhav
// Date   : 26/02/2022      
public class UpdateQtyPurchase {

	public void updatePurchaseQTY(){
		
		PreparedStatement preparedStatement = null;
		
		
		try {
			// Get connection and prepare statement
			
			preparedStatement = ConnectJDBC.connection.prepareStatement("UPDATE productdetails SET qty = qty - ? WHERE productid=?");
			
			// Taking info from purchase class and update in data base.
			for(int i = 0; i<Purchase.purchaseQTY.length; i++) {
				
				int qty = Purchase.purchaseQTY[i];
				
				int id  = Purchase.purchaseList[i]+1;				
				
				preparedStatement.setInt(1, qty);
				preparedStatement.setInt(2, id);
				
				// Execute query
				preparedStatement.executeUpdate();		
				
			}
			System.out.println("\n--------------------------------------------------------------------------");
			System.out.println("                   ***Record Updated. Order confirmed***");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

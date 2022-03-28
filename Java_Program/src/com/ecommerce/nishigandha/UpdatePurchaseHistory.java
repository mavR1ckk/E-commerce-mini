package com.ecommerce.nishigandha;

import java.sql.PreparedStatement;
import com.ecommerce.pooja.Purchase;
import com.ecommerce.validation.ConnectJDBC;
import com.ecommerce.abhinath.UserNameCity;

//Author : Nishigandha
public class UpdatePurchaseHistory{	
	
	public void updatePurchaseDB() {
		
		String name =UserNameCity.customerName;
		int id=UserNameCity.userId;	
		
		PreparedStatement preparedStatement = null;
		try {
			// Establish connection		
			
			preparedStatement = ConnectJDBC.connection.prepareStatement("INSERT INTO purchasehistory(UserID,UserName,ProductName,Qty,TotalAmount) VALUES (?,?,?,?,?);");
			//Execute statement
			for (int i =0; i<Purchase.purchaseQTY.length; i++) {
				String product = Purchase.itemInCart.get(i);
				int qty = Purchase.purchaseQTY[i];
				String amount=Purchase.priceAfterPurchase.get(i);
				
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, product);
				preparedStatement.setInt(4, qty);
				preparedStatement.setString(5,amount);
				preparedStatement.executeUpdate();
				
			}
			// submit the sql statement to database..
		}catch(Exception e) {
			System.out.println(e);			
		}		
	}
}

package com.ecommerce.abhinath;

import com.ecommerce.nishigandha.*;
import com.ecommerce.validation.ValidateInput;

// Author: Abhinath jadhav
// Date: 24/02/2022
public class AdminrightsImpl implements AdminRights{
	
	public void getAdminOptions() {
		// To print the options list.
		AdminOptions adminOptions = new AdminOptions();
		adminOptions.getOptions();
		System.out.println(); // For empty line
		
		AddProduct productDetails =  new AddProduct();
		RemoveUsers removeUsers = new RemoveUsers();
		RemoveProducts removeProducts = new RemoveProducts();
		UserDirectory userDirectory = new UserDirectory();
		PurchaseHistory purchaseHistory = new PurchaseHistory();
		UpdateQuantity updateQuantity = new UpdateQuantity();
		StockDetails stockDetails = new StockDetails();
		
		// To get admin choice
				
		ValidateInput checkInput = new ValidateInput();
		
		System.out.print("Enter HotKey to perform operation of your choice ->  ");
		int choice = checkInput.getInput(7);	
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		
		
		// To call method as per admin choice	
		try {
			switch (choice) {
				case 1: 
					// addProduct
					productDetails.addProducts();
					break;
				case 2:
					// removeProduct
					removeProducts.getRemoveProducts();
					break;
				case 3:
					// updateQTY
					updateQuantity.getUpdateQuantity();
					break;
				case 4:
					// getStockDetails
					stockDetails.getStockDetails();
					break;
				case 5: 
					// removeUser					
					removeUsers.removeUser();					
					break;
				case 6:
					// viewUserDirectory
					userDirectory.getUserDirectory();
					
					break;
				case 7:
					// viewPurchaseHistory
					purchaseHistory.getPurchaseHistory();
					break;
			}
			adminOptions.getnextOpertaion();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		finally {
			
		}
	}
}

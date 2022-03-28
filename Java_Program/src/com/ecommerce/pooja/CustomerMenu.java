package com.ecommerce.pooja;

import com.ecommerce.abhinath.CheckInput;
import com.ecommerce.shivam.*;


//Author : Pooja
public class CustomerMenu 
{
	
	public static void dislayCustomerMenu()
	{
		ProductList productList=new ProductList();
		
		Purchase purchase=new Purchase();
		
		LoginInterface loginInterface = new LoginInterfaceImpl();
		
		
		int choice;
			do 
			{
			System.out.println("                   Select option from below list                      ");
			System.out.println("                      ------------------------                            ");
			System.out.println("\t HotKey               Operation                            ");
			System.out.println("--------------------------------------------------------------------------");
			
			System.out.println("\t Customer Menu");
		
			System.out.println("\t   1: \t \t Purchase");
			System.out.println("\t   2: \t \t Return to log In page");
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("Enter HotKey to perform operation of your choice ->  ");
			
			CheckInput checkInput = new CheckInput();
			int customerChoice=checkInput.getInput(2);
			switch(customerChoice)
			{
				case 1:	productList.productListtoCustomer();
						purchase.AddProduct();
						break;
				
				case 2: loginInterface.getUserInput();;
						break;
			}	
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.print(" \n1: Continue to purchase \n2: Go to main menu \n3: Logout and exit ");
			choice=checkInput.getInput(3);
			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			if(choice == 2) {
				try {
					loginInterface.getUserInput();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			else if(choice == 3) {
				System.out.println("Logged out succussfully.");
				System.exit(0);
			}			
			
			} while(choice==1) ;		
	}
	public static void main(String[] args) {
		
		CustomerMenu.dislayCustomerMenu();
	}
}
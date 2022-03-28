package com.ecommerce.pooja;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import com.ecommerce.abhinath.*;
import com.ecommerce.nishigandha.UpdatePurchaseHistory;
import com.ecommerce.shivam.LogIn;
import com.ecommerce.validation.ValidateInput;
import com.ecommerce.validation.VarifyQty;

//Author : Pooja
public class Purchase 
{
	
	
	ValidateInput checkInput = new ValidateInput();
	UserNameCity userNameCity = new UserNameCity();
	VarifyQty qty = new VarifyQty();
	UpdatePurchaseHistory updatePurchaseHistory = new UpdatePurchaseHistory();
	UpdateQtyPurchase updateQtyPurchase = new UpdateQtyPurchase();
	
	int quantity;//purchase  quantity 
	
	int itemcount;//product count
	
	public static int purchaseList[];//array of number of product want to buy
	public static int purchaseQTY[];//array of number of product want to buy
	
	ProductList pList=new ProductList(); //object of product list class
	
	public static List<String> itemInCart=new ArrayList<String>();
	
	public static List<String> priceAfterPurchase = new ArrayList<String>();
	
	int total_products_in_cart=0;
	int q[];
	public void AddProduct() 
	{
		
		//add number of product you want to buy
		System.out.println("--------------------------------------------------------------------------");
		System.out.print("Enter how many Product Do you want to buy ->  ");
		
		itemcount=checkInput.getInput(20);
		
		while(itemcount==0)
		{
			System.out.println("Please add some product into the cart:");
			itemcount=checkInput.getInput(20);
		}
		
		purchaseList=new int[itemcount];
		purchaseQTY=new int[itemcount];
		q=new int[itemcount];
		
		try
		{
			System.out.println();			
			for(int i=0;i<itemcount;i++){
				
				System.out.print("Enter product Id to add in cart :");
				
				int j=checkInput.getInput(ProductList.pid);// To take user input and validate
				
				purchaseList[i]=j-1;//added product number in purchaseList array
				
				System.out.print("Enter product Qty : ");	
				
				quantity = checkInput.getInput(20); // to take item QTY.
				
				System.out.println("Checking available QTY...");
				
				qty.getvarifyQTY(j,quantity);	// To varify qty
				
				while (qty.getvarifyQTY(j,quantity) == false) {
					System.out.println();
					System.out.print("QTY unavailable, Please change QTY.");
					quantity = checkInput.getInput(20);
				}	
				
				Purchase.purchaseQTY[i] =quantity;
				System.out.println("Product added succssfully.");
				q[i]=quantity;
				System.out.println();
				
			}
			System.out.println("--------------------------------------------------------------------------");
			
			total_products_in_cart=itemcount;
			
			System.out.println("Below products placed in cart");
			System.out.println("Products in cart :     "+itemcount);
			System.out.println("----------------------------------------");
			System.out.println("number \t QTY \t Product  \t Price");
			System.out.println("--------------------------------------------------------------------------");
			
			for(int i=0;i<itemcount;i++)
			{
				
				System.out.println(1+purchaseList[i]+"\t"+purchaseQTY[i]+"\t"+ProductList.pname.get(purchaseList[i])+"\t"+ProductList.price.get(purchaseList[i]));
				itemInCart.add(i,ProductList.pname.get(purchaseList[i]));
				priceAfterPurchase.add(ProductList.price.get(purchaseList[i]));
			}
			
			
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.print(" \n1.Goto cart \n2.Cancle  ->  ");
		
		ValidateInput checkInput = new ValidateInput();
		int choice=checkInput.getInput(2);
		System.out.println("--------------------------------------------------------------------------");
		switch(choice)
		{
			case 1: gotoCart();
					break;
			
			case 2 :CustomerMenu.dislayCustomerMenu();
					break;
		}
	}
	public void displayCart()
	{
		System.out.println("                      ********** Your CART**********                      ");
		System.out.println("----------------------------------------");
		System.out.println("number \t QTY \t Product  \t Price");
		System.out.println("----------------------------------------");
		for(int i=0;i<total_products_in_cart;i++)
		{
			System.out.println(1+i+"\t"+purchaseQTY[i]+"\t"+ itemInCart.get(i)+"       "+priceAfterPurchase.get(i));
		}
	}
	
	public void gotoCart()
	{
		
		displayCart();
		System.out.println();
		System.out.println("Product Quantity:         "+itemInCart.size());
		double sum=0;
		int n=0;
		for(String i:priceAfterPurchase)
		{
			double j=Double.parseDouble(i);//price is stored as string in database so converted it into double
			

			sum=sum+(j*q[n]);
			n++;
			
			
		}
		System.out.println("Total Cost:               "+sum);
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.print(" \n1.Generate Bill \n2.Cancle  ->  ");
		ValidateInput checkInput = new ValidateInput();
		int choice=checkInput.getInput(2);
		System.out.println("--------------------------------------------------------------------------");
		switch(choice)
		{
			case 1: bill();
					break;
			
			case 2 :CustomerMenu.dislayCustomerMenu();
					break;
		}
	}
	public void bill()
	{
		
		userNameCity.getUserNameCity(LogIn.username);			
		System.out.println("                            ***Your Bill***                               ");
		System.out.println("----------------------------------------");
		
		System.out.println("Customer ID:      "+UserNameCity.userId);
		System.out.println("Customer Name:    "+UserNameCity.customerName);
		System.out.println("Customer city:    " + UserNameCity.City);
		
		LocalDate date=LocalDate.now();//get todays date		
		System.out.println("Billing Date:     "+date);
		
		LocalTime time= LocalTime.now();//get current time
		System.out.println("Billing Time:     "+time);
		System.out.println("--------------------------------------------------------------------------");
		
		System.out.println("                      ********** Your CART**********                      ");
		System.out.println("----------------------------------------");
		System.out.println("number \t QTY \t Product  \t Price");
		System.out.println("----------------------------------------");
		for(int i=0;i<total_products_in_cart;i++)
		{
			System.out.println(1+i+"\t"+purchaseQTY[i]+"\t"+ itemInCart.get(i)+"       "+priceAfterPurchase.get(i));
		}
		
		System.out.println();
		//gotoCart();//call cart function
		System.out.println("--------------------------------------------------------------------------");
		int qsum=0;
		for(int qtycount=0;qtycount<q.length;qtycount++)
		{
			qsum=qsum+q[qtycount];
		}
		System.out.println("Total items:              "+qsum);
		double sum=0;
		int r=0;
		for(String s :priceAfterPurchase)  //to calculate total cost
		{
			double d=Double.parseDouble(s);//price is stored as string in database so converted it into double
			
			sum=sum+(d*q[r]);
			r++;
		}
		System.out.println("Total Bill:               "+sum);
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("             ***Please wait we are working on your order***                ");
		updatePurchaseHistory.updatePurchaseDB();
		updateQtyPurchase.updatePurchaseQTY();
		System.out.println("                         ***Order confirmed***                            ");
		System.out.println("           __________________________________________________            ");
		System.out.println("           *************THANK YOU!! Visit Again**************");
	}
	
	
}
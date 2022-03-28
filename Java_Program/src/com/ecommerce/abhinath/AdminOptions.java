package com.ecommerce.abhinath;

import java.util.*;

import com.ecommerce.shivam.LoginInterface;
import com.ecommerce.shivam.LoginInterfaceImpl;

//Author: Abhinath Jadhav
//Date:   26/03/2022
public class AdminOptions {

	public void getOptions() {
		// to store the information of list.
		LinkedHashMap<Integer, String> adminRightsMap = new LinkedHashMap<>();
		adminRightsMap.put(1, "Add product");
		adminRightsMap.put(2, "Remove product");
		adminRightsMap.put(3, "Update qty");
		adminRightsMap.put(4, "Check available stock");
		adminRightsMap.put(5, "Remove user");
		adminRightsMap.put(6, "View registered users directory");
		adminRightsMap.put(7, "View purchase history of user");
				
		// To print the list on console
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("                    ****Welcome to Admin Page****                         ");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		System.out.println("                Select operation you want to perform                      ");
		System.out.println("                      ------------------------                            ");
		System.out.println("\t HotKey               Operation                            ");
		System.out.println("--------------------------------------------------------------------------");
		
		adminRightsMap.forEach((k,v) -> System.out.println("\t   " + k + ":                " + v));
		System.out.println("--------------------------------------------------------------------------");
	}
	
	public void getnextOpertaion() {
		CheckInput checkInput = new CheckInput();
		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.print(" \n 1: Another operation \n 2: Go to Log In page \n 3: Log out \n Press hotkey to perform operation -> ");
		int nextOperation = checkInput.getInput(3);		
		
		switch (nextOperation) {
		case 3:
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("\t \t***Logged out successfully. Thank you.***");
			System.exit(0);
			break;
		case 1:
			AdminRights adminrights = new AdminrightsImpl();
			adminrights.getAdminOptions();
			break;
		case 2:
			System.out.println("--------------------------------------------------------------------------");
			LoginInterface loginInterface = new LoginInterfaceImpl();
			loginInterface.getUserInput();
			break;
		}
	}
	
}

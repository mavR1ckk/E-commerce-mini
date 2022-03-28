package com.ecommerce.validation;

import java.util.List;
import java.util.Scanner;

public class ValidateInput {

	// To check input is in int or not and option is available or not.
	public int getInput(int i) {
		
		int input = 0;
		String str;
		// To validate input
		boolean valid = false;
		
		Scanner sc = new Scanner(System.in);
		
		while(valid==false) {
			
			str = sc.nextLine(); // to store input in string
			
			try {	
				ValidateInput check = new ValidateInput();
				input = Integer.parseInt(str);
				if(check.checkMaxPossible(input, i)) {
					valid = true;
				}	
				else {
					System.out.println();
					System.out.print("Please enter number between 1 and " + i + " -> ");
				}
				
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.print("Error : Please enter in number form -> ");
			}
		}
		return input;
	}
	
	// To check iput number is available in switch case.
	public boolean checkMaxPossible(int i, int j) {
		
		boolean valid = false;
		if(i<=j && i>0) {
			valid = true;
		}
		return valid;
	}
	
	public int getInput(List list) {
		
		int input = 0;
		String str = null;
		// To validate input
		boolean valid = false;
		
		Scanner sc = new Scanner(System.in);
		while(valid == false) {
			
			try {
				
				str = sc.nextLine(); // to store input in string
				input = Integer.parseInt(str); // To try converting string in int
				if (list.contains(input)) {
					valid=true;
				}	
				else {
					System.out.println();
					System.out.print("Invalid Input : Please choose ID from above list -> ");
				}
				
			} catch (Exception e) {
				System.out.println();
				System.out.print("Error : Please enter in number form ->");
			}					
		}		
		return input;
	}
}

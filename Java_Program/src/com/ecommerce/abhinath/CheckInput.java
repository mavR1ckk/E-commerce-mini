package com.ecommerce.abhinath;

import java.util.Scanner;

//Author : Abhinath Jadhav
//Date   : 27/03/2022
public class CheckInput {

	public int getInput(int i) {
		
		int input = 0;
		String str;
		boolean valid = false;
		
		Scanner sc = new Scanner(System.in);
		while(valid==false) {
			str = sc.nextLine();
			try {	
				CheckInput check = new CheckInput();
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
				System.out.print("Error : Please enter in number -> ");
			}
		}
		return input;
	}
	
	public boolean checkMaxPossible(int i, int j) {
		
		boolean valid = false;
		if(i<=j && i>0) {
			valid = true;
		}
		return valid;
	}
	
	public static void main(String[] args) {
		CheckInput check = new CheckInput();
		//System.out.println(check.checkMaxPossible(4, 3));
		System.out.println(check.getInput(3));
	}
}

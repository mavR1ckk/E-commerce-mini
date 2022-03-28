package com.ecommerce.pooja;

import com.ecommerce.common.ConnectJDBC;
import java.sql.*;

import java.util.*;

//Author : Pooja
public class ProductList 
{
	public static List<Integer> pid=new ArrayList<Integer>();
	public static List<String> pname=new ArrayList<String>();
	public static List<String> price=new ArrayList<String>();
	public static int productCount;
	
	public void productListtoCustomer()
	{
		PreparedStatement  preparedStatement;
		try
		{
			 //System.out.println("Connection Established");
			
			 //select query for getting product list
			preparedStatement=ConnectJDBC.connection.prepareStatement("select ProductID,ProductName,Price from productdetails");  
			 	//System.out.println("connction established");	

			System.out.println("\t      ***** \t SHOP NOW ****       ");
			System.out.println("\n\t********Available Products ******* ");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Prod no \t Product Name\t\t Price");
			System.out.println("--------------------------------------------------------------------------");
			 
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				productCount++;
				
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3));
				pid.add(rs.getInt(1));
				pname.add(rs.getString(2));
				price.add(rs.getString(3));
				
			}
			
					
	}catch(Exception e) 
	{
			System.out.println(e);
	}
	}
}
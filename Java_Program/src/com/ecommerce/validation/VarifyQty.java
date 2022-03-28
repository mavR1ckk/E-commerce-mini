package com.ecommerce.validation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VarifyQty {

	// To check qty is available or not as per user request
	public boolean getvarifyQTY(int prdouctID, int userQTY) {
		
		boolean check = false;
				
		PreparedStatement preparedstatement = null;
		
		try {
			
			preparedstatement = ConnectJDBC.connection.prepareStatement("select * from  productdetails where ProductID=?");
			
			preparedstatement.setInt(1,prdouctID);
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next()) {
				int availQTY = rs.getInt(5);				
				if(userQTY<=availQTY) {						
					check = true;
				}				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return check;
	}
}

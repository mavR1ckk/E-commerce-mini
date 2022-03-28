package com.ecommerce.abhinath;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ecommerce.common.ConnectJDBC;

// Author : Abhinath jadhav
// Date   : 26/03/2022
public class VarifyQty {

	
	public boolean getvarifyQTY(int i, int k) {
		
		boolean check = false;
				
		PreparedStatement preparedstatement = null;
		
		try {
			
			preparedstatement = ConnectJDBC.connection.prepareStatement("select * from  productdetails where ProductID=?");
			
			preparedstatement.setInt(1,i);
			ResultSet rs=preparedstatement.executeQuery();
			
			while(rs.next()) {
				int availQTY = rs.getInt(5);				
				if(k<=availQTY) {						
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

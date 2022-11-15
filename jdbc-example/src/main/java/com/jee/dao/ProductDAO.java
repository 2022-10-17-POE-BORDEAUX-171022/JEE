package com.jee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jee.modele.Product;

public class ProductDAO {
	
	
	
	
	public static List<Product> getAllProduct(){
		
		List<Product> res = new ArrayList<>();
		try {
			Connection con = UtilConnexion.seConnecter();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM product");	
			
			while (rs.next() ) {
				
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String descr = rs.getString("descr");
				float price = rs.getFloat("price");
				
				res.add( new Product(id, title, descr, price));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return res;
	}
	
	
	public static boolean deleteUser(int id) {
		try {
			Connection con = UtilConnexion.seConnecter();			
			PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE id= ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			con.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}
	
	
}
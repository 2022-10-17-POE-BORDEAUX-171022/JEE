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
			
			con.close();
			rs.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return res;
	}
	
	
	public static boolean deleteProduct(int id) {
		try {
			Connection con = UtilConnexion.seConnecter();			
			PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			con.close();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
	}
	
	
	public static Product getProductById(int id) {
		
		Product product = null;
		
		System.out.println("in getProduct");
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE id = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("product found");

				
				product = new Product(
				rs.getInt("id"),
				rs.getString("title"),
				rs.getString("descr"),
				rs.getFloat("price")
				);
				
			}
			
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	
	
}

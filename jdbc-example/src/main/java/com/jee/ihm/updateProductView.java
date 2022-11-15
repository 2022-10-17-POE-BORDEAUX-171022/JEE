package com.jee.ihm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UtilConnexion;


@WebServlet("/update")
public class updateProductView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt( request.getParameter("id") );

			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM product WHERE id= ?");
			ps.setInt(1, id);
			
			
			
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next()) {
				request.setAttribute("id", rs.getInt(1));
				request.setAttribute("title", rs.getString(2));
				request.setAttribute("descr", rs.getString(3));
				request.setAttribute("price", rs.getFloat(4));
			}
			
			request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
			
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/getall").forward(request, response);
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			System.out.println("Id :" + request.getParameter("id"));
			
			int id = Integer.parseInt( request.getParameter("id") );
			String title = request.getParameter("txtTitle");
			String description = request.getParameter("txtDescription");
			float price = Float.valueOf( request.getParameter("txtPrice") );
			
			PreparedStatement ps = con.prepareStatement("UPDATE product SET title=?, descr=?, price=? WHERE id = ?");
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setFloat(3, price);
			ps.setInt(4, id);
			
			ps.executeUpdate();
			
			con.close();
			
			
			request.setAttribute("msg", "Modifié avec succes");
			request.getRequestDispatcher("/getall").forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("msg", "Prob dans la modification");
			doGet(request, response);
		}
	}

}

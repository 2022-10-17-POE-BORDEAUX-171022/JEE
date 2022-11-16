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

import com.jee.dao.ProductDAO;
import com.jee.dao.UtilConnexion;
import com.jee.modele.Product;


@WebServlet("/update")
public class updateProductView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int id = Integer.parseInt( request.getParameter("id") );

		Product product = ProductDAO.getProductById(id);
		
		if (product != null) {
			System.out.println("product added to attribute");

			request.setAttribute("product", product);
			request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
		} else {
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

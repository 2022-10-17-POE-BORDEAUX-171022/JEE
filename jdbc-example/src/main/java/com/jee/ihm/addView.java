package com.jee.ihm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UtilConnexion;

@WebServlet("/add")
public class addView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String name = request.getParameter("txtTitle");
			String desc = request.getParameter("txtDesc");
			float price = Float.parseFloat( request.getParameter("txtPrice") );
			
			
			Connection con = UtilConnexion.seConnecter();
			
			String query = "INSERT INTO product(title, descr, price) VALUE ('" + name + "','" + desc + "','" + price +"')";
			
			
			System.out.println(query);
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate();
			
			con.close();
			
			request.getRequestDispatcher("/showProduct.jsp").forward(request, response);
			
		} catch (Exception e) {			
			request.setAttribute("msg", "Erreur dans le produit");
			doGet(request, response);
		}
	}
}

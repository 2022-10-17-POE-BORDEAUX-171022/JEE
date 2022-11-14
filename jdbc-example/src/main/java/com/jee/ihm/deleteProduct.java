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


@WebServlet("/delete")
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Connection con = UtilConnexion.seConnecter();
			
			int id = Integer.parseInt( request.getParameter("id") );
			
			String query = "DELETE FROM product WHERE id='" + id + "'";
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate();
			con.close();
			
			request.setAttribute("msg", "produit supprimé");
			request.getRequestDispatcher("/getall").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("msg", "erreur dans la suppression");
			request.getRequestDispatcher("/getall").forward(request, response);
		}
	
	}

}

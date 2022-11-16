package com.jee.ihm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.ProductDAO;
import com.jee.dao.UtilConnexion;


@WebServlet("/delete")
public class deleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt( request.getParameter("id") );
		boolean isOk = ProductDAO.deleteProduct(id);
		
		
		// request.setAttribute("msg", isOk ? "produit supprimé" : "erreur dans la suppression");
		if (isOk) {
			request.setAttribute("msg", "produit supprimé");
			
		} else {
			request.setAttribute("msg", "erreur dans la suppression");
		}
		request.getRequestDispatcher("/getall").forward(request, response);

	
	}

}

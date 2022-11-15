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
public class DeleteUsersView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String id = request.getParameter("id");
		
		try {
			
			Connection con = UtilConnexion.seConnecter();
			PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id= '"+ id +"';");
			ps.executeUpdate();
			
			con.close();
			
			request.getRequestDispatcher("/get").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

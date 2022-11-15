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
import javax.servlet.http.HttpSession;

import com.jee.dao.UtilConnexion;


@WebServlet("/update")
public class UpdateUsersView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);		
		String id = request.getParameter("id");
		
		
		try {
			
			Connection con = UtilConnexion.seConnecter();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id= '"+ id +"';");
			
			ResultSet rs = ps.executeQuery();
			
			if ( rs.next() ) {
				request.setAttribute("id", rs.getInt("id")); 
				request.setAttribute("email", rs.getString("email")); 
				request.setAttribute("login", rs.getString("login")); 
				request.setAttribute("password", rs.getString("password")); 
				
				request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "Utilisateur introuvable"); 
				request.getRequestDispatcher("/get").forward(request, response);

			}
			rs.close();
			con.close();
			
			
			
		} catch (Exception e) {
			request.setAttribute("error", "Probleme de connection"); 
			request.getRequestDispatcher("/get").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("in doPost");
		
		
		String id = request.getParameter("txtId");
		String email = request.getParameter("txtEmail");
		String login = request.getParameter("txtLogin");
		String password =request.getParameter("txtPassword");
		
		if ( email == null) email ="";
		if ( login == null) login = "";
		if ( password == null) password = "";
		if ( id == null) id = "";
		
		
		String error = "";
		
		if (!email.contains("@")){
			error += "L'email ne contient pas de @ <br>";
		} 
		if (login == null || login.equals("")) {
			error += "Le login est vide <br>";
		} 
		if ( password.length() < 8 ) {
			error += "password trop faible <br>";
		} 
		
		HttpSession session = request.getSession( true ); 

		
		if ("".equals(error)) {
			try {
				Connection con = UtilConnexion.seConnecter();
				
				
				
				
				PreparedStatement ps = con.prepareStatement("UPDATE user SET email='"+ email+"', login='"+ login+"', password='"+ password+"' WHERE id='"+ id +"';");
				ps.executeUpdate();
				con.close();
				
				System.out.println("update done");
				
				
				request.getRequestDispatcher("/get").forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
				session.setAttribute("error", "Probleme de connection");
				request.getRequestDispatcher("/get").forward(request, response);
			}
		} else {
			session.setAttribute("error", error );
			doGet(request, response);
		}
	}

}

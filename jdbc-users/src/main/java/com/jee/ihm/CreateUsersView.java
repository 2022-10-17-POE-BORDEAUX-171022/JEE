package com.jee.ihm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jee.dao.UtilConnexion;


@WebServlet("/new")
public class CreateUsersView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession( true ); 

		
		String email = (String) session.getAttribute("email");
		String login = (String) session.getAttribute("login");
		String password = (String) session.getAttribute("password");
		String confirmation = (String) session.getAttribute("confirmation");
		
		if ( email == null) session.setAttribute("email", "");
		if ( login == null) session.setAttribute("login", "");
		if ( password == null) session.setAttribute("password", "");
		if ( confirmation == null) session.setAttribute("confirmation", "");
		
		request.getRequestDispatcher("createUser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("txtEmail");
		String login = request.getParameter("txtLogin");
		String password =request.getParameter("txtPassword");
		String confirmation = request.getParameter("txtPasswordConfirmation");
		
		if ( email == null) email ="";
		if ( login == null) login = "";
		if ( password == null) password = "";
		if ( confirmation == null) confirmation = "";
		
		
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
		if ( !confirmation.equals(password) || "".equals(confirmation) ) {
			error += "Les passwords ne sont pas identiques <br>";
		}
		
		HttpSession session = request.getSession( true ); 

		
		if ("".equals(error)) {
			
			try {
				Connection con = UtilConnexion.seConnecter();
				PreparedStatement ps = con.prepareStatement("INSERT INTO user(email, login, password) VALUE ('"+email+"','"+login+"','" + password + "');" );
				ps.executeUpdate();
				
				con.close();
				request.getRequestDispatcher("/get").forward(request, response);			

			} catch (Exception e) {
				
				e.printStackTrace();
				
				session.setAttribute("error", "Erreur de connection");
				doGet(request, response);
			}
			
			
			
			
		} else {
			
			System.out.println("error :" + error);
			
			session.setAttribute("error", error);
			session.setAttribute("email", email);
			session.setAttribute("login", login);
			session.setAttribute("password", password);
			session.setAttribute("confirmation", confirmation);
			doGet(request, response);
			
		}
	}

}

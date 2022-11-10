package com.jee.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("txtEmail");
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		String confirmation = request.getParameter("txtPasswordConfirmation");

		if (email == null) email = "";
		if (login == null) login = "";
		if (password == null) password = "";
		if (confirmation == null) confirmation = "";
		
		
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
		
		
		if ("".equals(error)) {
			request.getRequestDispatcher("Connected.jsp").forward(request, response);			
		} else {
			HttpSession session = request.getSession( true ); 
			session.setAttribute("error", error);
			session.setAttribute("email", email);
			session.setAttribute("login", login);
			session.setAttribute("password", password);
			session.setAttribute("confirmation", confirmation);
			doGet(request, response);
			
		}
		
	}

}

package com.jee.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("txtEmail");
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		String passwordConfirmation = request.getParameter("txtPasswordConfirm");
		
		if (email == null) email = "";
		if (login == null) login = "";
		if (password == null) password = "";
		if (passwordConfirmation == null) passwordConfirmation = "";
		
		
		String error = (String) request.getAttribute("error");
		System.out.println("In doGet :" + error);
		
		response.setContentType("text/html");
		
		try (PrintWriter out = response.getWriter() ){
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	<link rel='stylesheet' type='text/css' href='style.css'></link>");
			out.println("		<title>Veuillez vous identifier</title>");
			out.println("	</head>");
			
			out.println("	<body>");
			out.println("		<h1>Veuillez vous identifier</h1>");
			out.println("		<h2>" + new Date() + "</h2>");
			if (error != null) {
				out.println("<p>"+ error +"</p>");
			} 
			
			
			out.println("		<form method='post'>");
			out.println("			<label for='txtEmail'>Email :</label>");
			out.println("			<input name='txtEmail' type='text' value='" + email + "'/><br/>");
			out.println("			<label for='txtLogin'>Login :</label>");
			out.println("			<input name='txtLogin' type='text' value='" + login + "'/><br/>");
			out.println("			<label for='txtPassword'>Password :</label>");
			out.println("			<input name='txtPassword' type='password' value='" + password + "'/><br/>");
			out.println("			<label for='txtPasswordConfirm'>Confirmation :</label>");
			out.println("			<input name='txtPasswordConfirm' type='password' value='" + passwordConfirmation + "'/><br/>");
			out.println("			<input name='btnConnect' type='submit'/>");
			out.println("		</form");
			out.println("	</body>"); 
			out.println("</html>");
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In doPost");
		String email = request.getParameter("txtEmail");
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		String passwordConfirmation = request.getParameter("txtPasswordConfirm");
		
		
		String error = null;
		
		if (email.contains("@") == false) {
			error = "L'email ne contient pas de @";
		} else if (login == null || login.equals("")) {
			error = "Le login est vide";
		} else if ( password.length() < 8 ) {
			error = "password trop faible";
		} else if ( passwordConfirmation.equals(password) == false ) {
			error = "Les passwords ne sont pas identiques";
		}

		System.out.println("ERROR :" + error);
		
		
		if (error == null) {
			try (PrintWriter out = response.getWriter() ){
				
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<p>Compte Créé</p>");
				out.println("<html>");
				
			}
		} else {
			request.setAttribute("error", error);
			doGet(request, response);
		}
	}

}

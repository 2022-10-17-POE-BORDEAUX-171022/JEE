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

import com.jee.dao.UserDAO;
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
		
		if (UserDAO.isValidUser(email, login, password, confirmation)) {			
			
			System.out.println("isValidUser");
			
			if (UserDAO.createUser(email, login, password)) {
				System.out.println("createUser");

				request.getRequestDispatcher("/get").forward(request, response);			
			} else {
				request.setAttribute("error", "Erreur de connection");
				doGet(request, response);
			}
			
		} else {
			System.out.println("! isValidUser");
			
			request.setAttribute("error", "Champs incorrect");
			request.setAttribute("email", email);
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			request.setAttribute("confirmation", confirmation);
			doGet(request, response);
		}
	}

}

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
import com.jee.modele.User;


@WebServlet("/update")
public class UpdateUsersView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt( request.getParameter("id") );
		
		
		User u = UserDAO.getUserById(id);
		
		if (u != null) {
			
			request.setAttribute("user", u);
			
			request.getRequestDispatcher("/updateUser.jsp").forward(request, response);			
		} else {
			request.setAttribute("error", "Probleme de connection"); 
			request.getRequestDispatcher("/get").forward(request, response);
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in doPost");
		
		int id = Integer.parseInt( request.getParameter("txtId") );
		String email = request.getParameter("txtEmail");
		String login = request.getParameter("txtLogin");
		String password =request.getParameter("txtPassword");
		
		if (UserDAO.isValidUser(email, login, password)) {
			if (! UserDAO.updateUser(id, email, login, password)) {
				request.setAttribute("error", "Probleme de connection");
			}
			request.getRequestDispatcher("/get").forward(request, response);
		} else {
			request.setAttribute("error", "champs incorrect" );
			doGet(request, response);
		}	
	}

}

package com.jee.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jee.dao.UserDAO;


@WebServlet("/delete")
public class DeleteUsersView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		int id =  Integer.parseInt( request.getParameter("id") );
						
		if (UserDAO.deleteUserById(id)) {
			request.setAttribute("msg", "User delete");
		} else {
			request.setAttribute("msg", "erreur dans la suppression");
		}
		
		request.getRequestDispatcher("/get").forward(request, response);
	}
}

package com.jee.hello;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = "/lifecycle", loadOnStartup = 1 )
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	int conter = 0;
	
    public LifeCycleServlet() {
    	super();
    	System.out.println("In constructor");
        
    }

	public void init(ServletConfig config) throws ServletException {
 
		System.out.println("In init");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In doGet :" +  ++conter);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

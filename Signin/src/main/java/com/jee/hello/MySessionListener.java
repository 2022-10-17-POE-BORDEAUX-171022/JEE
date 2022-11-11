package com.jee.hello;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;




@WebListener
public class MySessionListener implements HttpSessionListener{
	
	private static final Logger LOG = Logger.getLogger(MyServletContext.class.getName());

	
	
	@Override
	public void sessionCreated( HttpSessionEvent se) {
		LOG.log(Level.INFO, "session created");
	}
	

	@Override
	public void sessionDestroyed( HttpSessionEvent se) {
		LOG.log(Level.INFO, "session destroyed");
	}
	

}

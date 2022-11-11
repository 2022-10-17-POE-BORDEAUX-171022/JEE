package com.jee.hello;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyServletContext
 *
 */
@WebListener
public class MyServletContext implements ServletContextListener{
	
	private static final Logger LOG = Logger.getLogger(MyServletContext.class.getName());
	
	
	
    public MyServletContext() {
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	LOG.log(Level.INFO, "===== Application started");
    }
    
    
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	LOG.log(Level.INFO, "===== Application stop");
    }

}

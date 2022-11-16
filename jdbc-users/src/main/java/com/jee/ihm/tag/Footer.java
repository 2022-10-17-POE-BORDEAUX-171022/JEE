package com.jee.ihm.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Footer extends TagSupport{
	private static final long serialVersionUID = 4318240657455371033L;

	String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void release() {
		userName = "";
	}
	
	
	@Override
	public int doStartTag() throws JspException{
		JspWriter out = pageContext.getOut();
		try {
			out.println("<div>");
			out.println("<h3>2022 © SARL Infini Software - Tous droits réservés</h3");
			out.println("<p>Les informations présentes dans ce site vous sont fournies dans le but de vous aider à acquérir les compétences nécessaires à l'utilisation des langages ou des technologies considérés. Infini Software ne pourra nullement être tenu responsable de l'utilisation des informations présentes dans ce site.</p");
			out.println("<p>De plus, si vous remarquez des erreurs ou des oublis dans ce document, n'hésitez surtout pas à nous le signaler en envoyant un mail à l'adresse : dominique.liard@infini-software.com.</p");
			
			out.println("	<h1> Welcome to <strong>" + userName + "</strong> </h1");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;
	}
	
	@Override
	public int doEndTag() throws JspException{
		JspWriter out = pageContext.getOut();
		
		try {
			out.println("</div>");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1; 
	}
	
}

package com.jee.ihm.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HeaderTag extends TagSupport {
    private static final long serialVersionUID = 7947800060337250053L;
    private String pageName = "";
    @Override
    public void release() {
    	pageName = "";
    }
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	@Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println( "<div style='border: 1px solid black; width: 60%; margin: auto;'>" );
            out.println( "	<h1> Welcome to "+ pageName +" Page <h1>" );
            
        } catch ( IOException exception ) {
            exception .printStackTrace();
        }
        return 2;       // State of the life cycle of my TagSupport 
    }
    
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print( "</div>" );
        } catch ( IOException exception ) {
            exception .printStackTrace();
        }
        return 4;       // State of the life cycle of my TagSupport 
    }
    
}
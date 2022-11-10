<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.Date" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Veuillez vous identifier</title>
		<link rel='stylesheet' type='text/css' href='style.css'></link>
	</head>
	<body>
		<h1>Veuillez vous identifier</h1>
		<h2><%= new Date() %> </h2>
		
		
		<%
			String login = request.getParameter("txtLogin");
			String password = request.getParameter("txtPassword");
			if (login == null) login = "";
			if (password == null) password = "";
			
			if ( request.getMethod().equals("POST") && login.equals("java") && password.equals("jee")){
		%>
			<p> Welcome <%= login %> </p>
		<% } else { %>
			<form method='post'>
				<label for='txtLogin'>Login :</label>
				<input name='txtLogin' type='text' value='<%= login %>'/><br/>
				<label for='txtPassword'>Password :</label>
				<input name='txtPassword' type='password' value='<%= password %>'/><br/>
				<input name='btnConnect' type='submit'/>
			</form>
		<% } %>

	</body>
</html>
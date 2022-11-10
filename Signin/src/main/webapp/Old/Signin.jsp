<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.Date' %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Signin to Hello App</title>
		<link rel='stylesheet' type='text/css' href='style.css' >
	</head>
	<body>
		<h1>Signin to Hello App</h1>
		<h2><%= new Date() %></h2>
		
		<%
			String email = request.getParameter("txtEmail");
			String login = request.getParameter("txtLogin");
			String password = request.getParameter("txtPassword");
			String confirmation = request.getParameter("txtPasswordConfirmation");

			if (email == null) email = "";
			if (login == null) login = "";
			if (password == null) password = "";
			if (confirmation == null) confirmation = "";

			String error = "";

										
			if (!email.contains("@")){
				error = "L'email ne contient pas de @";
			} else if (login == null || login.equals("")) {
				error = "Le login est vide";
			} else if ( password.length() < 8 ) {
				error = "password trop faible";
			} else if ( !confirmation.equals(password) ) {
				error = "Les passwords ne sont pas identiques";
			}
			
			if (error == "" && request.getMethod() == "POST") {
		%>
			<p> New user :<%= login %> </p>
		<% } else { %>
		
		<p><%= error %> </p>
		
		<form method='post' >
			<label for='txtEmail'> Email :</label>
			<input name='txtEmail' type='text' value='<%= email %>'/>
			<br>
			<label for='txtLogin'> Login :</label>
			<input name='txtLogin' type='text' value='<%= login %>'/>
			<br>
			<label for='txtPassword'> Password :</label>
			<input name='txtPassword' type='text' value='<%= password %>'/>
			<br>
			<label for='txtPasswordConfirmation'> Confirmation :</label>
			<input name='txtPasswordConfirmation' type='text' value='<%= confirmation %>'/>
			<br>
			<input name='btnSubmit' type='submit'/>
		
		</form>
			
		<% } %>
			
	</body>
</html>
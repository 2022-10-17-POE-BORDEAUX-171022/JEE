<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<title>Create user</title>
		<link rel='stylesheet' type='text/css' href='style.css'></link>
	
	</head>
	<body>
	
		<h1>Veuillez vous identifier</h1>
		<h2><%= new Date() %> </h2>
		
		<%
			String email = request.getParameter("txtEmail");
			String login = request.getParameter("txtLogin");
			String password = request.getParameter("txtPassword");
			String passwordConfirmation = request.getParameter("txtPasswordConfirm");
			
			if (email == null) email = "";
			if (login == null) login = "";
			if (password == null) password = "";
			if (passwordConfirmation == null) passwordConfirmation = "";
			
			
			String error = "";
				
			if (email.contains("@") == false) {
				error = "L'email ne contient pas de @";
			} else if (login == null || login.equals("")) {
				error = "Le login est vide";
			} else if ( password.length() < 8 ) {
				error = "password trop faible";
			} else if ( passwordConfirmation.equals(password) == false ) {
				error = "Les passwords ne sont pas identiques";
			}
			
			System.out.println("Error:" + error);
			
			if (error == ""){
		%>
			<p>New user : <%= login %> </p>
		<% } else { %>
		
			<p> <%= error %></p>
		
			<form method='post'>
				<label for='txtEmail'>Email :</label>
				<input name='txtEmail' type='text' value='<%= email %>'/><br/>
				<label for='txtLogin'>Login :</label>
				<input name='txtLogin' type='text' value='<%= login %>'/><br/>
				<label for='txtPassword'>Password :</label>
				<input name='txtPassword' type='password' value='<%= password %>'/><br/>
				<label for='txtPasswordConfirm'>Confirmation :</label>
				<input name='txtPasswordConfirm' type='password' value='<%= passwordConfirmation %>'/><br/>
				<input name='btnConnect' type='submit'/>
			</form>
		<% } %>
		
	</body>
</html>
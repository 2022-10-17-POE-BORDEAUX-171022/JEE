<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import='java.util.Date' %>    
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Signin to hello app</title>
		<link rel='stylesheet' type='text/css' href='style.css'></link>
	</head>
	<body>
		<h1>Signin to hello app</h1>
		<h2><%= new Date() %></h2>
		<p>${error}</p>
	
		<form method='post' action='/Signin/signin'>
			<label for='txtEmail'> Email :</label>
			<input name='txtEmail' type='text' value='${email}'/>
			<br>
			<label for='txtLogin'> Login :</label>
			<input name='txtLogin' type='text' value='${login}'/>
			<br>
			<label for='txtPassword'> Password :</label>
			<input name='txtPassword' type='text' value='${password}'/>
			<br>
			<label for='txtPasswordConfirmation'> Confirmation :</label>
			<input name='txtPasswordConfirmation' type='text' value='${confirmation}'/>
			<br>
			<input name='btnSubmit' type='submit'/>
		
		</form>	
	</body>
</html>
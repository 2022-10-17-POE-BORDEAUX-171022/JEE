<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://myapp.fr/tld/extratags" prefix="mytags" %>
    
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Create User</title>
	</head>
	<body>
		<h1>Create User</h1>
	
	
	
	
		<% if (request.getAttribute("error") != null) {	%>
			<h3>${error}</h3>
		<% } %>
	
	
		<form method='post'>
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
		
		
		<mytags:Footer userName='${login}' />
		
		
	</body>
</html>
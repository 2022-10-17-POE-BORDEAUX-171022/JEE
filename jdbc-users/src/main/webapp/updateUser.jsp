<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update User</title>
	</head>
	<body>
			<h1>Update User</h1>
	
		<% if (session.getAttribute("error") != null) {	%>
			<h3>${error}</h3>
		<% } %>
	
		<form method='post'>
			<label for='txtId'> Id :</label>
			<input name='txtId' type='text' value='${id}'/>
			<br>
			<label for='txtEmail'> Email :</label>
			<input name='txtEmail' type='text' value='${email}'/>
			<br>
			<label for='txtLogin'> Login :</label>
			<input name='txtLogin' type='text' value='${login}'/>
			<br>
			<label for='txtPassword'> Password :</label>
			<input name='txtPassword' type='text' value='${password}'/>
			<br>
			<input name='btnSubmit' type='submit'/>
		</form>	
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login to Hello app</title>
		<link rel='stylesheet' type='text/css' href='style.css' />
	</head>
	<body>
		<h1>Login to Hello app</h1>
		
		
		<form method="post" action="login">
            <label for='txtLogin'>Login :</label>
            <input name="txtLogin" value='<%= session.getAttribute("login") %>' autofocus /><br/>
            <label for='txtPassword'>Password :</label>
            <input name="txtPassword" type="password" value='${password}' /><br/>
            <input type="submit" value="Connect" />
        </form>
		
		
	</body>
</html>
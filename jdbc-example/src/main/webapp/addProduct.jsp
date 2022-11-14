<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		<h1>Ajouter un produit :</h1>
		
		<% if ( request.getAttribute("msg") != null) {%>
			<h4>${msg}</h4>
		<% } %>
		
		<form method="post">
			<label for="txtTitle">Name :</label>
			<input type="text" name="txtTitle" placeholder="ex: citrouille">
			<br/>
			<label for="txtDesc">Description :</label>
			<input type="text" name="txtDesc" placeholder="ex: legumes">
			<br/>
			<label for="txtPrice">Price :</label>
			<input type="text" name="txtPrice" placeholder="ex: 1.89">
			<br/>
			<input type="submit">					
		</form>
		
		
	</body>
</html>
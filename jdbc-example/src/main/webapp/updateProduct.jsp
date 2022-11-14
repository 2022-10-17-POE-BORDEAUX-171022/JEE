<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		<% if ( request.getAttribute("msg") != null) {%>
			<h4>${msg}</h4>
		<% } %>
	
		<form method="post">
			<label for="txtId">Id :</label>
			<input type="text" name="txtId" value="${id}" >
			<br/>
			<label for="txtTitle">Title :</label>
			<input type="text" name="txtTitle" value="${title}">
			<br/>
			<label for="txtDescription">Description :</label>
			<input type="text" name="txtDescription" value="${descr}">
			<br/>
			<label for="txtPrice">Price :</label>
			<input type="text" name="txtPrice" value="${price}">
			<br/>
			<input type="submit">					
		</form>
		
	
	</body>
</html>
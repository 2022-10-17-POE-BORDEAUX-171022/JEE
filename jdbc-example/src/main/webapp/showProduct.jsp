<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jee.modele.Product" %>    
<%@ page import="com.jee.dao.ProductDAO" %>    


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des produits</title>
	</head>
	<body>
		<h1>Liste des produits</h1>
		
		
		<% if( request.getAttribute("msg") != null) { %>
			<h4>${msg}</h4>
		<% } %>
		

		<table>
			<tr> <th>IDP</th> <th>Titre</th> <th>Description</th> <th>Price</th> <th>Delete</th> </tr>
			<% for (Product p: ProductDAO.getAllProduct()){	%>
				<tr>
					<td> <%= p.getId() %> </td>
					<td> <%= p.getTitle() %> </td>
					<td> <%= p.getDescr() %> </td>
					<td> <%= p.getPrice() %> </td>
					<td> <a href="/jdbc-example/delete?id=<%= p.getId() %> ">Delete</a> </td>
					<td> <a href="/jdbc-example/update?id=<%= p.getId() %> ">Update</a> </td>
				</tr>
			<% 
				}
			%>
		</table>
		
		
		
		<a href="/jdbc-example/add">Ajouter</a>
		
		
	</body>
</html>
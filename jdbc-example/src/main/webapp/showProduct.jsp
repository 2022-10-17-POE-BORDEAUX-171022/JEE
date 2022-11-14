<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jee.dao.UtilConnexion" %>    
<%@ page import="java.sql.Connection" %>    
<%@ page import="java.sql.ResultSet" %>    

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
		
		<%
			Connection con = UtilConnexion.seConnecter();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM product");
		%>
		<table>
			<tr> <th>IDP</th> <th>Titre</th> <th>Description</th> <th>Price</th> <th>Delete</th> </tr>
			<% while (rs.next()) { %>
				<tr> 
					<td> <%= rs.getInt(1) %> </td>
					<td> <%= rs.getString(2) %> </td>
					<td> <%= rs.getString(3) %> </td>
					<td> <%= rs.getFloat(4) %> </td>
					<td> <a href="/jdbc-example/delete?id=<%= rs.getInt(1)%> ">Delete</a> </td>
					<td> <a href="/jdbc-example/update?id=<%= rs.getInt(1)%> ">Update</a> </td>
				</tr>
			<% 
			}
			con.close();
			rs.close();
			%>
		</table>
		
		
		
		<a href="/jdbc-example/add">Ajouter</a>
		
		
	</body>
</html>
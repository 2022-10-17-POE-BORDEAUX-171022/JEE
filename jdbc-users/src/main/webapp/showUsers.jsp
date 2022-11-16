<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.jee.modele.User" %>    
<%@ page import="com.jee.dao.UserDAO" %>    
<%@ page import="java.sql.ResultSet" %>    
<%@ page import="com.jee.dao.UtilConnexion" %>    

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Show Users</title>
	</head>
	<body>
		<h1>Show Users</h1>

		
		<% if (request.getAttribute("msg") != null) { %>
			<h5>${msg}</h5>
		<% } %>
		
		
		<table>
			<tr> <th>ID user</th> <th>email</th> <th>login</th> <th>password</th> <th>Update</th> <th>Delete</th>   </tr>
			
			<% for(User u : UserDAO.getAllUser()){ %>
				<tr>
					<td> <%= u.getId() %>  </td>
					<td> <%= u.getEmail() %> </td>
					<td> <%= u.getLogin() %> </td>
					<td> <%= u.getPassword() %> </td>		
					<td> <a href='/jdbc-users/update?id=<%= u.getId() %>'>Update</a></td>			
					<td> <a href='/jdbc-users/delete?id=<%= u.getId() %>'>Delete</a></td>			
				</tr>
			<% 
			} 
			
			%>		
		</table>
		
		<a href='/jdbc-users/new'>Create</a>
		
		
		
	</body>
</html>
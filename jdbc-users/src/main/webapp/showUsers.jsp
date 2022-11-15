<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.Connection" %>    
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
		<%
		Connection con = UtilConnexion.seConnecter();
		ResultSet rs = con.createStatement().executeQuery("SELECT * FROM user");
		%>
		
		<table>
			<tr> <th>ID user</th> <th>email</th> <th>login</th> <th>password</th> <th>Update</th> <th>Delete</th>   </tr>
			
			<% while(rs.next()){ %>
				<tr>
					<td> <%= rs.getInt(1) %>  </td>
					<td> <%= rs.getString(2) %> </td>
					<td> <%= rs.getString(3) %> </td>
					<td> <%= rs.getString(4) %> </td>		
					<td> <a href='/jdbc-users/update?id=<%= rs.getInt(1) %>'>Update</a></td>			
					<td> <a href='/jdbc-users/delete?id=<%= rs.getInt(1) %>'>Delete</a></td>			
				</tr>
			<% 
			} 
			con.close();
			rs.close();
			
			%>		
		</table>
		
		<a href='/jdbc-users/new'>Create</a>
		
		
		
	</body>
</html>
<%@page import="com.sathya.registrationApp.UserDao" %>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Display users...</title>
</head>
<body bgcolor="aqua">
	<table border="10">
		<thead>
			<tr>
				<th>User ID</th>
				<th>User Name</th>
				<th>User Email</th>
				<th>User Mobile</th>
				<th>User Location</th>
			</tr>
		
		</thead>
		<tbody>
		<c:forEach items="<%=new UserDao().findAll()%>" var="user">
		<tr>
			<td>${user.userId}</td>
			<td>${user.userName}</td>
			<td>${user.userEmail}</td>
			<td>${user.userMobile}</td>
			<td>${user.userLocation}</td>
		
		
		</tr>
		
		
		</c:forEach>
		
		
		</tbody>
	</table>


</body>
</html>
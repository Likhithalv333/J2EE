<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${deletedresult eq 0} ">
<%@include file="userdelete.html" %>
no user available on that userId...
</c:if>
<c:if test="${deletedresult eq 1 }">
<%@include file="userdelete.html" %>
user deleted from data base..
</c:if>

</body>
</html>
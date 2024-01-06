<%@ page language="java" contentType="text/html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Login Check</title>
</head>

<body>
<c:if test="${result eq 0 }">
<%@include file="user-login.html" %>
login failed........
</c:if>
<c:if test="${result eq 1 }">
<c:redirect url="http://www.sathyatech.com"></c:redirect>
</c:if>
</body>
</html>
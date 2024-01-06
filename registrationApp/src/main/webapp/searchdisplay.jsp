<%@page language="java" contentType="text/html"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body bgcolor="pink">

	<c:if test="${empty user}">
	   Search Result not found....
	   <jsp:include page="usersearch.html"/>
	</c:if>
	
	<c:if test="${not empty user}">
		<jsp:include page="usersearch.html"/>
		User id...${user.userId}		<br>
		User Name...${user.userName}	<br>
		User Email...${user.userEmail}	<br>
		User Mobile...${user.userMobile} <br>
		User Location...${user.userLocation}<br>
	</c:if>
	

	
</body>
</html>
 

 
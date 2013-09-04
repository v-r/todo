<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${logged_in == true}">
		<a href="<spring:url value="logout" />">Logout</a>
	</c:if> 
	<div style="border: 1px solid #ccc; width: 100%">
	<c:choose>
		<c:when test="${logged_in == true}">
			You are logged in.
		</c:when>
		<c:otherwise>
			Try to login: <a href="<spring:url value="login" />">Login</a>
		</c:otherwise>
	</c:choose>
	</div>
	hello
	<ul>
		<c:forEach var="$i" items="${items}">
			<li>${$i} - value!</li>
		</c:forEach>
	</ul>
	
	<p>
		<c:choose>
			<c:when test="${username != null}">
				Hello, ${username}
			</c:when>
			<c:otherwise>
				No user id was provided.
			</c:otherwise>
		</c:choose>
	</p>
	
	User id: ${user_id}
	<p>${notice}</p>
	<p>${hello.message}</p>
</body>
</html>
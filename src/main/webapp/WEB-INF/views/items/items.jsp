<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<link href="assets/css/bootstrap.css" rel="stylesheet">

</head>
<body>
	<div class="container">
	  <div class="row">
	  	<h3>
	  		<spring:message code="welcome.message" />
	  	</h3>
	  </div>
	  <div class="row">
		<c:choose>
			<c:when test="${logged_in == true}">
			</c:when>
		</c:choose>
		<p>Your items are:</p>
		<table class="table table-condenced">
		<thead>
			<tr>
				<td>Description</td>
				<td>Priority</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="$i" items="${items}">
				<tr>
					<td>${$i.description}</td>
					<td>${$i.priority}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	  </div>
	  
	  <div class="row">
	  	<a href="javascript:void(0);" class="btn" id="add_new_button">Add new ITEM</a>
	  	<a href="javascript:void(0);" class="btn">List</a>
	  </div>
	  <div class="row">
		<jsp:include page="item_form.jsp"></jsp:include>
	  </div>  
	</div>
	
	<script src="jquery-1.8.3.js"></script>
	<script src="assets/js/bootstrap.js">
    </script>
</body>
</html>
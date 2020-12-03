
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tables in the restaurant</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
	<c:if test="${ message !=null }">
			<div class="alert alert-danger" role="alert">${message}</div>
		</c:if>
		<h1>Please login to enter the reservation system</h1>
		<form:form action="${pageContext.request.contextPath}/login/"
			cssClass="form-horizontal" method="post">
			
			<div class="form-group">
				<label for="id">ID</label> 
				<input type="text" class="form-control" name="id">
			</div>
			<div class="form-group">
				<label for="password">Password</label> 
				<input type="password" class="form-control" name="password">
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

</body>
</html>
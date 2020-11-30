
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div>
		<a HREF="${pageContext.request.contextPath}/homePage/"
			class="btn btn-primary">Return to Home Page</a>
	</div>
	<div class="container">

		<h1>Edit ${serverName}'s profile</h1>

		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<form:form action="${pageContext.request.contextPath}/editProfile/"
			cssClass="form-horizontal" method="post" modelAttribute="server">
			<div class="form-group">
			
			</div>


			<div>
				<label for="serverName" class="col-md-3 controllabel">Name:
				</label>
				<div>
					<input name="name" value="${serverName}" />
				</div>
			</div>

			<div>
				<label for="phoneNumber" class="col-md-3 controllabel">Phone
					Number: </label>
				<div>
					<input name="phone" value="${phone}" />
				</div>
			</div>
			<form:button cssClass="btn btnprimary">
					Submit
					</form:button>

			<br>
			<br>
			<a HREF="${pageContext.request.contextPath}/changePass/">Change
				Password</a>

		</form:form>




	</div>
</body>
</html>
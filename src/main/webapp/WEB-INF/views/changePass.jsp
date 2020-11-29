<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="/static/js/jquery-1.11.1.min.js"></script>
<script src="/static/js/bootstrap.min.js" /></script>
</head>
<body>
	<div>
		<a HREF="${pageContext.request.contextPath}/homePage/"
			class="btn btn-primary">Return to Home Page</a>
	</div>
	<div class="container">

		<h1>Change Password</h1>

		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<c:if test="${ dangerMessage !=null }">
			<div class="alert alert-danger" role="alert">${dangerMessage}</div>
		</c:if>
		<form:form action="${pageContext.request.contextPath}/changePassword/"
			cssClass="form-horizontal" method="post" modelAttribute="server">



			<div>
				<label for="ID" class="col-md-3 controllabel">ID: </label>
				<div>
					<input name="ID" cssClass="form-control" />
				</div>
			</div>

			<div>
				<label for="previousPass" class="col-md-3 controllabel">Previous
					Password: </label>
				<div>
					<input name="previousPass" cssClass="form-control" />
				</div>
			</div>

			<div>
				<label for="newPass" class="col-md-3 controllabel">New
					Password: </label>
				<div>
					<input name="newPass" cssClass="form-control" />
				</div>
			</div>

			<div>
				<label for="confirmPass" class="col-md-3 controllabel">Confirm
					Password: </label>
				<div>
					<input name="confirmPass" cssClass="form-control" />
				</div>
			</div>
			<form:button cssClass="btn btnprimary">
					Submit
			</form:button>

		</form:form>


	</div>
</body>
</html>
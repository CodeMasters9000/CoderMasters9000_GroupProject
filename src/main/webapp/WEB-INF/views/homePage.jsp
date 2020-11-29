
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Reservation System</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="jumbotron vertical-center">
		<div class="container-md">

			<h1>
				Welcome to Restaurant Reservation System <br> By CodeMasters
				9000
			</h1>
			<div class="list-group">
				<table class="table">
					<thead>
						<tr>
							<th scope="col"><a
								HREF="${pageContext.request.contextPath}/tables/"
								class="list-group-item list-group-item-action list-group-item-primary">Show
									Tables</a></th>

							<th scope="col"><a
								HREF="${pageContext.request.contextPath}/editProfilePage/"
								class="list-group-item list-group-item-action list-group-item-primary">Edit
									server profile</a></th>

							<th scope="col"><a
								HREF="${pageContext.request.contextPath}/bills/"
								class="list-group-item list-group-item-action list-group-item-primary">Show
									Bills</a></th>
						</tr>
					</thead>
				</table>
			</div>
			<div>
		<a HREF="${pageContext.request.contextPath}/Logout/"
			class="btn btn-primary">Log out</a>
	</div>
		</div>
	</div>
	

</body>
</html>
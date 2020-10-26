
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Bills</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">

		<h1>Bill List</h1>
		<hr />
		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<table class="table table-striped table-bordered">

			<tr>
				<td>Bill ID</td>
				<td>Reservation ID</td>
				<td>Server ID</td>
				<td>Items Ordered</td>
				<td>itemsComped</td>
				<td>subTotal</td>
				<td>tip</td>
				<td>Total</td>
				<td>Is Paid</td>
				<td>Seating Time</td>
				<td>Leave Time</td>
			</tr>
			<c:forEach var="bill" items="${billList}">
				<tr>
					<td>${bill.billID}</td>
					<td>${bill.reservationID}</td>
					<td>${bill.serverID}</td>
					<td>${bill.itemsOrdered}</td>
					<td>${bill.itemsComped}</td>
					<td>${bill.subtotal}</td>
					<td>${bill.tip}</td>
					<td>${bill.total}</td>
					<td>${bill.isPaid}</td>
					<td>${bill.seatTime}</td>
					<td>
					<c:choose>
						<c:when test="${bill.leaveTime == '1970-01-01 01:00:00.0'}">
						Seated
						</c:when>
						<c:otherwise>
						${bill.leaveTime}
						</c:otherwise>
					</c:choose>
						</td>
				</tr>
			</c:forEach>
		</table>
	<h3>Create New Bill</h3>

		<form:form action="${pageContext.request.contextPath}/createBill/"
			cssClass="form-horizontal" method="post" modelAttribute="newBill">
			<div class="form-group">
				<label for="reservationID" class="col-md-3 controllabel">Reservation ID</label>
				<div class="col-md-9">
					<form:input type="number" path="reservationID" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="serverID" class="col-md-3 controllabel">Server ID</label>
				<div class="col-md-9">
					<form:input type="number" path="serverID" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">New Bill</form:button>
				</div>
			</div>
		</form:form>

	</div>
</body>
</html>
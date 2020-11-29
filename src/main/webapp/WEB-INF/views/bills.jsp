
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Bills</title>
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
				<td>Server Name</td>
				<td>Items Ordered</td>
				<td>itemsComped</td>
				<td>subTotal</td>
				<td>tip</td>
				<td>Total</td>
				<td>Is Paid</td>
				<td>Seating Time</td>
				<td>Leave Time</td>
				<td>Edit Bill</td>
			</tr>
			<c:forEach var="bill" items="${billList}">
				<tr>
					<td>${bill.billID}</td>
					<td>${bill.reservationID}</td>
					<td>${bill.serverID}</td>
					<c:forEach var="server" items="${serverList}">
						<c:choose>
							<c:when test="${bill.serverID == server.serverID}">
								<td>${server.serverName}</td>
							</c:when>
						</c:choose>
					</c:forEach>
					<td>${bill.itemsOrdered}</td>
					<td>${bill.itemsComped}</td>
					<td>${bill.subtotal}</td>
					<td>${bill.tip}</td>
					<td>${bill.total}</td>
					<td>${bill.isPaid}</td>
					<td>${bill.seatTime}</td>
					<td><c:choose>
							<c:when test="${bill.leaveTime.before(bill.seatTime)}">
						Seated
						</c:when>
							<c:otherwise>
						${bill.leaveTime}
						</c:otherwise>
						</c:choose></td>
					<td><a
						href="${pageContext.request.contextPath}/editBill?bill=${bill.billID}">View
							and Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		Server Directory
		<table class="table table-striped table-bordered">
			<tr>
				<td>Server ID</td>
				<td>Server Name</td>
			</tr>
			<c:forEach var="s" items="${serverList}">
				<tr>
					<td>${s.serverID}</td>
					<td>${s.serverName}</td>
				</tr>
			</c:forEach>
		</table>
		<h3>Create New Bill</h3>

		<form:form action="${pageContext.request.contextPath}/createBill/"
			cssClass="form-horizontal" method="post" modelAttribute="newBill">
			<div class="form-group">
				<label for="reservationID" class="col-md-3 controllabel">Reservation
					ID</label>
				<div class="col-md-9">
					<form:select path="reservationID" cssClass="form-control">
						<c:forEach var="res" items="${resList}">
							<option value="${res.reservationID}">${res.name}</option>
						</c:forEach>
					</form:select>
				</div>

			</div>
			<div class="form-group">
				<label for="serverID" class="col-md-3 controllabel">Server</label>

				<div class="col-md-9">
					<form:select path="serverID" cssClass="form-control">
						<c:forEach var="server" items="${serverList}">
							<option value="${server.serverID}">${server.serverName}</option>
						</c:forEach>
					</form:select>
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
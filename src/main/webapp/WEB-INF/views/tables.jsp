
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tables in the restaurant</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
	
		<h1>Tables map</h1>
		
		<hr><p>To see the schedule of the tables, click on their table ID on the chart</p><hr>
			<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<c:if test="${ dangerMessage !=null }">
			<div class="alert alert-danger" role="alert">${dangerMessage}</div>
		</c:if>
		<a href="https://ibb.co/bPVh3vQ"><img src="https://i.ibb.co/47LyfSK/floor.png" alt="floor" border="0"></a>
		<hr>
		
		<div>
		<h2>Available tables</h2>>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">TABLE ID </th>
		      <th scope="col">SEATS</th>
		      <th scope="col">CHANGE STATUS</th>
		    
		      
		      
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="table" items="${availableTables}">
		    <tr>
		      <th scope="row">00${table.tableID}</th>
		      <td>${table.seats}</td>
		      <td><a HREF="${pageContext.request.contextPath}/editTable/?id=${table.tableID}">Change Status</a></td>
		     
		      <form:form method="post" modelAttribute="table">
		      <form:input name = "tableID" path = "tableID" type="hidden" value = "${table.tableID}"></form:input>
		      </form:form>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		
		
		<h3>Unavailable Tables</h3>>
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">TABLE ID </th>
		      <th scope="col">RESERVATION ID</th>
		      <th scope="col">SERVER ID </th>
		      <th scope="col">BILL ID</th>
		      <th scope="col">SEATS</th>
		      <th scope="col">RESERVATION TIME</th>
		      <th scope="col">AVAILABLE TIME</th>
		      <th scope="col">Change Status </th>
		      
		      
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="table" items="${unavailableTables}">
		    <tr>
		      <th scope="row">${table.tableID}</th>
		      <td>${table.reservationID}</td>
		      <td>${table.serverID}</td>
		      <td>${table.billID}</td>
		      <td>${table.seats}</td>
		      <td>${table.reservationTime}</td>
		      <td>${table.availableTime}</td>
		      <td><a HREF="${pageContext.request.contextPath}/editUnavailable/?id=${table.tableID}">Change Status</a></td>
		      
		      
		      
		      
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
		</div>
	</div>	
</body>
</html>
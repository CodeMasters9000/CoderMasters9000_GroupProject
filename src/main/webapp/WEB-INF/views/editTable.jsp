<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change status</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>

<div class = "container">
	<h1>Change table id ${id} status</h1>
	
	<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<form:form action="${pageContext.request.contextPath}/editTable/"
			class="form-group" method="post" modelAttribute="table">
			<div class="form-group">
				<label for="ReservationID" class="col-md-3 controllabel">ReservationID : </label>
				<div>
					<input name="ReservationID" class="form-control" />
				</div>
				
				<div class="col-md-9">
					<select  name="serverID" class="form-control">
	
					<c:forEach var="server" items="${serverList}">
					<option value="${server.serverID}">${server.serverName}</option>
					</c:forEach>
					</select>
				
				<label for="billID" class="col-md-3 controllabel">Bill ID : </label>
				<div>
					<input name="billID" Class = "form-control" />
				</div>
				<label for="time" class="col-md-3 controllabel">Reservation Time : </label>
				
				<div>
					<input type ="time" name="time" min = "11:00" max = "23:00" />
					<input type ="date" name="date"/>
					
				</div>	
				</div>
				<div>
				<button class="btn btn-primary">
					Submit
					</button>
				</div>
		</div>
		</form:form>		
</div>
</body>
</html>
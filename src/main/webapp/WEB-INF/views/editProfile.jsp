
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
	
		<h1>Edit server profile</h1>
		
			<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<form:form action="${pageContext.request.contextPath}/editProfile/"
			cssClass="form-horizontal" method="post" modelAttribute="server">
			<div class="form-group">
				<label for="serverID" class="col-md-3 controllabel">Server</label>
				
				<div class="col-md-9">
					<form:select path="serverID" cssClass="form-control" action="${pageContext.request.contextPath}/editProfile/"
			method="post" modelAttribute="server">
					<c:forEach var="server" items="${serverList}">
					<option value="${server.serverID}">${server.serverName}</option>
					</c:forEach>
					</form:select>
					
				</div>
				
			</div>
			
			
			<div>
				<label for="serverName" class="col-md-3 controllabel">Name: </label>
				<div>
					<form:input path="serverName" cssClass = "form-control" placeholder="${serverModel.serverName}"/>
				</div>
			</div>
			
			<div>
				<label for="phoneNumber" class="col-md-3 controllabel">Phone Number: </label>
				<div>
					<form:input path="phoneNumber" cssClass = "form-control" placeholder="${serverModel.phoneNumber}"/>
				</div>
			</div>
			<form:button cssClass="btn btnprimary">
					Submit
					</form:button>
					
			<br><br>
			<a HREF="${pageContext.request.contextPath}/changePass/">Change Password</a>	
					
			</form:form>
			
			
			
			
	</div>
</body>
</html>
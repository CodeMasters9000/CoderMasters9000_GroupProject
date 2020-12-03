
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script>function initMap() {
  	  const myLatLng = { lat: 49.286025376036285, lng: -123.12225774443546 };
  	  const map = new google.maps.Map(document.getElementById("map"), {
  	    zoom: 4,
  	    center: myLatLng,
  	  });
  	  new google.maps.Marker({
  	    position: myLatLng,
  	    map,
  	    
  	  });
  	}</script>
<style>/* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
#map {
	height: 50%;
}

/* Optional: Makes the sample page fill the window. */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

h1 {
	text-align: center;
}

p {
	text-align: center;
	transform: translateY(0%);
	top: 50%;
}
</style>
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCGqtxIKlmg0SVtAjtzo9BtmIdOL3UcLKQ&callback=initMap&libraries=&v=weekly"
	defer></script>
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
	<div>
		<a HREF="${pageContext.request.contextPath}/Logout/" id="logout"
			class="btn btn-primary">Log out</a>
	</div>

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

		<p>Please find the location of the restaurant down below:</p>
	</div>

	<div id="map"></div>

</body>
</html>
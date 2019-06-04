<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
</head>
<body style="width: 450px;">
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="logo">
					<h1 style="width: 193px;">
						<a href="<c:url value='/' />"><img alt=""
							src="MAVMILES_logo.png" style="width: 173px; height: 124px;"></a>
					</h1>
					<p align="right">
						<a href="Login.jsp" target="_top"><span>Logout</span></a>
					</p>
				</div>
				<div class="content">
					<div class="menu_nav">
						<ul>
							<li><a href="viewAvailableCars.jsp" target="_top"><span>View Available Cars</span></a></li>
							<li><a href="ManagercancelRental.jsp" target="_top"><span>View Specific Rental</span></a></li>
							<li><a href="calendar.jsp" target="_top"><span>View Calendar of Rented Cars</span></a></li>
							<li><a href="ManagercancelRental.jsp" target="_top"><span>Delete a Reservation</span></a></li>
							<li><a href="AddCar.jsp" target="_top"><span>Add a Car</span></a></li>
							<li><a href="ManagerUpdateProfile" target="_top"><span>Update Profile</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
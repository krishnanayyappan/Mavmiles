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
							<li><a href="requestRentalform.jsp" target="_top"><span>Request A Rental</span></a></li>
							<li><a href="cancelreservedrentaldate.jsp" target="_top"><span>View
										Reserved Rentals</span></a></li>
							<li><a href="cancelreservedrentaldate.jsp" target="_top"><span>Cancel
										Reserved Rentals</span></a></li>
							<li><a href="ConfirmPay.jsp" target="_top"><span>Confirm/Pay
										for Reserved Rentals</span></a></li>
							<li><a href="UserUpdateProfile" target="_top"><span>Update
										Profile</span></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
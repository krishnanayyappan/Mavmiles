<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Specific Rental</title>
</head>
<body>
	<div class="header_resize">
		<div class="logo">
			<h1 style="width: 193px;">
				<a href="<c:url value='/' />"><img alt=""
					src="MAVMILES_logo.png" style="width: 173px; height: 124px;"></a>
			</h1>
			<p align="right"></p>
			<p align="right">
				<a href="managerhome.jsp" target="_top"><span>Home</span></a> <a
					href="Login.jsp" target="_top"><span>Logout</span></a>
			</p>
		</div>
	</div>
	<h4>View Specific Rental</h4>
	<form name="RentalForm" action="ViewManagerRental" method="post">
		<table>
			<tbody>
				<tr>
					<td>Rental ID</td>
					<td><input type="text" name="rentalid" value="" size="30"/></td>
				</tr>
			</tbody>
		</table>
		<br>
		<input type="reset" value="Clear" name="clear" style="width: 100px; margin= 20px;">
		<input type="submit" value="Search" name="submit" style="width: 100px; margin= 20px;" />
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Reserved Rentals</title>
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
				<a href="userhome.jsp" target="_top"><span>Home</span></a> <a
					href="Login.jsp" target="_top"><span>Logout</span></a>
			</p>
		</div>
	</div>
	<h4>View Reserved Rentals - Search</h4>
	<form name="RentalForm" action="listreservedrentals.jsp" method="post">
		<table>
			<tbody>
				<tr>
					<td>Start Date</td>
					<td><input type="text" name="name" value="" size="30"
						placeholder="MM/DD/YYYY" /></td>
				</tr>
				<tr>
					<td>End Date</td>
					<td><input type="text" name="loginID" value="" size="30" 
					placeholder="MM/DD/YYYY" /></td>
				</tr>
			</tbody>
		</table>
		<br>
		<input type="reset" value="Clear" name="clear" style="width: 100px; margin= 20px;">
		<input type="submit" value="Search" name="submit" style="width: 100px; margin= 20px;" />
	</form>

</body>
</html>
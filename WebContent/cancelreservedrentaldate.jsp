<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Reserved Rentals</title>
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
	<h4>Reserved Rentals - Search</h4>
	<form name="RentalForm" action="CancelRental" method="post">
	<input name="errMsg"  value="${RerrorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		<table>
			<tbody>
				<tr>
					<td>Rental ID</td>
					<td><input id="rentalid" type="text" name="rentalid" value="" size="30"/></td>
					<td> <input id="rentalidError" name="rentalidError"  value="${RerrorMsgs.rentalidError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
			</tbody>
		</table>
		<br>
		<input id="clear" type="reset" value="Clear" name="clear" style="width: 100px; margin= 20px;">
		<input id="submit" type="submit" value="Search" name="submit" style="width: 100px; margin= 20px;" />
	</form>

</body>
</html>
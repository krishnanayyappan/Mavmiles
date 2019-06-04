<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to MavMiles</title>
</head>
<body>
<div class="header_resize">
		<div class="logo">
			<h1 style="width: 193px;">
				<a href="<c:url value='/' />"><img alt=""
					src="MAVMILES_logo.png" style="width: 173px; height: 124px;"></a>
			</h1>
			<p align="right"></p>
		</div>
	</div>
	<h4>Registration Form</h4>
	<form name="myForm" action="Registration" method="post">
	<input name="errMsg"  value="${errorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		<table>
			<tbody>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${regModel.name}" size="40" /></td>
					<td> <input name="nameError"  value="${errorMsgs.nameError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Login ID</td>
					<td><input type="text" name="loginID" value="${regModel.loginID}" size="40" /></td>
					<td> <input name="loginIDError"  value="${errorMsgs.loginIDError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" value="${regModel.password}" size="40" /></td>
					<td> <input name="passwordError"  value="${errorMsgs.passwordError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>MAV ID</td>
					<td><input type="text" name="mavid" value="${regModel.mavid}" size="40" /></td>
					<td> <input name="mavidError"  value="${errorMsgs.mavidError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Email ID</td>
					<td><input type="text" name="email" value="${regModel.email}" size="40" /></td>
					<td> <input name="emailError"  value="${errorMsgs.emailError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td width="150px">Driving License #</td>
					<td><input type="text" name="drivingLicense" value="${regModel.drivingLicense}" size="40" /></td>
					<td> <input name="drivingLicenseError" value="${errorMsgs.drivingLicenseError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td width="150px" >Driving License Expiry Date</td>
					<td><input type="date" name="dlexp" value="${regModel.dlexp}" size="40" placeholder="YYYY-MM-DD" /></td>
					<td> <input name="dlexpError"  value="${errorMsgs.dlexpError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" value="${regModel.age}" size="40" /></td>
					<td> <input name="ageError"  value="${errorMsgs.ageError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Contact #</td>
					<td><input type="text" name="contact" value="${regModel.contact}" size="40" /></td>
					<td> <input name="contactError"  value="${errorMsgs.contactError}" type="text" style ="background-color: white; color: red; border: none; width: 500px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>User Type</td>
					<td><input type="radio" name="Type" value="User" size="40" />User
						<input type="radio" name="Type" value="Manager" size="40" />Manager
					</td>
				</tr>
			</tbody>
		</table>
		<input type="reset" value="Clear" name="clear" /> <input
			type="submit" value="Submit" name="submit" />
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<form action="Login">
		Login ID <input id="uname" type="text" name="uname" style="margin-left: 10px"> <br><br> Password<input
			id="pass" type="password" name="pass" style="margin-left: 10px"><br> <br> <input id="login" type="submit"
			value="Login" style="margin-left: 90px; width: 100px">
	</form>
	<form action="Registration.jsp">
	<input type="submit" id="register"
			value="Register" style="margin-left: 90px; width: 100px">	
	</form>
	 ${message}
</body>
</html>
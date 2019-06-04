<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
</head>
<body>

<div class="main">
		<div class="header">
			<div class="header_resize">

				<!-- TO MAKE THE URL REFERENCES WORK YOU MUST HAVE SESSION ID DISABLED IN URL - SEE WEB.XML -->

				<div class="logo">
					<h1 style="width: 193px;">
						<a href="<c:url value='/' />"><img alt=""
							src="MAVMILES_logo.png" style="width: 173px; height: 124px;"></a>
					</h1>
					<p align="right">
						<a href="adminhome.jsp" target="_top"><span>Home</span></a> <a
							href="Login.jsp" target="_top"><span>Logout</span></a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<h4>User Details</h4>
	<form name="userRevokeForm" action="RevokeThisUser" method="post">
		<table>
			<tbody>
				<tr>
					<td style="max-width: 50px;">Name</td>
					<td> <input name="name" value="${revmodel.name}" > </td>
				</tr>
				<!-- <tr>
					<td style="max-width: 50px;">Login ID</td> -->
					<td> <input type="hidden" name="loginid" value="${revmodel.loginid}" readonly> </td>
				<!-- </tr> -->
				<!-- <tr>
					<td style="max-width: 50px;">Password</td> -->
					<td> <input type="hidden" name="password" value="${revmodel.password}" > </td>
				<!-- </tr> -->
				<tr>
					<td style="max-width: 50px;">MavId</td>
					<td> <input name="mavid" value="${revmodel.mavid}" > </td>
				</tr>
				<tr>
					<td>Email</td>
					<td> <input name="email" value="${revmodel.email}" > </td>
				</tr>
				<tr>
					<td>Phone</td>
					<td> <input name="phone" value="${revmodel.phone}" > </td>
				</tr>
				<!-- <tr>
					<td>DL Number</td> -->
					<td> <input type="hidden" name="dl_number" value="${revmodel.dl_number}" > </td>
				<!-- </tr>
				<tr>
					<td>DL Expiry</td> -->
					<td> <input type="hidden" name="dl_expiry" value="${revmodel.dl_expiry}" > </td>
				</tr>
				<!-- <tr>
					<td>Status</td> -->
					<td> <input type="hidden" name="status" value="${revmodel.status}" > </td>
				<!-- </tr> -->
				
			</tbody>
		</table>

		<input type="submit" value="Revoke" name="revoke" style="margin-left: 70px; width: 200px"/>
	</form>

</body>
</html>
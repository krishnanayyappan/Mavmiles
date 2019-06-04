<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
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
	<h4>Update Profile</h4>
	<form name="userEditForm" action="EditMyProfile" method="post">
	<input id="errMsg" name="errMsg"  value="${UPerrorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		<table>
			<tbody>
				<tr>
					<td style="max-width: 50px;">Name</td>
					<td> <input id="name" name="name" value="${name}" > </td>
					<td> <input name="nameError"  value="${UPerrorMsgs.nameError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<!-- <tr>
					<td style="max-width: 50px;">Login ID</td> -->
					<td> <input id="loginid" type="hidden" name="loginid" value="${loginid}" readonly> </td>
				<!-- </tr> -->
				<tr>
					<td style="max-width: 50px;">Password</td>
					<td> <input id="password" type="password" name="password" value="${password}" > </td>
					<td> <input name="passwordError" value="${UPerrorMsgs.passwordError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td style="max-width: 50px;">MavId</td>
					<td> <input name="mavid" value="${mavid}" readonly> </td>
				</tr>
				<tr>
					<td>Email</td>
					<td> <input id="email" name="email" value="${email}" > </td>
					<td> <input name="emailError" value="${UPerrorMsgs.emailError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Phone</td>
					<td> <input id="phone" name="phone" value="${phone}" > </td>
					<td> <input name="phoneError" value="${UPerrorMsgs.phoneError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>DL Number</td>
					<td> <input id="dl_number" name="dl_number" value="${dl_number}" > </td>
					<td> <input name="dl_numberError" value="${UPerrorMsgs.dl_numberError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>DL Expiry</td>
					<td> <input id="dlexp" name="dl_expiry" value="${dl_expiry}" > </td>
					<td> <input name="dl_expiryError" value="${UPerrorMsgs.dl_expiryError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<!-- <tr>
					<td>Status</td> -->
					<td> <input type="hidden" name="status" value="${status}" > </td>
				<!-- </tr> -->
				
			</tbody>
		</table>

		<input type="submit" value="Update My Profile" name="edit" style="margin-left: 70px; width: 200px"/>
	</form>

</body>
</html>
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
	<form name="userEditForm" action="EditThisUser" method="post">
	<input name="errMsg"  value="${errorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		<table>
			<tbody>
				<tr>
					<td style="max-width: 50px;">Name</td>
					<td> <input name="name" value="${eupmodel.name}" > </td>
					<td> <input name="nameError"  value="${errorMsgs.nameError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<!-- <tr>
					<td style="max-width: 50px;">Login ID</td> -->
					<td> <input type="hidden" name="loginid" value="${eupmodel.loginid}" readonly> </td>
				<!-- </tr> -->
				<tr>
					<td style="max-width: 50px;">Password</td>
					<td> <input name="password" value="${eupmodel.password}" > </td>
					<td> <input name="passwordError"  value="${errorMsgs.passwordError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td style="max-width: 50px;">MavId</td>
					<td> <input name="mavid" value="${eupmodel.mavid}" > </td>
					<td> <input name="mavidError"  value="${errorMsgs.mavidError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Email</td>
					<td> <input name="email" value="${eupmodel.email}" > </td>
					<td> <input name="emailError"  value="${errorMsgs.emailError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Phone</td>
					<td> <input name="phone" value="${eupmodel.phone}" > </td>
					<td> <input name="contactError"  value="${errorMsgs.contactError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>DL Number</td>
					<td> <input name="dl_number" value="${eupmodel.dl_number}" > </td>
					<td> <input name="drivingLicenseError" value="${errorMsgs.drivingLicenseError}" type="text" style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>DL Expiry</td>
					<td> <input name="dl_expiry" value="${eupmodel.dl_expiry}" > </td>
					<td> <input name="dlexpError"  value="${errorMsgs.dlexpError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<!-- <tr>
					<td>Status</td> -->
					<td> <input type="hidden" name="status" value="${eupmodel.status}" > </td>
				<!-- </tr> -->
				
			</tbody>
		</table>

		<input type="submit" value="Update" name="edit" style="margin-left: 70px; width: 200px"/>
	</form>

</body>
</html>
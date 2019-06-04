<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A Car</title>
</head>
<body>
<div class="header_resize">
		<div class="logo">
			<h1 style="width: 193px;">
				<a href="<c:url value='/' />"><img alt=""
					src="MAVMILES_logo.png" style="width: 173px; height: 124px;"></a>
			</h1>
			<p align="right">
				<a href="managerhome.jsp" target="_top"><span>Home</span></a> 
				<a href="Login.jsp" target="_top"><span>Logout</span></a>
			</p>
		</div>
	</div>
	<h4>Add A Car</h4>
	<form name="Add A Car" action="AddCarController" method="post">
	<input name="errMsg"  value="${errorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		<table>
			<tbody>
				<tr>
					<td>Car Name</td>
					<td><input id="carname" type="text" name="carname" value="${addcarModel.carname}" size="40" /></td>
					<td> <input id="carnameError" name="carnameError" value="${errorMsgs.carnameError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>License ID</td>
					<td><input id="licenseid" type="text" name="licenseid" value="${addcarModel.licenseid}" size="40" /></td>
					<td> <input id="licenseidError" name="licenseidError" value="${errorMsgs.licenseidError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Weekday Rate</td>
					<td><input id="weekday_rate" type="text" name="weekday_rate" value="${addcarModel.weekday_rate}" size="40" /></td>
					<td> <input id="weekday_rateError" name="weekday_rateError" value="${errorMsgs.weekday_rateError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Weekend Rate</td>
					<td><input id="weekend_rate" type="text" name="weekend_rate" value="${addcarModel.weekend_rate}" size="40" /></td>
					<td> <input id="weekend_rateError" name="weekend_rateError" value="${errorMsgs.weekend_rateError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Week Rate</td>
					<td><input id="week_rate" type="text" name="week_rate" value="${addcarModel.week_rate}" size="40" /></td>
					<td> <input id="week_rateError" name="week_rateError" value="${errorMsgs.week_rateError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Capacity</td>
					<td><input id="capacity" type="text" name="capacity" value="${addcarModel.capacity}" size="40" /></td>
					<td> <input id="capacityError" name="capacityError" value="${errorMsgs.capacityError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>GPS Rate</td>
					<td><input id="gps" type="text" name="gps" value="${addcarModel.gps}" size="40" /></td>
					<td> <input id="gpsError" name="gpsError" value="${errorMsgs.gpsError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>OnStar Rate</td>
					<td><input id="onstar" type="text" name="onstar" value="${addcarModel.onstar}" size="40" /></td>
					<td> <input id="onstarError" name="onstarError" value="${errorMsgs.onstarError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				
				<tr>
					<td>SiriusXM Rate</td>
					<td><input id="siriusxm" type="text" name="siriusxm" value="${addcarModel.siriusxm}" size="40" /></td>
					<td> <input id="siriusxmError" name="siriusxmError" value="${errorMsgs.siriusxmError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
			</tbody>
		</table>
		<input id="clear" type="reset" value="Clear" name="clear" /> 
		<input id="submit" type="submit" value="Submit" name="submit" />
	</form>
</body>
</html>
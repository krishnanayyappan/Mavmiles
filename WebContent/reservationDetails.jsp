<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Details</title>
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
						<a href="userhome.jsp" target="_top"><span>Home</span></a> <a
							href="Login.jsp" target="_top"><span>Logout</span></a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<h4>Reservation Details</h4>
	<form name="RentalForm" action="CancelThisRental" method="post">
		<table>
			<tbody>
				<tr>
					<td style="max-width: 50px;">Rental ID</td>
					<td> <input name="rentalid" value="${rentalid}" > </td>
				</tr>
				<tr>
					<td style="max-width: 50px;">License ID</td>
					<td> <input name="licenseid" value="${licenseid}" > </td>
				</tr>
				<tr>
					<td style="max-width: 50px;">Car Name</td>
					<td> <input name="carname" value="${carname}" > </td>
				</tr>
				<tr>
					<td style="max-width: 50px;">Start Date</td>
					<td> <input name="startdate" value="${startdate}" > </td>
				</tr>
				<tr>
					<td>Start Time</td>
					<td> <input name="starttime" value="${starttime}" > </td>
				</tr>
				<tr>
					<td>End Date</td>
					<td> <input name="enddate" value="${enddate}" > </td>
				</tr>
				<tr>
					<td>End Time</td>
					<td> <input name="endtime" value="${endtime}" > </td>
				</tr>
				<tr>
					<td>Amount $</td>
					<td> <input name="amount" value="${amount}" > </td>
				</tr>
				<tr>
					<td>GPS</td>
					<td> <input name="gps" value="${gps}" > </td>
				</tr>
				<tr>
					<td>OnStar</td>
					<td> <input name="onstar" value="${onstar}" > </td>
				</tr>
				<tr>
					<td>SiriusXM</td>
					<td> <input name="siriusxm" value="${siriusxm}" > </td>
				</tr>
				<tr>
					<td style="width: 130px">Payment Status</td>
					<td> <input name="aac_member" value="${payment_status}" > </td>
				</tr>
			</tbody>
		</table>

		<input id="cancelbutton" type="submit" value="Cancel This Reservation" name="cancel" style="margin-left: 70px; width: 200px"/>
	</form>

</body>
</html>
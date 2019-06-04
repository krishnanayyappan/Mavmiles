<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request Rental</title>
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
	<h4>Request A Rental</h4>
	<form name="RentalForm" action="RequestRental" method="post">
	<input id="errMsg" name="errMsg" value="${RRerrorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		<table>
			<tbody>
				<tr>
					<td style="max-width: 50px;">Start Date</td>
					<td><input id="startdate" type="text" name="startdate" value="${reqRentalModel.startdate}" size="30" placeholder="YYYY-MM-DD" /></td>
					<td> <input id="startdateError" name="startdateError"  value="${RRerrorMsgs.startdateError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Start Time</td>
					<td><select id = "starttime" name="starttime">
							<option value="08:00">08:00</option>
							<option value="08:15">08:15</option>
							<option value="08:30">08:30</option>
							<option value="08:45">08:45</option>
							<option value="09:00">09:00</option>
							<option value="09:15">09:15</option>
							<option value="09:30">09:30</option>
							<option value="09:45">09:45</option>
							<option value="10:00">10:00</option>
							<option value="10:15">10:15</option>
							<option value="10:30">10:30</option>
							<option value="10:45">10:45</option>
							<option value="11:00">11:00</option>
							<option value="11:15">11:15</option>
							<option value="11:30">11:30</option>
							<option value="11:45">11:45</option>
							<option value="12:00">12:00</option>
							<option value="12:15">12:15</option>
							<option value="12:30">12:30</option>
							<option value="12:45">12:45</option>
							<option value="13:00">13:00</option>
							<option value="13:15">13:15</option>
							<option value="13:30">13:30</option>
							<option value="13:45">13:45</option>
							<option value="14:00">14:00</option>
							<option value="14:15">14:15</option>
							<option value="14:30">14:30</option>
							<option value="14:45">14:45</option>
							<option value="15:00">15:00</option>
							<option value="15:15">15:15</option>
							<option value="15:30">15:30</option>
							<option value="15:45">15:45</option>
							<option value="16:00">16:00</option>
							<option value="16:15">16:15</option>
							<option value="16:30">16:30</option>
							<option value="16:45">16:45</option>
							<option value="17:00">17:00</option>
							<option value="17:15">17:15</option>
							<option value="17:30">17:30</option>
							<option value="17:45">17:45</option>
							<option value="18:00">18:00</option>
							<option value="18:15">18:15</option>
							<option value="18:30">18:30</option>
							<option value="18:45">18:45</option>
							<option value="19:00">19:00</option>
							<option value="19:15">19:15</option>
							<option value="19:30">19:30</option>
							<option value="19:45">19:45</option>
							<option value="20:00">20:00</option>
					</select></td>
					<td><input id="starttimeError" name="starttimeError" value="${RRerrorMsgs.starttimeError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"></td>
				</tr>
				<tr>
					<td>End Date</td>
					<td><input id="enddate" type="text" name="enddate" value="${reqRentalModel.enddate}" size="30" placeholder="YYYY-MM-DD" /></td>
					<td> <input id="enddateError" name="enddateError"  value="${RRerrorMsgs.enddateError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>End Time</td>
					<td><select id="endtime" name="endtime">
							<option value="08:00">08:00</option>
							<option value="08:15">08:15</option>
							<option value="08:30">08:30</option>
							<option value="08:45">08:45</option>
							<option value="09:00">09:00</option>
							<option value="09:15">09:15</option>
							<option value="09:30">09:30</option>
							<option value="09:45">09:45</option>
							<option value="10:00">10:00</option>
							<option value="10:15">10:15</option>
							<option value="10:30">10:30</option>
							<option value="10:45">10:45</option>
							<option value="11:00">11:00</option>
							<option value="11:15">11:15</option>
							<option value="11:30">11:30</option>
							<option value="11:45">11:45</option>
							<option value="12:00">12:00</option>
							<option value="12:15">12:15</option>
							<option value="12:30">12:30</option>
							<option value="12:45">12:45</option>
							<option value="13:00">13:00</option>
							<option value="13:15">13:15</option>
							<option value="13:30">13:30</option>
							<option value="13:45">13:45</option>
							<option value="14:00">14:00</option>
							<option value="14:15">14:15</option>
							<option value="14:30">14:30</option>
							<option value="14:45">14:45</option>
							<option value="15:00">15:00</option>
							<option value="15:15">15:15</option>
							<option value="15:30">15:30</option>
							<option value="15:45">15:45</option>
							<option value="16:00">16:00</option>
							<option value="16:15">16:15</option>
							<option value="16:30">16:30</option>
							<option value="16:45">16:45</option>
							<option value="17:00">17:00</option>
							<option value="17:15">17:15</option>
							<option value="17:30">17:30</option>
							<option value="17:45">17:45</option>
							<option value="18:00">18:00</option>
							<option value="18:15">18:15</option>
							<option value="18:30">18:30</option>
							<option value="18:45">18:45</option>
							<option value="19:00">19:00</option>
							<option value="19:15">19:15</option>
							<option value="19:30">19:30</option>
							<option value="19:45">19:45</option>
							<option value="20:00">20:00</option>
					</select></td>
					<td><input id="endtimeError" name="endtimeError" value="${RRerrorMsgs.endtimeError}" type="text"  style ="background-color: white; color: red; border: none; width: 500px"   disabled="disabled" maxlength="60"></td>
				</tr>
				<tr>
					<td>Occupants</td>
					<td><select id="occupants" name="occupants">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
					</select></td>
				</tr>
				<tr>
					<td>Extras</td>
					<td><input id="gps" type="checkbox" name="gps" value="Y" size="30" />GPS
						<input id="onstar" type="checkbox" name="onstar" value="Y" size="30" />OnStar
						<input id="siriusxm" type="checkbox" name="siriusxm" value="Y" size="30" />SiriusXM
					</td>
				</tr>
				<tr>
					<td style="width: 130px">Arlington AutoClub Member</td>
					<td><input id="aac" type="checkbox" name="aac" value="Y" size="30" />Yes
					</td>
					</tr>
			</tbody>
		</table>

		<input id="reset" type="reset" value="Clear" name="clear" style="width: 103px;">
		<input id="submit" type="submit" value="Submit" name="submit" style="width: 94px;" />
	</form>
	
	<div class="mainbar"><div class="submb"></div></div>
	
       <table class="myTable" border="1"> 
			<tr class="myTableRow"> 
				<th class="myTableHead"  width="200" align="center">Car Name</th>
				<th class="myTableHead"  width="50" align="center">Capacity</th> 
				<th class="myTableHead"  width="100" align="center">Total Cost ($)</th>
				<th class="myTableHead"  width="100" align="center"> </th>
			</tr>
			
 		<c:forEach items="${CARS}" var="item">
			<tr class="myTableRow" onclick="Trial?page=${item.carname};">
			<td class="myTableCell"  width="200" align="center"><c:out value="${item.carname}" /></td>
			<td class="myTableCell"  width="50" align="center"><c:out value="${item.capacity}" /></td>
			<td class="myTableCell"  width="100" align="center"><c:out value="${item.amount_str}" /></td>
			<td  width="100" align="center"><a href="BookRental?page=${item.licenseid}"><c:out value="Book Now" /></a></td>
			</tr>
		</c:forEach>
 </table>
</body>
</html>
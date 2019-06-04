<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Available Cars</title>
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
						<a href="managerhome.jsp" target="_top"><span>Home</span></a> <a
							href="Login.jsp" target="_top"><span>Logout</span></a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<h4>View Available Cars - Search</h4>
	<form name="AvailableCarsForm" action="ViewAvailableCars" method="post">
	<input name="errMsg"  value="${verrorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		<table>
			<tbody>
				<tr>
					<td style="max-width: 50px;">Start Date</td>
					<td><input type="text" id="startdate" name="startdate"  value="${VACModel.startdate}" size="30"
						placeholder="YYYY-MM-DD" /></td>
						<td> <input name="startdateError"  value="${verrorMsgs.startdateError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				
				<tr>
					<td>End Date</td>
					<td><input type="text" name="enddate" id="enddate" value="${VACModel.enddate}" size="30"
						placeholder="YYYY-MM-DD" /></td>
						<td> <input name="enddateError"  value="${verrorMsgs.enddateError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				
			</tbody>
		</table>

		<input type="reset" value="Clear" name="clear" style="width: 103px;">
		<input type="submit" id="submit" value="Submit" name="submit" style="width: 94px;" />
	</form>
	
	<div class="mainbar"><div class="submb"></div></div>
	
       <table class="myTable" border="1"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" width="200" align="center">Car Name</th>
				<th class="myTableHead" width="50" align="center">Capacity</th> 
			</tr>
			
 		<c:forEach items="${VAC}" var="item">
			<tr class="myTableRow" onclick="Trial?page=${item.carname};">
				<td class="myTableCell" width="200" align="center"><c:out value="${item.carname}" /></td>
				<td class="myTableCell" width="50" align="center"><c:out value="${item.capacity}" /></td>
			</tr>
		</c:forEach>
 </table>
</body>
</html>
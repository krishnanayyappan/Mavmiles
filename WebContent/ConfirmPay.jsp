<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm and Pay</title>
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
	<h4>Confirm Reservation and Pay</h4>
	<form name="RentalForm" action="ConfirmPaymentController" method="post">
	<input name="errMsg"  value="${confPayerrorMsgs.errorMsg}" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
		<table>
			<tbody>
				<tr>
					<td style="max-width: 100px;">Rental-ID</td>
					<td><input id="rentalid" type="text" name="rentalid" value="${confPayModel.rentalid}" size="30" /></td>
					<td><input name="rentalidError"
						value="${confPayerrorMsgs.rentalidError}" type="text"
						style="background-color: white; color: red; border: none; width: 800px"
						disabled="disabled" maxlength="60"></td>
				</tr>
				<tr>
					<td style="max-width: 50px;">Credit Card Number</td>
					<td><input id="cardNumber" type="text" name="cardNumber" value="${confPayModel.cardNumber}" size="30"></td>
					<td><input name="cardNumberError"
						value="${confPayerrorMsgs.cardNumberError}" type="text"
						style="background-color: white; color: red; border: none; width: 800px"
						disabled="disabled" maxlength="60"></td>
				</tr>
				<tr>
					<td>Expiry Date</td>
					<td><input id="expiry" type="text" name="expiry" value="${confPayModel.expiry}" size="10"
						placeholder="MM-YY"></td>
					<td><input name="expiryError" value="${confPayerrorMsgs.expiryError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>CVV</td>
					<td><input id="cvv" type="password" name="cvv" value="${confPayModel.cvv}" size="4" /></td>
					<td><input name="cvvError" value="${confPayerrorMsgs.cvvError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td style="max-width: 50px;">Name on Card</td>
					<td><input id="nameOnCard" type="text" name="nameOnCard" value="${confPayModel.nameOnCard}" size="30" /></td>
					<td><input name="nameOnCardError" value="${confPayerrorMsgs.nameOnCardError}" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				</tr>
			</tbody>
		</table>

		<input id="pay" type="submit" value="Pay" name="pay"
			style="margin-left: 130px; width: 200px">
	</form>
</body>
</html>
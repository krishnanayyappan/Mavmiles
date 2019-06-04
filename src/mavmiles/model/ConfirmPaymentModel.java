/*package mavmiles.model;

public class ConfirmPaymentModel {

}
*/
package mavmiles.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class LoginModel
 */
@WebServlet("/ConfirmPaymentModel")
public class ConfirmPaymentModel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String rentalid = "";
	private static String cardNumber = "";
	private static String expiry = "";
	private static String cvv = "";
	private static String nameOnCard = "";

	public void setrentalid(String rentalid) {
		this.rentalid = rentalid;
	}

	public void setcardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setexpiry(String expiry) {
		this.expiry = expiry;
	}

	public void setcvv(String cvv) {
		this.cvv = cvv;
	}

	public void setnameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getrentalid() {
		return rentalid;
	}

	public String getcardNumber() {
		return cardNumber;
	}

	public String getexpiry() {
		return expiry;
	}

	public String getcvv() {
		return cvv;
	}

	public String getnameOnCard() {
		return nameOnCard;
	}

	public ConfirmPaymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setRental(String rentalid2, String cardNumber2, String expiry2, String cvv2, String nameOnCard2,
			String loginid) {
		setrentalid(rentalid2);
		setcardNumber(cardNumber2);
		setexpiry(expiry2);
		setcvv(cvv2);
		setnameOnCard(nameOnCard2);
	}

	public void validatePayment(ConfirmPaymentModel confPayModel, ConfirmPaymentErrorMsgs confPayerrorMsgs)
			throws java.text.ParseException {

		confPayerrorMsgs.setrentalidError(validaterentalid(confPayModel.getrentalid()));
		confPayerrorMsgs.setcardNumberError(validatecardNumber(confPayModel.getcardNumber()));
		confPayerrorMsgs.setexpiryError(validateexpiry(confPayModel.getexpiry()));
		confPayerrorMsgs.setcvvError(validatecvv(confPayModel.getcvv()));
		confPayerrorMsgs.setnameOnCardError(validatenameOnCard(confPayModel.getnameOnCard()));

		confPayerrorMsgs.setErrorMsg();

	}

	private String validatenameOnCard(String nameOnCard) {
		String result = "";
		if (nameOnCard.equals("")) {
			result = "Name cannot be blank";
		} else {
			if (stringContainsNumber(nameOnCard)) {
				result = "Name cannot contain numbers";
			}
		}
		return result;
	}

	private String validaterentalid(String rentalID) {
		String result = "";
		if (rentalID.equals("")) {
			result = "Rental ID cannot be blank";
		}
		return result;
	}

	private String validatecardNumber(String cardNumber) {
		String result = "";
		if (cardNumber.equals("")) {
			result = "Credit Card Number cannot be blank";
		} else {
			if ((cardNumber.length() < 15) || (cardNumber.length() > 16)) {
				result = "Credit Card Number should be 15 or 16 digits";
			}
		}
		return result;
	}

	private String validateexpiry(String expiry) {
		String result = "";
		int exp_month;
//		expiry.replaceAll("\\s+","");
		if (expiry.equals("")) {
			result = "Credit Card Expiry Date cannot be blank";
		} 

		else if (expiry.length() < 5 || expiry.length() > 5) {
			result = "Invalid date format";
		}
		else {
			java.util.Date valid_date;
			try {
				String month = expiry.substring(0, 2);
				valid_date = new SimpleDateFormat("MM-yy").parse(expiry);
				DateFormat formatter = new SimpleDateFormat("MM-yy");
				formatter.setLenient(false);
				Date today = new Date();
				Date current_date = formatter.parse(formatter.format(today));
				exp_month = Integer.parseInt(month);
				// good format
				
				if (valid_date.before(current_date)) {
					result = "Your Credit Card has expired!";
				}
				else if(exp_month>12) {
					result = "Invalid value for month";
				}
			} catch (java.text.ParseException e) {
				result = "Invalid date format";
				e.printStackTrace();
			}
		} 
		return result;
	}


	private String validatecvv(String cvv) {
		String result = "";
		if (cvv.equals("")) {
			result = "CVV cannot be blank";
		} else {
			if ((cvv.length() < 3) || (cvv.length() > 4)) {
				result = "CVV should be 3 or 4 digits";
			}
		}
		return result;
	}

	public boolean stringContainsNumber(String s) {
		return Pattern.compile("[0-9]").matcher(s).find();
	}

}

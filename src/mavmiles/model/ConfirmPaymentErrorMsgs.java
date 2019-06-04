package mavmiles.model;

public class ConfirmPaymentErrorMsgs {

	private String errorMsg;
	private String rentalidError;
	private String cardNumberError;
	private String expiryError;
	private String cvvError;
	private String nameOnCardError;
	
	public ConfirmPaymentErrorMsgs () {
		this.errorMsg="";
		this.rentalidError="";
		this.cardNumberError="";
		this.expiryError = "";
		this.cvvError="";
		this.nameOnCardError="";
	}
	
	public void setrentalidError(String rentalidError) {
		this.rentalidError = rentalidError;
	}
	
	public String getrentalidError() {
		return rentalidError;
	}
	
	public void setcardNumberError(String cardNumberError) {
		this.cardNumberError = cardNumberError;
	}
	
	public String getcardNumberError() {
		return cardNumberError;
	}
	
	public void setexpiryError(String expiryError) {
		this.expiryError = expiryError;
	}
	
	public String getexpiryError() {
		return expiryError;
	}
	
	public void setcvvError(String cvvError) {
		this.cvvError = cvvError;
	}
	
	public String getcvvError() {
		return cvvError;
	}
	
	public void setnameOnCardError(String nameOnCardError) {
		this.nameOnCardError = nameOnCardError;
	}
	
	public String getnameOnCardError() {
		return nameOnCardError;
	}
	
	public void setErrorMsg() {
		
		if ( !rentalidError.equals("") || !cardNumberError.equals("") || !expiryError.equals("") || !cvvError.equals("") || !nameOnCardError.equals("") ) {
			this.errorMsg="Please correct the following errors";
		}
			
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
}

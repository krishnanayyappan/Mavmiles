package mavmiles.model;

public class CancelRentalErrorMsgs {

	private String errorMsg;
	private String rentalidError;

	public CancelRentalErrorMsgs() {
		this.errorMsg = "";
		this.rentalidError = "";
	}

	public void setrentalidError(String rentalidError) {
		this.rentalidError = rentalidError;
	}

	// Get methods
	public String getrentalidError() {
		return rentalidError;
	}

	public void setErrorMsg() {

		if (!rentalidError.equals("")) {
			this.errorMsg = "Please correct the following errors";
		}

	}

	public String getErrorMsg() {
		return errorMsg;
	}

}

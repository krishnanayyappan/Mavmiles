package mavmiles.model;

public class RequestRentalErrorMsgs {
	
	private String errorMsg;
	private String startdateError;
	private String enddateError;
	private String starttimeError;
	private String endtimeError;
//	private String revokeError;
	
	public RequestRentalErrorMsgs () {
		this.errorMsg="";
		this.startdateError="";
		this.enddateError="";
		this.starttimeError="";
		this.endtimeError="";
//		this.revokeError="";
	}
	
	public void setstartdateError(String startdateError) {
		this.startdateError = startdateError;
	}
	
	public String getstartdateError() {
		return startdateError;
	}
	
	public void setenddateError(String enddateError) {
		this.enddateError = enddateError;
	}
	
	public String getenddateError() {
		return enddateError;
	}
	
	public void setstarttimeError(String starttimeError) {
		this.starttimeError = starttimeError;
	}
	
	public String getstarttimeError() {
		return starttimeError;
	}
	
	public void setendtimeError(String endtimeError) {
		this.endtimeError = endtimeError;
	}
	
	public String getendtimeError() {
		return endtimeError;
	}
	
	/*public void setrevokeError(String revokeError) {
		this.revokeError = revokeError;
	}
	
	public String getrevokeError() {
		return revokeError;
	}*/
	
	
	public void setErrorMsg() {
		
//		if ( !startdateError.equals("") || !enddateError.equals("") || !starttimeError.equals("") || !endtimeError.equals("") || !revokeError.equals("") ) {
		if ( !startdateError.equals("") || !enddateError.equals("") || !starttimeError.equals("") || !endtimeError.equals("") ) {
			this.errorMsg="Please correct the following errors";
		}
			
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
}

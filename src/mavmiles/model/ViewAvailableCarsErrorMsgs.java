package mavmiles.model;

public class ViewAvailableCarsErrorMsgs {
	
	private String errorMsg;
	private String startdateError;
	private String enddateError;
	
	
	public ViewAvailableCarsErrorMsgs () {
		this.errorMsg="";
		this.startdateError="";
		this.enddateError="";
		
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
	
	
	
	public void setErrorMsg() {
		
		if ( !startdateError.equals("") || !enddateError.equals("") ) {
			this.errorMsg="Please correct the following errors";
		}
			
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}

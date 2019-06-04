package mavmiles.model;

public class EditUserProfileErrorMsgs {
	private String errorMsg;
	private String loginIDError;
	
	public EditUserProfileErrorMsgs () {
		this.errorMsg="";
		this.loginIDError="";
	}

	public void setloginIDerror(String loginIDError) {
		this.loginIDError = loginIDError;
	}
	
	public String getloginIDError() {
		return loginIDError;
	}
	
	public void setErrorMsg() {
		if ( !loginIDError.equals("")) {
			this.errorMsg="Please correct the following errors";
		}
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}

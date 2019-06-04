package mavmiles.model;

public class RevokeUserErrorMsgs {

	
	private String errorMsg;
	
	private String loginIDError;
	
	
	public RevokeUserErrorMsgs () {
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
		
//		System.out.println("loginIDError = " + loginIDError);
		if ( !loginIDError.equals("")) {
			this.errorMsg="Please correct the following errors";
		}
			
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}

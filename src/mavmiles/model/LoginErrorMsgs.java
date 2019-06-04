package mavmiles.model;

public class LoginErrorMsgs {
	
	private String errorMsg;
	private String LoginIDerror;
	
	public LoginErrorMsgs () {
		this.errorMsg="";
		this.LoginIDerror="";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String action) {
//		if (action.equals("saveCompany")) {
//			if (!LoginIDerror.equals("") || !companyNameError.equals("") || !phoneError.equals("") || !emailError.equals(""))
				this.errorMsg="Invalid credentials!";
//		}			
	}
	public String getLoginIDerror() {
		return LoginIDerror;
	}
	public void setLoginIDerror(String LoginIDerror) {
		this.LoginIDerror = LoginIDerror;
	}

}

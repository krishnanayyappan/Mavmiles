package mavmiles.model;

public class RegistrationErrorMsgs {
	
	private String errorMsg;
	private String nameError;
	private String loginIDError;
	private String passwordError;
	private String mavidError;
	private String emailError;
	private String drivingLicenseError;
	private String dlexpError;
	private String contactError;
	private String ageError;
	
	public RegistrationErrorMsgs () {
		this.errorMsg="";
		this.nameError="";
		this.loginIDError="";
		this.passwordError = "";
		this.mavidError="";
		this.emailError="";
		this.drivingLicenseError="";
		this.dlexpError="";
		this.contactError="";
		this.ageError="";
	}
	
	public void setNameerror(String nameError) {
		this.nameError = nameError;
	}
	
	public String getnameError() {
		return nameError;
	}
	
	public void setloginIDerror(String loginIDError) {
		this.loginIDError = loginIDError;
	}
	
	public String getloginIDError() {
		return loginIDError;
	}
	
	public void setpassworderror(String passwordError) {
		this.passwordError = passwordError;
	}
	
	public String getpasswordError() {
		return passwordError;
	}
	
	public void setmavidError(String mavidError) {
		this.mavidError = mavidError;
	}
	
	public String getmavidError() {
		return mavidError;
	}
	
	public void setemailError(String emailError) {
		this.emailError = emailError;
	}
	
	public String getemailError() {
		return emailError;
	}
	
	public void setdrivingLicenseError(String drivingLicenseError) {
		this.drivingLicenseError = drivingLicenseError;
	}
	
	public String getdrivingLicenseError() {
		return drivingLicenseError;
	}
	
	public void setdlexpError(String dlexpError) {
		this.dlexpError = dlexpError;
	}
	
	public String getdlexpError() {
		return dlexpError;
	}
	
	public void setcontactError(String contactError) {
		this.contactError = contactError;
	}
	
	public String getcontactError() {
		return contactError;
	}
	
	public void setageError(String ageError) {
//		System.out.println("setageError");
		this.ageError = ageError;
	}
	
	public String getageError() {
		return ageError;
	}
	
	public void setErrorMsg() {
		if ( !nameError.equals("") || !loginIDError.equals("") || !passwordError.equals("") || !mavidError.equals("") || !emailError.equals("") || !drivingLicenseError.equals("") || !dlexpError.equals("") || !ageError.equals("") || !contactError.equals("") ) {
			this.errorMsg="Please correct the following errors";
		}		
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}

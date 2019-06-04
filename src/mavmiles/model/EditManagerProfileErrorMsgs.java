package mavmiles.model;

public class EditManagerProfileErrorMsgs {
	
	private String errorMsg;
	private String nameError;
	private String loginIDError;
	private String passwordError;
	private String mavidError;
	private String emailError;
	private String dl_numberError;
	private String dl_expiryError;
	private String phoneError;
	private String ageError;
	
	public EditManagerProfileErrorMsgs () {
		this.errorMsg="";
		this.nameError="";
		this.loginIDError="";
		this.passwordError = "";
		this.mavidError="";
		this.emailError="";
		this.dl_numberError="";
		this.dl_expiryError="";
		this.phoneError="";
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
	
	public void setdl_numberError(String dl_numberError) {
		this.dl_numberError = dl_numberError;
	}
	
	public String getdl_numberError() {
		return dl_numberError;
	}
	
	public void setdl_expiryError(String dl_expiryError) {
		this.dl_expiryError = dl_expiryError;
	}
	
	public String getdl_expiryError() {
		return dl_expiryError;
	}
	
	public void setphoneError(String phoneError) {
		this.phoneError = phoneError;
	}
	
	public String getphoneError() {
		return phoneError;
	}
	
	public void setageError(String ageError) {
		this.ageError = ageError;
	}
	
	public String getageError() {
		return ageError;
	}
	
	public void setErrorMsg() {
		
		if ( !nameError.equals("") || !loginIDError.equals("") || !passwordError.equals("") || !mavidError.equals("") || !emailError.equals("") || !dl_numberError.equals("") || !ageError.equals("") || !phoneError.equals("") ) {
			this.errorMsg="Please correct the following errors";
		}
			
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

}
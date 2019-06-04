package mavmiles.model;

public class AddCarErrorMsgs {

	
	private String errorMsg;
	private String carnameError;
	private String licenseidError;
	private String capacityError;
	private String weekday_rateError;
	private String weekend_rateError;
	private String week_rateError;
	private String onstarError;
	private String gpsError;
	private String siriusxmError;
	
	public AddCarErrorMsgs () {
		this.errorMsg = "";
		this.carnameError = "";
		this.licenseidError = "";
		this.capacityError = "";
		this.weekday_rateError = "";
		this.weekend_rateError = "";
		this.week_rateError = "";
		this.onstarError = "";
		this.gpsError = "";
		this.siriusxmError = "";
	}
	
	

	
	public void setcarnameError(String carnameError) {
		System.out.println("setcarnameError =" + carnameError);
		this.carnameError = carnameError;
	}
	
	public void setlicenseidError(String licenseidError) {
		this.licenseidError = licenseidError;
	}
	
	public void setcapacityError(String capacityError) {
		this.capacityError = capacityError;
	}
	
	public void setweekday_rateError(String weekday_rateError) {
		this.weekday_rateError = weekday_rateError;
	}
	
	public void setweekend_rateError(String weekend_rateError) {
		this.weekend_rateError = weekend_rateError;
	}
	
	public void setweek_rateError(String week_rateError) {
		this.week_rateError = week_rateError;
	}
	
	public void setonstarError(String onstarError) {
		this.onstarError = onstarError;
	}
	
	public void setgpsError(String gpsError) {
		this.gpsError = gpsError;
	}
	
	public void setsiriusxm(String siriusxmError) {
		this.siriusxmError = siriusxmError;
	}
	
	

	
	// Get methods
	public String getcarnameError() {
		//System.out.println("Model GET name =" + carname);
		return carnameError;
	}
	
	public String getlicenseidError() {
		return licenseidError;
	}
	
	public String getcapacityError() {
		return capacityError;
	}
	
	public String getweekday_rateError() {
		return weekday_rateError;
	}
	
	public String getweekend_rateError() {
		return weekend_rateError;
	}
	
	public String getweek_rateError() {
		return week_rateError;
	}
	
	public String getonstarError() {
		return onstarError;
	}
	
	public String getgpsError() {
		return gpsError;
	}
	
	public String getsiriusxmError() {
		return siriusxmError;
	}
	

	
	
	
 public void setErrorMsg() {
		
		//if ( !carnameError.equals("") || !licenseidError.equals("") || !capacityError.equals("") || !weekday_rateError.equals("") || !weekend_rateError.equals("") || !week_rateError.equals("") || !onstarError.equals("") || !gpsError.equals("") || !siriusxmError.equals("") ) {
	 System.out.println("errorMessage for carname blank =" + carnameError + ";");
//	 	if ( !carnameError.equals("")){
		if (!carnameError.equals("") || !licenseidError.equals("") || !capacityError.equals("")
				|| !weekday_rateError.equals("") || !weekend_rateError.equals("") || !week_rateError.equals("")
				|| !onstarError.equals("") || !gpsError.equals("") || !siriusxmError.equals("")) {
			System.out.println("errorMessage printing");
			this.errorMsg = "Please correct the following errors";
		}
			
	}
	
	public String getErrorMsg() {
		System.out.println("errorMessage getting");
		return errorMsg;
	}

       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AddCarModel() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
}

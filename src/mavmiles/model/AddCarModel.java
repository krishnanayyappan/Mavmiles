package mavmiles.model;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class AddCarModel
 */
@WebServlet("/AddCarModel")
public class AddCarModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String carname = "";
	private static String licenseid = "";
	private static int capacity = 0;
	private static float weekday_rate = 0;
	private static float weekend_rate = 0;
	private static float week_rate = 0;
	private static float onstar = 0;
	private static float gps = 0;
	private static float siriusxm = 0;
	
	public void setcarname(String carname) {
		this.carname = carname;
	}
	
	public void setlicenseid(String licenseid) {
		this.licenseid = licenseid;
	}
	
	public void setcapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void setweekday_rate(float weekday_rate) {
		this.weekday_rate = weekday_rate;
	}
	
	public void setweekend_rate(float weekend_rate) {
		this.weekend_rate = weekend_rate;
	}
	
	public void setweek_rate(float week_rate) {
		this.week_rate = week_rate;
	}
	
	public void setonstar(float onstar) {
		this.onstar = onstar;
	}
	
	public void setgps(float gps) {
		this.gps = gps;
	}
	
	public void setsiriusxm(float siriusxm) {
		this.siriusxm = siriusxm;
	}
		
	public void setAddCar(String carname2, String licenseid2, int capacity2, float weekday_rate2, float weekend_rate2,
			float week_rate2, float onstar2, float gps2, float siriusxm2) {
		setcarname(carname2);
		setlicenseid(licenseid2);
		setcapacity(capacity2);
		setweekday_rate(weekday_rate2);
		setweekend_rate(weekend_rate2);
		setweek_rate(week_rate2);
		setonstar(onstar2);
		setgps(gps2);
		setsiriusxm(siriusxm2);
	}
	
	// Get methods
	public String getcarname() {
		return carname;
	}
	
	public String getlicenseid() {
		return licenseid;
	}
	
	public int getcapacity() {
		return capacity;
	}
	
	public float getweekday_rate() {
		return weekday_rate;
	}
	
	public float getweekend_rate() {
		return weekend_rate;
	}
	
	public float getweek_rate() {
		return week_rate;
	}
	
	public float getonstar() {
		return onstar;
	}
	
	public float getgps() {
		return gps;
	}
	
	public float getsiriusxm() {
		return siriusxm;
	}
	
	public void validateAddCar(AddCarModel addcarModel, AddCarErrorMsgs cerrorMsgs) {
		
		cerrorMsgs.setcarnameError(validatecarname(addcarModel.getcarname()));
		cerrorMsgs.setlicenseidError(validatelicenseid(addcarModel.getlicenseid()));
		cerrorMsgs.setcapacityError(validatecapacity(addcarModel.getcapacity()));
		cerrorMsgs.setweekday_rateError(validateweekday_rate(addcarModel.getweekday_rate()));
		cerrorMsgs.setweekend_rateError(validateweekend_rate(addcarModel.getweekend_rate()));
		cerrorMsgs.setweek_rateError(validateweek_rate(addcarModel.getweek_rate()));
		cerrorMsgs.setonstarError(validateonstar(addcarModel.getonstar()));
		cerrorMsgs.setgpsError(validategps(addcarModel.getgps()));
		cerrorMsgs.setsiriusxm(validatesiriusxm(addcarModel.getsiriusxm()));
		
		cerrorMsgs.setErrorMsg();	
	}
 
	public String validatecarname(String carname3) {
		String result="";
		if (carname3.equals("")) {
			result="Car Name cannot be blank";
		} 
		return result;
	}
	
	
	public String validatelicenseid(String licenseid) {
		String result = "";
		if (licenseid.equals("")) {
			result = "License ID cannot be blank";
		} else {
			if (!(licenseid.length() == 7)){
				result = "License ID must be 7 characters";
		}
		}

		return result;
	}

	
	public String validatecapacity(int capacity) {
		String result = "";
		if ( capacity > 9 || capacity <= 0 ) {
			result="Capacity should be in the range 1 to 9";
		} 
		return result;
	}
	
	public String validateweekday_rate(float weekday_rate) {
		String result = "";
		if (weekday_rate <= 0) {
			result="Weekday Rate should be greater than zero";
		} 
		return result;
	}
	
	
	public String validateweekend_rate(float weekend_rate) {
		String result = "";
		if (weekend_rate <= 0) {
			result="Weekend Rate should be greater than zero";
		} 
		return result;
	}
	
	public String validateweek_rate(float week_rate) {
		String result = "";
		if (week_rate <= 0) {
			result="Week Rate should be greater than zero";
		} 
		return result;
	}
	
	public String validateonstar(float onstar) {
		String result = "";
		if (onstar <= 0) {
			result="OnStar Rate should be greater than zero";
		} 
		return result;
	}
	
	public String validategps(float gps) {
		String result = "";
		if (gps <= 0) {
			result="GPS Rate should be greater than zero";
		} 
		return result;
	}

	public String validatesiriusxm(float siriusxm) {
		String result = "";
		if (siriusxm <= 0) {
			result="SiriusXM Rate should be greater than zero";
		} 
		return result;
	}

    public AddCarModel() {
        super();
        // TODO Auto-generated constructor stub
    }

}

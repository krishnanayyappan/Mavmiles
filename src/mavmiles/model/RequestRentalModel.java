package mavmiles.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@WebServlet("/RequestRentalModel")
public class RequestRentalModel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String startdate = "";
	private static String starttime = "";
	private static String enddate = "";
	private static String endtime = "";
	private static int occupants = 0;
	private static String gps = "";
	private static String onstar = "";
	private static String siriusxm = "";
	private static String aac = "";

	private static long TotalDays = 0;
	private static long working_days = 0;
	private static long weekend_days = 0;

	public void setstartdate(String startdate) {
		this.startdate = startdate;
	}

	public void setstarttime(String starttime) {
		this.starttime = starttime;
	}

	public void setenddate(String enddate) {
		this.enddate = enddate;
	}

	public void setendtime(String endtime) {
		this.endtime = endtime;
	}

	public void setoccupants(int occupants) {
		this.occupants = occupants;
	}

	public void setgps(String gps) {
		this.gps = gps;
	}

	public void setonstar(String onstar) {
		this.onstar = onstar;
	}

	public void setsiriusxm(String siriusxm) {
		this.siriusxm = siriusxm;
	}

	public void setaac(String aac) {
		this.aac = aac;
	}

	public void setTotalDays(long TotalDays) {
		this.TotalDays = TotalDays;
	}

	public void setworking_days(long working_days) {
		this.working_days = working_days;
	}

	public void setweekend_days(long weekend_days) {
		this.weekend_days = weekend_days;
	}

	public void setRental(String startdate2, String starttime2, String enddate2, String endtime2, int occupants2,
			String gps2, String onstar2, String siriusxm2, String aac2) {
		setstartdate(startdate2);
		setstarttime(starttime2);
		setenddate(enddate2);
		setendtime(endtime2);
		setoccupants(occupants2);
		setgps(gps2);
		setonstar(onstar2);
		setsiriusxm(siriusxm2);
		setaac(aac2);
	}

	// Get methods
	public String getstartdate() {
		return startdate;
	}

	public String getstarttime() {
		return starttime;
	}

	public String getenddate() {
		return enddate;
	}

	public String getendtime() {
		return endtime;
	}

	public int getoccupants() {
		return occupants;
	}

	public String getgps() {
		return gps;
	}

	public String getonstar() {
		return onstar;
	}

	public String getsiriusxm() {
		return siriusxm;
	}

	public String getaac() {
		return aac;
	}

	public long getTotalDays() {
		return TotalDays;
	}

	public long getworking_days() {
		return working_days;
	}

	public long getweekend_days() {
		return weekend_days;
	}

	// DB storage values

	private String carname = "";
	private String licenseid = "";
	private int capacity = 0;
	private float weekday_rate = 0;
	private float weekend_rate = 0;
	private float week_rate = 0;
	private float gps_rate = 0;
	private float onstar_rate = 0;
	private float siriusxm_rate = 0;

	private float amount = 0;
	private String amount_str = "";
	private static int age = 0;

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

	public void setgps_rate(float gps_rate) {
		this.gps_rate = gps_rate;
	}

	public void setonstar_rate(float onstar_rate) {
		this.onstar_rate = onstar_rate;
	}

	public void setsiriusxm_rate(float siriusxm_rate) {
		this.siriusxm_rate = siriusxm_rate;
	}

	public void setamount(float amount) {
		this.amount = amount;
	}

	public void setamount_str(String amount_str) {
		this.amount_str = amount_str;
	}

	@SuppressWarnings("static-access")
	public void setage(int age) {
		this.age = age;
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

	public float getgps_rate() {
		return gps_rate;
	}

	public float getonstar_rate() {
		return onstar_rate;
	}

	public float getsiriusxm_rate() {
		return siriusxm_rate;
	}

	public float getamount() {
		return amount;
	}

	public String getamount_str() {
		return amount_str;
	}

	public int getage() {
		return age;
	}

	public void validateRental(RequestRentalModel reqRentalModel, RequestRentalErrorMsgs RRerrorMsgs)
			throws java.text.ParseException {

		try {
			RRerrorMsgs.setstartdateError(validatestartdate(reqRentalModel.getstartdate()));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		try {
			RRerrorMsgs.setenddateError(validateenddate(reqRentalModel.getstartdate(), reqRentalModel.getenddate()));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		RRerrorMsgs.setstarttimeError(validatestarttime(reqRentalModel.getstartdate(),
				reqRentalModel.getstarttime()));
		RRerrorMsgs.setendtimeError(validateendtime(reqRentalModel.getstartdate(), reqRentalModel.getenddate(),
				reqRentalModel.getstarttime(), reqRentalModel.getendtime()));
		RRerrorMsgs.setErrorMsg();
	}

	public String validatestartdate(String start) throws java.text.ParseException {
		String result = "";
		if (start.length() == 0) {
			result = "Start Date cannot be blank";
		} else {
			if (!(start.length() == 10)) {
				result = "Invalid date format";
			} else {
				try {
					java.util.Date valid_date = new SimpleDateFormat("yyyy-MM-dd").parse(start);

					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date today = new Date();
					Date current_date = formatter.parse(formatter.format(today));

					// good format
					if (valid_date.before(current_date)) {
						result = "Start Date should be a current/future date";
					}
				} catch (ParseException e) {
					// bad format
					e.printStackTrace();
					result = "Invalid date format";
				}
			}

		}
		return result;
	}

	public String validateenddate(String start, String end) throws java.text.ParseException {
		String result = "";
		if (end.length() == 0) {
			result = "End Date cannot be blank";
		} else {
			if (!(end.length() == 10)) {
				result = "Invalid date format";
			} else {
				try {
					java.util.Date valid_date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end);
//					if (!start.equals("")) {
						java.util.Date start2 = new SimpleDateFormat("yyyy-MM-dd").parse(start);
						// good format
						if (valid_date2.before(start2)) {
							result = "End Date should be after Start Date";
						}
//					}
				} catch (ParseException e) {
					// bad format
					result = "Invalid date format";
				}

			}
		}
		return result;
	}

	public String validatestarttime(String start_d, String start_x )
			throws java.text.ParseException {
		String result = "";

		if (!start_d.equals("")) {
			LocalTime sun_starttime = LocalTime.parse("11:59");
			LocalTime sun_endtime = LocalTime.parse("17:00");
			LocalTime stime = LocalTime.parse(start_x);

			String start_day = null;

			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date dt1 = format1.parse(start_d);
			DateFormat format2 = new SimpleDateFormat("EEEE");
			start_day = format2.format(dt1);

			if (start_day.equals("Sunday")) {
				if ((!stime.isAfter(sun_starttime)) || (stime.isAfter(sun_endtime))) {
					result = "Sunday working hours - 12:00 to 17:00 hrs";
				}
			}
		}
		return result;
	}

	public String validateendtime(String start_d, String end_d, String start_x, String end_x)
			throws java.text.ParseException {
		String result = "";

		LocalTime stime = LocalTime.parse(start_x);
		LocalTime etime = LocalTime.parse(end_x);
		LocalTime sat_endtime = LocalTime.parse("17:00");
		LocalTime sun_starttime = LocalTime.parse("12:00");
		LocalTime sun_endtime = LocalTime.parse("17:00");

		if ((start_d.equals(end_d)) && (!etime.isAfter(stime)) && !end_d.equals("")) {
			result = "End time should be after the Start time";
		} else {
			String end_day = null;

			if (!start_d.equals("") && !end_d.equals("")) {
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//				Date dt1 = format1.parse(start_d);
				DateFormat format2 = new SimpleDateFormat("EEEE");

				Date dt2 = format1.parse(end_d);
				end_day = format2.format(dt2);

				if (end_day.equals("Saturday")) {
					if (etime.isAfter(sat_endtime)) {
						result = "Saturday working hours - 08:00 to 17:00 hrs";
					}
				} else {
					if (end_day.equals("Sunday")) {
						if (etime.isAfter(sun_endtime) || etime.isBefore(sun_starttime)) {
							result = "Sunday working hours - 12:00 to 17:00 hrs";
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestRentalModel() {
		super();
	}

}

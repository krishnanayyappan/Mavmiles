package mavmiles.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class ViewAvailableCarsModel
 */
@WebServlet("/ViewAvailableCarsModel")
public class ViewAvailableCarsModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String startdate = "";

	private static Date startdate_d = new Date();
	private static String enddate = "";
	
	public void setstartdate(String startdate) {
		this.startdate = startdate;
	}
	
	public void setstartdate_d(Date startdate_d) {
		this.startdate_d = startdate_d;
	}
	
	
	public void setenddate(String enddate) {
		this.enddate = enddate;
	}
       
	
	public String getstartdate() {
		return startdate;
	}
	
	public Date getstartdate_d() {
		return startdate_d;
	}
	
	public String getenddate() {
		return enddate;
	}
	
	
	
	public void setViewCar(String startdate2, String enddate2) {
		setstartdate(startdate2);
		setenddate(enddate2);
	}
	// DB storage values
	
		private String carname = "";
		private String licenseid = "";
		private int capacity = 0;
		
		public void setcarname(String carname) {
			this.carname = carname;
		}
		
		public void setlicenseid(String licenseid) {
			this.licenseid = licenseid;
		}
		
		public void setcapacity(int capacity) {
			this.capacity = capacity;
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
		
	
		
		
		public void validateViewAvailableCars(ViewAvailableCarsModel VACModel, ViewAvailableCarsErrorMsgs verrorMsgs) throws java.text.ParseException {
			
			verrorMsgs.setstartdateError(validatestartdate(VACModel.getstartdate()));
			verrorMsgs.setenddateError(validateenddate(VACModel, VACModel.getenddate()));
			
			verrorMsgs.setErrorMsg();	
		}

		private String validatestartdate(String start) throws java.text.ParseException {
			String result="";
			
			if (start.equals("")) {
				result="Start Date cannot be blank";
			} else {
					if (!(start.length() == 10)) {
						result= "Invalid date format";
					} else {
						try {
							java.util.Date valid_date = new SimpleDateFormat("yyyy-MM-dd").parse(start);
							setstartdate_d(valid_date);
							
							DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							Date today = new Date();
							Date current_date = formatter.parse(formatter.format(today));
							
							// good format
							if (valid_date.before(current_date)) {
								result= "Start Date should be a current/future date";							
							}
						} catch (ParseException e) {
						    // bad format
							result= "Invalid date format";
						}
					}
						
					} 
			return result;
		}

		private String validateenddate(ViewAvailableCarsModel VACModel, String end) throws java.text.ParseException {
			String result="";
			if (end.equals("")) {
				result="End Date cannot be blank";
			} else {
				if (!(end.length() == 10) ) {
					result= "Invalid date format";
				} else {
						try {
							java.util.Date valid_date2 = new SimpleDateFormat("yyyy-MM-dd").parse(end);
							
							DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							Date today = new Date();
							Date current_date = formatter.parse(formatter.format(today));
							
							// good format
							if (valid_date2.before(VACModel.getstartdate_d())) {
								result= "End Date should be on/after Start Date";							
							} 
//							
						} catch (ParseException e) {
						    // bad format
							result= "Invalid date format";
						}
						
					} 
			}
			return result;
		}


		public void setsearch(String startdate2, String enddate2) {
			// TODO Auto-generated method stub
			setstartdate(startdate2);
			setenddate(enddate2);
		}
		
		
		
    /**
     * @see HttpServlet#HttpServlet()
     *//*
    public ViewAvailableCarsModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}

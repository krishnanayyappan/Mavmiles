package mavmiles.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.RequestRentalDAO;
import mavmiles.model.RequestRentalErrorMsgs;
import mavmiles.model.RequestRentalModel;

/**
 * Servlet implementation class RequestRental
 */
@WebServlet("/RequestRental")
public class RequestRental extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestRental() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestRentalModel reqRentalModel = new RequestRentalModel();
		RequestRentalErrorMsgs RRerrorMsgs = new RequestRentalErrorMsgs();
		RequestRentalDAO reqRentalDAO = new RequestRentalDAO();
		
		String startdate = request.getParameter("startdate");
		String starttime = request.getParameter("starttime");
		String enddate = request.getParameter("enddate");
		String endtime = request.getParameter("endtime");
		int occupants = Integer.parseInt(request.getParameter("occupants"));
		String gps = request.getParameter("gps");
		String onstar = request.getParameter("onstar");
		String siriusxm = request.getParameter("siriusxm");
		String aac = request.getParameter("aac");
		
		String renterStat = "";
//		
		if (gps == null ) {
			gps = "N";
		}
		
		if (onstar == null ) {
			onstar = "N";
		}
		
		if (siriusxm == null ) {
			siriusxm = "N";
		}
		
		if (aac == null ) {
			aac = "N";
		}
		
		session.removeAttribute("RRerrorMsgs");
		
		reqRentalModel.setRental(startdate, starttime, enddate, endtime, occupants, gps, onstar, siriusxm, aac);
		try {
			reqRentalModel.validateRental(reqRentalModel, RRerrorMsgs);
//			renterStat = reqRentalDAO.getRenterStatus("SELECT status FROM profile WHERE Loginid = 'neerja12'");
//			RRerrorMsgs.setrevokeError(reqRentalModel.validaterevoke(renterStat));
			RRerrorMsgs.setErrorMsg();
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		session.setAttribute("reqRentalModel", reqRentalModel);

		if (RRerrorMsgs.getErrorMsg().equals("")) {
			if (!startdate.equals("") || !starttime.equals("") || !enddate.equals("") || !(occupants == 0) || !endtime.equals("")
					|| !gps.equals("") || !onstar.equals("") || !siriusxm.equals("") || !aac.equals("") || !renterStat.equals("N")) {
				
				String startDate = startdate + " " + starttime;
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				java.util.Date date = null;
				try {
					date = sdf1.parse(startDate);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//				System.out.println("sqlStartDate = " + sqlStartDate);
				
				String endDate = enddate + " " + endtime;
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				java.util.Date date2 = null;
				try {
					date2 = sdf2.parse(endDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				java.sql.Date sqlendDate = new java.sql.Date(date2.getTime());

				long startTime = date.getTime();
				
				@SuppressWarnings("null")
				long endTime = date2.getTime();
				long diffTime = endTime - startTime;
				long TotalDays = diffTime / (1000 * 60 * 60 * 24);
				long diffMinutes = diffTime / (60 * 1000) % 60;
				
				long working_days = getWorkingDaysBetweenTwoDates(sqlStartDate, sqlendDate);
				
				if (diffMinutes > 0) {
					TotalDays++;
				}
				
				long weekend_days = TotalDays - working_days;
				reqRentalModel.setTotalDays(TotalDays);
				reqRentalModel.setworking_days(working_days);
				reqRentalModel.setweekend_days(weekend_days);
				
				ArrayList<RequestRentalModel> CarsAvailable = new ArrayList<RequestRentalModel>();
				CarsAvailable = reqRentalDAO.searchRental(reqRentalModel);
				
				session.setAttribute("CARS", CarsAvailable);
				session.removeAttribute("reqRentalModel");
				getServletContext().getRequestDispatcher("/requestRentalform.jsp").forward(request, response);
			}
		} else {
			// session.setAttribute("regModel", regModel);
			reqRentalModel.setRental(startdate, starttime, enddate, endtime, occupants, gps, onstar, siriusxm, aac);
			session.setAttribute("RRerrorMsgs", RRerrorMsgs);
			response.sendRedirect("requestRentalform.jsp");
		}
		
		/*String startDate = startdate + " " + starttime;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date date = null;
		try {
			date = sdf1.parse(startDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
//		System.out.println("sqlStartDate = " + sqlStartDate);
		
		String endDate = enddate + " " + endtime;
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		java.util.Date date2 = null;
		try {
			date2 = sdf2.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlendDate = new java.sql.Date(date2.getTime());

		long startTime = date.getTime();
		
		@SuppressWarnings("null")
		long endTime = date2.getTime();
		long diffTime = endTime - startTime;
		long TotalDays = diffTime / (1000 * 60 * 60 * 24);
		long diffMinutes = diffTime / (60 * 1000) % 60;
		
		long working_days = getWorkingDaysBetweenTwoDates(sqlStartDate, sqlendDate);
		
		if (diffMinutes > 0) {
			TotalDays++;
		}
		
		long weekend_days = TotalDays - working_days;*/
		
//		RequestRentalModel reqRentalModel = new RequestRentalModel();
		
		/*if (sdate_error.equals("")) {
			reqRentalModel.setstartdate(startdate);
		} else {
			session.setAttribute("sdate_error", sdate_error);
			getServletContext().getRequestDispatcher("/requestRentalform.jsp").forward(request, response);
		}*/
		
		/*reqRentalModel.setstartdate(startdate);
		reqRentalModel.setstarttime(starttime);
		reqRentalModel.setenddate(enddate);
		reqRentalModel.setendtime(endtime);
		reqRentalModel.setoccupants(occupants);
		reqRentalModel.setgps(gps);
		reqRentalModel.setonstar(onstar);
		reqRentalModel.setsiriusxm(siriusxm);
		reqRentalModel.setaac(aac);
		reqRentalModel.setTotalDays(TotalDays);
		reqRentalModel.setworking_days(working_days);
		reqRentalModel.setweekend_days(weekend_days);
		
		RequestRentalDAO reqRentalDAO = new RequestRentalDAO();
		
		ArrayList<RequestRentalModel> CarsAvailable = new ArrayList<RequestRentalModel>();
		CarsAvailable = reqRentalDAO.searchRental(reqRentalModel);

		session.setAttribute("CARS", CarsAvailable);
		getServletContext().getRequestDispatcher("/requestRentalform.jsp").forward(request, response); */
		
//		doGet(request, response);
	}

	public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
	    Calendar startCal = Calendar.getInstance();
	    startCal.setTime(startDate);        

	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(endDate);

	    int workDays = 0;

	    //Return 0 if start and end are the same
	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	        return 0;
	    }

	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	        startCal.setTime(endDate);
	        endCal.setTime(startDate);
	    }

	    do {
	       //excluding start date
	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	            ++workDays;
	        }
	    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

	    return workDays;
	}
	
}

package mavmiles.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.RequestRentalDAO;
import mavmiles.data.calendarDao;
import mavmiles.model.RequestRentalModel;
import mavmiles.model.CalendarModelErrorMsgs;
import mavmiles.model.CalendarModel;

/**
 * Servlet implementation class ViewAvailableCars
 */
@WebServlet("/calendar")
public class calendar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public calendar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		CalendarModel VACModel = new CalendarModel();
		calendarDao vacDAO = new calendarDao();
		CalendarModelErrorMsgs verrorMsgs = new CalendarModelErrorMsgs();

//		String startdate = request.getParameter("startdate");
//		String enddate = request.getParameter("enddate");

		String startdate1 = "";
//		if (!request.getParameter("startdate").equals("")) {
			startdate1 = request.getParameter("startdate");
//		} else {
//			startdate1 = " ";
//		}

		String enddate1 = "";
//		if (!request.getParameter("enddate").equals("")) {
			enddate1 = request.getParameter("enddate");
//		} else {
//			enddate1 = " ";
//		}

		session.removeAttribute("verrorMsgs");
		VACModel.setsearch(startdate1, enddate1);
		try {
			VACModel.validateCalendar(VACModel, verrorMsgs);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ViewAvailableCarsModel VACModel = new ViewAvailableCarsModel();

		// VACModel.setstartdate(startdate);
		// VACModel.setenddate(enddate);

		// ViewAvailableCarsDAO vacDAO = new ViewAvailableCarsDAO();

		if (verrorMsgs.getErrorMsg().equals("")) {
			if (!startdate1.equals("") || !enddate1.equals("")) {

				ArrayList<CalendarModel> CarsAvailable = new ArrayList<CalendarModel>();
				CarsAvailable = vacDAO.searchRental(VACModel);

				session.setAttribute("VAC", CarsAvailable);
				session.removeAttribute("VACModel");
				getServletContext().getRequestDispatcher("/calendar.jsp").forward(request, response);
			}
		} else {
			// session.setAttribute("regModel", regModel);
			VACModel.setsearch(startdate1, enddate1);
			session.setAttribute("verrorMsgs", verrorMsgs);
			response.sendRedirect("calendar.jsp");
		}

//		ArrayList<ViewAvailableCarsModel> CarsAvailable = new ArrayList<ViewAvailableCarsModel>();
//		CarsAvailable = vacDAO.searchRental(VACModel);
//		
//		session.setAttribute("VAC", CarsAvailable);
//		getServletContext().getRequestDispatcher("/viewAvailableCars.jsp").forward(request, response);

//		doGet(request, response);
	}

}

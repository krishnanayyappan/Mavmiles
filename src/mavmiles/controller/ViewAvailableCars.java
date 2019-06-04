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
import mavmiles.data.ViewAvailableCarsDAO;
import mavmiles.model.RequestRentalModel;
import mavmiles.model.ViewAvailableCarsErrorMsgs;
import mavmiles.model.ViewAvailableCarsModel;

/**
 * Servlet implementation class ViewAvailableCars
 */
@WebServlet("/ViewAvailableCars")
public class ViewAvailableCars extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAvailableCars() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ViewAvailableCarsModel VACModel = new ViewAvailableCarsModel();
		ViewAvailableCarsDAO vacDAO = new ViewAvailableCarsDAO();
		ViewAvailableCarsErrorMsgs verrorMsgs = new ViewAvailableCarsErrorMsgs();
		
//		String startdate = request.getParameter("startdate");
//		String enddate = request.getParameter("enddate");
		
		String startdate1 = "";
	/*	if (!request.getParameter("startdate").equals("")) {*/
			startdate1 = request.getParameter("startdate");
		/*} else {
			startdate1 = " ";
		}
		*/
		String enddate1 = "";
		/*if (!request.getParameter("enddate").equals("")) {*/
			enddate1 = request.getParameter("enddate");
		/*} else {
			enddate1 = " ";
		}*/
		
		session.removeAttribute("verrorMsgs");
		VACModel.setsearch(startdate1, enddate1);
		try {
			VACModel.validateViewAvailableCars(VACModel, verrorMsgs);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ViewAvailableCarsModel VACModel = new ViewAvailableCarsModel();
		
		//VACModel.setstartdate(startdate);
		//VACModel.setenddate(enddate);
		
		//ViewAvailableCarsDAO vacDAO = new ViewAvailableCarsDAO();
		
		
		if (verrorMsgs.getErrorMsg().equals("")) {
			if (!startdate1.equals("") || !enddate1.equals("")) {
								
				ArrayList<ViewAvailableCarsModel> CarsAvailable = new ArrayList<ViewAvailableCarsModel>();
				CarsAvailable = vacDAO.searchRental(VACModel);
				
				session.setAttribute("VAC", CarsAvailable);
				session.removeAttribute("VACModel");
				getServletContext().getRequestDispatcher("/viewAvailableCars.jsp").forward(request, response);
			}
		} else {
			// session.setAttribute("regModel", regModel);
			VACModel.setsearch(startdate1, enddate1);
			session.setAttribute("verrorMsgs", verrorMsgs);
			response.sendRedirect("viewAvailableCars.jsp");
		}
		
//		ArrayList<ViewAvailableCarsModel> CarsAvailable = new ArrayList<ViewAvailableCarsModel>();
//		CarsAvailable = vacDAO.searchRental(VACModel);
//		
//		session.setAttribute("VAC", CarsAvailable);
//		getServletContext().getRequestDispatcher("/viewAvailableCars.jsp").forward(request, response);
		
//		doGet(request, response);
	}

}

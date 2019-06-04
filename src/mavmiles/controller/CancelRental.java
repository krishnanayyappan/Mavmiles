package mavmiles.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.CancelRentalDAO;
import mavmiles.data.RegistrationDAO;
import mavmiles.model.AddCarErrorMsgs;
import mavmiles.model.CancelRentalErrorMsgs;
import mavmiles.model.CancelRentalModel;
import mavmiles.model.RequestRentalModel;

/**
 * Servlet implementation class CancelRental
 */
@WebServlet("/CancelRental")
public class CancelRental extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelRental() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String rentalid = request.getParameter("rentalid");

		CancelRentalModel cancelmodel = new CancelRentalModel();
		CancelRentalDAO cancelrentalDAO = new CancelRentalDAO();

		CancelRentalErrorMsgs RerrorMsgs = new CancelRentalErrorMsgs();
		session.removeAttribute("errorMsgs");

		cancelmodel.setCancelRental(rentalid);
		cancelmodel.validateCancelRental(cancelmodel, RerrorMsgs);

		if (RerrorMsgs.getErrorMsg().equals("")) {
			if (!rentalid.equals("")) {
				ArrayList<CancelRentalModel> Details = new ArrayList<CancelRentalModel>();
				Details = cancelrentalDAO.searchRental(rentalid);

				for (CancelRentalModel cmodel : Details) {
					session.setAttribute("rentalid", cmodel.getrentalid());
					session.setAttribute("licenseid", cmodel.getlicenseid());
					session.setAttribute("carname", cmodel.getcarname());
					session.setAttribute("startdate", cmodel.getstartdate());
					session.setAttribute("starttime", cmodel.getstarttime());
					session.setAttribute("enddate", cmodel.getenddate());
					session.setAttribute("endtime", cmodel.getendtime());
					session.setAttribute("amount", cmodel.getamount());
					session.setAttribute("gps", cmodel.getgps());
					session.setAttribute("onstar", cmodel.getonstar());
					session.setAttribute("siriusxm", cmodel.getsiriusxm());
					session.setAttribute("aac_member", cmodel.getaac_member());
					session.setAttribute("payment_status", cmodel.payment_status());
				}
				
				session.removeAttribute("cancelmodel");
				response.sendRedirect("reservationDetails.jsp");
			}
		} else {
			session.setAttribute("cancelmodel", cancelmodel);
			session.setAttribute("RerrorMsgs", RerrorMsgs);
			response.sendRedirect("cancelreservedrentaldate.jsp");
		}

//		
//		for (CancelRentalModel cmodel : Details) {   
////		    System.out.println("Array list carname = " + cmodel.getcarname());
//		
//		session.setAttribute("rentalid", cmodel.getrentalid());
//		session.setAttribute("licenseid", cmodel.getlicenseid());
//		session.setAttribute("carname", cmodel.getcarname());
//		session.setAttribute("startdate", cmodel.getstartdate());
//		session.setAttribute("starttime", cmodel.getstarttime());
//		session.setAttribute("enddate", cmodel.getenddate());
//		session.setAttribute("endtime", cmodel.getendtime());
//		session.setAttribute("amount", cmodel.getamount());
//		session.setAttribute("gps", cmodel.getgps());
//		session.setAttribute("onstar", cmodel.getonstar());
//		session.setAttribute("siriusxm", cmodel.getsiriusxm());
//		session.setAttribute("aac_member", cmodel.getaac_member());
//		session.setAttribute("payment_status", cmodel.payment_status());
//		
//		}

//		response.sendRedirect("reservationDetails.jsp");

//		doGet(request, response);
	}

}

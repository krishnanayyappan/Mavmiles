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
import mavmiles.model.CancelRentalModel;

/**
 * Servlet implementation class CancelThisRental
 */
@WebServlet("/CancelThisRental")
public class CancelThisRental extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelThisRental() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String rentalid = request.getParameter("rentalid");
		String loginid = "karthik10";
		
		CancelRentalDAO cancelrentalDAO = new CancelRentalDAO();
		cancelrentalDAO.deletethisRental(rentalid, loginid);
		
		response.sendRedirect("userhome.jsp");
		
//		System.out.println("Cancelthisreturn = " + rentalid);
//		doGet(request, response);
	}

}

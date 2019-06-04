package mavmiles.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.BookRentalDAO;

/**
 * Servlet implementation class BookRental
 */
@WebServlet("/BookRental")
public class BookRental extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRental() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();

		String licenseid = request.getParameter("page");
		
//		RequestRentalModel rentmodel = new RequestRentalModel();
		BookRentalDAO bookDAO = new BookRentalDAO();
		bookDAO.createReservation(licenseid);
		
		getServletContext().getRequestDispatcher("/BookingConfirmed.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}

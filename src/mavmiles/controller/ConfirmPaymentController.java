/*package mavmiles.controller;

public class ConfirmPaymentController {

}
*/

package mavmiles.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.ConfirmPaymentDAO;
import mavmiles.data.RegistrationDAO;
import mavmiles.data.RequestRentalDAO;
import mavmiles.model.ConfirmPaymentErrorMsgs;
import mavmiles.model.ConfirmPaymentModel;
import mavmiles.model.LoginModel;
import mavmiles.model.RegistrationModel;
import mavmiles.model.RequestRentalErrorMsgs;
import mavmiles.model.RequestRentalModel;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/ConfirmPaymentController")
public class ConfirmPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmPaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ConfirmPaymentModel confPayModel = new ConfirmPaymentModel();
		ConfirmPaymentErrorMsgs confPayerrorMsgs = new ConfirmPaymentErrorMsgs();
		ConfirmPaymentDAO confPayDAO = new ConfirmPaymentDAO();

		String rentalid = request.getParameter("rentalid");
		String cardNumber = request.getParameter("cardNumber");
		
		String expiry = "";
		/*if (!request.getParameter("expiry").equals("")) {*/
			expiry = request.getParameter("expiry");
		/*} else {
			expiry = " ";
		}*/
//		String expiry = request.getParameter("expiry");
		String cvv = request.getParameter("cvv");
		String nameOnCard = request.getParameter("nameOnCard");
		String Loginid = "karthik10";
		
		LoginModel loginmodel = new LoginModel();
		loginmodel.setLoginID(Loginid);
		
		session.removeAttribute("payerrorMsgs");
		
		confPayModel.setRental(rentalid, cardNumber, expiry, cvv, nameOnCard, Loginid);
		try {
			confPayModel.validatePayment(confPayModel, confPayerrorMsgs);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("confPayModel", confPayModel);
		
		if (confPayerrorMsgs.getErrorMsg().equals("")) {
			if (!rentalid.equals("") || !cardNumber.equals("") || !expiry.equals("") || !cvv.equals("") || !nameOnCard.equals("") ) {
				confPayDAO.insertPayInfo(confPayModel, loginmodel);
				session.removeAttribute("confPayModel");
				response.sendRedirect("thankYouPage.jsp");
			}
		}
		else {
			confPayModel.setRental(rentalid, cardNumber, expiry, cvv, nameOnCard, Loginid);
			session.setAttribute("confPayerrorMsgs", confPayerrorMsgs);
			response.sendRedirect("ConfirmPay.jsp");
		}
				
		/*ConfirmPaymentModel confPayModel = new ConfirmPaymentModel();
		confPayModel.setrentalID(rentalId);
		confPayModel.setcardNumber(cardNumber);
		confPayModel.setexpiry(expiry);
		confPayModel.setcvv(cvv);
		confPayModel.setnameOnCard(nameOnCard);
		
		LoginModel loginmodel = new LoginModel();
		loginmodel.setLoginID(Loginid);
		
		ConfirmPaymentDAO confPayDAO = new ConfirmPaymentDAO();
		confPayDAO.insertPayInfo(confPayModel, loginmodel);
		
		response.sendRedirect("thankYouPage.jsp");*/
		
//		doGet(request, response);
	}

}

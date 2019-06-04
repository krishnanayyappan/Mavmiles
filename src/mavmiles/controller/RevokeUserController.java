/*package mavmiles.controller;

public class RevokeUserController {

}*/
/*package mavmiles.controller;

public class EditUserProfileController {

}*/
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
import mavmiles.data.EditUserProfileDAO;
import mavmiles.data.RegistrationDAO;
import mavmiles.data.RevokeUserDAO;
import mavmiles.model.CancelRentalModel;
import mavmiles.model.EditUserProfileErrorMsgs;
import mavmiles.model.EditUserProfileModel;
import mavmiles.model.RequestRentalModel;
import mavmiles.model.RevokeUserErrorMsgs;
import mavmiles.model.RevokeUserModel;

/**
 * Servlet implementation class CancelRental
 */
@WebServlet("/RevokeUserController")
public class RevokeUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevokeUserController() {
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
		HttpSession session = request.getSession();

		RevokeUserModel revmodel = new RevokeUserModel();
		RevokeUserErrorMsgs CerrorMsgs = new RevokeUserErrorMsgs();
		RevokeUserDAO revUserDAO = new RevokeUserDAO();
		
		String loginid = request.getParameter("loginid");
		session.removeAttribute("errorMsgs");
		
		revmodel.setProfile(loginid);
		revmodel.validateProfile(revmodel, CerrorMsgs);
		
		session.setAttribute("revmodel", revmodel);
		
		
		if (CerrorMsgs.getErrorMsg().equals("")) {
			if (!loginid.equals("")) {
				ArrayList<RevokeUserModel> Details = new ArrayList<RevokeUserModel>();
				Details = revUserDAO.searchUser(loginid);
				session.setAttribute("revmodel",revmodel);
				response.sendRedirect("revokeDetails.jsp");
			}
			
			
		}
		else {
//			session.setAttribute("regModel", regModel);
			revmodel.setProfile(loginid);
			session.setAttribute("errorMsgs", CerrorMsgs);
			response.sendRedirect("revokeUser.jsp");	
		}
	
	}

}

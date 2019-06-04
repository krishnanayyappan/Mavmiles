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
import mavmiles.model.CancelRentalModel;
import mavmiles.model.EditUserProfileErrorMsgs;
import mavmiles.model.EditUserProfileModel;
import mavmiles.model.RegistrationErrorMsgs;
import mavmiles.model.RequestRentalModel;

/**
 * Servlet implementation class CancelRental
 */
@WebServlet("/EditUserProfileController")
public class EditUserProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserProfileController() {
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
		EditUserProfileModel eupmodel = new EditUserProfileModel();
		EditUserProfileErrorMsgs CerrorMsgs = new EditUserProfileErrorMsgs();
		EditUserProfileDAO editUserProfileDAO = new EditUserProfileDAO();
		
		String loginid = request.getParameter("loginid");
		session.removeAttribute("errorMsgs");
		
		eupmodel.setProfile(loginid);
		eupmodel.validateProfile(eupmodel, CerrorMsgs);

		session.setAttribute("eupmodel", eupmodel);
		
		
		if (CerrorMsgs.getErrorMsg().equals("")) {
			if (!loginid.equals("")) {
				ArrayList<EditUserProfileModel> Details = new ArrayList<EditUserProfileModel>();
				Details = editUserProfileDAO.searchUser(loginid);
			}
			
			session.setAttribute("eupmodel",eupmodel);
			response.sendRedirect("userDetails.jsp");
		}
		else {
//			session.setAttribute("regModel", regModel);
			eupmodel.setProfile(loginid);
			session.setAttribute("errorMsgs", CerrorMsgs);
			response.sendRedirect("edituserprofile.jsp");	
		}
		

		

		
		

		
	/*for (EditUserProfileModel eupmodel : Details) {   
//		    System.out.println("Array list carname = " + cmodel.getcarname());
		
		session.setAttribute("name", eupmodel.getname());
		session.setAttribute("loginid", eupmodel.getloginid());
		session.setAttribute("password", eupmodel.getpassword());
		session.setAttribute("mavid", eupmodel.getmavid());
		session.setAttribute("email", eupmodel.getemail());
		session.setAttribute("phone", eupmodel.getphone());
		session.setAttribute("dl_number", eupmodel.getdl_number());
		session.setAttribute("dl_expiry", eupmodel.getdl_expiry());
		session.setAttribute("status", eupmodel.getstatus());
		session.setAttribute("onstar", cmodel.getonstar());
		session.setAttribute("siriusxm", cmodel.getsiriusxm());
		session.setAttribute("aac_member", cmodel.getaac_member());
		session.setAttribute("payment_status", cmodel.payment_status());
		
		}*/
		
		//response.sendRedirect("userDetails.jsp");
		
//		doGet(request, response);
	}

}

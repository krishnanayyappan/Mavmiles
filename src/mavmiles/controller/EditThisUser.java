/*package mavmiles.controller;

public class EditThisUser {

}


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
import mavmiles.model.EditUserProfileModel;
import mavmiles.model.RegistrationModel;

*//**
 * Servlet implementation class CancelThisRental
 *//*
@WebServlet("/EditThisUser")
public class EditThisUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public EditThisUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String loginid = request.getParameter("loginid");
		
		EditUserProfileDAO editProfileDAO = new EditUserProfileDAO();
		editProfileDAO.editthisUser(loginid);
		
		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String loginid = request.getParameter("loginid");
		String password = request.getParameter("password");
		int mavid = Integer.parseInt(request.getParameter("mavid"));
		String email = request.getParameter("email");
		String dl_number = request.getParameter("dl_number");
		String dl_expiry = request.getParameter("dl_expiry");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");
		
//		System.out.println(name);
		EditUserProfileModel userProfile = new EditUserProfileModel();
		userProfile.setname(name);
		userProfile.setloginid(loginid);
		userProfile.setpassword(password);
		userProfile.setmavid(mavid);
		userProfile.setemail(email);
		userProfile.setdl_number(dl_number);
		userProfile.setdl_expiry(dl_expiry);
		userProfile.setphone(phone);
		userProfile.setstatus(status);
		
		EditUserProfileModel editModel = new EditUserProfileModel();
		EditUserProfileDAO editUserDAO = new EditUserProfileDAO();
		editUserDAO.editthisUser(editModel.getloginid());
		
		response.sendRedirect("adminhome.jsp");
		
//		System.out.println("Cancelthisreturn = " + rentalid);
//		doGet(request, response);
	}

}*/

package mavmiles.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.EditUserProfileDAO;
//import company_management.data.CompanyDAO;
import mavmiles.data.RegistrationDAO;
import mavmiles.model.EditThisUserModel;
import mavmiles.model.EditThisUserModelErrorMsgs;
import mavmiles.model.RegistrationErrorMsgs;
import mavmiles.model.RegistrationModel;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/EditThisUser")
public class EditThisUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditThisUser() {
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
		
		EditThisUserModel editThisModel = new EditThisUserModel();
		EditThisUserModelErrorMsgs CerrorMsgs = new EditThisUserModelErrorMsgs();
		EditUserProfileDAO editUserDAO = new EditUserProfileDAO();

		String name = request.getParameter("name");
		String loginID = request.getParameter("loginid");
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		int mavid = 0;
		if ( (!request.getParameter("mavid").equals("")) && (isTextInteger(request.getParameter("mavid")) ) ) {
			 mavid = Integer.parseInt(request.getParameter("mavid"));
		}
		
		String email = request.getParameter("email");
		String drivingLicense = request.getParameter("dl_number");
		
		String dl_expiry = "";
//		if (!request.getParameter("dl_expiry").equals("")) {
			dl_expiry = request.getParameter("dl_expiry");
//		} else {
//			dl_expiry = " ";
//		}
		
		/*int age = 0;
		if (!request.getParameter("age").equals("")) {
			age = Integer.parseInt(request.getParameter("age"));
		}
		*/
		String contact = request.getParameter("phone");
		String Type = request.getParameter("Type");
		
		session.removeAttribute("errorMsgs");
		
//		editThisModel.setProfile(name, loginID, password, mavid, email, drivingLicense, dl_expiry, contact, status);
		editThisModel.setProfile(name, loginID, password, email, drivingLicense, dl_expiry, contact);
		editThisModel.validateProfile(editThisModel, CerrorMsgs);
		session.setAttribute("editThisModel", editThisModel);
		
		if (CerrorMsgs.getErrorMsg().equals("")) {
			if (!name.equals("") || !loginID.equals("") || !password.equals("") || !(mavid == 0) || !email.equals("") || !drivingLicense.equals("") || !contact.equals("") ) {
				editUserDAO.editUserData(editThisModel);
			}
			
			session.removeAttribute("editThisModel");
			response.sendRedirect("adminhome.jsp");
		}
		else {
//			editThisModel.setProfile(name, loginID, password, mavid, email, drivingLicense, dl_expiry, contact, status);
			editThisModel.setProfile(name, loginID, password, email, drivingLicense, dl_expiry, contact);
			session.setAttribute("errorMsgs", CerrorMsgs);
			response.sendRedirect("userDetails.jsp");	
		}
		
		
	}
	
	private boolean isTextInteger (String st) {
        boolean result;
		try
        {
            Long.parseLong(st);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}

}


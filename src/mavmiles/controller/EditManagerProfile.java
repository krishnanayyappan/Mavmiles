package mavmiles.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.ManagerUpdateProfileDAO;
import mavmiles.data.UserUpdateProfileDAO;
import mavmiles.model.EditManagerProfileErrorMsgs;
import mavmiles.model.EditManagerProfileModel;
import mavmiles.model.EditMyProfileErrorMsgs;
import mavmiles.model.EditMyProfileModel;
import mavmiles.model.UserUpdateProfileModel;

/**
 * Servlet implementation class EditMyProfile
 */
@WebServlet("/EditManagerProfile")
public class EditManagerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditManagerProfile() {
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
		
		EditManagerProfileErrorMsgs MPerrorMsgs = new EditManagerProfileErrorMsgs();

		String name = request.getParameter("name");
		String loginid = request.getParameter("loginid");
		String password = request.getParameter("password");
		
		int mavid = 0;
		if ( (!request.getParameter("mavid").equals("")) && (isTextInteger(request.getParameter("mavid")) ) ) {
			 mavid = Integer.parseInt(request.getParameter("mavid"));
		}
		
		String email = request.getParameter("email");
		String dl_number = request.getParameter("dl_number");
//		String dl_expiry = request.getParameter("dl_expiry");
		
		String dl_expiry = "";
//		if (!request.getParameter("dl_expiry").equals("")) {
			dl_expiry = request.getParameter("dl_expiry");
//		} else {
//			dl_expiry = " ";
//		}
		
		String phone = request.getParameter("phone");
		
//		System.out.println("Controller phone = " + phone);
		
		String status = request.getParameter("status");
		
		session.removeAttribute("userProfile");
		
//		UserUpdateProfileModel userProfile = new UserUpdateProfileModel();
		EditManagerProfileModel managerProfile = new EditManagerProfileModel();
		managerProfile.setProfile(name, loginid, password, email, dl_number, dl_expiry, phone);
		managerProfile.validateProfile(managerProfile, MPerrorMsgs);
		session.setAttribute("managerProfile", managerProfile);
		
		if (MPerrorMsgs.getErrorMsg().equals("")) {
			if (!name.equals("") || !password.equals("") || !(mavid == 0) || !email.equals("") || !dl_number.equals("") || !phone.equals("") ) {
				ManagerUpdateProfileDAO editManagerDAO = new ManagerUpdateProfileDAO();
				editManagerDAO.editManagerdetails(managerProfile.getloginid());
			}
			
			session.removeAttribute("managerProfile");
			response.sendRedirect("managerhome.jsp");
		}
		else {
//			session.setAttribute("regModel", regModel);
			managerProfile.setProfile(name, loginid, password, email, dl_number, dl_expiry, phone);
			session.setAttribute("MPerrorMsgs", MPerrorMsgs);
			response.sendRedirect("managerProfileDetails.jsp");	
		}
		
//		userProfile.setname(name);
//		userProfile.setloginid(loginid);
//		userProfile.setpassword(password);
//		userProfile.setmavid(mavid);
//		userProfile.setemail(email);
//		userProfile.setdl_number(dl_number);
//		userProfile.setdl_expiry(dl_expiry);
//		userProfile.setphone(phone);
//		userProfile.setstatus(status);
		
//		UserUpdateProfileModel uupmodel = new UserUpdateProfileModel();
//		UserUpdateProfileDAO editUserDAO = new UserUpdateProfileDAO();
//		editUserDAO.editthisUser(uupmodel.getloginid());
//		
//		response.sendRedirect("userhome.jsp");
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

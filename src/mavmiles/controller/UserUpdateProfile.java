package mavmiles.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.UserUpdateProfileDAO;
import mavmiles.model.UserUpdateProfileModel;

/**
 * Servlet implementation class UserUpdateProfile
 */
@WebServlet("/UserUpdateProfile")
public class UserUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();

//		String loginid = request.getParameter("loginid");
		String loginid = "karthik10";
				
		UserUpdateProfileDAO userUpdateDAO = new UserUpdateProfileDAO();
		
		ArrayList<UserUpdateProfileModel> Details = new ArrayList<UserUpdateProfileModel>();
		Details = userUpdateDAO.searchUser2(loginid);
		
		for (UserUpdateProfileModel uupmodel : Details) {
			session.setAttribute("name", uupmodel.getname());
			session.setAttribute("loginid", uupmodel.getloginid());
			session.setAttribute("password", uupmodel.getpassword());
			session.setAttribute("mavid", uupmodel.getmavid());
			session.setAttribute("email", uupmodel.getemail());
			session.setAttribute("phone", uupmodel.getphone());
			session.setAttribute("dl_number", uupmodel.getdl_number());
			session.setAttribute("dl_expiry", uupmodel.getdl_expiry());
			session.setAttribute("status", uupmodel.getstatus());
		}
		
		response.sendRedirect("userProfileDetails.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}

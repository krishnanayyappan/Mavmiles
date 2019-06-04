package mavmiles.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.ManagerUpdateProfileDAO;
import mavmiles.data.UserUpdateProfileDAO;
import mavmiles.model.ManagerUpdateProfileModel;
import mavmiles.model.UserUpdateProfileModel;

/**
 * Servlet implementation class ManagerUpdateProfile
 */
@WebServlet("/ManagerUpdateProfile")
public class ManagerUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

//		String loginid = request.getParameter("loginid");
		String loginid = "rohan99";
				
		ManagerUpdateProfileDAO managerUpdateDAO = new ManagerUpdateProfileDAO();
		
		ArrayList<ManagerUpdateProfileModel> Details = new ArrayList<ManagerUpdateProfileModel>();
		Details = managerUpdateDAO.searchUser2(loginid);
		
		for (ManagerUpdateProfileModel mupmodel : Details) {
			session.setAttribute("name", mupmodel.getname());
			session.setAttribute("loginid", mupmodel.getloginid());
			session.setAttribute("password", mupmodel.getpassword());
			session.setAttribute("mavid", mupmodel.getmavid());
			session.setAttribute("email", mupmodel.getemail());
			session.setAttribute("phone", mupmodel.getphone());
			session.setAttribute("dl_number", mupmodel.getdl_number());
			session.setAttribute("dl_expiry", mupmodel.getdl_expiry());
			session.setAttribute("status", mupmodel.getstatus());
		}
		
		response.sendRedirect("managerProfileDetails.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

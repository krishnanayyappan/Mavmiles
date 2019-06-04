package mavmiles.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import company_management.data.CompanyDAO;
import mavmiles.data.RegistrationDAO;
import mavmiles.model.RegistrationErrorMsgs;
import mavmiles.model.RegistrationModel;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		
		RegistrationModel regModel = new RegistrationModel();
		RegistrationErrorMsgs CerrorMsgs = new RegistrationErrorMsgs();
		RegistrationDAO regDAO = new RegistrationDAO();

		String name = request.getParameter("name");
		String loginID = request.getParameter("loginID");
		String password = request.getParameter("password");
		String mavid = request.getParameter("mavid");
		String email = request.getParameter("email");
		String drivingLicense = request.getParameter("drivingLicense");
		String dlexp = request.getParameter("dlexp");
		String age = request.getParameter("age");
		String contact = request.getParameter("contact");
		String Type = request.getParameter("Type");
		
		session.removeAttribute("errorMsgs");
		
		regModel.setProfile(name, loginID, password, mavid, email, drivingLicense, dlexp, contact, Type, "Y", age);
		regModel.validateProfile(regModel, CerrorMsgs);
		session.setAttribute("regModel", regModel);
		
		if (CerrorMsgs.getErrorMsg().equals("")) {
			if (!name.equals("") || !loginID.equals("") || !password.equals("") || !mavid.equals("") || !email.equals("") || !drivingLicense.equals("") || !contact.equals("") ) {
				regDAO.createProfile(regModel);
			}
			
			session.removeAttribute("regModel");
			response.sendRedirect("Login.jsp");
		}
		else {
//			session.setAttribute("regModel", regModel);
			regModel.setProfile(name, loginID, password, mavid, email, drivingLicense, dlexp, contact, Type, "Y", age);
			session.setAttribute("errorMsgs", CerrorMsgs);
			response.sendRedirect("Registration.jsp");	
		}
		
		/*regModel.setname(name);
		regModel.setLoginID(loginID);
		regModel.setPassword(Password);
		regModel.setmavid(mavid);
		regModel.setemail(email);
		regModel.setDrivingLicense(DrivingLicense);
		regModel.setDLexp(DLexp);
		regModel.setContact(Contact);
		regModel.setType(Type);
		regModel.setStatus("Y");*/
		
		
		
//		RegistrationDAO regDAO = new RegistrationDAO();
//		regDAO.createProfile(regModel);
		
//		response.sendRedirect("Login.jsp");
		
//		doGet(request, response);
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

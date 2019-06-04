package mavmiles.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.LoginDAO;
import mavmiles.model.LoginModel;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		ArrayList<LoginModel> LogininDB = new ArrayList<LoginModel>();
		LogininDB = LoginDAO.searchlogin(uname);
		
		// session.setAttribute("COMPANIES", companyInDB);
		// getServletContext().getRequestDispatcher("/listCompany.jsp").forward(request,
		// response);

		/*
		 * for( LoginModel s: LogininDB ){ System.out.println("From Login = " + s); }
		 */
		
		if (uname.equals(LoginModel.getLoginID()) && pass.equals(LoginModel.getpassword())) {
				session = request.getSession();
				
				if (LoginModel.getusertype().equals("User")) {
					session.setAttribute("username", uname);
					response.sendRedirect("userhome.jsp");
				}
				if (LoginModel.getusertype().equals("Manager")) {
						session.setAttribute("username", uname);
						response.sendRedirect("managerhome.jsp");
				}
			} else {
				if (uname.equals("admin") && pass.equals("admin")) {
						session = request.getSession();
						session.setAttribute("username", uname);
						response.sendRedirect("adminhome.jsp");
				} else {
					String message = "Invalid credentials!";
					request.getSession().setAttribute("message", message);
					response.sendRedirect("Login.jsp");

					//Below 2 lines are partly working
//					request.getSession().setAttribute("errorMessage", "Invalid username or password");
//					getServletContext().getRequestDispatcher("/Login.jsp");
//		              RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
//		              dispatcher.forward( request, response);
			}
			}

		/*if (uname.equals("admin")) {
			if (pass.equals("admin")) {
				session = request.getSession();
				// session.setAttribute("username", uname);
				response.sendRedirect("adminhome.jsp");
			} 
			else if (uname.equals(LoginModel.getLoginID()) && pass.equals(LoginModel.getpassword())) {
				session = request.getSession();
				
				if (LoginModel.getusertype().equals("User")) {
					session.setAttribute("username", uname);
					response.sendRedirect("userhome.jsp");
				} else if (LoginModel.getusertype().equals("Manager")) {
						session.setAttribute("username", uname);
						response.sendRedirect("managerhome.jsp");
					}
				}
			} else {
//				String message = "Invalid credentials!";
//				request.getSession().setAttribute("message", message);
				response.sendRedirect("Login.jsp");
			}*/
			// response.getWriter().append("Served at: ").append(request.getContextPath());
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		  String action = request.getParameter("action"), url=""; HttpSession session =
//		  request.getSession();
		 
		 doGet(request, response);
	}*/

}
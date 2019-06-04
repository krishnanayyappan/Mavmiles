package mavmiles.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginModel
 */
@WebServlet("/LoginModel")
public class LoginModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String Loginid = "";
	private static String password = "";
	private static String usertype = "";
	
	public void setLoginID(String Loginid) {
//		System.out.println("LoginID = " + Loginid);
		this.Loginid = Loginid;
	}
	
	public void setPassword(String password) {
//		System.out.println("password = " + password);
		this.password = password;
	}
	
	public void setUserType(String usertype) {
//		System.out.println("usertype = " + usertype);
		this.usertype = usertype;
	}
	
	public static String getLoginID() {
		return Loginid;
	}
	
	public static String getpassword() {
		return password;
	}
	
	public static String getusertype() {
		return usertype;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}

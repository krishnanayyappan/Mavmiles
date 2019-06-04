package mavmiles.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class UserUpdateProfileModel
 */
@WebServlet("/ManagerUpdateProfileModel")
public class ManagerUpdateProfileModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String name = "";
	private static String loginid = "";
	private static String password = "";
	private static int mavid = 0;
	private static String email = "";
	private static String phone = "";
	private static String dl_number = "";
	private static String dl_expiry = "";
	private static String status = "";
	
	public void setname(String name) {
//		System.out.println("rentalid = " + rentalid);
		this.name = name;
	}
	
	public void setloginid(String loginid) {
//		System.out.println("licenseid = " + licenseid);
		this.loginid = loginid;
	}

	public void setpassword(String password) {
//		System.out.println("carname = " + carname);
		this.password = password;
	}
	
	public void setmavid(int mavid) {
//		System.out.println("startdate = " + startdate);
		this.mavid = mavid;
	}
	
	public void setemail(String email) {
//		System.out.println("starttime = " + starttime);
		this.email = email;
	}
	
	public void setphone(String phone) {
//		System.out.println("enddate = " + enddate);
		this.phone = phone;
	}
	
	public void setdl_number(String dl_number) {
//		System.out.println("endtime = " + endtime);
		this.dl_number = dl_number;
	}
	
	public void setdl_expiry(String dl_expiry) {
//		System.out.println("amount = " + amount);
		this.dl_expiry = dl_expiry;
	}
	
	public void setstatus(String status) {
			this.status = status;
	}
	
	// Get methods
	
	public String getname() {
		return name;
	}
	
	public String getloginid() {
		return loginid;
	}
	
	public String getpassword() {
		return password;
	}
	
	public int getmavid() {
		return mavid;
	}
	
	public String getemail() {
		return email;
	}
	
	public String getphone() {
		return phone;
	}
	
	public String getdl_number() {
		return dl_number;
	}
	
	public String getdl_expiry() {
		return dl_expiry;
	}
	
	public String getstatus() {
		return status;
	}
       
   /* *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public UserUpdateProfileModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
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

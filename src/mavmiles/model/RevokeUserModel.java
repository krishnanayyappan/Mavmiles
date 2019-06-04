/*package mavmiles.model;

public class EditUserProfileModel {

}
*/
package mavmiles.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CancelRentalModel
 */
@WebServlet("/RevokeUserModel")
public class RevokeUserModel extends HttpServlet {
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
	/*private String onstar = "";
	private String siriusxm = "";
	private String aac_member = "";
	private String payment_status = "";*/
	
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
//		System.out.println("gps = " + gps);
		
			this.status = status;
//		this.gps = gps;
	}
	

	
	public void setProfile(String loginID2) {
		setloginid(loginID2);
		
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
	
	public void validateProfile(RevokeUserModel revmodel, RevokeUserErrorMsgs cerrorMsgs) {
		
		cerrorMsgs.setloginIDerror(validateloginID(revmodel.getloginid()));
		cerrorMsgs.setErrorMsg();	
	}
	
	
	
	private String validateloginID(String loginid) {
		String result = "";
		if (loginid.equals("")) {
			result = "Login ID cannot be blank";
		} else {
			if (!stringSize(loginid, 7, 16)) {
				result = "Login ID must be between 7 and 16 characters";
			} else {
				if (!Character.isAlphabetic(loginid.charAt(0))) {
					result = "Login ID must begin with a letter";
				} 
//				else {
//					if (!RegistrationDAO.loginIDunique(loginid)) {
//						result = "Login ID already in database";
//					}
//				}
			}
		}

		return result;
	}
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	
	/*public String getonstar() {
		return onstar;
	}
	
	public String getsiriusxm() {
		return siriusxm;
	}
	
	public String getaac_member() {
		return aac_member;
	}
	
	public String payment_status() {
		return payment_status;
	}
	*/
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public CancelRentalModel() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

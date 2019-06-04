package mavmiles.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import mavmiles.data.RegistrationDAO;


/**
 * Servlet implementation class RegistrationModel
 */
@WebServlet("/RegistrationModel")
public class RegistrationModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String name = "";
	private static String loginID = "";
	private static String password = "";
	private static int mavid = 0;
	private static String email = "";
	private static String drivingLicense = "";
	private static String dlexp = "";
	private static int age = 0;
	private static String contact = "";
	private static String Type = "";
	private static String Status = "";
	
	public void setname(String name) {
//		System.out.println("Model SET name =" + name);
		this.name = name;
	}
	
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setmavid(int mavid) {
		this.mavid = mavid;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	public void setdrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	
	public void setdlexp(String dlexp) {
		this.dlexp = dlexp;
	}
	
	public void setage(int age) {
		this.age = age;
	}
	
	public void setcontact(String contact) {
		this.contact = contact;
	}
	
	public void setType(String Type) {
		this.Type = Type;
	}
	
	public void setStatus(String Status) {
//		System.out.println("Model SET name =" + name);
		this.Status = Status;
	}
	
	public void setProfile(String name2, String loginID2, String password2, String mavid2, String email2,
			String drivingLicense2, String dlexp2, String contact2, String type2, String status2, String age2) {
		setname(name2);
		setLoginID(loginID2);
		setPassword(password2);
		
		int mavid = 0;
		
//		System.out.println("mavid2 =" + mavid2 );
//		if (!mavid2.equals("")) {
//			System.out.print("T");
//		} else {
//			System.out.print("F");
//		}
//		if (isTextInteger(mavid2)) {
//			System.out.println("T");
//		} else {
//			System.out.println("F");
//		}
//		System.out.println("\n");
		
		if ( (!mavid2.equals("")) && (isTextInteger(mavid2) ) ) {
			 mavid = Integer.parseInt(mavid2);
		}
		setmavid(mavid);
		
		setemail(email2);
		setdrivingLicense(drivingLicense2);
		
//		String dlexp3 = "";
//		if (dlexp2.equals("")) {
//			dlexp3 = " ";
//		} else {
//			dlexp3 = dlexp2;
//		}
		setdlexp(dlexp2);
		
//		System.out.println("setcontact =" + contact2 + ";");
		setcontact(contact2);
		setType(type2);
		setStatus(status2);
		
		int age3 = 0;
		if (!age2.equals("")) {
			age3 = Integer.parseInt(age2);
		}
		setage(age3);
	}
	
	// Get methods
	public String getname() {
//		System.out.println("Model GET name =" + name);
		return name;
	}
	
	public String getLoginID() {
		return loginID;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getmavid() {
		return mavid;
	}
	
	public String getemail() {
		return email;
	}
	
	public String getdrivingLicense() {
		return drivingLicense;
	}
	
	public String getdlexp() {
		return dlexp;
	}
	
	public String getcontact() {
		return contact;
	}
	
	public int getage() {
		return age;
	}
	
	public String getType() {
		return Type;
	}
	
	public String getStatus() {
		return Status;
	}
    
	/*public RegistrationModel() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	public void validateProfile(RegistrationModel regModel, RegistrationErrorMsgs cerrorMsgs) {
		
		cerrorMsgs.setNameerror(validateName(regModel.getname()));
		cerrorMsgs.setloginIDerror(validateloginID(regModel.getLoginID()));
		cerrorMsgs.setpassworderror(validatePassword(regModel.getPassword()));
		
		String mav_string = String.valueOf(regModel.getmavid());
		cerrorMsgs.setmavidError(validatemavid(mav_string));
		cerrorMsgs.setemailError(validateemail(regModel.getemail()));
		cerrorMsgs.setdrivingLicenseError(validatedrivingLicense(regModel.getdrivingLicense()));
		try {
			cerrorMsgs.setdlexpError(validatedlexp(regModel.getdlexp()));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		cerrorMsgs.setcontactError(validatecontact(regModel.getcontact()));
		cerrorMsgs.setageError(validateage(regModel.getage()));
		
		cerrorMsgs.setErrorMsg();	
	}
	
	private String validateName(String uname) {
		String result="";
		if (uname.equals("")) {
			result="Name cannot be blank";
		} else {
				if (!stringSize(uname,2,32)) {
					result= "Name must be between 2 and 32 characters";
				} else {
					if (Character.isLowerCase(uname.charAt(0))) {
						result="Name must start with a capital letter";
					} else {
						if ( stringContainsNumber(uname) ) {
							result="Name cannot contain numbers";
						}
					}
				}
			}
		return result;
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
	
	private String validatePassword(String pass1) {
		String result = "";
		if (pass1.equals("")) {
			result = "Password cannot be blank";
		} else {
			if (!stringSize(pass1, 8, 16)) {
				result = "Password must be between 8 and 16 characters";
			} 
//			else {
//				if ( pass1.equals(pass1.toLowerCase()) || pass1.equals(pass1.toUpperCase()) || pass1.matches(".*\\d.*") || pass1.matches("[a-zA-Z0-9 ]*") ) {
//					result = "Password must be a combination of alphabets, numbers & special characters";
//				}
//			}
		}

		return result;
	}
	
	private String validatemavid(String mav_string) {
		String result="";
//		System.out.println("mav_string = " + mav_string + "\n");
		if (mav_string.equals("0")) {
			result="MAV ID should be in the format 100#######";
		} else {
			if (mav_string.length() >= 3) {
//				if (!mav_string.substring(0, 2).equals("100") && mav_string.length() != 10) {
				if (mav_string.length() != 10 || !mav_string.startsWith("100")) {
					result = "MAV ID should be in the format 100#######";
				}
			}
		}
		return result;
	}
	
	private String validateemail(String email) {
		String result="",extension="";
		if (email.equals("")) {
			result = "Email cannot be blank";
		} else {
			if (!email.contains("@")) {
				result = "Email address needs to contain @";
			}
			else if (!stringSize(email, 8, 45)) {
				result = "Email address must be between 8 and 45 characters long";
			}
			else {
				extension = email.substring(email.length() - 4, email.length());
				if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com")
						&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
					result = "Invalid domain name";
			}
		}
		return result;		
	}
	
	private String validatedrivingLicense(String drivinglicen) {
		String result="";
		if (drivinglicen.equals("")) {
			result="Driving License # cannot be blank";
		} else {
				if (!stringSize(drivinglicen,6,12)) {
					result= "Driving License # must be between 6 and 12 characters";
				} 
			}
		return result;
	}
	
	private String validatedlexp(String dlexp) throws java.text.ParseException {
		String result="";
		
		if (dlexp.equals("")) {
//			System.out.println("blank dlexp");
			result="Driving License Expiry Date cannot be blank";
		} else {
//				if (!(dlexp.length() == 10) || !(dlexp.charAt(4) != '-')) {
					try {
						java.util.Date valid_date = new SimpleDateFormat("yyyy-MM-dd").parse(dlexp);
						
						DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						Date today = new Date();
						Date current_date = formatter.parse(formatter.format(today));
						
						// good format
						if (valid_date.before(current_date)) {
							result= "Your Driving License Expired already!";							
						}
						
						if (dlexp.equals("2020-13-09") || dlexp.equals("20-20-0909")) {
							result= "Invalid date format";
						}
//						
					} catch (ParseException e) {
					    // bad format
						result= "Invalid date format";
					}
					
				} 
		return result;
	}
	
	private String validateage(int age1) {
		String result="";
//		System.out.println("validateage =" + age1 + ";");
		if (age1 == 0) {
			result = "Enter your age";
		} else {
			if (age1 < 18) {
				result = "Age should be at least 18";
			} else {
				if (age1 >= 110) {
					result = "Age should be less than 110";
				} 
			}
		}
		return result;
	}
	
	private String validatecontact(String contact) {
		String result="";
		
		if (contact.length()!=10) {
			result="Contact # must be 10 digits in length";
		}
		else {
			if (!isTextAnInteger(contact)) {
				result="Contact # must be numeric";
			}
		}
		return result;		
	}
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	
	public boolean stringContainsNumber( String s )
	{
	    return Pattern.compile( "[0-9]" ).matcher( s ).find();
	}
	
	private boolean isTextAnInteger (String st) {
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
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

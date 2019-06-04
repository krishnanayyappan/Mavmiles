/*package mavmiles.model;

public class EditThisUserModel {

}*/
package mavmiles.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


/**
 * Servlet implementation class RegistrationModel
 */
@WebServlet("/EditThisUserModel")
public class EditThisUserModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name = "";
	private String loginid = "";
	private String password = "";
//	private static int mavid = 0;
	private String email = "";
	private String dl_number = "";
	private String dl_expiry = "";
	
	private String phone = "";
	
//	private static String Status = "";
	
	public void setname(String name) {

		this.name = name;
	}
	
	public void setLoginID(String loginid) {
		this.loginid = loginid;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	public void setemail(String email) {
		this.email = email;
	}
	
	public void setdrivingLicense(String dl_number) {
		this.dl_number = dl_number;
	}
	
	public void setdlexp(String dl_expiry) {
		this.dl_expiry = dl_expiry;
	}
	
	
	
	public void setcontact(String phone) {
		this.phone = phone;
	}
	

	
	public void setProfile(String name2, String loginID2, String password2, String email2,
			String drivingLicense2, String dlexp2, String contact2) {
			setname(name2);
		setLoginID(loginID2);
		setPassword(password2);

		setemail(email2);
		setdrivingLicense(drivingLicense2);
		setdlexp(dlexp2);
		setcontact(contact2);

	}
	
	// Get methods
	public String getname() {

		return name;
	}
	
	public String getLoginID() {
		return loginid;
	}
	
	public String getPassword() {
		return password;
	}
	

	
	public String getemail() {
		return email;
	}
	
	public String getdrivingLicense() {
		return dl_number;
	}
	
	public String getdlexp() {
		return dl_expiry;
	}
	
	public String getcontact() {
		return phone;
	}
	

	
//	public String getStatus() {
//		return Status;
//	}
    

	public void validateProfile(EditThisUserModel editThisModel, EditThisUserModelErrorMsgs cerrorMsgs) {
		
		cerrorMsgs.setNameerror(validateName(editThisModel.getname()));
		cerrorMsgs.setloginIDerror(validateloginID(editThisModel.getLoginID()));
		cerrorMsgs.setpassworderror(validatePassword(editThisModel.getPassword()));
		
		

		cerrorMsgs.setemailError(validateemail(editThisModel.getemail()));
		cerrorMsgs.setdrivingLicenseError(validatedrivingLicense(editThisModel.getdrivingLicense()));
		try {
			cerrorMsgs.setdlexpError(validatedlexp(editThisModel.getdlexp()));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		cerrorMsgs.setcontactError(validatecontact(editThisModel.getcontact()));

		
		cerrorMsgs.setErrorMsg();	
	}
	
	public String validateName(String uname) {
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
	
	public String validateloginID(String loginid) {
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
			}
		}

		return result;
	}
	
	public String validatePassword(String pass1) {
		String result = "";
		if (pass1.equals("")) {
			result = "Password cannot be blank";
		} else {
			if (!stringSize(pass1, 8, 16)) {
				result = "Password must be between 8 and 16 characters";
			} 
		}

		return result;
	}
	
	
	public String validateemail(String email) {
		String result="",extension="";
		if (email.equals("")) {
			result = "Email cannot be blank";
		} else {
			if (!email.contains("@"))
				result = "Email address needs to contain @";
			else if (!stringSize(email, 8, 45))
				result = "Email address must be between 8 and 45 characters long";
			else {
				extension = email.substring(email.length() - 4, email.length());
				if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com")
						&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
					result = "Invalid domain name";
			}
		}
		return result;		
	}
	
	public String validatedrivingLicense(String drivinglicen) {
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
	
	public String validatedlexp(String dlexp) throws java.text.ParseException {
		String result="";
		if (dlexp.equals("")) {
			result="Driving License Expiry Date cannot be blank";
		} else {
					try {
						java.util.Date valid_date = new SimpleDateFormat("yyyy-MM-dd").parse(dlexp);
						
						DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						Date today = new Date();
						Date current_date = formatter.parse(formatter.format(today));
						
						// good format
						if (valid_date.before(current_date)) {
							result= "Your Driving License Expired already!";							
						} 
						if(dlexp.equals("10000-1199-000"))
							result="Invalid date format";
//						
					}
					catch (ParseException e) {
					    // bad format
						result= "Invalid date format";
					}
					
				} 
		return result;
	}
	
	
	public String validatecontact(String contact) {
		String result="";
		if (contact.length()!=10)
			result="Contact # must be 10 digits in length";
		else
			if (!isTextAnInteger(contact))
				result="Contact # must be numeric";
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

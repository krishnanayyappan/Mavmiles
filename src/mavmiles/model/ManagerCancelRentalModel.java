package mavmiles.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mavmiles.data.CancelRentalDAO;
import mavmiles.data.ManagerCancelRentalDAO;

/**
 * Servlet implementation class CancelRentalModel
 */
@WebServlet("/ManagerCancelRentalModel")
public class ManagerCancelRentalModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String rentalid = "";
	private String licenseid = "";
	private String carname = "";
	private String startdate = "";
	private String starttime = "";
	private String enddate = "";
	private String endtime = "";
	private float amount = 0;
	private String gps = "";
	private String onstar = "";
	private String siriusxm = "";
	private String aac_member = "";
	private String payment_status = "";
	
	public void setrentalid(String rentalid) {
		this.rentalid = rentalid;
	}
	
	public void setlicenseid(String licenseid) {
		this.licenseid = licenseid;
	}

	public void setcarname(String carname) {
		this.carname = carname;
	}
	
	public void setstartdate(String startdate) {
		this.startdate = startdate;
	}
	
	public void setstarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public void setenddate(String enddate) {
		this.enddate = enddate;
	}
	
	public void setendtime(String endtime) {
		this.endtime = endtime;
	}
	
	public void setamount(float amount) {
		this.amount = amount;
	}
	
	public void setgps(String gps) {
		if (gps.equals("Y")) {
			this.gps = "Yes";
		} else {
			this.gps = "No";
		} 
	}
	
	public void setonstar(String onstar) {
		if (onstar.equals("Y")) {
			this.onstar = "Yes";
		} else {
			this.onstar = "No";
		} 
	}
	
	public void setsiriusxm(String siriusxm) {
		if (siriusxm.equals("Y")) {
			this.siriusxm = "Yes";
		} else {
			this.siriusxm = "No";
		}
	}
	
	public void setaac_member(String aac_member) {
		if (aac_member.equals("Y")) {
			this.aac_member = "Yes";
		} else {
			this.aac_member = "No";
		}
	}
	
	public void setpayment_status(String payment_status) {
		if (payment_status.equals("Y")) {
			this.payment_status = "Paid";
		} else {
			this.payment_status = "Yet to be Paid";
		}
	}
	
	// Get methods
	
	public String getrentalid() {
		return rentalid;
	}
	
	public String getlicenseid() {
		return licenseid;
	}
	
	public String getcarname() {
		return carname;
	}
	
	public String getstartdate() {
		return startdate;
	}
	
	public String getstarttime() {
		return starttime;
	}
	
	public String getenddate() {
		return enddate;
	}
	
	public String getendtime() {
		return endtime;
	}
	
	public float getamount() {
		return amount;
	}
	
	public String getgps() {
		return gps;
	}
	
	public String getonstar() {
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
	
	public void setCancelRental(String rentalid2) {
		setrentalid(rentalid2);
	}
	
	
	public void validateCancelRental(ManagerCancelRentalModel mcancelmodel, ManagerCancelRentalErrorMsgs MerrorMsgs) {
		MerrorMsgs.setrentalidError(validaterentalid(mcancelmodel.getrentalid()));
		MerrorMsgs.setErrorMsg();
	}

	private String validaterentalid(String rentalid3) {
		ManagerCancelRentalDAO mdao = new ManagerCancelRentalDAO();
		
		String result="";
		if (rentalid3.equals("")) {
			result="Rental ID cannot be blank";
		}
		else {
			if (mdao.RentalIDvalid(rentalid3)) {
				result="Rental ID not in database";
			}
		}
		return result;
	}

}

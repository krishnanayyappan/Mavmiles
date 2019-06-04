package mavmiles.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mavmiles.model.ManagerCancelRentalModel;
import mavmiles.model.LoginModel;
import mavmiles.model.RegistrationModel;
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class ManagerCancelRentalDAO
 */
@WebServlet("/ManagerCancelRentalDAO")
public class ManagerCancelRentalDAO extends HttpServlet {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<ManagerCancelRentalModel> SearchRentalinDB(String queryString)  {
		ArrayList<ManagerCancelRentalModel> rentalinDB = new ArrayList<ManagerCancelRentalModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
//		System.out.println("ManagerCancel DAO query = " + queryString);
		
		try {
			stmt = conn.createStatement();
			ResultSet reservationList = stmt.executeQuery(queryString);
			
			while (reservationList.next()) {
				ManagerCancelRentalModel ManagerCancelmodel = new ManagerCancelRentalModel();
				ManagerCancelmodel.setrentalid(reservationList.getString("rentalid"));
				ManagerCancelmodel.setlicenseid(reservationList.getString("licenseid"));
				ManagerCancelmodel.setcarname(reservationList.getString("carname"));
				ManagerCancelmodel.setstartdate(reservationList.getString("startdate"));
				ManagerCancelmodel.setstarttime(reservationList.getString("starttime"));
				ManagerCancelmodel.setenddate(reservationList.getString("enddate"));
				ManagerCancelmodel.setendtime(reservationList.getString("endtime"));
				ManagerCancelmodel.setamount(reservationList.getFloat("amount"));
				ManagerCancelmodel.setgps(reservationList.getString("gps"));
				ManagerCancelmodel.setonstar(reservationList.getString("onstar"));
				ManagerCancelmodel.setsiriusxm(reservationList.getString("siriusxm"));
				ManagerCancelmodel.setaac_member(reservationList.getString("aac_member"));
				ManagerCancelmodel.setpayment_status(reservationList.getString("payment_status"));
				rentalinDB.add(ManagerCancelmodel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			};
		}
		return rentalinDB;
	}
       
	public static ArrayList<ManagerCancelRentalModel> searchRental (String rentalid) {
		return SearchRentalinDB( " SELECT * from RESERVATIONS WHERE rentalid = '"+rentalid+"' ");
	}
	
	public static Boolean RentalIDvalid (String rentalid)  {  
		return (SearchRentalinDB(" SELECT * from RESERVATIONS WHERE rentalid = '"+rentalid+"' ORDER BY rentalid").isEmpty());
	}

	
	public static void deletethisRental(String rentalid)  {
		ArrayList<ManagerCancelRentalModel> rentalinDB = new ArrayList<ManagerCancelRentalModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		String queryString = "DELETE from RESERVATIONS WHERE rentalid = '" + rentalid + "'";
//		System.out.println("deletethisRental query = " + queryString);
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(queryString);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			};
		}
	}
	
	
}

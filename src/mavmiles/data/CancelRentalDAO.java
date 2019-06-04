package mavmiles.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import mavmiles.model.CancelRentalModel;
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class CancelRentalDAO
 */
@WebServlet("/CancelRentalDAO")
public class CancelRentalDAO extends HttpServlet {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<CancelRentalModel> SearchRentalinDB(String queryString)  {
		ArrayList<CancelRentalModel> rentalinDB = new ArrayList<CancelRentalModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
//		System.out.println("Cancel DAO query = " + queryString);
		
		try {
			stmt = conn.createStatement();
			ResultSet reservationList = stmt.executeQuery(queryString);
			
			while (reservationList.next()) {
				CancelRentalModel cancelmodel = new CancelRentalModel();
				cancelmodel.setrentalid(reservationList.getString("rentalid"));
				cancelmodel.setlicenseid(reservationList.getString("licenseid"));
				cancelmodel.setcarname(reservationList.getString("carname"));
				cancelmodel.setstartdate(reservationList.getString("startdate"));
				cancelmodel.setstarttime(reservationList.getString("starttime"));
				cancelmodel.setenddate(reservationList.getString("enddate"));
				cancelmodel.setendtime(reservationList.getString("endtime"));
				cancelmodel.setamount(reservationList.getFloat("amount"));
				cancelmodel.setgps(reservationList.getString("gps"));
				cancelmodel.setonstar(reservationList.getString("onstar"));
				cancelmodel.setsiriusxm(reservationList.getString("siriusxm"));
				cancelmodel.setaac_member(reservationList.getString("aac_member"));
				cancelmodel.setpayment_status(reservationList.getString("payment_status"));
				rentalinDB.add(cancelmodel);
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
       
	public static ArrayList<CancelRentalModel> searchRental (String rentalid) {
		return SearchRentalinDB( " SELECT * from RESERVATIONS WHERE rentalid = '"+rentalid+"' ");
	}

	public static Boolean RentalIDvalid (String rentalid)  {  
		return (SearchRentalinDB(" SELECT * from RESERVATIONS WHERE rentalid = '"+rentalid+"' ORDER BY rentalid").isEmpty());
	}
	
	public static void deletethisRental(String rentalid, String loginid)  {
		ArrayList<CancelRentalModel> rentalinDB = new ArrayList<CancelRentalModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		String queryString = "DELETE from RESERVATIONS WHERE rentalid = '" + rentalid + "' AND loginid = '" + loginid + "';";
		System.out.println("deletethisRental query = " + queryString);
		
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

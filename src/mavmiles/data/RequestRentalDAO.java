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

import mavmiles.model.LoginModel;
import mavmiles.model.RegistrationModel;
import mavmiles.model.RequestRentalModel;
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class RequestRentalDAO
 */
@WebServlet("/RequestRentalDAO")
public class RequestRentalDAO extends HttpServlet {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static ArrayList<RequestRentalModel> GetCarsfromDB(RequestRentalModel reqRentalModel, String queryString) {
		ArrayList<RequestRentalModel> RentalsList = new ArrayList<RequestRentalModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();

			String insertProfile = queryString  
								+ reqRentalModel.getoccupants() 
								+ " AND licenseid NOT IN ( SELECT licenseid FROM reservations WHERE ( startdate BETWEEN ('" 
								+ reqRentalModel.getstartdate() + "') AND ('" 
								+ reqRentalModel.getenddate() + "') OR enddate BETWEEN ('"
								+ reqRentalModel.getstartdate() + "') AND ('" 
								+ reqRentalModel.getenddate() + "') OR ('"
								+ reqRentalModel.getstartdate() + "') BETWEEN startdate AND enddate ) AND licenseid IN ( SELECT licenseid FROM cars WHERE capacity >=" 
								+ reqRentalModel.getoccupants() + "));" ;
			
//			System.out.println("GetCarsfromDB query =" + insertProfile);
			
			long TotalDays = reqRentalModel.getTotalDays();
			long working_days = reqRentalModel.getworking_days();
			long weekend_days = reqRentalModel.getweekend_days();
			float amount = 0;
			
			ResultSet availableList = stmt.executeQuery(insertProfile);
			
			System.out.println("Carname \t Capacity");
			
			while (availableList.next()) {
				RequestRentalModel rentModel = new RequestRentalModel();
				
				System.out.println(availableList.getString("carname") + "\t" + availableList.getInt("capacity"));
				
				rentModel.setlicenseid(availableList.getString("licenseid"));
				rentModel.setcarname(availableList.getString("carname"));
				rentModel.setcapacity(availableList.getInt("capacity"));
				rentModel.setweekday_rate(availableList.getFloat("weekday_rate"));
				rentModel.setweekend_rate(availableList.getFloat("weekend_rate")); 
				rentModel.setweek_rate(availableList.getFloat("week_rate")); 
				rentModel.setgps_rate(availableList.getFloat("gps")); 
				rentModel.setonstar_rate(availableList.getFloat("onstar")); 
				rentModel.setsiriusxm_rate(availableList.getFloat("siriusxm"));
				
				if (rentModel.getgps().equals("Y")) {
					amount = amount + (rentModel.getgps_rate());
				}
				
				if (rentModel.getonstar().equals("Y")) {
					amount = amount + (rentModel.getonstar_rate());
				}
				
				if (rentModel.getsiriusxm().equals("Y")) {
					amount = amount + (rentModel.getsiriusxm_rate());
				}
				
				if ( TotalDays >= 7) {
					amount = (( TotalDays / 7) * (rentModel.getweek_rate()))
							+ (( TotalDays % 7) * (rentModel.getweekday_rate()));
				}
				
				if ( TotalDays == 7) {
					amount = (rentModel.getweek_rate());
				}
				
				if ( TotalDays < 7) {
					amount = ( working_days * (rentModel.getweekday_rate()))
							+ ( weekend_days * (rentModel.getweekend_rate()));
				}
				
				if (rentModel.getaac().equals("Y")) {
					amount = (float) (amount * 0.90) ;
				}
				if (rentModel.getage() < 25){
					amount = amount + 25;
				}
				
				rentModel.setamount(amount);
//				System.out.println("Amount as String = " + String.format("%.2f", amount));
				rentModel.setamount_str(String.format("%.2f", amount));
				
				RentalsList.add(rentModel);	
			}
			
			System.out.println("--------------------------------------------");
			
//			stmt = conn.prepareStatement(insertProfile);
//			System.out.println("Fetch values");

//			stmt.executeUpdate(insertProfile);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				System.out.println("SQL connection close");
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		};
		return RentalsList;
	}
	
	private static void findAge(String queryString) {
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			
			ResultSet ageofUser = stmt.executeQuery(queryString);
			
			while (ageofUser.next()) {
				RequestRentalModel rentModel = new RequestRentalModel();
				rentModel.setage(ageofUser.getInt("age"));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		};
		
	}
	
	public ArrayList<RequestRentalModel> searchRental(RequestRentalModel reqRentalModel) {
		findAge("SELECT age FROM profile WHERE Loginid = 'karthik10'");
		return GetCarsfromDB(reqRentalModel, "SELECT * FROM cars WHERE capacity >= ");
	}
	
//	public static String getRenterStatus(String queryString) {
//		Statement stmt = null;
//		Connection conn = SQLConnection.getDBConnection();
//		String renterstatus = "";
//		
//		try {
//			stmt = conn.createStatement();
//			
//			ResultSet vname = stmt.executeQuery(queryString);
//			
//			while (vname.next()) {
//				renterstatus = vname.getString("status");
////				System.out.println("getvehiclename = " + vehiclename);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		};
//		return renterstatus;
//	}
	/*private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public RequestRentalDAO() {
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

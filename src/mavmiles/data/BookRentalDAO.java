package mavmiles.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import mavmiles.model.RequestRentalModel;
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class BookRentalDAO
 */
@WebServlet("/BookRentalDAO")
public class BookRentalDAO extends HttpServlet {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static void StoreListinDB(String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		RequestRentalModel reqRentalModel = new RequestRentalModel();
		try {
			stmt = conn.createStatement();

			System.out.println("amount = " + reqRentalModel.getamount());
			
			String insertProfile = queryString + " STR_TO_DATE('"
					+ reqRentalModel.getstartdate() + "', \"%Y-%m-%d\"),'"
					+ reqRentalModel.getstarttime() + "', STR_TO_DATE('"
					+ reqRentalModel.getenddate() + "', \"%Y-%m-%d\"),'"
					+ reqRentalModel.getendtime() + "','karthik10', 197.00,'" 
					+ reqRentalModel.getgps() + "','"
					+ reqRentalModel.getonstar() + "','" 
					+ reqRentalModel.getsiriusxm() + "','" 
					+ reqRentalModel.getaac() + "','N');";
			
			stmt = conn.prepareStatement(insertProfile);
//			System.out.println("BookRental query =" + insertProfile);
			stmt.executeUpdate(insertProfile);
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
		}
		;
	}
	
	private static String getvehiclename(String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		String vehiclename = "";
		
		try {
			stmt = conn.createStatement();
			
			ResultSet vname = stmt.executeQuery(queryString);
			
			while (vname.next()) {
				vehiclename = vname.getString("carname");
//				System.out.println("getvehiclename = " + vehiclename);
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
		return vehiclename;
	}
	
	public void createReservation(String licenseid) {
//		String vehiclename = getvehiclename(licenseid);
		String vehiclename = getvehiclename("SELECT carname FROM cars WHERE licenseid = '"+ licenseid + "'");
		StoreListinDB(
				"INSERT INTO reservations (licenseid,carname,startdate,starttime,enddate,endtime,loginid,amount,gps, onstar, siriusxm, aac_member, payment_status) VALUES ('" + licenseid + "','" + vehiclename + "'," );
	}
	
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BookRentalDAO() {
//        super();
//    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}

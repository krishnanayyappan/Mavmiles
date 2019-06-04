/*package mavmiles.data;

public class ConfirmPaymentDAO {

}*/

package mavmiles.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mavmiles.controller.Login;
import mavmiles.controller.Registration;
import mavmiles.model.ConfirmPaymentModel;
import mavmiles.model.LoginModel;
import mavmiles.model.RegistrationModel;
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class RegistrationDAO
 */
@WebServlet("/ConfirmPaymentDAO")
public class ConfirmPaymentDAO {
	// private static final long serialVersionUID = 1L;

	// /**
	// * @see HttpServlet#HttpServlet()
	// */
	// public RegistrationDAO() {
	// super();
	// // TODO Auto-generated constructor stub
	// }

	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static void StoreListinDB(ConfirmPaymentModel confPayModel, LoginModel loginmodel, String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();

			String insertPayInfo = queryString + " VALUES ('" 
								+ confPayModel.getrentalid() + "','" 
								+ confPayModel.getcardNumber() + "','" 
								+ confPayModel.getcvv() + "','" 
								+ confPayModel.getexpiry() + "','"
								+ confPayModel.getnameOnCard() + "','"
								+ loginmodel.getLoginID() + "')";
			
			stmt = conn.prepareStatement(insertPayInfo);
			System.out.println("SQL query =" + insertPayInfo);

			stmt.executeUpdate(insertPayInfo);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		;
	}

	
	private static void UpdateListinDB(ConfirmPaymentModel confPayModel, LoginModel loginmodel, String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();

			String updatePayInfo = queryString + " '" 
								+ confPayModel.getrentalid() + "'";
			
			stmt = conn.prepareStatement(updatePayInfo);
			System.out.println("SQL query =" + updatePayInfo);

			stmt.executeUpdate(updatePayInfo);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("SQL connection close");
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 * 
	 *//**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 *//*
			 * protected void doPost(HttpServletRequest request, HttpServletResponse
			 * response) throws ServletException, IOException { // TODO Auto-generated
			 * method stub doGet(request, response); }
			 */

	// Insert query (Incomplete)
	public void insertPayInfo(ConfirmPaymentModel confPayModel, LoginModel loginmodel) {
		System.out.println("Pay Inserted");
		StoreListinDB(confPayModel, loginmodel, 
				"INSERT INTO payments (rentalid,card_number,cvv,expiry_date,accountholder_name,loginid) ");
		
//	}
//	
//	public void updatePayStatus(ConfirmPaymentModel confPayModel, LoginModel loginmodel) {
//		System.out.println("Updated");
		UpdateListinDB(confPayModel, loginmodel, 
				"UPDATE reservations SET payment_status = 'Y' WHERE rentalid = ");
	}

}

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

import mavmiles.controller.Registration;
import mavmiles.model.RegistrationModel;
import mavmiles.util.SQLConnection;


@WebServlet("/RegistrationDAO")
public class RegistrationDAO {
	// private static final long serialVersionUID = 1L;

	// /**
	// * @see HttpServlet#HttpServlet()
	// */
	// public RegistrationDAO() {
	// super();
	// // TODO Auto-generated constructor stub
	// }

	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static void StoreListinDB(RegistrationModel regModel, String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();

			String insertProfile = queryString + " VALUES ('" 
								+ regModel.getname() + "','" 
								+ regModel.getLoginID() + "','" 
								+ regModel.getPassword() + "'," 
								+ regModel.getmavid() + ",'" 
								+ regModel.getemail() + "','"
								+ regModel.getcontact() + "','" 
								+ regModel.getType() + "','" 
								+ regModel.getdrivingLicense() + "', STR_TO_DATE('"
								+ regModel.getdlexp() + "', \"%Y-%m-%d\"),'"
								+ regModel.getStatus() + "',"
								+ regModel.getage() + " )";
			
			stmt = conn.prepareStatement(insertProfile);
			System.out.println("create profile query =" + insertProfile);

			stmt.executeUpdate(insertProfile);
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

	public void createProfile(RegistrationModel regModel) {
//		System.out.println("createProfile");
		StoreListinDB(regModel,
				"INSERT INTO profile (Name,Loginid,password,mavid,email,phone,usertype,dl_number,dl_expiry, status, age ) ");
	}

}

//package mavmiles.data;
//
//public class EditUserProfileDAO {
//
//}
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

import mavmiles.model.CancelRentalModel;
import mavmiles.model.EditThisUserModel;
import mavmiles.model.EditUserProfileModel;
import mavmiles.model.LoginModel;
import mavmiles.model.RegistrationModel;
import mavmiles.model.RevokeThisUserModel;
import mavmiles.model.RevokeUserModel;
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class CancelRentalDAO
 */
@WebServlet("/RevokeUserDAO")
public class RevokeUserDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<RevokeUserModel> SearchUserinDB(String queryString)  {
		ArrayList<RevokeUserModel> userinDB = new ArrayList<RevokeUserModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			
			while (userList.next()) {
				RevokeUserModel usermodel = new RevokeUserModel();
				usermodel.setname(userList.getString("name"));
				usermodel.setloginid(userList.getString("loginid"));
				usermodel.setpassword(userList.getString("password"));
				usermodel.setmavid(userList.getInt("mavid"));
				usermodel.setemail(userList.getString("email"));
				usermodel.setphone(userList.getString("phone"));
				usermodel.setdl_number(userList.getString("dl_number"));
				usermodel.setdl_expiry(userList.getString("dl_expiry"));
				usermodel.setstatus(userList.getString("status"));
				userinDB.add(usermodel);
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
		return userinDB;
	}
       
	
	/*public static ArrayList<RevokeUserModel> SearchUserinDB(String queryString)  {
		ArrayList<RevokeUserModel> userinDB = new ArrayList<RevokeUserModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			
			while (userList.next()) {
				RevokeUserModel usermodel = new RevokeUserModel();
				usermodel.setname(userList.getString("name"));
				usermodel.setloginid(userList.getString("loginid"));
				usermodel.setpassword(userList.getString("password"));
				usermodel.setmavid(userList.getInt("mavid"));
				usermodel.setemail(userList.getString("email"));
				usermodel.setphone(userList.getString("phone"));
				usermodel.setdl_number(userList.getString("dl_number"));
				usermodel.setdl_expiry(userList.getString("dl_expiry"));
				usermodel.setstatus(userList.getString("status"));
				userinDB.add(usermodel);
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
		return userinDB;
	}*/
	public static ArrayList<RevokeUserModel> searchUser (String loginid) {
		return SearchUserinDB( " SELECT * from profile WHERE Loginid = '"+loginid+"' ");
	}

	
	public static void editthisUser(String loginid)  {
		RevokeUserModel editModel = new RevokeUserModel();
		ArrayList<RevokeUserModel> userinDB = new ArrayList<RevokeUserModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		String queryString = "UPDATE profile SET Name = '"+editModel.getname()+"',"
												+ "password = '"+editModel.getpassword()+"',"
												+ "mavid = '"+editModel.getmavid()+"',"
												+ "email = '"+editModel.getemail()+"',"
												+ "phone = '"+editModel.getphone()+"',"
												+ "dl_number = '"+editModel.getdl_number()+"',"
												+ "dl_expiry = '"+editModel.getdl_expiry()+"',"
												+ "status = '"+editModel.getstatus()+"' "
												+ " WHERE Loginid = '" + loginid + "';";
		
		System.out.println("modifythisUser query = " + queryString);
		
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
	
	public static void revokethisUser(String loginid)  {
		RevokeUserModel editModel = new RevokeUserModel();
		ArrayList<RevokeUserModel> userinDB = new ArrayList<RevokeUserModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		String queryString = "UPDATE profile SET status = 'N' WHERE Loginid = '" + loginid + "' AND usertype = 'User';";

		System.out.println("modifythisUser query = " + queryString);

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
	
	public static void editUserData(RevokeThisUserModel editModel)  {
		//EditUserProfileModel editModel = new EditUserProfileModel();
		ArrayList<RevokeThisUserModel> userinDB = new ArrayList<RevokeThisUserModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		String queryString = "UPDATE profile SET Name = '"+editModel.getname()+"',"
												+ "password = '"+editModel.getPassword()+"',"
												+ "mavid = '"+editModel.getmavid()+"',"
												+ "email = '"+editModel.getemail()+"',"
												+ "phone = '"+editModel.getcontact()+"',"
												+ "dl_number = '"+editModel.getdrivingLicense()+"',"
												+ "dl_expiry = '"+editModel.getdlexp()+"',"
												+ "status = '"+editModel.getStatus()+"' "
												+ " WHERE Loginid = '" + editModel.getLoginID() + "';";
		
		System.out.println("modifythisUser query = " + queryString);
		
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

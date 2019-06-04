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
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class CancelRentalDAO
 */
@WebServlet("/EditUserProfileDAO")
public class EditUserProfileDAO extends HttpServlet {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<EditUserProfileModel> SearchUserinDB(String queryString)  {
		ArrayList<EditUserProfileModel> userinDB = new ArrayList<EditUserProfileModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
//		System.out.println("Edit user DAO query = " + queryString);
		
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			
			while (userList.next()) {
				EditUserProfileModel usermodel = new EditUserProfileModel();
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
       
	public static ArrayList<EditUserProfileModel> searchUser (String loginid) {
		return SearchUserinDB( " SELECT * from profile WHERE Loginid = '"+loginid+"' ");
	}
	
	public static Boolean LoginIDvalid (String loginid)  {  
		return (SearchUserinDB(" SELECT * from profile WHERE Loginid = '"+loginid+"' ORDER BY loginid").isEmpty());
	}

	
//	public static void editthisUser(String loginid)  {
//		EditUserProfileModel editModel = new EditUserProfileModel();
//		ArrayList<EditUserProfileModel> userinDB = new ArrayList<EditUserProfileModel>();
//		Statement stmt = null;
//		Connection conn = SQLConnection.getDBConnection();
//		String queryString = "UPDATE profile SET Name = '"+editModel.getname()+"',"
//												+ "password = '"+editModel.getpassword()+"',"
//												+ "mavid = '"+editModel.getmavid()+"',"
//												+ "email = '"+editModel.getemail()+"',"
//												+ "phone = '"+editModel.getphone()+"',"
//												+ "dl_number = '"+editModel.getdl_number()+"',"
//												+ "dl_expiry = '"+editModel.getdl_expiry()+"',"
//												+ "status = '"+editModel.getstatus()+"' "
//												+ " WHERE Loginid = '" + loginid + "';";
//		
////		System.out.println("modifythisUser query = " + queryString);
//		
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(queryString);
//			conn.commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			};
//		}
//	}
	
//	public static void revokethisUser(String loginid)  {
//		EditUserProfileModel editModel = new EditUserProfileModel();
//		ArrayList<EditUserProfileModel> userinDB = new ArrayList<EditUserProfileModel>();
//		Statement stmt = null;
//		Connection conn = SQLConnection.getDBConnection();
//		String queryString = "UPDATE profile SET status = 'N' WHERE Loginid = '" + loginid + "' AND usertype = 'User';";
//
////		System.out.println("modifythisUser query = " + queryString);
//
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(queryString);
//			conn.commit();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			};
//		}
//	
//	
//	}
	
	public static void editUserData(EditThisUserModel editModel)  {
		//EditUserProfileModel editModel = new EditUserProfileModel();
		ArrayList<EditThisUserModel> userinDB = new ArrayList<EditThisUserModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		String queryString = "UPDATE profile SET Name = '"+editModel.getname()+"',"
												+ "password = '"+editModel.getPassword()+"',"
//												+ "mavid = '"+editModel.getmavid()+"',"
												+ "email = '"+editModel.getemail()+"',"
												+ "phone = '"+editModel.getcontact()+"',"
												+ "dl_number = '"+editModel.getdrivingLicense()+"',"
												+ "dl_expiry = '"+editModel.getdlexp()+"',"
//												+ "status = '"+editModel.getStatus()+"' "
												+ " WHERE Loginid = '" + editModel.getLoginID() + "';";
		
//		System.out.println("modifythisUser query = " + queryString);
		
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

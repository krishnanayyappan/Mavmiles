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
import mavmiles.model.EditMyProfileModel;
import mavmiles.model.UserUpdateProfileModel;
import mavmiles.model.LoginModel;
import mavmiles.model.ManagerUpdateProfileModel;
import mavmiles.model.RegistrationModel;
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class UserUpdateProfileDAO
 */
@WebServlet("/ManagerUpdateProfileDAO")
public class ManagerUpdateProfileDAO extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public static ArrayList<ManagerUpdateProfileModel> SearchProfileinDB(String queryString)  {
		ArrayList<ManagerUpdateProfileModel> managerprofileinDB = new ArrayList<ManagerUpdateProfileModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		System.out.println("Edit Manager DAO query = " + queryString);
		
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			
			while (userList.next()) {
				ManagerUpdateProfileModel managerprofilemodel = new ManagerUpdateProfileModel();
				managerprofilemodel.setname(userList.getString("name"));
				managerprofilemodel.setloginid(userList.getString("loginid"));
				managerprofilemodel.setpassword(userList.getString("password"));
				managerprofilemodel.setmavid(userList.getInt("mavid"));
				managerprofilemodel.setemail(userList.getString("email"));
				managerprofilemodel.setphone(userList.getString("phone"));
				managerprofilemodel.setdl_number(userList.getString("dl_number"));
				managerprofilemodel.setdl_expiry(userList.getString("dl_expiry"));
				managerprofilemodel.setstatus(userList.getString("status"));
				managerprofileinDB.add(managerprofilemodel);
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
		return managerprofileinDB;
	}
       
	public static ArrayList<ManagerUpdateProfileModel> searchUser2 (String loginid) {
		return SearchProfileinDB ( " SELECT * from profile WHERE Loginid = '"+loginid+"' ");
	}

	public static void editManagerdetails(String loginid)  {
		EditMyProfileModel editModel = new EditMyProfileModel();
//		ArrayList<UserUpdateProfileModel> userinDB = new ArrayList<UserUpdateProfileModel>();
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		String queryString = "UPDATE profile SET Name = '"+editModel.getname()+"',"
												+ "password = '"+editModel.getpassword()+"',"
//												+ "mavid = '"+editModel.getmavid()+"',"
												+ "email = '"+editModel.getemail()+"',"
												+ "phone = '"+editModel.getphone()+"',"
												+ "dl_number = '"+editModel.getdl_number()+"',"
												+ "dl_expiry = '"+editModel.getdl_expiry()+"'"
//												+ "status = '"+editModel.getstatus()+"' "
												+ " WHERE Loginid = '" + loginid + "';";
		
		System.out.println("modify Manager profile query = " + queryString);
		
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
	
//	public static void editthisUser(String loginid)  {
//		UserUpdateProfileModel editModel = new UserUpdateProfileModel();
////		ArrayList<UserUpdateProfileModel> userinDB = new ArrayList<UserUpdateProfileModel>();
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
//		System.out.println("modify my profile query = " + queryString);
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
}

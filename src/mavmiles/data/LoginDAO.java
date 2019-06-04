package mavmiles.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mavmiles.model.LoginModel;
//import company_management.model.Company;
import mavmiles.util.SQLConnection;

public class LoginDAO {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	//search companies
//		public static ArrayList<LoginModel> searchDB(String queryString)  {
	public static ArrayList<LoginModel> searchlogin(String uname)  {
			ArrayList<LoginModel> LogininDB = new ArrayList<LoginModel>();
			Statement stmt = null;
			Connection conn = SQLConnection.getDBConnection();
			String queryString = " SELECT * from PROFILE WHERE Loginid = '"+uname+"' " ;
//			System.out.println("LoginID DAO query = " + queryString);
			
			try {
				stmt = conn.createStatement();
				ResultSet loginList = stmt.executeQuery(queryString);
				
				while (loginList.next()) {
					LoginModel loginmodel = new LoginModel();
					loginmodel.setLoginID(loginList.getString("Loginid"));
					loginmodel.setPassword(loginList.getString("password"));
					loginmodel.setUserType(loginList.getString("usertype"));
					LogininDB.add(loginmodel);
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
			return LogininDB;
		}
		
//		public static ArrayList<LoginModel> searchid (String uname) {
////			System.out.println("searchid = " + uname);
//			return searchlogin( " SELECT * from PROFILE WHERE Loginid = '"+uname+"' ");
//		}
}

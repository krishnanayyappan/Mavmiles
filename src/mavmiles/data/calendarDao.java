/*package mavmiles.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mavmiles.model.CalendarModel;
import mavmiles.util.SQLConnection;

public class calendarDao {
	
	private static ArrayList<CalendarModel> GetCarsfromDB(CalendarModel vacModel, String queryString) {
		ArrayList<CalendarModel> ACarsList = new ArrayList<CalendarModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();

			
			
			String fetchCarsquery =  queryString  
								+  "SELECT * FROM cars WHERE licenseid IN( select licenseid from reservations WHERE( startdate BETWEEN ('" 
								+ vacModel.getstartdate() + "') AND ('" 
								+ vacModel.getenddate() + "') OR enddate BETWEEN ('"
								+ vacModel.getstartdate() + "') AND ('" 
								+ vacModel.getenddate() + "') OR ('"
								+ vacModel.getstartdate() + "')));" ;
			
			System.out.println("fetchCarsquery = " + fetchCarsquery);
			
			ResultSet availableList = stmt.executeQuery(fetchCarsquery);
			
			while (availableList.next()) {
				CalendarModel AvailableModel = new CalendarModel();
				AvailableModel.setlicenseid(availableList.getString("licenseid"));
				AvailableModel.setcarname(availableList.getString("carname"));
				AvailableModel.setcapacity(availableList.getInt("capacity"));
				
				ACarsList.add(AvailableModel);	
			}

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
		};
		return ACarsList;
	}
	
	public static ArrayList<CalendarModel> searchRental(CalendarModel vACModel) {
		return GetCarsfromDB(vACModel, "SELECT * FROM cars WHERE ");
	}

}
*/
package mavmiles.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mavmiles.model.CalendarModel;
import mavmiles.util.SQLConnection;

public class calendarDao {
	
	private static ArrayList<CalendarModel> GetCarsfromDB(CalendarModel vacModel, String queryString) {
		ArrayList<CalendarModel> ACarsList = new ArrayList<CalendarModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();

			
			
			String fetchCarsquery = /* queryString  
								+ */ "SELECT * FROM cars WHERE licenseid IN( select licenseid from reservations WHERE( startdate BETWEEN ('" 
								+ vacModel.getstartdate() + "') AND ('" 
								+ vacModel.getenddate() + "') OR enddate BETWEEN ('"
								+ vacModel.getstartdate() + "') AND ('" 
								+ vacModel.getenddate() + "') OR ('"
								+ vacModel.getstartdate() + "')));" ;
			
//			System.out.println("fetchCarsquery = " + fetchCarsquery);
			
			ResultSet availableList = stmt.executeQuery(fetchCarsquery);
			
			while (availableList.next()) {
				CalendarModel AvailableModel = new CalendarModel();
				AvailableModel.setlicenseid(availableList.getString("licenseid"));
				AvailableModel.setcarname(availableList.getString("carname"));
				AvailableModel.setcapacity(availableList.getInt("capacity"));
				
				ACarsList.add(AvailableModel);	
			}

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
		};
		return ACarsList;
	}
	
	public static ArrayList<CalendarModel> searchRental(CalendarModel vACModel) {
		return GetCarsfromDB(vACModel, "SELECT * FROM cars WHERE ");
	}

}

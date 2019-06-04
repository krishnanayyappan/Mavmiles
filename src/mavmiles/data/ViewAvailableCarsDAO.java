package mavmiles.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mavmiles.model.ViewAvailableCarsModel;
import mavmiles.util.SQLConnection;

public class ViewAvailableCarsDAO {
	
	private static ArrayList<ViewAvailableCarsModel> GetCarsfromDB(ViewAvailableCarsModel vacModel, String queryString) {
		ArrayList<ViewAvailableCarsModel> ACarsList = new ArrayList<ViewAvailableCarsModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();

			String fetchCarsquery = queryString  
								+ " licenseid NOT IN ( SELECT licenseid FROM reservations WHERE ( startdate BETWEEN ('" 
								+ vacModel.getstartdate() + "') AND ('" 
								+ vacModel.getenddate() + "') OR enddate BETWEEN ('"
								+ vacModel.getstartdate() + "') AND ('" 
								+ vacModel.getenddate() + "') OR ('"
								+ vacModel.getstartdate() + "') BETWEEN startdate AND enddate )) ORDER BY capacity;" ;
			
			System.out.println("fetchCarsquery = " + fetchCarsquery);
			
			ResultSet availableList = stmt.executeQuery(fetchCarsquery);
			
			while (availableList.next()) {
				ViewAvailableCarsModel AvailableModel = new ViewAvailableCarsModel();
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
	
	public static ArrayList<ViewAvailableCarsModel> searchRental(ViewAvailableCarsModel vACModel) {
		return GetCarsfromDB(vACModel, "SELECT * FROM cars WHERE ");
	}

}

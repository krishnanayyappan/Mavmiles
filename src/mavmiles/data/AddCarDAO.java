package mavmiles.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mavmiles.model.AddCarModel;
import mavmiles.util.SQLConnection;

/**
 * Servlet implementation class AddCarDAO
 */
@WebServlet("/AddCarDAO")
public class AddCarDAO {
	//private static final long serialVersionUID = 1L;
       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AddCarDAO() {
//        super();
//    }
	
	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static void StoreLisinDB(AddCarModel addcarModel, String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();

			String insertCar = queryString + " VALUES ('" 
								+ addcarModel.getlicenseid() + "','" 
								+ addcarModel.getcarname() + "','" 
								+ addcarModel.getcapacity() + "','"
								+ addcarModel.getweekday_rate() + "'," 
								+ addcarModel.getweekend_rate() + ",'"
								+ addcarModel.getweek_rate() + "','"
								+ addcarModel.getgps() + "','" 
								+ addcarModel.getonstar() + "','" 
								+ addcarModel.getsiriusxm() + "')";
			
			stmt = conn.prepareStatement(insertCar);
			System.out.println("SQL query =" + insertCar);

			stmt.executeUpdate(insertCar);
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
	
	public void createCar(AddCarModel addcarModel) {
//		System.out.println("createCar");
		StoreLisinDB(addcarModel,
				"INSERT INTO cars (licenseid,carname,capacity,weekday_rate,weekend_rate,week_rate,gps,onstar,siriusxm) ");
	}
	
}

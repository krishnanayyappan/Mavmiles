package mavmiles.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mavmiles.data.AddCarDAO;
import mavmiles.model.AddCarErrorMsgs;
import mavmiles.model.AddCarModel;


/**
 * Servlet implementation class AddCarController
 */
@WebServlet("/AddCarController")
public class AddCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		AddCarDAO addcarDAO = new AddCarDAO();
		AddCarModel addcarModel = new AddCarModel();
		AddCarErrorMsgs CerrorMsgs = new AddCarErrorMsgs();
		
		String carname = request.getParameter("carname");
		String licenseid = request.getParameter("licenseid");
		
		int capacity = 0;
		if (!request.getParameter("capacity").equals("")) {
			capacity = Integer.parseInt(request.getParameter("capacity"));
		}
		
		float weekday_rate = 0;
		if (!request.getParameter("weekday_rate").equals("")) {
			weekday_rate = Float.parseFloat(request.getParameter("weekday_rate"));
		}
		
		
		float weekend_rate = 0;
		if (!request.getParameter("weekend_rate").equals("")) {
			weekend_rate = Float.parseFloat(request.getParameter("weekend_rate"));
		}
		
		
		float week_rate = 0;
		if (!request.getParameter("week_rate").equals("")) {
			week_rate = Float.parseFloat(request.getParameter("week_rate"));
		}
		
		float onstar = 0;
		if (!request.getParameter("onstar").equals("")) {
			onstar = Float.parseFloat(request.getParameter("onstar"));
		}
		
		float gps = 0;
		if (!request.getParameter("gps").equals("")) {
			gps = Float.parseFloat(request.getParameter("gps"));
		}
		
		float siriusxm = 0;
		if (!request.getParameter("siriusxm").equals("")) {
			siriusxm = Float.parseFloat(request.getParameter("siriusxm"));
		}
		
		
	session.removeAttribute("errorMsgs");
		
	addcarModel.setAddCar(carname, licenseid, capacity, weekday_rate, weekend_rate, week_rate, onstar, gps, siriusxm);
	addcarModel.validateAddCar(addcarModel, CerrorMsgs);
		
		if (CerrorMsgs.getErrorMsg().equals("")) {
			if ( !carname.equals("") || !licenseid.equals("") || !(capacity == 0) || !(weekday_rate == 0) || !(weekend_rate == 0) || !(week_rate == 0) || !(onstar == 0) || !(gps == 0) || !(siriusxm == 0) ) {
//			if(!carname.equals("")) {
				addcarDAO.createCar(addcarModel);
			
			
			
			
//			session.setAttribute("COMPANIES", companyInDB);
			session.removeAttribute("addcarModel");
			response.sendRedirect("managerhome.jsp");
			}
		}
		else {
			session.setAttribute("addcarModel", addcarModel);
			session.setAttribute("errorMsgs", CerrorMsgs);
			response.sendRedirect("AddCar.jsp");	
		}
		
		
//		float weekend_rate = Float.parseFloat(request.getParameter("weekend_rate"));
//		float week_rate = Float.parseFloat(request.getParameter("week_rate"));
//		float onstar = Float.parseFloat(request.getParameter("onstar"));
//		float gps = Float.parseFloat(request.getParameter("gps"));
//		float siriusxm = Float.parseFloat(request.getParameter("siriusxm"));
		
		
		
//		AddCarModel addcarModel = new AddCarModel();
//		addcarModel.setcarname(carname);
//		addcarModel.setlicenseid(licenseid);
//		addcarModel.setweekday_rate(weekday_rate);
//		addcarModel.setweekend_rate(weekend_rate);
//		addcarModel.setweek_rate(week_rate);
//		addcarModel.setcapacity(capacity);
//		addcarModel.setonstar(onstar);
//		addcarModel.setgps(gps);
//		addcarModel.setsiriusxm(siriusxm);
		
		//regModel.setStatus("Y");
		
//		AddCarDAO addcarDAO = new AddCarDAO();
//		addcarDAO.createCar(addcarModel);
//		
//		response.sendRedirect("managerhome.jsp");
		
		//doGet(request, response);
	}

}

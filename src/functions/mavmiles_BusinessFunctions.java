package functions;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class mavmiles_BusinessFunctions {

	public static WebDriver driver;
	public static Properties prop;

	public void Mav_BF_Login(WebDriver driver, String sUserName, String sPassword) {
		driver.findElement(By.name("uname")).clear();
	    driver.findElement(By.name("uname")).sendKeys(sUserName);
	    driver.findElement(By.name("pass")).clear();
	    driver.findElement(By.name("pass")).sendKeys(sPassword);
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}

	public void Mav_RequestRental(WebDriver driver, String startdate, String starttime, String enddate, String endtime, String occupants, String gps_x, String onstar_x, String siriusxm_x, String aac_x) {
		
		driver.findElement(By.id(prop.getProperty("Txt_RequestRental_startdate"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_RequestRental_startdate"))).sendKeys(startdate);
	    new Select(driver.findElement(By.id(prop.getProperty("Txt_RequestRental_starttime")))).selectByVisibleText(starttime);
	    driver.findElement(By.id(prop.getProperty("Txt_RequestRental_enddate"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_RequestRental_enddate"))).sendKeys(enddate);
	    new Select(driver.findElement(By.id(prop.getProperty("Txt_RequestRental_endtime")))).selectByVisibleText(endtime);
	    new Select(driver.findElement(By.id(prop.getProperty("Txt_RequestRental_occupants")))).selectByVisibleText(occupants);
	    if ( gps_x.equals("Y")) {
	    	driver.findElement(By.id(prop.getProperty("Box_RequestRental_gps"))).click();
	    }
	    if ( onstar_x.equals("Y")) {
	    	driver.findElement(By.id(prop.getProperty("Box_RequestRental_onstar"))).click();
	    }
	    if ( siriusxm_x.equals("Y")) {
	    	driver.findElement(By.id(prop.getProperty("Box_RequestRental_siriusxm"))).click();
	    }
	    if ( aac_x.equals("Y")) {
	    	driver.findElement(By.id(prop.getProperty("Box_RequestRental_aac"))).click();
	    }
	    
	    driver.findElement(By.id(prop.getProperty("Btn_RequestRental_submit"))).click();
	}

	
	
	public void Mav_CancelRental(WebDriver driver, String rentalid){

		driver.findElement(By.id(prop.getProperty("Txt_CancelRental_rentalid"))).clear();
		driver.findElement(By.id(prop.getProperty("Txt_CancelRental_rentalid"))).sendKeys(rentalid);

		driver.findElement(By.id(prop.getProperty("Btn_CancelRental_submit"))).click();
	}
	
	public void Mav_AddACar(WebDriver driver, String carname, String licenseid, String capacity, String weekday_rate,
			String weekend_rate, String week_rate, String onstar, String gps, String siriusxm) {
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_carname"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_carname"))).sendKeys(carname);
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_licenseid"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_licenseid"))).sendKeys(licenseid);
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_weekday_rate"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_weekday_rate"))).sendKeys(weekday_rate);
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_weekend_rate"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_weekend_rate"))).sendKeys(weekend_rate);
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_week_rate"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_week_rate"))).sendKeys(week_rate);
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_capacity"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_capacity"))).sendKeys(capacity);
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_gps"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_gps"))).sendKeys(gps);
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_onstar"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_onstar"))).sendKeys(onstar);
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_siriusxm"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_AddCar_siriusxm"))).sendKeys(siriusxm);
		driver.findElement(By.name(prop.getProperty("Btn_AddCar_submit"))).click();
	}
	
	public void Mav_ManagerCancelRental(WebDriver driver, String rentalid) {
		driver.findElement(By.name(prop.getProperty("Txt_ManagerCancelRental_RentalId"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_ManagerCancelRental_RentalId"))).sendKeys(rentalid);
		driver.findElement(By.name(prop.getProperty("Btn_ManagerCancelRental_submit"))).click();			
	}
	
	/* Confirm Pay*/
	public void Mav_ConfirmPay(WebDriver driver, String rentalid, String cardNumber, String expiry, String cvv, String nameOnCard/*, String Loginid*/) {
//		driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_MyItinerary"))).click();
		
		driver.findElement(By.id(prop.getProperty("Txt_CofirmPay_RentailId"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_CofirmPay_RentailId"))).sendKeys(rentalid);	  
	    
	    driver.findElement(By.id(prop.getProperty("Txt_CofirmPay_CNumber"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_CofirmPay_CNumber"))).sendKeys(cardNumber);
	   	
	    driver.findElement(By.id(prop.getProperty("Txt_ConfirmPay_CExp"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_ConfirmPay_CExp"))).sendKeys(expiry);
	    
	    driver.findElement(By.id(prop.getProperty("Txt_ConfirmPay_CcvvNumber"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_ConfirmPay_CcvvNumber"))).sendKeys(cvv);
	    
	    driver.findElement(By.id(prop.getProperty("Txt_ConfirPay_NameonCard"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_ConfirPay_NameonCard"))).sendKeys(nameOnCard);
	    
//	    driver.findElement(By.id(prop.getProperty("Btn_ConfirmPay_Pay"))).click();
	    driver.findElement(By.name("pay")).click();
	}
	
	/* Calendar*/
	public void Mav_CalTest(WebDriver driver, String startdate, String enddate) {
//		driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_MyItinerary"))).click();
		
		driver.findElement(By.id(prop.getProperty("Txt_CalTest_StartDate"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_CalTest_StartDate"))).sendKeys(startdate);	  
	    
	    driver.findElement(By.id(prop.getProperty("Txt_CalTest_EndDate"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_CalTest_EndDate"))).sendKeys(enddate);
	    driver.findElement(By.name("submit")).click();
	}
	
	public void Mav_Register(WebDriver driver, String name, String loginID, String password, String mavid, String email,
			String drivingLicense, String dlexp, String contact, String Type, String age) {
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("loginID")).clear();
		driver.findElement(By.name("loginID")).sendKeys(loginID);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("mavid")).clear();
		driver.findElement(By.name("mavid")).sendKeys(mavid);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("drivingLicense")).clear();
		driver.findElement(By.name("drivingLicense")).sendKeys(drivingLicense);
		driver.findElement(By.name("dlexp")).clear();
		driver.findElement(By.name("dlexp")).sendKeys(dlexp);
		driver.findElement(By.name("age")).clear();
		driver.findElement(By.name("age")).sendKeys(age);
		driver.findElement(By.name("contact")).clear();
		driver.findElement(By.name("contact")).sendKeys(contact);
		driver.findElement(By.name("Type")).click();
		driver.findElement(By.name("submit")).click();
	}
	
	/*View Available Cars*/
	public void Mav_ViewAvailableCars(WebDriver driver, String startdate, String enddate) {
//		driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_MyItinerary"))).click();
		
		driver.findElement(By.id(prop.getProperty("Txt_ViewAvailableCars_startdate"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_ViewAvailableCars_startdate"))).sendKeys(startdate);
	   // new Select(driver.findElement(By.id(prop.getProperty("Txt_RequestRental_starttime")))).selectByVisibleText(starttime);
	    driver.findElement(By.id(prop.getProperty("Txt_ViewAvailableCars_enddate"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_ViewAvailableCars_enddate"))).sendKeys(enddate);
	
	    
	    driver.findElement(By.name("submit")).click();
	}
	
	// Admin
	public void Mav_Login_Profile(WebDriver driver, String loginid)
	{
		driver.findElement(By.name(prop.getProperty("Txt_Booking_LoginID"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Booking_LoginID"))).sendKeys(loginid);
		driver.findElement(By.name(prop.getProperty("Btn_Search_Loginid"))).click();
	}
	
	public void Mav_Update_Profile(WebDriver driver, String name, String loginid, String password, String Email,
			String Drivinglicense, String dlexp, String contact) {
		driver.findElement(By.name(prop.getProperty("Txt_Booking_Name"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Booking_Name"))).sendKeys(name);
//		driver.findElement(By.name(prop.getProperty("Txt_Booking_LoginID"))).clear();
//		driver.findElement(By.name(prop.getProperty("Txt_Booking_LoginID"))).sendKeys(loginid);
		driver.findElement(By.name(prop.getProperty("Txt_Booking_Password"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Booking_Password"))).sendKeys(password);
		driver.findElement(By.name(prop.getProperty("Txt_Booking_Email"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Booking_Email"))).sendKeys(Email);
		driver.findElement(By.name(prop.getProperty("Txt_Drivinglicense"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_Drivinglicense"))).sendKeys(Drivinglicense);
		driver.findElement(By.name(prop.getProperty("Txt_dlexp"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_dlexp"))).sendKeys(dlexp);
		driver.findElement(By.name(prop.getProperty("Txt_contact"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_contact"))).sendKeys(contact);
//		driver.findElement(By.xpath("(//a[contains(text(),'Update')])[1]")).click();
		driver.findElement(By.name("edit")).click();
	}
	
	public void User_Mav_Update_Profile(WebDriver driver, String name,  String password, String Email,
			String Drivinglicense, String dlexp, String contact) {
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_Name"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_Name"))).sendKeys(name);
//		driver.findElement(By.name(prop.getProperty("Txt_Booking_LoginID"))).clear();
//		driver.findElement(By.name(prop.getProperty("Txt_Booking_LoginID"))).sendKeys(loginid);
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_Password"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_Password"))).sendKeys(password);
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_Email"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_Email"))).sendKeys(Email);
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_Drivinglicense"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_Drivinglicense"))).sendKeys(Drivinglicense);
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_dlexp"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_dlexp"))).sendKeys(dlexp);
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_contact"))).clear();
		driver.findElement(By.name(prop.getProperty("Txt_UserUpdate_contact"))).sendKeys(contact);
		driver.findElement(By.name(prop.getProperty("Btn_UserUpdate_submit"))).click();
		}
	
}

package test;

//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import mavmiles.model.*;


@RunWith(JUnitParamsRunner.class)
public class ViewAvailableCarTest {

//		private String symbol ;
//	    private String symbol_val;
	ViewAvailableCarsErrorMsgs acmerror;
	ViewAvailableCarsModel req = new ViewAvailableCarsModel();
	    
	    @Before
		public void setUpBeforeClass() throws Exception {
	    	acmerror = new ViewAvailableCarsErrorMsgs();
//	    	System.out.println("Hi All,The test begins now..!!");
		}
		
	    @FileParameters("src/test/inputs_CalModelTest.csv")
		@Test
		// parameters for test() need to be the same as in the Excel test case
		public void name_test(int testcaseno, String startdate, String enddate,String errorMsg,  String startdateError, String enddateError) throws ParseException {
	    	req.setViewCar(startdate, enddate);
	    	req.validateViewAvailableCars(req, acmerror);
	    	assertTrue(errorMsg.equals(acmerror.getErrorMsg()));
	 		assertTrue(startdateError.equals(acmerror.getstartdateError()));
	 		assertTrue(enddateError.equals(acmerror.getenddateError()));
	 	 		
		}
	
	 	
//		@Test
//	    public void check_symbol_lparan() throws ParseException{
//			symbol = "";
//	        String is_blank = req.validateName(symbol);
//	        assertEquals(is_blank, "Name cannot be blank");
//	    }
//		
//		@Test
//	    public void check_symbol_lparan1() throws ParseException{
//			symbol = "1";
//	        String is_blank = req.validateName(symbol);
//	        assertEquals(is_blank, "Name must be between 2 and 32 characters");
//	    }
//		
//		@Test
//	    public void check_symbol_lparan2() throws ParseException{
//			symbol = "karthik";
//	        String is_blank = req.validateName(symbol);
//	        assertEquals(is_blank, "Name must start with a capital letter");
//	    }
//		@Test
//	    public void check_symbol_lparan3() throws ParseException{
//			symbol = "12karthik10";
//	        String is_blank = req.validateName(symbol);
//	        assertEquals(is_blank, "Name cannot contain numbers");
//	    }
//		@Test
//	    public void check_symbol_lparan4() throws ParseException{
//			symbol = "Karthik";
//	        String is_blank = req.validateName(symbol);
//	        assertFalse(is_blank.equals("Login ID must begin with a letter"));
//	    }
//		
//		@Test
//	    public void check_symbol_lparan5() throws ParseException{
//			symbol = "";
//	        String is_blank = req.validateloginID(symbol);
//	        assertEquals(is_blank, "Login ID cannot be blank");
//	    }
//		
//		@Test
//	    public void check_symbol_lparan6() throws ParseException{
//			symbol = "1234";
//	        String is_blank = req.validateloginID(symbol);
//	        assertEquals(is_blank, "Login ID must be between 7 and 16 characters");
//	    }
//		
//		@Test
//	    public void check_symbol_lparan7() throws ParseException{
//			symbol = "1karthik10";
//	        String is_blank = req.validateloginID(symbol);
//	        assertEquals(is_blank, "Login ID must begin with a letter");
//	    }
//		
//		@Test
//	    public void check_symbol_lparan8() throws ParseException{
//			symbol = "karthik10";
//	        String is_blank = req.validateloginID(symbol);
//	        assertFalse(is_blank.equals("Login ID must begin with a letter"));
//	    }
//		
//		@Test
//	    public void check_symbol_lparan9() throws ParseException{
//			symbol = "";
//	        String is_blank = req.validatePassword(symbol);
//	        assertEquals(is_blank, "Password cannot be blank");
//	        
//	    }
//		
//		@Test
//	    public void check_symbol_lparan10() throws ParseException{
//			symbol = "*****";
//	        String is_blank = req.validatePassword(symbol);
//	        assertEquals(is_blank, "Password must be between 8 and 16 characters");
//	        
//	    }
//		
//		@Test
//	    public void check_symbol_lparan11() throws ParseException{
//			symbol = "************";
//	        String is_blank = req.validatePassword(symbol);
//	        assertFalse(is_blank.equals("Password must be between 8 and 16 characters"));
//	        
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan12() throws ParseException{
//			symbol = "0";
//	        String is_blank = req.validatemavid(symbol);
//	        assertEquals(is_blank, "MAV ID should be in the format 100#######");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan13() throws ParseException{
//			symbol = "124556";
//	        String is_blank = req.validatemavid(symbol);
//	        assertEquals(is_blank, "MAV ID should be in the format 100#######");
//	        
//	    }
//		
//		@Test
//	    public void check_symbol_lparan14() throws ParseException{
//			symbol = "1001508245";
//	        String is_blank = req.validatemavid(symbol);
//	        assertFalse(is_blank.equals("MAV ID should be in the format 100#######"));
//	        
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan15() throws ParseException{
//			symbol = "";
//	        String is_blank = req.validateemail(symbol);
//	        assertEquals(is_blank, "Email cannot be blank");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan16() throws ParseException{
//			symbol = "advseteam2gmail.com";
//	        String is_blank = req.validateemail(symbol);
//	        assertEquals(is_blank, "Email address needs to contain @");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan17() throws ParseException{
//			symbol = "advse@";
//	        String is_blank = req.validateemail(symbol);
//	        assertEquals(is_blank, "Email address must be between 7 and 45 characters long");
//	        
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan18() throws ParseException{
//			symbol = "advseteam2@gmailcom";
//	        String is_blank = req.validateemail(symbol);
//	        assertEquals(is_blank, "Invalid domain name");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan19() throws ParseException{
//			symbol = "advseteam2@gmail.com";
//	        String is_blank = req.validateemail(symbol);
//	        assertFalse(is_blank.equals("Invalid domain name"));
//	        
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan20() throws ParseException{
//			symbol = "advseteam2@gmail.edu";
//	        String is_blank = req.validateemail(symbol);
//	        assertFalse(is_blank.equals("Invalid domain name"));
//	        
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan21() throws ParseException{
//			symbol = "advseteam2@gmail.org";
//	        String is_blank = req.validateemail(symbol);
//	        assertFalse(is_blank.equals("Invalid domain name"));
//	        
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan22() throws ParseException{
//			symbol = "advseteam2@gmail.gov";
//	        String is_blank = req.validateemail(symbol);
//	        assertFalse(is_blank.equals("Invalid domain name"));
//	        
//	        
//	    }
//		
//		@Test
//	    public void check_symbol_lparan23() throws ParseException{
//			symbol = "";
//	        String is_blank = req.validatedrivingLicense(symbol);
//	        assertEquals(is_blank, "Driving License # cannot be blank");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan24() throws ParseException{
//			symbol = "12345";
//	        String is_blank = req.validatedrivingLicense(symbol);
//	        assertEquals(is_blank, "Driving License # must be between 6 and 12 characters");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan25() throws ParseException{
//			symbol = "1234567";
//	        String is_blank = req.validatedrivingLicense(symbol);
//	        assertFalse(is_blank.equals("Driving License # must be between 6 and 12 characters"));
//	        
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan26() throws ParseException{
//			symbol = "";
//	        String is_blank = req.validatecontact(symbol);
//	        assertEquals(is_blank, "Contact # must be 10 digits in length");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan27() throws ParseException{
//			symbol = "12345678a";
//	        String is_blank = req.validatecontact(symbol);
//	        assertEquals(is_blank, "Contact # must be 10 digits in length");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan28() throws ParseException{
//			symbol = "1234567890";
//	        String is_blank = req.validatecontact(symbol);
//	        assertFalse(is_blank.equals("Contact # must be 10 digits in length"));
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan29() throws ParseException{
//			symbol = " ";
//	        String is_blank = req.validatedlexp(symbol);
//	        assertEquals(is_blank, "Driving License Expiry Date cannot be blank");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan30() throws ParseException{
//			symbol = "1998-10-10";
//	        String is_blank = req.validatedlexp(symbol);
//	        assertEquals(is_blank, "Your Driving License Expired already!");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan31() throws ParseException{
//			symbol = "10000-1199-000";
//	        String is_blank = req.validatedlexp(symbol);
//	        assertEquals(is_blank, "Invalid date format");
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan32() throws ParseException{
//			symbol = "12-12-2018";
//	        String is_blank = req.validatecontact(symbol);
//	        assertFalse(is_blank.equals("Invalid date format"));
//	        
//	    }
//		
//		@Test
//	    public void check_symbol_lparan33() throws ParseException{
//			symbol = "advseteam2@gmail.net";
//	        String is_blank = req.validateemail(symbol);
//	        assertFalse(is_blank.equals("Invalid domain name"));
//	        
//	        
//	    }
//		@Test
//	    public void check_symbol_lparan34() throws ParseException{
//			symbol = "advseteam2@gmail.mil";
//	        String is_blank = req.validateemail(symbol);
//	        assertFalse(is_blank.equals("Invalid domain name"));
//	        
//	        
//	    }
		
		
		@After
		public void tearDownAfterClass() throws Exception {
		System.out.println("Hi All,The test ends successfully..!!");
			}

	}
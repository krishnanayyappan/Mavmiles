package test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mavmiles.model.*;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class CalendarModelTest {
		
	    CalendarModel cal ;
	    CalendarModelErrorMsgs calerror;
	    
	    @Before
		public void setUp() throws Exception {
	    	cal = new CalendarModel();
	    	calerror = new CalendarModelErrorMsgs();
		}
		
	 	@After
		public void tearDownAfterClass() throws Exception {
		}
	 	@FileParameters("src/test/inputs_CalModTest.csv")
		@Test
		public void cal_test(String testcaseno, String startdate2, String enddate2, String errorMsg, String startdateError, String enddateError)
			throws ParseException {
	
			cal.setViewCar(startdate2, enddate2);
			cal.validateCalendar(cal, calerror);
			
			
	 		assertTrue(errorMsg.equals(calerror.getErrorMsg()));
	 		assertTrue(startdateError.equals(calerror.getstartdateError()));
	 		assertTrue(enddateError.equals(calerror.getenddateError()));

	 		
		}

}
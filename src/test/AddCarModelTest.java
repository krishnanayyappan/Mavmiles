package test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import mavmiles.model.*;

@RunWith(JUnitParamsRunner.class)
public class AddCarModelTest {
		
		AddCarModel acm ;
		AddCarErrorMsgs acmerror;
	    
	    @Before
		public void setUp() throws Exception {
//	    	System.out.println("Test start");
	    	acm = new AddCarModel();
	    	acmerror = new AddCarErrorMsgs();
		}
		
	 	@After
		public void tearDownAfterClass() throws Exception {
//	 		System.out.println("Test complete");
		}

	 	@FileParameters("src/test/inputs_AddCarModelTest.csv")
		@Test
		public void carModel_test(int testcaseno, String carname, String licenseid, int capacity, float weekday_rate,
			float weekend_rate, float week_rate, float onstar, float gps, float siriusxm,
			String errorMsg, String carnameError, String licenseidError, String capacityError, String weekday_rateError,
			String weekend_rateError, String week_rateError, String onstarError, String gpsError, String siriusxmError)
			throws ParseException {
	 		
	 		acm.setAddCar(carname, licenseid, capacity, weekday_rate, weekend_rate, week_rate, onstar, gps, siriusxm);
	 		acm.validateAddCar(acm, acmerror);
	 		assertTrue(errorMsg.equals(acmerror.getErrorMsg()));
	 		assertTrue(carnameError.equals(acmerror.getcarnameError()));
	 		assertTrue(licenseidError.equals(acmerror.getlicenseidError()));
	 		assertTrue(capacityError.equals(acmerror.getcapacityError()));
	 		assertTrue(weekday_rateError.equals(acmerror.getweekday_rateError()));
	 		assertTrue(weekend_rateError.equals(acmerror.getweekend_rateError()));
	 		assertTrue(week_rateError.equals(acmerror.getweek_rateError()));
	 		assertTrue(onstarError.equals(acmerror.getonstarError()));
	 		assertTrue(gpsError.equals(acmerror.getgpsError()));
	 		assertTrue(siriusxmError.equals(acmerror.getsiriusxmError()));
	 		
		}

}
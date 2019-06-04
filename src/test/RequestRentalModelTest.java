package test;

import static org.junit.Assert.assertTrue;

import mavmiles.model.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class RequestRentalModelTest {
		
	    RequestRentalModel req ;
	    RequestRentalErrorMsgs reqerror;
	    
	    @Before
		public void setUp() throws Exception {
	    	req = new RequestRentalModel();
	    	reqerror = new RequestRentalErrorMsgs();
		}
		
	 	@After
		public void tearDownAfterClass() throws Exception {
		}

	 	@FileParameters("src/test/inputs_RequestRentalModelTest.csv")
		@Test
		public void carname_test(int testcaseno, String startdate, String starttime, String enddate, String endtime,
			int occupants, String gps, String onstar, String siriusxm, String aac, String errorMsg,
			String startdateError, String starttimeError, String enddateError, String endtimeError,
			String occupantsError, String gpsError, String onstarError, String siriusxmError, String aacError, String comments)
			throws ParseException {
	 		
//	 		System.out.println(testcaseno);
			req.setRental(startdate, starttime, enddate, endtime, occupants, gps, onstar, siriusxm, aac);
			req.validateRental(req, reqerror);
			assertTrue(errorMsg.equals(reqerror.getErrorMsg()));
			assertTrue(startdateError.equals(reqerror.getstartdateError()));
			assertTrue(starttimeError.equals(reqerror.getstarttimeError()));
			assertTrue(enddateError.equals(reqerror.getenddateError()));
			assertTrue(endtimeError.equals(reqerror.getendtimeError()));
	 		
		}

}
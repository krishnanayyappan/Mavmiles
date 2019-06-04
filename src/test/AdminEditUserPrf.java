package test;


import static org.junit.Assert.*;

import java.text.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import mavmiles.model.*;


@RunWith(JUnitParamsRunner.class)
public class AdminEditUserPrf {

	EditUserProfileErrorMsgs acmerror;
	EditUserProfileModel req;
	    
	    @Before
		public void setUpBeforeClass() throws Exception {
	    	req = new EditUserProfileModel();
	    	acmerror = new EditUserProfileErrorMsgs();
		}
		
	    @FileParameters("src/test/adminedituser.csv")
		@Test
		// parameters for test() need to be the same as in the Excel test case
		public void name_test(int testcaseno, String loginid, String errorMsg, String LoginError ) throws ParseException {
	    	req.setProfile(loginid);
	    	req.validateProfile(req, acmerror);
	    	assertTrue(errorMsg.equals(acmerror.getErrorMsg()));
            assertTrue(LoginError.equals(acmerror.getloginIDError()));
	 		
		}
	
	 	@After
		public void tearDownAfterClass() throws Exception {
			}

	}
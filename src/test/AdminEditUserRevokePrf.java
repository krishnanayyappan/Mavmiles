package test;

//import static org.junit.Assert.assertFalse;
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
public class AdminEditUserRevokePrf {

//	EditUserProfileErrorMsgs acmerror;
//	EditUserProfileModel req;
	
	RevokeUserErrorMsgs acmerror;
	RevokeUserModel req;
	    
	    @Before
		public void setUpBeforeClass() throws Exception {
//	    	req = new EditUserProfileModel();
//	    	acmerror = new EditUserProfileErrorMsgs();
	    	req = new RevokeUserModel();
	    	acmerror = new RevokeUserErrorMsgs();
	    }
		
	    @FileParameters("src/test/adminedituser2.csv")
		@Test
		public void name_test(int testcaseno, String loginid, String errorMsg, String LoginError ) throws ParseException {
	    	req.setProfile(loginid);
	    	req.validateProfile(req, acmerror);
	    	
	    	System.out.println(testcaseno + "\t" + errorMsg + "\t" + acmerror.getErrorMsg());
	    	assertTrue(errorMsg.equals(acmerror.getErrorMsg()));
            assertTrue(LoginError.equals(acmerror.getloginIDError()));
		}

	    @After
		public void tearDownAfterClass() throws Exception {
		}

	}
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
public class UserUpdateProfileTest {


	EditMyProfileErrorMsgs acmerror;
	    EditMyProfileModel req = new EditMyProfileModel();
	    
	    @Before
		public void setUpBeforeClass() throws Exception {
	    	acmerror = new EditMyProfileErrorMsgs();
//	    	System.out.println("Hi All,The test begins now..!!");
		}
		
	    @FileParameters("src/test/comm_upd_profile.csv")
		@Test
		
		public void name_test(int testcaseno, String name, String loginid, String password,String Email,String Drivinglicense,String dlexp,String contact,String errorMsg,  String nameError, String LoginError, String passwordError, String EmailError, String DrivinglicenseError, String dlexpError, String contactError ) throws ParseException {
	    	req.setProfile(name,loginid,password, Email, Drivinglicense, dlexp, contact );
	    	
	    	req.validateProfile(req, acmerror);

	    	assertTrue(errorMsg.equals(acmerror.getErrorMsg()));
	 		assertTrue(nameError.equals(acmerror.getnameError()));
	 		assertTrue(LoginError.equals(acmerror.getloginIDError()));
	 		assertTrue(passwordError.equals(acmerror.getpasswordError()));
	 		
	 		assertTrue(EmailError.equals(acmerror.getemailError()));
	 		assertTrue(DrivinglicenseError.equals(acmerror.getdl_numberError()));
	 		assertTrue(dlexpError.equals(acmerror.getdl_expiryError()));
	 		assertTrue(contactError.equals(acmerror.getphoneError()));	
		}
		
		@After
		public void tearDownAfterClass() throws Exception {
//		System.out.println("Hi All,The test ends successfully..!!");
			}

	}
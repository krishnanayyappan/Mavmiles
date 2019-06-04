package test;

import static org.junit.Assert.*;
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
public class RegistrationModelTest {
	RegistrationModel reg;
	RegistrationErrorMsgs regError;

	@Before
	public void setUp() throws Exception {
	reg = new RegistrationModel();
	regError = new RegistrationErrorMsgs();
	}

	@After
	public void tearDown() throws Exception {
	}

	@FileParameters("src/test/krishnan_check_input_registration.csv")
	@Test
	public void Registration_test(int testcaseno, String name, String loginID, String password, String mavid, String email, String drivingLicense,
			String dlexp, String contact, String Type, String Status, String age, String errorMsg, String nameError, String loginIDError,
			String passwordError, String mavidError, String emailError, String drivingLicenseError, String dlexpError,
			String ageError, String contactError , String comments)
			throws ParseException {

//			int mavid = 0;
//			if ( (!mavid_str.equals("")) && (isTextInteger(mavid_str) ) ) {
//				 mavid = Integer.parseInt(mavid_str);
//			}
//			
//			String dlexp = "";
//			if (!dlexp_str.equals("")) {
//				dlexp = dlexp_str;
//			} else {
//				dlexp = " ";
//			}
			
//			int age = 0;
//			if (!age_str.equals("")) {
//				age = Integer.parseInt(age_str);
//			}
			
//			System.out.println("\n" +testcaseno);
//			System.out.println("contact =" + contact + ";");
		
			reg.setProfile(name, loginID, password, mavid, email, drivingLicense, dlexp, contact, Type, Status, age);
			reg.validateProfile(reg, regError);

//			System.out.println("ageError =" + ageError + ";");
//			System.out.println("regError =" + regError.getageError() + ";");
			
	 		assertTrue(errorMsg.equals(regError.getErrorMsg()));
	 		assertTrue(nameError.equals(regError.getnameError()));
	 		assertTrue(loginIDError.equals(regError.getloginIDError()));
	 		assertTrue(passwordError.equals(regError.getpasswordError()));
	 		assertTrue(mavidError.equals(regError.getmavidError()));
	 		assertTrue(emailError.equals(regError.getemailError()));
	 		assertTrue(drivingLicenseError.equals(regError.getdrivingLicenseError()));
	 		assertTrue(dlexpError.equals(regError.getdlexpError()));
	 		assertTrue(contactError.equals(regError.getcontactError()));
	 		assertTrue(ageError.equals(regError.getageError()));
	}
	
}

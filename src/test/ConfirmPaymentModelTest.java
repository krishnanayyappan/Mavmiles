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
public class ConfirmPaymentModelTest {
		
	ConfirmPaymentModel cpm ;
	ConfirmPaymentErrorMsgs cpmerror;
    
    @Before
	public void setUp() throws Exception {
    	cpm = new ConfirmPaymentModel();
    	cpmerror = new ConfirmPaymentErrorMsgs();
	}
	
 	@After
	public void tearDownAfterClass() throws Exception {
	}

 	@FileParameters("src/test/inputs_ConfirmPaymentModelTest.csv")
	@Test
	public void payment_test(int testcaseno, String rentalid, String cardNumber, String expiry, String cvv, String nameOnCard, String Loginid, 
		String errorMsg, String rentalidError, String cardNumberError, String expiryError, String cvvError,
		String nameOnCardError, String LoginidError)
		throws ParseException {
 		
 		cpm.setRental(rentalid, cardNumber, expiry, cvv, nameOnCard, Loginid);
 		cpm.validatePayment(cpm, cpmerror);
 		
 		System.out.println("\n" +testcaseno);
 		System.out.println("cardNumb =" + cardNumberError + ";");
 		System.out.println("cpmerror =" + cpmerror.getcardNumberError() + ";");

 		assertTrue(errorMsg.equals(cpmerror.getErrorMsg()));
 		assertTrue(rentalidError.equals(cpmerror.getrentalidError()));
 		assertTrue(cardNumberError.equals(cpmerror.getcardNumberError()));
 		assertTrue(expiryError.equals(cpmerror.getexpiryError()));
 		assertTrue(cvvError.equals(cpmerror.getcvvError()));
 		assertTrue(nameOnCardError.equals(cpmerror.getnameOnCardError()));
 		/*assertTrue(LoginidError.equals(cpmerror.geweek_rateError()));*/
 		}

}

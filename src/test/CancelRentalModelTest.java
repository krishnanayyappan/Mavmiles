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
public class CancelRentalModelTest {

	CancelRentalModel cancel;
	CancelRentalErrorMsgs cError;

	@Before
	public void setUp() throws Exception {
		cancel = new CancelRentalModel();
		cError = new CancelRentalErrorMsgs();
	}

	@After
	public void tearDownAfterClass() throws Exception {
	}

	@FileParameters("src/test/rentalid_CancelRentalModelTest.csv")
	@Test
	public void rentalID_test(int testcaseno, String rentalid, String errorMsg, String rentalidError, String comments)
			throws ParseException {
		cancel.setCancelRental(rentalid);
		cancel.validateCancelRental(cancel, cError);
		assertTrue(errorMsg.equals(cError.getErrorMsg()));
		assertTrue(rentalidError.equals(cError.getrentalidError()));
	}
}
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
public class ManagerCancelRentalTest {

	ManagerCancelRentalErrorMsgs rerror;
	ManagerCancelRentalModel manager;

	@Before
	public void setUpBeforeClass() throws Exception {
		manager = new ManagerCancelRentalModel();
		rerror = new ManagerCancelRentalErrorMsgs();
	}

	@FileParameters("src/test/rentalid_CancelRentalModelTest.csv")
	@Test
	public void name_test(int testcaseno, String rentalid, String errorMsg, String RentalIdError, String comments)
			throws ParseException {
		manager.setCancelRental(rentalid);
		manager.validateCancelRental(manager, rerror);
		assertTrue(errorMsg.equals(rerror.getErrorMsg()));
		assertTrue(RentalIdError.equals(rerror.getrentalidError()));
	}

	@After
	public void tearDownAfterClass() throws Exception {
	}

}

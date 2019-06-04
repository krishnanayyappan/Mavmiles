package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
@RunWith(JUnitParamsRunner.class)
public class ConfirmPaymentSelenium extends functions.mavmiles_BusinessFunctions{
	  private WebDriver driver;
	//  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  public static String sAppURL, SharedUIMap;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
	    driver = new FirefoxDriver();
//	    baseUrl = "http://localhost:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver. manage(). window(). maximize();
	    prop = new Properties();
		prop.load(new FileInputStream("./Configuration/mavmiles_Configuration.properties"));
		sAppURL = prop.getProperty("sAppURL");
		SharedUIMap = prop.getProperty("SharedUIMap");
		prop.load(new FileInputStream(SharedUIMap));
	  }

	  @Test
	  @FileParameters("src/selenium/inputs_ConfirmPaymentModelSelenium.csv")
		public void payment_test(int testcaseno, String rentalid, String cardNumber, String expiry, String cvv, String nameOnCard, /*String Loginid,*/ 
				String rentalid_Valid, String cardNumber_Valid, String expiry_Valid, String cvv_Valid, String nameOnCard_Valid, /*String Loginid_Valid,*/String errorMsg, String rentalidError, String cardNumberError, String expiryError, String cvvError,
				String nameOnCardError, String LoginidError) throws Exception {
		  driver.get(sAppURL);
		  Mav_BF_Login(driver, "karthik10", "Karthik@10");
		  
		  driver.findElement(By.linkText("Confirm/Pay for Reserved Rentals")).click();
		  Mav_ConfirmPay(driver, rentalid, cardNumber, expiry, cvv, nameOnCard/*, Loginid*/);
		  
		  String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");
		  String UI_rentalidError = driver.findElement(By.name("rentalidError")).getAttribute("value");
		  String UI_cardNumberError = driver.findElement(By.name("cardNumberError")).getAttribute("value");
		  String UI_expiryError = driver.findElement(By.name("expiryError")).getAttribute("value");
		  String UI_cvvError = driver.findElement(By.name("cvvError")).getAttribute("value");
		  String UI_nameOnCardError = driver.findElement(By.name("nameOnCardError")).getAttribute("value");
		  
		  assertEquals(errorMsg, UI_errorMsg);
		  assertEquals(rentalidError, UI_rentalidError);
		  assertEquals(cardNumberError, UI_cardNumberError);
		  assertEquals(expiryError, UI_expiryError);
		  assertEquals(cvvError, UI_cvvError);
		  assertEquals(nameOnCardError, UI_nameOnCardError);
		  
		  Mav_ConfirmPay(driver, rentalid_Valid, cardNumber_Valid, expiry_Valid, cvv_Valid, nameOnCard_Valid/*, Loginid_Valid*/);
		  
		 // driver.findElement(By.xpath("(//a[contains(text(),'Book Now')])[1]")).click();
		  driver.findElement(By.linkText("Return to Home Page")).click();
		  driver.findElement(By.linkText("Logout")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

//	  private boolean isElementPresent(By by) {
//	    try {
//	      driver.findElement(by);
//	      return true;
//	    } catch (NoSuchElementException e) {
//	      return false;
//	    }
//	  }
//
//	  private boolean isAlertPresent() {
//	    try {
//	      driver.switchTo().alert();
//	      return true;
//	    } catch (NoAlertPresentException e) {
//	      return false;
//	    }
//	  }
//
//	  private String closeAlertAndGetItsText() {
//	    try {
//	      Alert alert = driver.switchTo().alert();
//	      String alertText = alert.getText();
//	      if (acceptNextAlert) {
//	        alert.accept();
//	      } else {
//	        alert.dismiss();
//	      }
//	      return alertText;
//	    } finally {
//	      acceptNextAlert = true;
//	    }
//	  }
	}

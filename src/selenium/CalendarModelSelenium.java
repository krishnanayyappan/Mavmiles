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
public class CalendarModelSelenium extends functions.mavmiles_BusinessFunctions{
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
	  @FileParameters("src/selenium/inputs_CalendarModelSelnium.csv")
		public void calendar_test(String testcaseno, String startdate, String enddate, String startdate_Valid, String enddate_Valid, String errorMsg, String startdateError, String enddateError) throws Exception {
		  driver.get(sAppURL);
		  Mav_BF_Login(driver, "rohan99", "Rohan@99");
		  
		  driver.findElement(By.linkText("View Calendar of Rented Cars")).click();
		  Mav_CalTest(driver, startdate, enddate);
		  
		  /*String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");*/
		  String UI_startdateError = driver.findElement(By.name("startdateError")).getAttribute("value");
		  String UI_enddateError = driver.findElement(By.name("enddateError")).getAttribute("value");
		 
		  
		  /*assertEquals(errorMsg, UI_errorMsg);*/
		  assertEquals(startdateError, UI_startdateError);
		  assertEquals(enddateError, UI_enddateError);

		  
		  Mav_CalTest(driver, startdate_Valid, enddate_Valid);
		  
		 // driver.findElement(By.xpath("(//a[contains(text(),'Book Now')])[1]")).click();
		 // driver.findElement(By.linkText("Return to Home Page")).click();
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

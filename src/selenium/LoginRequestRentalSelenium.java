package selenium;

import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class LoginRequestRentalSelenium extends functions.mavmiles_BusinessFunctions{
  private WebDriver driver;
//  private String baseUrl;
  private boolean acceptNextAlert = true;
  public static String sAppURL, SharedUIMap;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
    driver = new FirefoxDriver();
//    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver. manage(). window(). maximize();
    prop = new Properties();
	prop.load(new FileInputStream("./Configuration/mavmiles_Configuration.properties"));
	sAppURL = prop.getProperty("sAppURL");
	SharedUIMap = prop.getProperty("SharedUIMap");
	prop.load(new FileInputStream(SharedUIMap));
  }

  @Test
  @FileParameters("src/selenium/inputs_RequestRentalSelenium.csv")
	public void testLoginRequestRental(int testcaseno, String startdate, String starttime, String enddate,
			String endtime, int occupants, String gps, String onstar, String siriusxm, String aac,
			String startdate_valid, String starttime_valid, String enddate_valid, String endtime_valid,
			int occupants_valid, String gps_valid, String onstar_valid, String siriusxm_valid, String aac_valid,
			String errorMsg, String startdateError, String starttimeError, String enddateError, String endtimeError,
			String occupantsError, String gpsError, String onstarError, String siriusxmError, String aacError,
			String comments) throws Exception {
//    driver.get(baseUrl + "/mavmiles/");
	  driver.get(sAppURL);
	  Mav_BF_Login(driver, "karthik10", "Karthik@10");
	  
	  String occupants_str = String.valueOf(occupants);
	  driver.findElement(By.linkText("Request A Rental")).click();
	  Mav_RequestRental(driver, startdate, starttime, enddate, endtime, occupants_str, gps, onstar, siriusxm, aac );
	  
	  String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");
	  String UI_startdateError = driver.findElement(By.name("startdateError")).getAttribute("value");
	  String UI_starttimeError = driver.findElement(By.name("starttimeError")).getAttribute("value");
	  String UI_enddateError = driver.findElement(By.name("enddateError")).getAttribute("value");
	  String UI_endtimeError = driver.findElement(By.name("endtimeError")).getAttribute("value");
	  
	  assertEquals(errorMsg, UI_errorMsg);
	  assertEquals(startdateError, UI_startdateError);
	  assertEquals(starttimeError, UI_starttimeError);
	  assertEquals(enddateError, UI_enddateError);
	  assertEquals(endtimeError, UI_endtimeError);
	  
	  String occupants_str_valid = String.valueOf(occupants_valid);
	  Mav_RequestRental(driver, startdate_valid, starttime_valid, enddate_valid, endtime_valid, occupants_str_valid, gps_valid, onstar_valid, siriusxm_valid, aac_valid );
	  
	  driver.findElement(By.xpath("(//a[contains(text(),'Book Now')])[1]")).click();
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

//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
}

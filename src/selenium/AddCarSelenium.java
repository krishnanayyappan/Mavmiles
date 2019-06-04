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
public class AddCarSelenium extends functions.mavmiles_BusinessFunctions{
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
  @FileParameters("src/selenium/inputs_AddCarSelenium.csv")
  public void testAddCar(int testcaseno, String carname, String licenseid, int capacity, float weekday_rate,
			float weekend_rate, float week_rate, float onstar, float gps, float siriusxm,
			String carname_valid, String licenseid_valid, int capacity_valid, float weekday_rate_valid,
			float weekend_rate_valid, float week_rate_valid, float onstar_valid, float gps_valid, float siriusxm_valid,
			String errorMsg, String carnameError, String licenseidError, String capacityError, String weekday_rateError,
			String weekend_rateError, String week_rateError, String onstarError, String gpsError, String siriusxmError) throws Exception {
//    driver.get(baseUrl + "/mavmiles/");
	  driver.get(sAppURL);
	  Mav_BF_Login(driver, "sachin200", "Sachin@200");
	  
	  String capacity_str = String.valueOf(capacity);
	  String weekday_rate_str = String.valueOf(weekday_rate);
	  String weekend_rate_str = String.valueOf(weekend_rate);
	  String week_rate_str = String.valueOf(week_rate);
	  String onstar_str = String.valueOf(onstar);
	  String gps_str = String.valueOf(gps);
	  String siriusxm_str = String.valueOf(siriusxm);
	  
//	  driver.findElement(By.linkText("Add A Car")).click();
	  driver.findElement(By.xpath("//li[5]/a/span")).click();
	  Mav_AddACar(driver, carname, licenseid, capacity_str, weekday_rate_str, weekend_rate_str, week_rate_str, onstar_str, gps_str, siriusxm_str );
	  
	  String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");
	  String UI_carnameError = driver.findElement(By.name("carnameError")).getAttribute("value");
	  String UI_licenseidError = driver.findElement(By.name("licenseidError")).getAttribute("value");
	  String UI_capacityError = driver.findElement(By.name("capacityError")).getAttribute("value");
	  String UI_weekday_rateError = driver.findElement(By.name("weekday_rateError")).getAttribute("value");
	  String UI_weekend_rateError = driver.findElement(By.name("weekend_rateError")).getAttribute("value");
	  String UI_week_rateError = driver.findElement(By.name("week_rateError")).getAttribute("value");
	  String UI_gpsError = driver.findElement(By.name("gpsError")).getAttribute("value");
	  String UI_onstarError = driver.findElement(By.name("onstarError")).getAttribute("value");
	  String UI_siriusxmError = driver.findElement(By.name("siriusxmError")).getAttribute("value");
	  
	  assertEquals(errorMsg, UI_errorMsg);
	  assertEquals(carnameError, UI_carnameError);
	  assertEquals(licenseidError, UI_licenseidError);
	  assertEquals(capacityError, UI_capacityError);
	  assertEquals(weekday_rateError, UI_weekday_rateError);
	  assertEquals(weekend_rateError, UI_weekend_rateError);
	  
//	  System.out.println(testcaseno + " " + week_rate + " ; " + week_rateError);
	  assertEquals(week_rateError, UI_week_rateError);
	  assertEquals(gpsError, UI_gpsError);
	  assertEquals(onstarError, UI_onstarError);
	  assertEquals(siriusxmError, UI_siriusxmError);
	  
	  capacity_str = String.valueOf(capacity_valid);
	  weekday_rate_str = String.valueOf(weekday_rate_valid);
	  weekend_rate_str = String.valueOf(weekend_rate_valid);
	  week_rate_str = String.valueOf(week_rate_valid);
	  onstar_str = String.valueOf(onstar_valid);
	  gps_str = String.valueOf(gps_valid);
	  siriusxm_str = String.valueOf(siriusxm_valid);
	  Mav_AddACar(driver, carname_valid, licenseid_valid, capacity_str, weekday_rate_str, weekend_rate_str, week_rate_str, onstar_str, gps_str, siriusxm_str );
	  
//	  driver.findElement(By.xpath("(//a[contains(text(),'Book Now')])[3]")).click();
//	  driver.findElement(By.linkText("Return to Home Page")).click();
//	  driver.findElement(By.linkText("Logout")).click();
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

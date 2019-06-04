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
public class ViewAvailableCarsSelenium extends functions.mavmiles_BusinessFunctions{
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
  @FileParameters("src/selenium/inputs_ViewAvailableCarsSelenium.csv")
  public void testViewAvailableCars(int testcaseno, String startdate, String enddate, 
			String startdate_valid, String enddate_valid,String errorMsg, String startdateError, String enddateError) throws Exception {
//    driver.get(baseUrl + "/mavmiles/");
	  driver.get(sAppURL);
	  Mav_BF_Login(driver, "rohan99", "Rohan@99");
	  
//	  String startdate_str = String.valueOf(startdate);
//	  String enddate_str = String.valueOf(enddate);
	
	  
	  driver.findElement(By.linkText("View Available Cars")).click();
//	  driver.findElement(By.xpath("//li[5]/a/span")).click();
	  Mav_ViewAvailableCars(driver, startdate, enddate);
	  
	  String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");
	  String UI_startdateError = driver.findElement(By.name("startdateError")).getAttribute("value");
	  String UI_enddateError = driver.findElement(By.name("enddateError")).getAttribute("value");
	  
	  assertEquals(errorMsg, UI_errorMsg);
	  assertEquals(startdateError, UI_startdateError);
	  assertEquals(enddateError, UI_enddateError);
	
	  Mav_ViewAvailableCars(driver, startdate_valid, enddate_valid );
	  
//	  driver.findElement(By.xpath("(//a[contains(text(),'Book Now')])[3]")).click();
//	  driver.findElement(By.linkText("Return to Home Page")).click();
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

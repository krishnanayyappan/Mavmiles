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
public class ManagerCancelRentalSelenium extends functions.mavmiles_BusinessFunctions{
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
  @FileParameters("src/selenium/inputs_ManagerCancelRentalSelenium.csv")
  public void testManagerCancelRental(int testcaseno, String rentalid, String rentalid_valid, String errorMsg, String rentalidError, String comments) throws Exception {
	  driver.get(sAppURL);
	  Mav_BF_Login(driver, "sachin200", "Sachin@200");
	  
	  driver.findElement(By.linkText("Delete a Reservation")).click();
	  Mav_ManagerCancelRental(driver,rentalid);
	  
	  String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");
	  String UI_rentalidError = driver.findElement(By.name("rentalidError")).getAttribute("value");
	  
	  assertEquals(errorMsg, UI_errorMsg);
	  assertEquals(rentalidError, UI_rentalidError);
	  
	  Mav_ManagerCancelRental(driver,rentalid_valid);
	  
	  Thread.sleep(5_000);
//	  driver.findElement(By.id(prop.getProperty("Btn_CancelRental_cancel"))).click();
	  driver.findElement(By.name("cancel")).click();
	  
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

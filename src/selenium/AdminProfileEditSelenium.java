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
public class AdminProfileEditSelenium extends functions.mavmiles_BusinessFunctions{
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
  @FileParameters("src/selenium/inputs_AdminProfileEdit.csv")
	public void testAdminProfileEdit(int testcaseno, String name, String loginid, String password,String Email,String Drivinglicense,String dlexp,String contact,
			String name_valid, String loginid_valid, String password_valid, String email_valid,String dl_valid,String dlexp_valid,String contact_valid,
			String errorMsg, String nameError, String loginidError, String passwordError, String emailError,String Drivinglicenseerror,String dlexperror,String contacterror) throws Exception {
//    driver.get(baseUrl + "/mavmiles/");
	  driver.get(sAppURL);
	  Mav_BF_Login(driver, "admin", "admin");

	  driver.findElement(By.xpath("//li[1]/a/span")).click();
//	  driver.findElement(By.linkText("Edit User Profile")).click();
	  Mav_Login_Profile(driver,"karthik10");
	  Mav_Update_Profile(driver, name, loginid, password, Email, Drivinglicense, dlexp, contact);
	  
	  String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");
	  String UI_nameError = driver.findElement(By.name("nameError")).getAttribute("value");
//	  String UI_loginidError = driver.findElement(By.name("loginIDError")).getAttribute("value");
	  String UI_passwordError = driver.findElement(By.name("passwordError")).getAttribute("value");
	  String UI_emailError = driver.findElement(By.name("emailError")).getAttribute("value");
	  String UI_Drivinglicenseerror = driver.findElement(By.name("drivingLicenseError")).getAttribute("value");
	  String UI_dlexperror = driver.findElement(By.name("dlexpError")).getAttribute("value");
	  String UI_contacterror = driver.findElement(By.name("contactError")).getAttribute("value");
	  
	  assertEquals(errorMsg, UI_errorMsg);
	  assertEquals(nameError, UI_nameError);
//	  assertEquals(loginidError, UI_loginidError);
	  assertEquals(passwordError, UI_passwordError);
	  assertEquals(Drivinglicenseerror, UI_Drivinglicenseerror);
	  assertEquals(dlexperror, UI_dlexperror);
	  assertEquals(contacterror, UI_contacterror);
	  assertEquals(emailError, UI_emailError);
	  
	  Mav_Update_Profile(driver, name_valid, loginid_valid, password_valid, email_valid, dl_valid, dlexp_valid, contact_valid);
	  
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

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
public class RegistrationSelenium extends functions.mavmiles_BusinessFunctions{
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  public static String sAppURL, SharedUIMap;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver. manage(). window(). maximize();
    prop = new Properties();
	prop.load(new FileInputStream("./Configuration/mavmiles_Configuration.properties"));
	sAppURL = prop.getProperty("sAppURL");
	SharedUIMap = prop.getProperty("SharedUIMap");
	prop.load(new FileInputStream(SharedUIMap));
  }

  @Test
  @FileParameters("src/selenium/inputs_RegistrationSelenium.csv")
	public void testRegister(int testcaseno, String name, String loginID, String password, String mavid, String email,
			String drivingLicense, String dlexp, String contact, String Type, String Status, String age,
			String name_valid, String loginID_valid, String password_valid, String mavid_valid, String email_valid,
			String drivingLicense_valid, String dlexp_valid, String contact_valid, String Type_valid,
			String Status_valid, String age_valid, String errorMsg, String nameError, String loginIDError,
			String passwordError, String mavidError, String emailError, String drivingLicenseError, String dlexpError,
			String contactError, String ageError, String comments) throws Exception {
//    driver.get(baseUrl + "/mavmiles/");
	  driver.get(sAppURL);

//	  driver.findElement(By.linkText("Register")).click();
	  driver.findElement(By.id(prop.getProperty("Txt_Login_register"))).click();
	  Mav_Register(driver, name, loginID, password, mavid, email, drivingLicense, dlexp, contact, Type, age);

	  String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");
	  String UI_nameError = driver.findElement(By.name("nameError")).getAttribute("value");
	  String UI_loginIDError = driver.findElement(By.name("loginIDError")).getAttribute("value");
	  String UI_passwordError = driver.findElement(By.name("passwordError")).getAttribute("value");
	  String UI_mavidError = driver.findElement(By.name("mavidError")).getAttribute("value");
	  String UI_emailError = driver.findElement(By.name("emailError")).getAttribute("value");
	  String UI_drivingLicenseError = driver.findElement(By.name("drivingLicenseError")).getAttribute("value");
	  String UI_dlexpError = driver.findElement(By.name("dlexpError")).getAttribute("value");
	  String UI_contactError = driver.findElement(By.name("contactError")).getAttribute("value");
	  String UI_ageError = driver.findElement(By.name("ageError")).getAttribute("value");

	  assertEquals(errorMsg, UI_errorMsg);
	  assertEquals(nameError, UI_nameError);
	  assertEquals(loginIDError, UI_loginIDError);
	  assertEquals(passwordError, UI_passwordError);
	  assertEquals(mavidError, UI_mavidError);
	  assertEquals(emailError, UI_emailError);
	  assertEquals(drivingLicenseError, UI_drivingLicenseError);
	  assertEquals(dlexpError, UI_dlexpError);
	  assertEquals(contactError, UI_contactError);
	  assertEquals(ageError, UI_ageError);


	  Mav_Register(driver, name_valid, loginID_valid, password_valid, mavid_valid, email_valid, drivingLicense_valid, dlexp_valid, contact_valid, Type_valid, age_valid );

	  //driver.findElement(By.xpath("(//a[contains(text(),'submit')])[1]")).click();
//	  driver.findElement(By.linkText("submit")).click();
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

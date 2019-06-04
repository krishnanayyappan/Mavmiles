package selenium;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class AdminLoginProfileSelenium extends functions.mavmiles_BusinessFunctions{
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
  @FileParameters("src/selenium/inputs_AdminLoginEdit.csv")
	public void testAdminLoginProfile(int testcaseno, String loginid,String loginid_valid,	String errorMsg, String loginidError) throws Exception {
//    driver.get(baseUrl + "/mavmiles/");
	  driver.get(sAppURL);
	  Mav_BF_Login(driver, "admin", "admin");
	  
//	  String occupants_str = String.valueOf(occupants);
	  driver.findElement(By.xpath("//li[1]/a/span")).click();
//	  driver.findElement(By.linkText("Edit User Profile")).click();
	  Mav_Login_Profile(driver, loginid);
	  
	  String UI_errorMsg = driver.findElement(By.name("errMsg")).getAttribute("value");
	  String UI_loginidError = driver.findElement(By.name("loginIDError")).getAttribute("value");
	  assertEquals(errorMsg, UI_errorMsg);
//	  assertEquals(nameError, UI_nameError);
	  assertEquals(loginidError, UI_loginidError);
//	  assertEquals(passwordError, UI_passwordError);
//	  assertEquals(Drivinglicenseerror, UI_Drivinglicenseerror);
//	  assertEquals(dlexperror, UI_dlexperror);
//	  assertEquals(contacterror, UI_contacterror);
	  
//	  String occupants_str_valid = String.valueOf(occupants_valid);
	  Mav_Login_Profile(driver, loginid_valid);
	  
//	  driver.findElement(By.xpath("(//a[contains(text(),'Update')])[1]")).click();
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

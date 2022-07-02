package Lab06;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class firsttestngfile {
  public String baseUrl = "http://:http://lms.poly.edu.vn//";
  String driverPath = "C:\\chormedriver.exe";
  public WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Launching Chrome browser");
    System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
    driver.get(baseUrl);
  }
  @Test
  public void verifyHomePageTitle(){
    String expectedTitle ="Hệ thống quản lý trị học tập Fpt Polytechnic";
    String actualTitle = driver.getTitle();
    assertEquals(actualTitle, expectedTitle);
  }
  @AfterTest
  public void afterTest() {
    driver.close();
  }

}

package Lab05;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class NewTest {
  WebDriver driver;
  @DataProvider(name="data")
  public Object[][] dp() {
    return new Object[][] {
      {"https://lms.poly.edu.vn"},
        {"https://ap.poly.edu.vn"},
        {"https://cms.poly.edu.vn/"}
    };
  }
  @BeforeMethod	
  public void beforeMethod() {
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    driver.manage().window().maximize();
  }
  @Test(dataProvider = "data")
  public void f(String tenWeb){
    driver.get(tenWeb);
    assertEquals(driver.getTitle(), "Learning Management System | Hệ thống quản trị học tập | FPT Polytechnic Việt Nam");
  }
  
  
  @AfterMethod
  public void afterMethod() {
    driver.close();
  }


 
}

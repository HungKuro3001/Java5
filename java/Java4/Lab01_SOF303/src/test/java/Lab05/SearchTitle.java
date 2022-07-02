package Lab05;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SearchTitle {
  @Test
  public void testTimKiemLMS(){
	    WebDriverManager.edgedriver().setup();
	    EdgeDriver driver = new EdgeDriver();
	    driver.get("https://lms.poly.edu.vn");
	    driver.manage().window().maximize();
	    assertEquals(driver.getTitle(), "Learning Management System | Hệ thống quản trị học tập | FPT Polytechnic Việt Nam");
	    driver.close();
	  }
  @Test
	  public void testTimKiemAP(){
	    WebDriverManager.edgedriver().setup();
	    EdgeDriver driver = new EdgeDriver();
	    driver.get("https://ap.poly.edu.vn");
	    driver.manage().window().maximize();
	    assertEquals(driver.getTitle(), "Cao đẳng FPT Polytechnic");
	    driver.close();
	  }
 @Test
 	public void testTimKiemCMS() {
	   WebDriverManager.edgedriver().setup();
	    EdgeDriver driver = new EdgeDriver();
	    driver.get("https://cms.poly.edu.vn/");
	    driver.manage().window().maximize();
	    assertEquals(driver.getTitle(), "\n"
	    		+ "       Dashboard | FPT Polytechnic | Course Management System\n"
	    		+ "      ");
	    driver.close();
 }
}

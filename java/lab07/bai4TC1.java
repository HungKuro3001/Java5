package lab07;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class bai4TC1 {
	WebDriver driver;
 
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage (). window ().maximize ();
      driver.get("http://live.techpanda.org/index.php/");
      
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  

  @Test
  public void TestNoiDungTitle() {
	  String noiDungString=driver.findElement(By.className("page-title")).getText();
	  assertEquals(noiDungString, "THIS IS DEMO SITE FOR   ");
  }
  
  @Test
  public void clickMobile() {
	  driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
  }
  @Test
  public void TestTieuDeMobile() {
	  driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
	  String noiDungString=driver.findElement(By.className("page-title")).getText();
	  assertEquals(noiDungString, "MOBILE");
	  
  }
  
  @Test
  public void TestSortName() {
	  driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")).click();
	  String sortString= driver.getCurrentUrl();
	  assertTrue(sortString.contains("name"));
	  
  }
  
  @Test
  public void soSanhGia() {
	  driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")).click();
	  String giaTrangMoblie=driver.findElement(By.id("product-price-1")).getText();
	  driver.findElement(By.xpath("//*[@id=\"product-collection-image-1\"]")).click();
	  String giaChiTietString=driver.findElement(By.className("price")).getText();
	  assertEquals(giaChiTietString, giaTrangMoblie);
  }
  @Test
  public void TestTitle() {
//	  System.out.println(driver.getTitle());
	  driver.get("http://live.techpanda.org/index.php/");
	  assertEquals(driver.getTitle(),"Home page");
  }

}

package ASM2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestBien {
  WebDriver driver;
  @BeforeMethod
  public void beforMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  this.driver.get("https://live.techpanda.org");
	  this.driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first > a")).click();
  }
  @Test(dataProvider = "dp")
	public void f(String soLuong, String msg) {
		//add to cart
		  driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button > span > span")).click() ;
		  
		 // driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")).click() ;
		  driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).clear();
		  driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).sendKeys(soLuong);
		  
	  driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > button")).click() ;
	  String msg2="";
	  if(soLuong.equals("501")) {
		   msg2 = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div > ul > li > ul > li")).getText();
	  }
	  else if(soLuong.equals("0")) {
		  msg2 = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.page-title > h1")).getText();
	  }
	  else if(soLuong.equals("-1")) {
		  msg="";
	  }
	  else {
		  msg2 = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span")).getText();
	  }
	 
	 //String msg2 = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-info > p")).getText();  
	 System.out.println(msg2);
	  assertEquals(msg, msg2);
	  
	}

	@DataProvider(name="dp")
	public Object [][] tieuDe() {
	  return new Object[][] {
		  {"501", "Some of the products cannot be ordered in requested quantity."},
		  {"499","$49,900.00"},
		  {"500","$50,000.00"},
		  {"1", "$100.00"},
		  {"-1", ""},
		  {"0", "SHOPPING CART IS EMPTY"}
	  };
	  }

  @AfterMethod
  public void afterTest() {
	  this.driver.close();
  }

}

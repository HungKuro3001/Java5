package Test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class TC1 {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    driver.get("https://live.techpanda.org/");
    

  }

  @Test
  public void test1(){
    driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();
    driver.findElement(By.cssSelector("#header-account > div > ul > li.first > a")).click();
    driver.findElement(By.cssSelector("#login-form > div > div.col-1.new-users > div.buttons-set > a")).click();
    driver.findElement(By.cssSelector("#firstname")).sendKeys("Hung");
    driver.findElement(By.cssSelector("#middlename")).sendKeys("Phi");
    driver.findElement(By.cssSelector("#lastname")).sendKeys("Hoang");
    driver.findElement(By.cssSelector("#email_address")).sendKeys("hunghpph1712455@fpt.edu.vn");
    driver.findElement(By.cssSelector("#password")).sendKeys("123456");
    driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
    driver.findElement(By.cssSelector("#is_subscribed")).click();
    driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
    driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.last > a")).click();
    String welcome = driver.findElement(By.cssSelector("body > div > div > div.header-language-background > div > p")).getText();
    assertEquals(welcome, "WELCOME, HUNG PHI HOANG!");
    driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.last > a")).click();
    driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > ul > li:nth-child(1) > a")).click();
    driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.last > a")).click();
    driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(2) > div > div.actions > ul > li:nth-child(1) > a")).click();
    driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-share")).click();
    driver.findElement(By.cssSelector("#email_address")).sendKeys("baconvoi1234@gmail.com");
    driver.findElement(By.cssSelector("#message")).sendKeys("hello");
    driver.findElement(By.cssSelector("#form-validate > div.buttons-set.form-buttons > button")).click();



  }

  @AfterTest
  public void afterTest() {
    driver.close();
  }

}

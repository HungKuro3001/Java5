package ASM2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class TestCase1 {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    driver.get("https://live.techpanda.org/");
    driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first > a")).click();

  }
  @Test
  public void testName(){
    String name = driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > h2 > a")).getText();
    driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > a")).click();
    String name2 = driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-name > span")).getText();
    assertEquals(name, name2);
  }
  @AfterTest
  public void afterTest() {
    driver.close();
  }

}

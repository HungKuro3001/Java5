package ASM2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class TestCase2 {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    driver.get("https://live.techpanda.org/");
    driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first > a")).click();

  }
  @Test
  public void addToCart(){
    driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > button")).click();
    // change QTY 1 to 100
    driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).sendKeys("1000");
    driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > button")).click();
    String message = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div > ul > li > ul > li > span")).getText();
    assertEquals(message, "Some of the products cannot be ordered in requested quantity.");
    driver.findElement(By.cssSelector("#empty_cart_button")).click();
    String title = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.page-title > h1")).getText();
    assertEquals(title, "SHOPPING CART IS EMPTY");

  }
  @AfterTest
  public void afterTest() {
    driver.close();
  }

}

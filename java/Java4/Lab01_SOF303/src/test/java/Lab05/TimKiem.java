package Lab05;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class TimKiem {
  @Test(groups="test1")
  public void testTimKiem1(){
    WebDriverManager.edgedriver().setup();
    EdgeDriver driver = new EdgeDriver();
    driver.get("https://www.google.com");
    driver.manage().window().maximize();
    driver.findElement(By.name("q")).sendKeys("Cao đẳng thực hành");
    WebElement element = driver.findElements(By.name("btnK")).get(1);
    Actions action = new Actions(driver).click(element);
    action.build().perform();
    driver.close();
  }
  @Test(groups="test1")
  public void testTimKiem2(){
	    WebDriverManager.edgedriver().setup();
	    EdgeDriver driver = new EdgeDriver();
	    driver.get("https://www.google.com");
	    driver.manage().window().maximize();
	    driver.findElement(By.name("q")).sendKeys("Cao đẳng FPT");
	    WebElement element = driver.findElements(By.name("btnK")).get(1);
	    Actions action = new Actions(driver).click(element);
	    action.build().perform();
	    driver.close();
	  }
  @Test
  public void testTimKiem3(){
	    WebDriverManager.edgedriver().setup();
	    EdgeDriver driver = new EdgeDriver();
	    driver.get("https://www.google.com");
	    driver.manage().window().maximize();
	    driver.findElement(By.name("q")).sendKeys("Cao đẳng thực hành FPT");
	    WebElement element = driver.findElements(By.name("btnK")).get(1);
	    Actions action = new Actions(driver).click(element);
	    action.build().perform();
	    driver.close();
	  }
}

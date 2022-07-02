package Lab06;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

@Test
public class TestClass {
  @BeforeTest
  public void beforeTest() {
    System.out.println("testClass: beforeTest");
  }
  public void unitLevel1(){
    System.out.println("testClass: unitLevel1");
  }
  public void unitLevel2(){
    System.out.println("testClass: unitLevel2");
  }
  @BeforeMethod
  public void beforeMethod() {
    System.out.println("testClass: beforeMethod");
  }
  @Parameters({"param"})
  @BeforeMethod
  public void beforeMethodWithParameter(String param) {
    System.out.println("testClass: beforeMethod: " + param);
  }
  @AfterMethod
  public void afterMethod() {
    System.out.println("testClass: afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
    System.out.println("testClass: beforeClass");
  }

  @AfterClass
  public void afterClass() {
    System.out.println("testClass: afterClass");
  }

  

  @AfterTest
  public void afterTest() {
    System.out.println("testClass: afterTest");
  }
  
}

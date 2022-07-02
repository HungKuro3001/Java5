package Lab04;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class VatCaCulatorTest {

  @Test(groups = "Hung")
  public void getVatTest1() {
	  assertEquals(VatCaCulator.getVat(1000000), 50000.0);
  }
  @Test(groups = "Hung")
  public void getVatTest2() {
	  assertEquals(VatCaCulator.getVat(5000000), 500000.0);
  }
  @Test
  public void getVatTest3() {
    assertEquals(VatCaCulator.getVat(15000000), 2250000.0);
  }
  @Test
  public void getVatTest4() {
    assertEquals(VatCaCulator.getVat(25000000), 5000000.0);
  }
  @Test
  public void getVatTest5() {
	    assertEquals(VatCaCulator.getVat(65000000), 1.95E7);
	  }
  // test trường hợp sai
  @Test
    public void getVatTestSai() {
	    assertEquals(VatCaCulator.getVat(100000000), 3.5E7);
	  }
}

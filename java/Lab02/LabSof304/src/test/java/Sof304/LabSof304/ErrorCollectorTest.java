package Sof304.LabSof304;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;


public class ErrorCollectorTest {
	@Rule
	public ErrorCollector collector =new ErrorCollector();
	@Test
	public void test1() {
	    collector.addError(new Throwable("Loi o dong 1"));
	    collector.addError(new Throwable("Loi o dong 2"));
	   try {
	       assertTrue("A"=="B");
	       fail("Test case fail");
	     } catch (Throwable e) {
	       collector.addError(e);
}
	}
}

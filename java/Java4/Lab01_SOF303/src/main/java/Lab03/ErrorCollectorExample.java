package Lab03;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorExample {
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	@Test
	public void example() {
		collector.addError(new Throwable("There is an error in first line"));
		collector.addError(new Throwable("There is an error in second line"));
		try {
			Assert.assertTrue("A"=="B");
		} catch (Throwable e) {
			collector.addError(e);
		}
	}
}

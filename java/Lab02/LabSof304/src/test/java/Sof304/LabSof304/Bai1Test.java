package Sof304.LabSof304;

import javax.annotation.processing.Generated;

import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class Bai1Test {

	private Bai1 createTestSubject() {
		return new Bai1();
	}

	
	@Test(expected = ArithmeticException.class)
	public void testDivide() throws Exception {
		Bai1 testSubject;

		
		testSubject = createTestSubject();
		testSubject.div();
	}
}
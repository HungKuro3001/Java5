package SOF304.Lap2;

import org.junit.Assert;
import org.junit.Test;

import SOF304.Lab2.MathFunc;

public class MathFuncTest2 {

	private MathFunc createTestSubject() {
		return new MathFunc();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFactorial() {
		MathFunc testSubject;
		int number = 0;
		long result;

		// test 2
		testSubject = createTestSubject();
		number = -1;
		result = testSubject.factorial(number);

		// test 4
		testSubject = createTestSubject();
		number = 21;
		result = testSubject.factorial(number);

		// test 6
		testSubject = createTestSubject();
		number = 22;
		result = testSubject.factorial(number);
	}

	@Test
	public void TestFactorialDone() {
		MathFunc testSubject;
		int number = 0;
		long result;

		// test 1
		testSubject = createTestSubject();
		number = 0;
		result = testSubject.factorial(number);
		Assert.assertEquals(1, result);
		// test 3
		testSubject = createTestSubject();
		number = 1;
		result = testSubject.factorial(number);
		Assert.assertEquals(1, result);
		// test 5
		testSubject = createTestSubject();
		number = 20;
		result = testSubject.factorial(number);
		Assert.assertEquals(2432902008176640000L, result);
		// test 7
		testSubject = createTestSubject();
		number = 3;
		result = testSubject.factorial(number);
		Assert.assertEquals(6, result);

		// test 8
		testSubject = createTestSubject();
		number = 2;
		result = testSubject.factorial(number);
		Assert.assertEquals(2, result);
	}

	@Test
	public void testPlus() throws Exception {
		MathFunc testSubject;
		int a = 3;
		int b = 6;
		long result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.plus(a, b);
		Assert.assertEquals(9, result);
	}
}
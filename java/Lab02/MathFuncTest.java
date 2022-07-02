package SOF304.Lap2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import SOF304.Lab2.MathFunc;

public class MathFuncTest {
	MathFunc mathFunc;
	@Before
	public void setUp() throws Exception {
		mathFunc=new MathFunc();
	}

	@After
	public void tearDown() throws Exception {
		mathFunc=null;
	}
	@Ignore
	@Test
	public void todo() {
		assertTrue(mathFunc.plus(3, 3)==6);
	}
	@Test
	public void calls1() {
		assertEquals(0, mathFunc.getCalls());
	}
	@Test
	public void calls2() {
		mathFunc.factorial(1);
		assertEquals(1, mathFunc.getCalls());
	}
	@Test
	public void calls3() {
		mathFunc.factorial(3);
		assertEquals(1, mathFunc.getCalls());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFactorial1() {
		mathFunc.factorial(-1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testFactorial2() {
		mathFunc.factorial(22);
	}
	@Test
	public void testFactorial3() {
		assertEquals(1, mathFunc.factorial(0));
	}
	@Test
	public void testFactorial4() {
		assertEquals(2432902008176640000L,mathFunc.factorial(20));
	}
	@Test
	public void testFactorial5() {
		assertEquals(1, mathFunc.factorial(1));
	}
	@Test
	public void testFactorial6() {
		assertEquals(40320, mathFunc.factorial(8));
	}

	@Test
	public void testPlus() {
		assertEquals(7, mathFunc.plus(3, 4));
	}
}

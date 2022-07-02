package SOF304.SOF304_Lab1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;

public class CaculatorTest2 {
Caculator goi;
public  CaculatorTest2() {
	goi = new Caculator();
}
	@Test
	public void testAdd() {
		assertEquals(11, goi.add(5, 6));
	}

	@Test
	public void testSub() {
		assertEquals(11, goi.sub(5, 6));
	}

	@Test
	public void testMul() {
		assertEquals(11, goi.mul(5, 6));
	}

	@Test
	public void testDiv() {
		assertEquals(11, goi.div(5, 6));
	}

}

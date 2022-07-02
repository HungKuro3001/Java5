package Lab2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TinhGiaiThuaTest {
	TinhGiaiThua math;

	@Before
	public void setUpBeforeClass() throws Exception {
		math = new TinhGiaiThua();
	}

	@After
	public void tearDownAfterClass() throws Exception {
		math = null;
	}

	@Test
	public void testGetCall() {
		assertEquals(0, math.getCall());
		math.tinhGiaiThua(1);
		assertEquals(1, math.getCall());
		math.tinhGiaiThua(2);
		assertEquals(2, math.getCall());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testTinhGiaiThua() {
		assertEquals(math.tinhGiaiThua(-1), 1);
		assertEquals(math.tinhGiaiThua(1), 1);
		assertEquals(math.tinhGiaiThua(5), 120);
	}

	@Ignore
	@Test
	public void testPlus() {
		assertEquals(math.plus(1, 2), 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGiaiThuaSoAm() throws Exception {
		math.tinhGiaiThua(-1);
		math.tinhGiaiThua(2);
		math.tinhGiaiThua(20);

	}

	@Test
	public void testGiaiThuaTry() throws Exception {
		try {
			math.tinhGiaiThua(-1);
			fail("không phát hiện lỗi");
		} catch (Exception e) {
			assertEquals("Số nhập vào được nhỏ hơn 0 lớn hơn 20", e.getMessage());
		}

	}
   @Rule
   public ExpectedException ngoaile = ExpectedException.none();
   
   public void kiemtrangoailevoiRule() throws Exception{
	   ngoaile.expect(IllegalArgumentException.class);
	   math.tinhGiaiThua(-1);
	   math.tinhGiaiThua(2);
		math.tinhGiaiThua(20);
   }
}

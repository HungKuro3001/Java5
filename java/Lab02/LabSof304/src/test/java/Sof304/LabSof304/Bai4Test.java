package Sof304.LabSof304;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.annotation.processing.Generated;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.rules.ExpectedException;
public class Bai4Test {
	MathFunc math =new MathFunc(); 
	@BeforeEach
	public void init() throws Exception {
		 math =new MathFunc(); 
	}

	@AfterEach
	public void tearDown() throws Exception {
		math =null;
	}


	@Test
	public void testFactorial() {
		assertEquals(math.factorial(0), 1);
		assertEquals(math.factorial(1), 1);
		assertEquals(math.factorial(5), 120);
		assertEquals(math.factorial(20), 2432902008176640000L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWrong() throws Exception{
	
		math.factorial(-1);
		math.factorial(22);
		math.factorial(21);
		
	}
	//with try catch có kèm chú thích lỗi
	@Test 
	public void kiemtranhunggiaithuasaivoighichuloi() throws Exception{ 
	try { 
		math.factorial(-1);
		math.factorial(22);
		math.factorial(21);
	fail("không bắt được ngoại lệ"); 
	} catch (IllegalArgumentException e) { 
		assertEquals("Số nhập vào không được âm và trong khoảng 0..20", e.getMessage()); 
	} 
	}
	//with try catch 
	public void kiemtranhunggiaithuasai() throws Exception{ 
		try { 
			math.factorial(-1);
			math.factorial(22);
			math.factorial(21);
		fail("không bắt được ngoại lệ"); 
		} catch (IllegalArgumentException e) { 
		} 
		}

	
	//bắt ngoại lẹ bằng rule
	@Rule
	public ExpectedException ngoaiLe =ExpectedException.none();
	@Test
	public void kiemTraNLWRule() throws Exception{
		ngoaiLe.expect(IllegalArgumentException.class);
		math.factorial(-1);
		math.factorial(22);
		math.factorial(21);
	}
}

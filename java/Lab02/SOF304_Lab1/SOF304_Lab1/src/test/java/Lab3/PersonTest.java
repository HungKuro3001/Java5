package Lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonTest {
   @Rule
   public ExpectedException exception = ExpectedException.none();
	@Test
	public void test() {
		exception.expect(IllegalArgumentException.class);
		new Person("Fpoly",-1);
	}
	@Test
	public void test2() {
		try {
			new Person("Fpoly",2);
			fail("không dính lỗi");
		} catch (Exception e) {
			assertEquals("Invalid age: -1", e.getMessage());
		}
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void test3() {	
			new Person("Fpoly",2);		
	}


}

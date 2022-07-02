package Sof304.LabSof304;
import static org.junit.Assert.fail;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonTest {
	@Rule
	public ExpectedException exception =ExpectedException.none();
	
		@Test
		public void testExpectedException() {
			exception.expect(IllegalArgumentException.class);
			new Person("Manh", -1);
			new Person("Manh", 14);
			new Person("Manh", 66);
		}
		@Test
		public void testExpectedExceptionwithtrycatch() {
			try {
			new Person("Manh", -1);
			new Person("Manh", 14);
			new Person("Manh", 66);
			fail("Không bắt được ngoại lệ");
			}
			catch (IllegalArgumentException e) {
			e.getMessage()	;
			}
		}
}

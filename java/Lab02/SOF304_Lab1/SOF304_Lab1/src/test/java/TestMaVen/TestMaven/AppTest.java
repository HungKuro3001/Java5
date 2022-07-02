package TestMaVen.TestMaven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.processing.Generated;

import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class AppTest {

	private App createTestSubject() {
		return new App();
	}

	@Test
	public void testIsEventNumber() throws Exception {
		App testSubject;
		int input = 5;
		boolean result;
		boolean kyvong=true;

		// default test
		testSubject = createTestSubject();
		result = testSubject.isEventNumber(input);
		assertEquals(kyvong, result);
	}
	@Test
	public void testIsEventNumber4() throws Exception {
		App testSubject;
		int input = 4;
		boolean result;
		boolean kyvong=true;

		// default test
		testSubject = createTestSubject();
		result = testSubject.isEventNumber(input);
		assertEquals(kyvong, result);
	}
}
package SOF304.SOF304_Lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.processing.Generated;

import org.junit.Test;
import java.util.*;
import org.junit.Assert;

public class CaculatorTest {

	public Caculator createTestSubject() {
		return new Caculator();
	}

	@Test
	public void testDiv() throws Exception {
		Caculator testSubject;
		int a = 40;
		int b = 5;
		int result;
        int kyvong = 8;
		// default test
		testSubject = createTestSubject();
		result = testSubject.div(a, b);
		assertEquals(kyvong, result);
	}

	@Test
	public void testAdd() throws Exception {
		Caculator testSubject;
		int a = 1;
		int b = 2;
		int result;
		 int kyvong = 8;
		// default test
		testSubject = createTestSubject();
		result = testSubject.add(a, b);
		assertEquals(kyvong, result);
	}

	@Test
	public void testMul() throws Exception {
		Caculator testSubject;
		int a = 2;
		int b = 0;
		int result;
		 int kyvong = 2;
		// default test
		testSubject = createTestSubject();
		result = testSubject.mul(a, b);
		assertEquals(kyvong, result);
	}

	@Test
	public void testSub() throws Exception {
		Caculator testSubject;
		int a = 2;
		int b = 2;
		int result;
		 int kyvong = 4;
		// default test
		testSubject = createTestSubject();
		result = testSubject.sub(a, b);
		assertEquals(kyvong, result);
	}
}
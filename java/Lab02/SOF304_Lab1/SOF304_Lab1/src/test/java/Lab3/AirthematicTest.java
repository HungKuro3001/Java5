package Lab3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class AirthematicTest {
	String message = "FPT polytecnic";
    JunitMessage messageMessage = new JunitMessage(message);
	@Test(expected = ArithmeticException.class)
	public void testJunitMessage() throws Exception{
		System.out.println("fpoly Junit Message exception is printing");
		messageMessage.printMessage();
	}
	@Test
	public void testJunitHiMessage() throws Exception{
		
		message = "Hi!"+message;
		System.out.println("FPT Junit Message is printing");
		assertEquals(message, messageMessage.printHiMessage());
	}

}

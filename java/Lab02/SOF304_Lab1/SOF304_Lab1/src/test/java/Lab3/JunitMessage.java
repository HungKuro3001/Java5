package Lab3;

public class JunitMessage {
    private String message;

	public JunitMessage(String message) {
		super();
		this.message = message;
	}
    
    public void printMessage() {
    	System.out.println(message);
    	int divide  = 1/0;
    }
    public String printHiMessage() {
    	message = "Hi!" + message;
    	System.out.println(message);
    	return message;
    }
}

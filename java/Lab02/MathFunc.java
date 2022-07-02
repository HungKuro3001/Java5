package SOF304.Lab2;

public class MathFunc {
	int calls;

	public int getCalls() {
		return calls;
	}

	public long factorial(int number) {
		this.calls++;
		if (number < 0 || number >= 21) {
			throw new IllegalArgumentException();
		}
		long result = 1;
		if (number > 1) {
			for (int i = 1; i <= number; i++) {
				result *= i;
			}
		}
		return result;
	}

	public long plus(int a, int b) {
		this.calls++;
		return a + b;
	}
}

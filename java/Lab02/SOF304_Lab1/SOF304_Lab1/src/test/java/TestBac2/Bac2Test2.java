package TestBac2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;

import org.junit.jupiter.api.BeforeEach;

public class Bac2Test2 {
	// A reference to the SquareEquation class
	private Bac2 se = new Bac2(2, 1, -3);;
	@BeforeEach
	void setUp() throws Exception {
	// This method is called first.
	// Create an instance of the SquareEquation class
	se = new Bac2(2, 1, -3); // 2*x^2 + x - 3 = 0
	}
	@Test
	public void testSolution() {
	// Declare an instance of the Roots class
	Roots rt = se.Solution();
	// Solution check x1
	assertEquals(rt.x1, -1.5);
	// Solution check x2
	assertEquals(rt.x2, 1.0);
	}
	@Test
	public void testSolution2() {
	// Declare an instance of the Roots class
	Roots rt = se.Solution();
	// Solution check x1
	assertEquals(rt.x1, -1.5);
	// Solution check x2
	assertEquals(rt.x2, 10.0);
	}
	@Test
	public void testSolution3() {
	// Declare an instance of the Roots class
	Roots rt = se.Solution();
	// Solution check x1
	assertEquals(rt.x1, -1.5);
	// Solution check x2
	assertEquals(rt.x2, 15.0);

	}
}

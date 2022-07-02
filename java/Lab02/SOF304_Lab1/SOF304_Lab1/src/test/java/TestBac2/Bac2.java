package TestBac2;

import javax.naming.spi.DirStateFactory.Result;

class Roots{
	 public double x1,x2;
	 public Roots() {
		// TODO Auto-generated constructor stub
	}
	public Roots(double x1, double x2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
	}
	 
 }
public class Bac2 {
  private double a,b,c;
  
  public Bac2() {
	// TODO Auto-generated constructor stub
}

public Bac2(double a, double b, double c) {
	super();
	this.a = a;
	this.b = b;
	this.c = c;
}
public Roots Solution() {
	double delta = Math.pow(b, 2) - 4*a*c;
	if( delta < 0 ) {
		throw new ArithmeticException("Vô nghiệm");
	}
	Roots reusult = new Roots();
	reusult.x1 = (-b - Math.sqrt(delta))/(2*a);
	reusult.x2 = (-b + Math.sqrt(delta))/(2*a);
	return reusult;
	
}
  
}

package Lab3;

public class Person {
  private  String name;
  private  int age;
public Person(String name, int age) {
	super();
	this.name = name;
	this.age = age;
	if(name.isEmpty()) {
		throw new IllegalArgumentException("Tên Trống");
	}
	if(age < 0 || age > 100) {
		throw new IllegalArgumentException("Invalid age: "+age );
	}
}
    
  
  
}

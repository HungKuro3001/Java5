package Sof304.LabSof304;

public class Person {
	private  String name;
	private int age;
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
		
		if(age<=0) {
			throw new IllegalArgumentException("Tuổi không hợp lệ:"+age);
			
		}
		else if(age<15) {
			throw new IllegalArgumentException("Chưa đủ tuổi lao động:"+age);
		}
		else if(age>65) {
			throw new IllegalArgumentException("Nghỉ ngơi đi bác ơi:"+age);
		}
	}
	
}

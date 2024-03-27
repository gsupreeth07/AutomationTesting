package Java18.innerclass.operator;

import Java18.innerclass.A;
import Java18.innerclass.Greetabl;

public class OpertorDemo {
	
	void printName() {
		System.out.println("my name is Supreeth");
		
	}
	static void printName(String name) {
		System.out.println("good morning, my name is "+name);
	}
	public static void main(String[] args) {
		A ab= new OpertorDemo()::printName;
		ab.printName();
		
		Greetabl gb= OpertorDemo::printName;
		
		
	}

}

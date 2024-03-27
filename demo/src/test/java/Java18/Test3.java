package Java18;

public class Test3 {
	
	public static void main(String[] args) {
		Test t1 = new Test();
		Test2 t2 = new Test2();
		
		A a1 = new A() {
			public void printName() {
				System.out.println("Annonymous inner class");
			}
		};
		
		A a2 = new A() {
			public void printName() {
				System.out.println("Annonymous inner class");
			}
		};
		
	}

}

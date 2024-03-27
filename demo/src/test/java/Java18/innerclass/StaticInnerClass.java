package Java18.innerclass;

public class StaticInnerClass {
	
	static int age=25;
	 static class Test {
		static void test1() {
			System.out.println("i'm from inner class static method " + age);
			
		}
		
		void test2() {
			System.out.println("i'm from inner class non static method " + age );
		}
		
	}
	 
	 public static void main(String[] args) {
		 Test t = new Test();
		 t.test2();
		 t.test1();
		 
		 StaticInnerClass.Test.test1();
	}
	 
	 

}

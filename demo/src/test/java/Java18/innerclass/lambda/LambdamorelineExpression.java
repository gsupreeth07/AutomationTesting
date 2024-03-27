package Java18.innerclass.lambda;

public class LambdamorelineExpression {

	
	public static void main(String[] args) {
		A a1 = new A() {
			public void printName() {
				System.out.println("annonymous inner class");
			}
		};
		
		A a = () -> {
			System.out.println("---------------------");
			System.out.println("lambda expression");
			System.out.println("---------------------");
		
		};
		a.printName();
		
		
	}
}

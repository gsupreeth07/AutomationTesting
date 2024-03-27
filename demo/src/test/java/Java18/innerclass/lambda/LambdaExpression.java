package Java18.innerclass.lambda;

public class LambdaExpression {

	
	public static void main(String[] args) {
		A a1 = new A() {
			public void printName() {
				System.out.println("annonymous inner class");
			}
		};
		
		A a = () -> System.out.println("lambda expression");
		a.printName();
		
		B b = (name) -> System.out.println("lambda expression " +name);
	b.printName("supreeth");
	}
}

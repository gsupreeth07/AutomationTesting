package Java18.innerclass;

public class LocalInnerClass {
	
	public static void main(String[] args) {
		
		class Person{
			String name;
			int age ;
			
			public Person() {
				
			}
			public Person(String name, int age) {
				this.name=name;
				this.age=age;
				System.out.println("person name and age"+ name +age);
			}
		}
	}

}

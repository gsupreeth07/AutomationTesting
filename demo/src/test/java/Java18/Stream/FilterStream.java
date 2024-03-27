package Java18.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStream {

	public static void main(String[] args) {
		List<Integer> l= new ArrayList<Integer>();
		l.add(23);
		l.add(56);
		l.add(73);
		l.add(14);
		l.add(10);
		l.add(14);
		l.add(66);
		l.add(89);
		l.add(100);
		l.add(01);
		
		Stream<Integer> stream = l.stream();
		
		Stream<Integer> lamda = stream.filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer num) {
				
				return num>18 ;
			}
		});
		System.out.println("printing the number greater than 18");
		List<Integer> greaterthan18 = lamda.filter(num -> num>18).collect(Collectors.toList());
		greaterthan18.forEach(System.out::println);
		
		stream.close();
		
		stream = l.stream();
		System.out.println("printing the odd numbers");
		List<Integer> oddnumbers = lamda.filter(num -> num%2!=0).collect(Collectors.toList());
		oddnumbers.forEach(System.out::println);
		
		stream.close();
		
		stream = l.stream();
		System.out.println("printing the even numbers");
		List<Integer> evennumbers = lamda.filter(num -> num%2==0).collect(Collectors.toList());
		evennumbers.forEach(System.out::println);
		
		stream.close();
		
		stream = l.stream();
		System.out.println("printing the first number greater than 18");
	//	List<Integer> firstNumbergreaterthan18 = lamda.filter(num -> (num>18)).findFirst();
		oddnumbers.forEach(System.out::println);
		
		
		
		
		
		
	
		
		
		
	
	}
}

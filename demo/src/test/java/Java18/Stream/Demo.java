package Java18.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {

	public static void main(String[] args) {
		List<Integer> l= new ArrayList<Integer>();
		l.add(23);
		l.add(56);
		l.add(73);
		l.add(34);
		l.add(10);
		l.add(44);
		l.add(66);
		l.add(89);
		l.add(100);
		l.add(01);
		
		Stream<Integer> stream = l.stream();
		
		stream.forEach(System.out::println);
		
	
	}
}

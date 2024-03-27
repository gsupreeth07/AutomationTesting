package Java18.innerclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;

public class SpiltIterator {
	
	
	
	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<Integer>();
		
		for (int i = 0; i < 250; i++) {
			l.add(i+1);
		}
		
		Spliterator<Integer> it = l.spliterator();
		Spliterator<Integer> childIt=it.trySplit();
		
		it.forEachRemaining((ele) -> System.out.println(ele));
		
		System.out.println("Second set");
	
		childIt.forEachRemaining(ele -> System.out.println(ele));
	    
	    
		
		
	}

}

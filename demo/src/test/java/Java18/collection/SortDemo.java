package Java18.collection;

import java.util.ArrayList;
import java.util.List;

public class SortDemo {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(59);
		list.add(10);
		list.add(30);
		list.add(20);
		
		list.sort((x,y) -> x.compare(x,y));
		list.forEach((item) -> System.out.println(item));
	}

}

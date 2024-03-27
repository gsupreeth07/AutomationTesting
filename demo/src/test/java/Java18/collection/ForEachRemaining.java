package Java18.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ForEachRemaining {

	
	public static void main(String[] args) {
		List<String> name= new ArrayList<String>();
		name.add("supreeth");
		name.add("rakesh");
		name.add("sandeep");
		name.add("mallikarjun");
		
		name.forEach((item)  -> System.out.println(item));
		
		System.out.println("----printing using iterator----");
		
		Iterator<String> t = name.iterator();
		
		t.forEachRemaining((item) -> System.out.println(item));
		
	//	name.removeIf()
	}
}

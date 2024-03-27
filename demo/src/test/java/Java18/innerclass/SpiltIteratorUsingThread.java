package Java18.innerclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpiltIteratorUsingThread {

	
	public static void main(String[] args)
	{
		List<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < 250; i++)
		{
			al.add(i+1);
		}
		
		Spliterator<Integer> it = al.spliterator();
		Spliterator<Integer> childIt = it.trySplit();
		
		new Thread(() -> it.forEachRemaining((ele) -> System.out.println("Thread1 " + ele))).start();
		new Thread(() -> childIt.forEachRemaining((ele) -> System.out.println("Thread2 " + ele))).start();
		
	}
}

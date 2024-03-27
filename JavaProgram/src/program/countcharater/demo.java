package program.countcharater;

public class demo {
public static void main(String[] args) {
	String string= "hello world";
	int count =0;
	
	for (int i = 0; i < string.length(); i++) {
		if (string.charAt(i)!=' ') 
			count++;
		}
		System.out.print("total number of char in a string "+count);
	}

}

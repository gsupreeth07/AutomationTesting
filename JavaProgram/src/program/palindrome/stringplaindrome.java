package program.palindrome;

import java.util.Scanner;

public class stringplaindrome {
	
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		System.out.println("enter a string to check it is palindrome");
		String string = scan.next();
		String rev="";
		for (int i = string.length()-1; i >=0; i--) {
			rev=rev+string.charAt(i);
			
		}
		
		if(string.equalsIgnoreCase(rev)) {
			System.out.println("string is palindrome");
		}
		else {
			System.out.println("string is not palindrome");
		}
	}

}

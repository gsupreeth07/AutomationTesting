package program.palindrome;

public class Number {
	
	public static void main(String[] args) {
		int i=987;
		int sum=0;
		int n,temp ;
		temp=i;
		while(i>0) {
			
			n=i%10;
			sum=(sum*10)+n;
			n=n/10;
		}
		
		if(temp==sum) {
			System.out.println("number is palindrome");
		}
		else {
			System.out.println("number is not palindrome");
		}
	}

}

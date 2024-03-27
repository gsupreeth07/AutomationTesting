package program.reverse;

public class whiledemo {
	public static void main(String[] args) {
		
		int num=987;
		int rev=0;
		int n;
		
		while(num>0) {
			
			n=num%10;
			rev=(rev*10)+n;
			n=n/10;
		}
		System.out.println(rev);
	}


}

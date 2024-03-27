package program.rondomnumber;

public class demo2 {
	public static void main(String[] args) {
		int min =200;
		int max=400;
		System.out.println("random nmber btw"+min+"and"+max);
		double a = Math.random()*(max-min+1)+min;
		System.out.println(a);
		int b = (int)(Math.random()*(max-min+1)+min);
		System.out.println(b);
	}

}

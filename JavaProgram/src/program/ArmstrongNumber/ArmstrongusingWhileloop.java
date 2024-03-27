package program.ArmstrongNumber;

import java.util.Scanner;

public class ArmstrongusingWhileloop {
	
	public static void main(String[] args) {
		int n= 153;
		int sum=0;
		int temp,r;
		temp=n;
		Scanner sc= new Scanner(System.in);
		while (n>0) {
			r=n%10;
			n=n/10;
			
			sum=sum + r*r*r; 
			System.out.println(sum);
		}
		System.out.println(temp+" = "+sum);
		if (temp== sum) {
			System.out.println("Number is Armstrong");
		}
		else {
			System.out.println("number is not a Armstrong");
		}
	}

}

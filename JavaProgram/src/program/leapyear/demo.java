package program.leapyear;

import java.util.Scanner;

public class demo {
	
	public static void main(String[] args) {
		int year;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a year ");
		year = sc.nextInt();
		
		// 1st condition check- It is century leap year
        // 2nd condition check- It is leap year and not
        // century year
		     
		if ((year % 400 == 0) || ((year % 4 ==0 ) && (year % 100 != 0))) {
			System.out.println(year+" is a leap year");
		}
		
		else {
			System.out.println(year+" is  not a leap year");
		}
	}

}

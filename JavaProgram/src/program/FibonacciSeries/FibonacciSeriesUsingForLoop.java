package program.FibonacciSeries;

public class FibonacciSeriesUsingForLoop {

	public static void main(String[] args) {
		
		int num=100;
		int firstNum=0;
		int secondNum=1;
		int nxtNum = 0;
		for (int i = 0; i <num; i++) {
			nxtNum=firstNum+secondNum;
			
			firstNum=secondNum;
			secondNum=nxtNum;
			
			System.out.print(nxtNum+" ");

		}
	}
}

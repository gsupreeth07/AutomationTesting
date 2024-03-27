package program.reverse;

public class wordString {

	public static void main(String[] args) {

		String string = "hello supreeth, how are you";
		String[] wor=string.split(" ");

		for (int i = 0; i < wor.length; i++) {
			
			System.out.print(wor[i] + " ");
			/* for (int j = wor[i].length()-1; j >= 0; j--) {
				System.out.print(wor[i].charAt(j));            
			}

			System.out.print(" ");	*/

		}
		
	}

}

package program.Strinng;

public class CountLowerAndUppercaseletter {
	
	public static void main(String[] args) {
		String string ="GoodMorning,WelcomeToAutomation";
		int lowercase = 0;
		int uppercase = 0;
	
		
		
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if(ch>= 'A' && ch<='Z') {
				uppercase++;
			}
			else() {
				lowercase++;
			}
		}
		
		System.out.println("No of uppercase letter : "+uppercase);
		System.out.println("No of lowercase letter : "+lowercase);
	}

}

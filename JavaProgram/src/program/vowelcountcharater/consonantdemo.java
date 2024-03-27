package program.vowelcountcharater;

public class consonantdemo {
	
	public static void main(String[] args) {
	/*	consonant-There are 21 consonants in the English alphabet: 
			B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, W, X, Y, Z. 
			Keep in mind that “Y” can sometimes function as a vowel (which is known as a semivowel).*/
		
		String string= "This is a really simple sentence";
		string=string.toLowerCase();
		int count =0;
		
		for (int i = 0; i < string.length()-1; i++) {
			if (string.charAt(i)>='a' && string.charAt(i)<='z' )
				count++;
			}
			System.out.print("total number of char in a string is "+count);
		}         
	}



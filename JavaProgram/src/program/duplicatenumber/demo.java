package program.duplicatenumber;

public class demo {
	public static void main(String[] args) {
		int[] arr= new int [] {1, 2, 3, 4, 2, 7, 8, 8, 3};
		System.out.println("dulipcate element in array");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0+1; j < arr.length; j++) {
				if (arr[i]==arr[j]) 
					System.out.println(arr[j]);
				}
			}
			
		}
	}



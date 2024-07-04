package strings;

import java.util.Arrays;
import java.util.Scanner;

public class SortAlphabetically {
	public static void main(String[] args) {
		
	
	System.out.println("Enter the string:");
	Scanner sc = new Scanner(System.in);

	String inputString = sc.nextLine();
	char input[]=inputString.toCharArray();
	Arrays.sort(input);
	System.out.println("The sorted String:"+String.valueOf(input));
	sc.close();
	}
}

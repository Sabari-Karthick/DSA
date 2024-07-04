package strings;

import java.util.Scanner;

public class VowelsAndConsonants {
	public static void main(String[] args) {
		System.out.println("Enter the string:");
		Scanner sc = new Scanner(System.in);

		String Str = sc.nextLine();
	

	 
	    int vowels = 0, consonants = 0;

	    Str = Str.toLowerCase();
	    for (int i = 0; i < Str.length(); ++i) {
	      char ch = Str.charAt(i);

	      
	      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	        ++vowels;
	      }

	      
	      else if ((ch >= 'a' && ch <= 'z')) {
	        ++consonants;
	      }
	     
	    }
	    System.out.println("Vowels:"+vowels);
	      System.out.println("Consonants:"+consonants);
	      sc.close();
	}
}

package strings;

import java.util.Scanner;

public class Specialchar {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		System.out.println("Enter the string:");
		Scanner sc = new Scanner(System.in);

		String Str = sc.nextLine();

	 
	    int vowels = 0, consonants = 0, digits = 0, spaces = 0,spl=0;

	    Str = Str.toLowerCase();
	    for (int i = 0; i < Str.length(); ++i) {
	      char ch = Str.charAt(i);

	     
	      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	        ++vowels;
	      }

	     
	      else if ((ch >= 'a' && ch <= 'z')) {
	        ++consonants;
	      }
	      
	      
	      else if (ch >= '0' && ch <= '9') {
	        ++digits;
	      }
	      
	 
	      else if (ch == ' ') {
	        ++spaces;
              }
	      else {
	    	  spl++;
	      }
	   }
	    System.out.println("Digits:"+digits);
	      System.out.println("SpecialChar:"+spl);
	      sc.close(); 
}
}
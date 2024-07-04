package strings;
import java.util.Arrays;
import java.util.Scanner;

public class Anagaram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

	    
	    System.out.print("Enter first String: ");
	    String str1 = sc.nextLine();
	    System.out.print("Enter second String: ");
	    String str2 = sc.nextLine();

	    
	    if(str1.length() == str2.length()) {


	      char[] String1 = str1.toCharArray();
	      char[] String2 = str2.toCharArray();

	    
	      Arrays.sort(String1);
	      Arrays.sort(String2);
	      boolean result = Arrays.equals(String1, String2);

	      if(result) {
	        System.out.println(str1 + " and " + str2 + " are anagram.");
	      }
	      else {
	        System.out.println(str1 + " and " + str2 + " are not anagram.");
	      }
	    }
	    else {
	      System.out.println(str1 + " and " + str2 + " are not anagram.");
	    }
  sc.close();

	}
	

}

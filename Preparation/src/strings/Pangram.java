package strings;

import java.util.Scanner;

public class Pangram {
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String str = sc.nextLine();
        
 
        str = str.toLowerCase();
   	 
        boolean isPangram = true;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!str.contains(String.valueOf(ch))) {
                isPangram = false;
                break;
            }
        }
        if (isPangram)
            System.out.println("It is Pangram");
        else
            System.out.println("It is not Pangram");
        sc.close();
    }

}

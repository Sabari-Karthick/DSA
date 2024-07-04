package strings;

import java.util.Scanner;

public class RepeatingChar{
		
		 
		
		static void printCharWithFreq(String str)
		{
			int SIZE = 26;
			int n = str.length();
			int[] freq = new int[SIZE];
			for (int i = 0; i < n; i++)
				freq[str.charAt(i) - 'a']++;
			System.out.println("The repeated characters are:");
			for (int i = 0; i < n; i++) {

				
				if (freq[str.charAt(i) - 'a'] != 0 && freq[str.charAt(i) - 'a'] > 1) {

					
					System.out.print(str.charAt(i)+":");
					System.out.print(freq[str.charAt(i) - 'a'] + " ");

					
					freq[str.charAt(i) - 'a'] = 0;
				}
			}
		}
		
	
		public static void main(String args[])
		{
			System.out.println("Enter the string:");
			Scanner sc = new Scanner(System.in);

			String str = sc.nextLine();
			printCharWithFreq(str);
			sc.close();
		}
	}

	
	




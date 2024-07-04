package strings;

import java.util.Scanner;

public class ReverseInPosition {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String inputString = sc.nextLine();
	    String input[] = inputString.split(" ");
	    for(String i : input)
	    {
	      	String output = "";
	      	for(int j= i.length()-1;j>=0;j--) {
	      		output+=i.charAt(j);
	      	}
	      	System.out.print(output+" ");
	    }
  sc.close();
	}

}

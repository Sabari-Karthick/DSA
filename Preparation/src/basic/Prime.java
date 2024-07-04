package basic;

import java.util.Scanner;

public class Prime {
	public static boolean isPrime(int n)
	{
	  if(n<2)            
	      {
		return false;
         	}
	  else {
		  for(int i = 2;i<=n/2;i++) {
			  if(n%i==0) {
				  return false;
			  }
		  }
		  return true;
	  }
	  
    }

	public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number to check:");
//         int number = sc.nextInt();
//       if(  isPrime(number)) {
//    	   System.out.println("The number is prime");
//       }
//       else {
//    	   System.out.println("The number is not prime");
//       }
        	printPrime100();	
         sc.close();

	}
	public static void printPrime100() {
		
		System.out.println("The Prime numbers from 1 to 100: ");
	for(int i=1;i<=100;i++) {
		if(isPrime(i)) {
	        System.out.println(i);
		}
	}
	}
}

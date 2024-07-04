package basic;



public class Fibanocci {
	public static void main(String[] args) {
		
		int n=10;
		fibanocci(n);
	}
	public static void fibanocci(int n) {
		int num1=0;int num2=1;
	  int counter =0;
	  while(counter < n) {
		  System.out.print(num1+ " ");
		  int num3=num1+num2;
		  num1=num2;
		  num2=num3;
		  counter=counter+1;
		  
	  }
		
	}
	
}
 
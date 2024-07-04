package basic;

public class Fact {
	public static void main(String[] args) {
		int n=5;
		System.out.println("Factorial is: "+Facto(n));
	}
 public static int Facto(int n) {
	if(n==0) {
		return 1;
	}
	else {
		return n * Facto(n-1);
	}
}
}

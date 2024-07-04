package basic;

public class SumOfN {
public static void main(String[] args) {
	int n=10;
	int sum=0;
	for(int i=1;i<=n;i++) {
		sum+=i;
	}
	System.out.println(sum);
	System.out.println(sum(n));
}
public static int sum(int n) {
      return n*(n+1)/2;
}
}

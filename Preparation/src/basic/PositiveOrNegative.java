package basic;

public class PositiveOrNegative {
	public static void main(String[] args) {
		isPositive(-89);
	}
    public static void isPositive(int i) {
    	if(i>0) {
    		System.out.println("Positive");
    	}
    	else if(i==0) {
    		System.out.println("Zero");
    	}
    	else {
    		System.out.println("Negative");
    	}
    }
}

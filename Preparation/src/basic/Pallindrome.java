package basic;

public class Pallindrome {
public static void main(String[] args) {
     String s="imadami";
     System.out.println(isPalindrome(s));
}
public static boolean isPalindrome (String s) {
	String rev="";
	for(int i=s.length()-1;i>=0;i--) {
		rev=rev+s.charAt(i);
	}
	if(s.equalsIgnoreCase(rev)) {
		return true;
	}
	return false;
}
}

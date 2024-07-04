package strings;

public class ValidSubString {
public static void main(String[] args) {
	String S = "))(";
	int length = findMaxLen(S);
	System.out.println(length);

}

  static int findMaxLen(String S) {
	  
        // code here
//        int count=0;
//        char []a = S.toCharArray();
//int j= a.length-1;
//   for(int i=0;i<a.length;i++) {
//	   if((a[i]==')'&& a[i+1]==')'&& i<a.length-1)) {
//			  i++;
//			  }
//	   else if(a[i]=='('&&a[j]==')') {
//		   count+=2;
//		   i++;
//		   j--;
//	   }
//	   else if(a[j]=='(') {
//		   j--;
//	   }
//	   if(i>=j) {
//		   return count;
//		   
//	   }
//   }
	  int n=S.length();
	  int left=0,right=0;
	  int maxLength=0;
	  for (int i = 0; i < n; i++) {
      		if(S.charAt(i)=='(')
      			left++;
      		else
      			right++;
      		 
      	if(left==right)
      			maxLength=Math.max(maxLength, 2* right);
      	else if(right>left)
    	  left=right=0;
	}
	  left = right = 0;
	  for (int i = n-1; i >=0; i--) {
    		if(S.charAt(i)=='(')
    			left++;
    		else
    			right++;
    		 
    	if(left==right)
    			maxLength=Math.max(maxLength, 2* left);
    	else if(right<left)
  	  left=right=0;
	}
	return maxLength;
    }

}


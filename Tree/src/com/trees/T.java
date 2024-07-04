package com.trees;

import java.util.Arrays;

public class T {
public static void main(String[] args) {
    int [] a = {3,1,2,5,4};
    int [] b = {1,2,3,4,5};
    int helper = helper(a,b,1 );
    System.out.println(helper);
}

private static int  helper(int[] a, int[] b, int count) {
	    if(Arrays.equals(a, b)) {
	    	return count;
	    }
	   int[] c =  new int[a.length];
	   for(int i=0;i<a.length;i++) {
		   c[a[i]-1] = b[i];
	   }
	    System.out.println(Arrays.toString(c));
	    return helper(a, c, count+1);
}
}

package com.Linear;
/**
 * @author _karthick
 * |-> how the time grows with respect to the input grows
 * Time Complexity : Best case:O(1) -> constant  Big O is the worst case that is it never goes worser than linear(The Upper Bound)
 *                 : Worst case:O(n) -> size of array
 * 
 *
 */
public class Linear {
	public static void main(String[] args) {
		System.out.println(getElementByLinear(new int[]{1, 4,5,34,2,66,456,9,232},9));
		
	}
	
	static int getElementByLinear(int[] arr,int target ) {
		
		if (arr.length==0) {
			return -1;
		}
		for(int i=0;i<arr.length;i++) {
		 	
		 if(arr[i]==target)
			 return i;
			
		}
		return -1;
		
	}
	
}

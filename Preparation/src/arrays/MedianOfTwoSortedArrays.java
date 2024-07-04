package arrays;

import java.util.ArrayList;
import java.util.Collections;


public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int []arr1= {1,1};
		int []arr2=		{1,2};
		double median = findMedianSortedArrays(arr1, arr2);
		System.out.println(median);
		
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median;

	    ArrayList<Integer> list = new ArrayList<>();
	    
		for(int i: nums1) {
			list.add(i);
		}
		for(int i: nums2) {
			list.add(i);
		}
	    Collections.sort(list);
	    
	   int n=list.size();
	    if(n%2==0) {
	    	median = (double)((double)(list.get(n/2)+list.get(n/2-1))/2);
	    }
	    else {
	    	median = list.get(n/2);
	    }
	   
		return median;
	        
	    }

}

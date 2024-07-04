package com.Recursion.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Time Complexity :: O( N * 2 ^N) 
                //:: For every number the subset is doubled
public class AllSubSet {
	public static void main(String[] args) {
        System.out.println(getAll(new int[] {1,2,3}));
        System.out.println(getAllDuplicates(new int[] {1,1,2,3}));
	}
	
	
	
	 static List<List<Integer>> getAll(int []arr){
		 List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        
		 subsets.add(new ArrayList<Integer>());
		 
		 for(int num : arr){
			int n = subsets.size();
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> internal = new ArrayList<>(subsets.get(i));
				internal.add(num);
				subsets.add(internal);
			}
			 
		 }
		 
		 return subsets;
	 }
	 
	 
	 // if we found  duplicate only add it to the newly created list of the previous step
	 //but for the above step the duplicates needs to be adjacent//So we need to sort the array
	 static List<List<Integer>> getAllDuplicates(int []arr){
		 List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        
		 subsets.add(new ArrayList<Integer>());
		 Arrays.sort(arr);
		 
		 int end = 0;
		  for(int i=0;i<arr.length;i++)
		  {
			  int start = 0;
			  int n = subsets.size();
			  if(i>0 && arr[i]==arr[i-1]) {
				  start=end+1;
			  }
			  end = subsets.size()-1;
			 
			  for(int j=start;j<n;j++) {
				  ArrayList<Integer> internal = new ArrayList<>(subsets.get(j));
				  internal.add(arr[i]);
				  subsets.add(internal); 
			  }
		  }
		 
		 return subsets;
	 }
	 
}

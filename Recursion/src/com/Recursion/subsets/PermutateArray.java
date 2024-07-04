package com.Recursion.subsets;


import java.util.ArrayList;
import java.util.List;

public class PermutateArray {
	public static void main(String[] args) {
       List<List<Integer>> list = permutate(new int[] {1,2,3});
       System.out.println(list);
       List<List<Integer>> list2 = permute(new int[] {3,2,1});
       System.out.println(list2);
		
	}
	 public static List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        
	        List<Integer> candidates = new ArrayList<>();
	         
	        for(int num : nums) {
	            candidates.add( num );
	        }
	        
	        permute(candidates, new ArrayList<>(), result);
	        
	        return result;
	    }
	    
	    private static void permute(List<Integer> candidates, List<Integer> permutation, List<List<Integer>> result) {
	        
	        // Since no number is left for permutation, a permutation is generated
	        if( candidates.isEmpty() ) {
	            result.add( new ArrayList<>( permutation ) );
	            return;
	        }
	        
	        int n = candidates.size();
	        
	        for(int i=0; i<n; i++) {
	            int num = candidates.get(i);
	            
	            // Fix the current number
	            permutation.add( num );
	            
	            // Remove the current number from candidates
	            candidates.remove( i );
	            
	            // And permute for remaining numbers
	            permute(candidates, permutation, result);
	            
	            // Add the number back to it's original index
	            candidates.add(i, num );
	            
	            // Remove the number from the permutation
	            permutation.remove( permutation.size() - 1 );
	        }
	    }
 
	  public static List<List<Integer>> permutate(int[] nums) {
	        List<List<Integer>> ans = new ArrayList<>();
	        function(nums,ans,0);
	        return ans;
	    }
	    public static void swap(int arr[],int a,int b){
	        int temp = arr[a];
	        arr[a]=arr[b];
	        arr[b]=temp;
	    }
	    public static void function(int []arr,List<List<Integer>> ans,int start){
	        if(start==arr.length){
	            List<Integer> list = new ArrayList<>();
	            for(int i: arr){
	                list.add(i);
	            }
	            ans.add(list);
	            return;
	        }
	        for(int i = start;i<arr.length;i++){
	            swap(arr,start,i);
	            function(arr,ans,start+1);
	            swap(arr,start,i);
	        }
	    }
}

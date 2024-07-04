package com.array.easy;

import java.util.HashSet;
import java.util.Set;

//https://neetcode.io/problems/duplicate-integer
//It has O(n) as both space and time
//We can get O(N logN) and O(1) if we use sort
//Or O(n ^ 2) if brute force
public class DuplicateItemsInArray {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,3};
          System.out.println(hasDuplicate(arr));
	}
	public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set =   new HashSet<>();
        for(int num : nums){
          if(!set.add(num)){
              return true;
          }
        }
        return false;
  }
}

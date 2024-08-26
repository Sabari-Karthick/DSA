package com.twopointer;
//https://leetcode.com/problems/valid-palindrome/description/

//This problem does not purposefully require Sliding Window but it is better optimized with it.
public class ValidPalindrome {

}

class Sol124{
	class Solution {
	    public boolean isPalindrome(String s) {
	        int start = 0;
	        int end = s.length() -1 ;
	        while(start <= end){
	            Character i = s.charAt(start);
	            Character j = s.charAt(end);
	            if(!Character.isLetterOrDigit(i)){
	                 start++;
	                 continue;
	            }
	            if(!Character.isLetterOrDigit(j)){
	                 end--;
	                 continue;
	            }
	            if(Character.toLowerCase(i) != Character.toLowerCase(j)){
	                return false;
	            }
	            start++;
	            end--;
	        }
	        return true;
	    }
	}
}
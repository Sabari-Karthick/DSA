package com.twopointer;
//https://leetcode.com/problems/valid-palindrome/description/

/**
 * 
 * Pattern Used: Two-pointer technique.
 * Why Two-Pointer? 
 * Efficient for comparing elements from both ends of the string and reducing time complexity to O(N).
 * 
 * 
 */
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
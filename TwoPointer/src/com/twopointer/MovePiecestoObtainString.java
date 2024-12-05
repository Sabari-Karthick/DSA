package com.twopointer;
/**
 * 
 * 
 * https://leetcode.com/problems/move-pieces-to-obtain-a-string
 */
public class MovePiecestoObtainString {

}

class Solution {
	  public boolean canChange(String start, String target) {
	    final int n = start.length();
	    int i = 0; // start's index
	    int j = 0; // target's index

	    while (i <= n && j <= n) {
	      while (i < n && start.charAt(i) == '_')
	        ++i;
	      while (j < n && target.charAt(j) == '_')
	        ++j;
	      if (i == n || j == n)
	        return i == n && j == n;
	      if (start.charAt(i) != target.charAt(j))
	        return false;
	      if (start.charAt(i) == 'R' && i > j) //If start has R in a position it should be in a lesser one than the target if no it needs to move back which is not possible
	        return false;
	      if (start.charAt(i) == 'L' && i < j) // If start has L in a postion it shoul be in a greater that the target so that it can move back otherwise it needs to move right which is not possible
	        return false;
	      ++i;
	      ++j;
	    }

	    return true;
	  }
	}
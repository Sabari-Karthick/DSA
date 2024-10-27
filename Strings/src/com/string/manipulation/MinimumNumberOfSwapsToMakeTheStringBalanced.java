package com.string.manipulation;
/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 * 
 * 
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced {

}
class Solutionasdriwr26jhyi786{
    public int minSwaps(String s) {

        //For a balance string at any time we do not want there is no more closing bracket than opening 
        // So we are tracking max number of the extra closing brackets at any time because it tells we need a swap or not 
        //at end we can tell what the min swap needed
          int close = 0,  maxClose = 0;
        for(char c : s.toCharArray()){
            if (c == '['){
                close--;
            }else{
                close = close + 1;
                maxClose = Math.max(close,maxClose);
            }
        }
        return (maxClose + 1)/2; //Each swap gets rid of two closing brackets
      
    }
}
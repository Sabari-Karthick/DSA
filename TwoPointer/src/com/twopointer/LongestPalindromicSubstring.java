package com.twopointer;

public class LongestPalindromicSubstring {
}

// O(N ^ 2)
class Solution234532342 {
    public String longestPalindrome(String s) {

        char[] arr = s.toCharArray();

        int maxL = 0, maxR = 0;
// Palindrome is simple a string mirror its part
        for(int i = 0; i< arr.length;i++){
            int[] lengthArr = new int[2];
// A odd palindrome have its mirror over the center character
            findPalindrome(s,i,i,lengthArr);

            if(lengthArr[1] - lengthArr[0] > maxR - maxL){ // if new length is bigger than old length
                maxR = lengthArr[1];
                maxL = lengthArr[0];
            }

            int[] lengthEvenArr = new int[2];

// A even palindrome have its mirror between the two center characters
            findPalindrome(s,i,i+1,lengthEvenArr);
            if(lengthArr[1] - lengthArr[0] > maxR - maxL){
                maxR = lengthArr[1];
                maxL = lengthArr[0];
            }
        }

        return s.substring(maxL,maxR+1);
    }
// We place the mirror and see how long the mirror show reflection and return that length
    private void findPalindrome(String s, int i, int i1, int[] lengthArr) {
        if(i < 0 || i1 >= s.length() || s.charAt(i) != s.charAt(i1)) {
            return;
        }

        lengthArr[0] = i;
        lengthArr[1] = i1;

        findPalindrome(s,i-1,i1+1,lengthArr);

    }


}
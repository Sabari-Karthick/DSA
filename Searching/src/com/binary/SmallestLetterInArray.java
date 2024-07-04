package com.binary;

public class SmallestLetterInArray {
public static void main(String[] args) {//
	
	char []letters= {'c','f','j'};
	System.out.println(nextGreatestLetter(letters, 'a'));

}
public static char nextGreatestLetter(char[] letters, char target) {
    
    int start = 0;
    int end = letters.length-1;
    while(start<=end){
        int mid = start + (end - start)/2;
        if(target>letters[mid]){
           start = mid +1;
        }
        else if(target<letters[mid]){
            end = mid -1;
        }
        else{
            start=mid+1;//since we need to return the larger than target we ignore the equals condition and increment the start as the next thing may be the largest or it can be the same thing 
        }
    }
    return letters[start%letters.length];
}
}
//Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
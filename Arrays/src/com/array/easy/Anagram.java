package com.array.easy;
//https://leetcode.com/problems/valid-anagram/submissions/1302166734/
public class Anagram {
public static void main(String[] args) {
	
}
public static boolean isAnagram(String s, String t) {
    if(s.length() != t.length()){
        return false;
    }
    int[] letterArray = new int[26];//all alphabets
    for(int i = 0 ; i< s.length();i++){
        letterArray[s.charAt(i) - 'a']++;//subtracting with a give that letter position and increased to 1
        letterArray[t.charAt(i) - 'a']--;//it reduces to zero
    }
    for(int count : letterArray){
        if(count != 0){
            return false;
        }
    }
    return true;
}
}

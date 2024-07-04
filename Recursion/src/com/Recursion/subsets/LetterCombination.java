package com.Recursion.subsets;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

public class LetterCombination {//for every number we leave some letters ans select some letters so it subset Pattern
	public static void main(String[] args) {
      combinations("", "12");
      List<String> list = letterCombinations("23");
      System.out.println(list);
      List<String> list2 = combinations1("", "12");
      System.out.println(list2);
	}
	public  static List<String> letterCombinations(String digits) {

        return helper("",digits,new ArrayList<String>());
    }
    static List<String> helper(String p,String up,ArrayList<String> ans){
        if(up.isEmpty()){
            ans.add(p);
            return ans;
        }
        int digit = up.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit *3;i++){
            char c = (char)('a'+i);
            helper(p+c,up.substring(1),ans);
        }
        return ans;
    }
	static void combinations(String p ,String up) {
		if(up.isEmpty()) {
			System.out.println(p+" ");
			return;
		}
		int digit = up.charAt(0)-'0';
		for(int i=(digit-1)*3;i<digit*3;i++) {
			char charToAdd = (char) ('a'+i);
			combinations(p+charToAdd, up.substring(1));
		}
		
	}
	static List<String> combinations1(String p ,String up) {
		if(up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		int digit = up.charAt(0)-'0';
		ArrayList<String> ans = new ArrayList<>();
		for(int i=(digit-1)*3;i<digit*3;i++) {
			char charToAdd = (char) ('a'+i);
			List<String> list = combinations1(p+charToAdd, up.substring(1));
			ans.addAll(list);
		}
		return ans;
	}
}

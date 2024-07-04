package com.Recursion.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutation {// N!-> Answers
	public static void main(String[] args) {
          permutate("", "abc");
          System.out.println(permutate1("", "abc"));
	}
	static void permutate(String p,String up) {
		if(up.isEmpty()) {
			System.out.print(p+" ");
			return;
		}
		char c = up.charAt(0);
		for (int i = 0; i <= p.length(); i++) {
			
			String f = p.substring(0,i);
			String s = p.substring(i, p.length());
			permutate(f+c+s, up.substring(1));
		}
	}
	static List<String> permutate1(String p,String up) {
		if(up.isEmpty()) {
			ArrayList<String > list = new ArrayList<>();
			list.add(p);
			return list;
		}
		char c = up.charAt(0);
		ArrayList<String> ansList = new ArrayList<>();
		for (int i = 0; i <= p.length(); i++) {
			
			String f = p.substring(0,i);
			String s = p.substring(i, p.length());
			List<String> ans = permutate1(f+c+s, up.substring(1));
			ansList.addAll(ans);
		}
		return ansList;
	}
}

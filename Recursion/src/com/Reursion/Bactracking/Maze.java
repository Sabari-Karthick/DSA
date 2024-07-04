package com.Reursion.Bactracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {
	public static void main(String[] args) {
		int ans = count(3, 3);
		System.out.println(ans);
		path("", 3, 3);
		List<String> list = path1("", 3, 3);
		System.out.println(list);
	}

	static int count(int r, int c) {// to find the number of routes

		if (r == 1 || c == 1) {
			return 1;
		}

		int left = count(r - 1, c);
		int right = count(r, c - 1);
		return left + right;
	}
	
	
	static void path(String p,int r,int c) {
		if(r==1 && c==1) {
			System.out.println(p+" ");
			return;
		}
		
		
		if(r>1) {
			path(p+"D", r-1, c);
		}
		if(c>1) {
			path(p+"R", r, c-1);
		}
	}
	static List<String> path1(String p,int r,int c) {
		if(r==1 && c==1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		
		ArrayList<String> ans = new ArrayList<>();
		if(r>1) {
			ans.addAll( path1(p+"D", r-1, c));
		}
		if(c>1) {
			ans.addAll( path1(p+"R", r, c-1));
		}
		return ans;
	}
}

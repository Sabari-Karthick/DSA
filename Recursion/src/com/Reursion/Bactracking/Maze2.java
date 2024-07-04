package com.Reursion.Bactracking;

import java.util.ArrayList;
import java.util.List;

public class Maze2 {// can move in any direction
	public static void main(String[] args) {
		List<String> list = path1("", 3, 3);
		System.out.println(list);

	}

	static List<String> path1(String p, int r, int c) {
		if (r == 1 && c == 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}

		ArrayList<String> ans = new ArrayList<>();
		if (r > 1) {
			ans.addAll(path1(p + "V", r - 1, c));
		}
		if (c > 1) {
			ans.addAll(path1(p + "H", r, c - 1));
		}
		if(c>1&&r>1) {
			ans.addAll(path1(p+"D", r-1, c-1));
		}
		return ans;
	}
}

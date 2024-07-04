package com.Reursion.Bactracking;

import java.util.ArrayList;
import java.util.List;

public class Maze3 {// can move in any direction
	public static void main(String[] args) {
		boolean[][] maze = {
				{true,true,true},
				{true,false,true},
				{true,true,true}
		};
		
      List<String> ans = path1("", maze, 0, 0);
      System.out.println(ans);
	}

	static List<String> path1(String p,boolean[][] maze, int r, int c) {
		if (r == maze.length-1 && c == maze[0].length-1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		
		if(!maze[r][c]) {
			return new ArrayList<String>();
		}

		
		ArrayList<String> ans = new ArrayList<>();
		if (r <  maze.length-1) {
			ans.addAll(path1(p + "D",maze, r + 1, c));
		}
		if (c <maze.length-1) {
			ans.addAll(path1(p + "R",maze, r, c + 1));
		}
		
		return ans;
	}
}

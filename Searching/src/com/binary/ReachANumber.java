package com.binary;
//You are standing at position 0 on an infinite number line. There is a destination at position target.
//
//You can make some number of moves numMoves so that:
//
//On each move, you can either go left or right.
//During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
//Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach the destination.\
//https://leetcode.com/problems/reach-a-number/
//it is a greedy approach

public class ReachANumber {
	public static void main(String[] args) {
		System.out.println(reachNumber(2));
	}

	public static int reachNumber(int target) {
		target = Math.abs(target);
		int start = 0;
		int step = 0;
		while (start < target) {
			start += ++step;
		}
		while ((start - target) % 2 == 1) {//if overshoot happen and it is odd we need to make it even so that it take fewer step by just take one move back 
			start += ++step;
		}
		return step;
	}
}

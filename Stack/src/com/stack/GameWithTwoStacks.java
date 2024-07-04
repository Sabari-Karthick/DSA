package com.stack;


//https://www.hackerrank.com/challenges/game-of-two-stacks/problem?h_r=internal-search&isFullScreen=true
//Alexa has two stacks of non-negative integers, stack  and stack  where index  denotes the top of the stack. Alexa challenges Nick to play the following game:
//
//In each move, Nick can remove one integer from the top of either stack  or stack .
//Nick keeps a running sum of the integers he removes from the two stacks.
//Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
//Nick's final score is the total number of integers he has removed from the two stacks.
//Given a,b , and  for  games, find the maximum possible score Nick can achieve.


//initial approach may be remove the less top of either of the stack but it is not good because may be a stack with larger top may follow with many lesser values



public class GameWithTwoStacks {

}
//same as subsequence pattern pop from first stack with one call and from second stack from another call

//import java.util.*;
//
//class TwoStacks {
//  static int twoStacks(int x, int[] a, int[] b) {
//    return twoStacks(x, a, b, 0, 0) - 1;
//  }
//
//  private static int twoStacks(int x, int[] a, int[] b, int sum, int count) {
//    if (sum > x) {
//      return count;
//    }
//
//    if (a.length == 0 || b.length == 0) {
//      return count;
//    }
//
//    int ans1 = twoStacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
//    int ans2 = twoStacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum + a[0], count + 1);
//
//    return Math.max(ans1, ans2);
//  }
//
//  public static void main(String[] args) {
//    Scanner s = new Scanner(System.in);
//    int t = s.nextInt();
//    for (int i = 0; i < t; i++) {
//      int n = s.nextInt();
//      int m = s.nextInt();
//      int x = s.nextInt();
//      int[] a = new int[n];
//      int[] b = new int[m];
//      for (int j = 0; j < n; j++) {
//        a[j] = s.nextInt();
//      }
//      for (int j = 0; j < m; j++) {
//        b[j] = s.nextInt();
//      }
//      System.out.println(twoStacks(x, a, b));
//    }
//  }
//
//}
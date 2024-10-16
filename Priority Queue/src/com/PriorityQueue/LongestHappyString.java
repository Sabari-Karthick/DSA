package com.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 
 * 
 * https://leetcode.com/problems/longest-happy-string/description
 * 
 * Time is O(n⋅log3)=O(n) where n is the length of string at max it is a+b+c
 * Space is also O(n)
 */
public class LongestHappyString {

}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Queue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]); // Max Heap
        if (a > 0)
            queue.offer(new int[] { 'a', a });
        if (b > 0)
            queue.offer(new int[] { 'b', b });
        if (c > 0)
            queue.offer(new int[] { 'c', c });

        StringBuilder res = new StringBuilder();
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int len = res.length();
            if (len >= 2 && res.codePointAt(len - 1) == cur[0] && res.codePointAt(len - 2) == cur[0]) { // If the
                                                                                                        // previous two
                                                                                                        // characters
                                                                                                        // are same //
                                                                                                        // codePointAt()
                                                                                                        // return the
                                                                                                        // unicode
                if (queue.size() == 0) // there is no second max in the heap
                    break;
                int[] cur2 = queue.poll();
                res.append((char) cur2[0]);
                if (cur2[1] > 1) {
                    cur2[1]--;
                    queue.offer(cur2);
                }
                queue.offer(cur);// Since the max is polled offer it back
            } else {
                res.append((char) cur[0]);
                if (cur[1] > 1) {
                    cur[1]--;
                    queue.offer(cur);
                }

            }
        }
        return res.toString();
    }
}
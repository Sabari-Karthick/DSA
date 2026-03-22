package com.slidingwindow;

import java.util.*;

public class LongestContinuousSubarrayWithAbsoluteDiff {
    public static void main(String[] args) {
        System.out.println(new Solution025nhg().longestSubarray(new int[]{8,2,4,7},4));
    }
}

class Solution025nhg {
    public int longestSubarray(int[] nums, int limit) {

        int max = Integer.MIN_VALUE;

        TreeMap<Integer,Integer> map = new TreeMap<>(); // The Key is the num and value is the frequency as there maybe duplicates

        int left = 0; // Tail

        for(int right = 0; right < nums.length; right++){ // Head moves forward

            map.put(nums[right],map.getOrDefault(nums[right],0)+1);

            // Is the window currently break the limit ?
            while (map.lastKey() - map.firstKey() > limit){
                // Not a valid widow move it

                // Reduce its Frequency
                map.put(nums[left],map.get(nums[left])-1);

                if (map.get(nums[left])==0){
                    map.remove(nums[left]); // If frequency hit zero remove
                }

                left++; // Move it

            }

            // Valid window

            max = Math.max(max,right-left+1); // Always the size of window is r - l +1

        }


        return max;
    }
}

class Solutionb46w8k {
    public int longestSubarray(int[] nums, int limit) {
        // Two lines: One keeps the biggest at the front, one keeps the smallest at the front
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0; // The Tail
        int maxLen = 0;

        // The Head moves forward
        for (int right = 0; right < nums.length; right++) {
            int newGuy = nums[right];

            // 1. THE BOUNCERS (Adding to the window)
            // Max Line: Kick out anyone at the back who is smaller than the new guy
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < newGuy) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(newGuy);

            // Min Line: Kick out anyone at the back who is bigger than the new guy
            while (!minDeque.isEmpty() && minDeque.peekLast() > newGuy) {
                minDeque.pollLast();
            }
            minDeque.addLast(newGuy);

            // 2. SHRINK THE WINDOW (If the math is broken)
            // The absolute Max and Min are always sitting right at the front of their lines
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {

                int leavingGuy = nums[left];

                // If the guy leaving the window happens to be the King at the front, pop him!
                if (maxDeque.peekFirst() == leavingGuy) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == leavingGuy) {
                    minDeque.pollFirst();
                }

                left++; // The tail steps forward
            }

            // 3. RECORD THE SIZE
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
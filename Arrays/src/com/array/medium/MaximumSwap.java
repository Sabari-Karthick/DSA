package com.array.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * 
 * 
 * O(N ^ 2) Solution :: you can pass the entire number in the outer loop and for each number pass internally and compare to find any bigger number if found swap and stop
 * 
 * O(N) Two Pass :: Pass from the right and store the max found till in the array. In the next pass if the max found till is greater than that number swap and stop
 * 
 * 
 * The parsing from right to left is to ensure the swap is in the most significant digit
 * https://leetcode.com/problems/maximum-swap/description
 * 
 * 
 */
public class MaximumSwap {

}
class Solution458324huguh {
    public int maximumSwap(int num) {
        String[] split = String.valueOf(num).split("");
        Integer[] nums = Arrays.stream(split).map(Integer::parseInt).toArray(Integer[]::new);
        int max = 0;
        int max_i = -1, swap_i = -1, swap_j = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // We want to maintain the max and the swap index
            if (nums[i] > max) {
                max = nums[i];
                max_i = i;
            }
            if (nums[i] < max) {
                swap_i = i;
                swap_j = max_i;
            }
        }
        if (swap_i != -1 && swap_j != -1) {
            swap(nums, swap_i, swap_j);
        }
        return Integer.parseInt(Arrays.stream(nums)
                .map(String::valueOf)
                .collect(Collectors.joining()));

    }

    private void swap(Integer[] arr, int from, int to) {
        int a = arr[from];
        arr[from] = arr[to];
        arr[to] = a;
    }
}

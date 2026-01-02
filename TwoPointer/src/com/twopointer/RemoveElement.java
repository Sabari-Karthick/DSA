package com.twopointer;

import java.util.Arrays;

/**
 *
 * The Core Problem needs Manipulation in Place . A direct hint to use Two Pointer Approach.
 *
 * Ok now to decide where to place the two pointers.
 * Intuition : We need to remove all occurrences of val from the array.
 * Means if not equals means we need to collect all those in the front part of the array.
 *
 * So lets just start with one pointer at start and moves forward to find all elements not equal to val.
 * When we see an element that is not equal we need to know where to place it.
 *
 * So it itself says to have another pointer that tracks the position of next non-val element.
 * Means both pointers move forward, one (right) to explore all elements and another (left) to track the position of next non-val element.
 * The left pointer is kinda waiting for non-val elements to overwrite the elements at its position and move forward.
 * When we find a non-val element at right pointer, we place it at left pointer position and move left forward.
 *
 * Just for say if the problem wants all the non-val at the end means we can start both pointers at the end of the array and move left pointer backward to track the position of next non-val element.
 * Same but both pointers move backward.
 *
 * So the algo is :
 *    - Start both pointers at the start of the array.
 *    - Move right pointer forward to explore all elements.
 *    - if element at right is not equal to val, we place it at left pointer position and move left forward.
 *    - Finally left pointer will give the count of elements not equal to val.
 *
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = removeElement(nums, val);
        System.out.println("Number of elements not matching " + val + ": " + newLength);
        System.out.print("Modified array: " + Arrays.toString(nums));
    }

    // This two pointer approach uses one pointer (right) to traverse the array and another pointer (left) to track the position of the next non-val element.
    // So both pointers move forward, but left only moves when a non-val element is found.
    // Here we are not swapping elements, instead we are overwriting the elements at the left pointer with non-val elements found by the right pointer as we don't need to care about the elements that are equal to val.



    // Basically right will explore all the elements while left will be waiting for non-val elements to overwrite the elements at its position and move forward.
    private static int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}

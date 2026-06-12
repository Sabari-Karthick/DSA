package com.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Collections;

public class MinimumCostToSortArray {

    public static long minimumCost(int[] nums) {
        // Pass 1: The standard Uphill calculation
        long forwardCost = getUphillCost(nums);
        
        // Pass 2: The Reverse trick to calculate Downhill cost
        int n = nums.length;
        int[] reversedNums = new int[n];
        for (int i = 0; i < n; i++) {
            reversedNums[i] = nums[n - 1 - i];
        }
        long reverseCost = getUphillCost(reversedNums);
        
        // Pick the cheapest path
        return Math.min(forwardCost, reverseCost);
    }

//    Uphill Engine (Max-Heap):
//
//    Rule: If current < peak
//
//    Action: cost += peak - current
//
//    Downhill Engine (Min-Heap):
//
//    Rule: If current > valley
//
//    Action: cost += current - valley

    // The Below method is a optimized one with just uphill.
    // To arrive it we really have the idea of downhill.
    // But we can replace the downhill with the reverse of the array and then apply the same uphill logic to it.
    // How reverse eliminates the need for a separate downhill engine?
    // When we reverse the array, the "valleys" in the original array become "peaks" in the reversed array.
    // Eg : Original: 5, 2, 1, 4, 3 -> Reversed: 3, 4, 1, 2, 5
    // Meaning the valleys (1 and 2) in the original array are now peaks in the reversed array.
    // Uphill only knows to bulldoze peaks while downhill only knows to fill valleys.
    // For Uphill to do the downhill it needs to see the valleys as peaks, means here it need to see a number that is bigger than the current number, which is only possible if we reverse the array and then apply the same logic.
    // For downhill of 5 2 1 4 3 -> is 5 2 1 1 1 for the uphill engine to do the same thing we need to see 3 4 1 2 5 as 3 3 1 1 1 which is only possible if we reverse the array and then apply the same logic for the cost to be same.
    // Because uphill logic cant fill the valleys but it can bulldoze the peaks, so if we reverse the array then the valleys become peaks and then we can apply the same logic to get the cost for downhill.

    // The single, blind "Uphill Engine" we built
    private static long getUphillCost(int[] nums) {
        // Our "Undo Button" bag: Remembers the highest peaks
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long totalCost = 0;
        
        for (int currentNumber : nums) {
            // Always toss the current number in the bag
            maxHeap.offer(currentNumber);
            
            // If the highest past peak is bigger than our current number... we hit a cliff!
            if (maxHeap.peek() > currentNumber) {
                // Bulldoze the past peak down to the current number's level
                totalCost += maxHeap.poll() - currentNumber;
                
                // Toss the newly bulldozed peak (which is now equal to currentNumber) back in
                maxHeap.offer(currentNumber);
            }
        }
        
        return totalCost;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 4, 3};
        long cost = minimumCost(nums);
        System.out.println("Minimum cost to sort the array: " + cost); // Expected output: 4 (5->4->3 and 2->1)
    }
}
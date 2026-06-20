package com.PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        // There is a obvious solution is fill the frequency Map and put them into Buckets representing the frequency and then iterate from the end of the bucket to get the top K frequent elements

        // Ok lets say the array is not finite so can we still use the bucket sort ?
        // No without N (the length of the array) we cant use the bucket sort as we dont know the max frequency .

        // So whats the brute force solution ?
        // Hmm maybe frequency map and then sort the map by value and get the top K elements.
        // But sorting is O(nlogn) and we can do better than that.

        // What Bucket solves us ? It solves us the problem of sorting by value and getting the top K elements in O(n) time complexity.
        // How ? Because we know the last buckets or the one with higher frequency

        // Else we need a way to sort ,

        // To avoid the sort what we needed ? We need a DS that do the sorting for us .
        // We can use a PQ , But max or min ?
        // Okay lets say we use Max Heap, What we do ? We put all the entries of the fmap into the max heap and then pop K times to get the top K frequent elements.
        // But the time complexity of this is O(nlogn) ? How nlogn ? Because we are putting n elements into the max heap for one insert it is logn and we are doing it n times so nlogn.

        // Plus see practically we have a array of 10 million elements and we need to get the top 10 frequent elements, So we are doing a lot of unnecessary work by putting all the elements into the max heap and then popping 10 times. So we can do better than that.

        // Ok Take Min Heap , what we do ? We can keep the size of the heap to K and then we can put all the elements into the min heap and if the size of the heap is greater than K then we pop the min element.
        // So at the end we will have the top K frequent elements in the min heap. The time complexity of this is O(nlogk) because we are doing n insertions and each insertion takes logk time.

        Map<Integer, Integer> fmap = new HashMap<>();

        for(int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue()); // Min Heap based on frequency

        // Now dont be more complex on keeping the bag size to K,

        for(Map.Entry<Integer, Integer> entry : fmap.entrySet()) {
            // Put the element everytime
            minHeap.offer(entry);
            if(minHeap.size() > k)  { // If the bag gets bigger ask the bouncer (minHeap) to kick out the least frequent element
                minHeap.poll();
            }
        }

        int[] result = new int[k]; // Fill the result array and return

        for(int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k))); // Output: [1, 2]
    }

}

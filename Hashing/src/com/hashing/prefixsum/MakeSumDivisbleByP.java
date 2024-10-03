package com.hashing.prefixsum;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * https://leetcode.com/problems/make-sum-divisible-by-p/description/
 * O(N)
 */
public class MakeSumDivisbleByP {

}
class Solution9fasfdajir {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for (int num : nums) {
            total = (total + num) % p;
        }
        int rem = total % p;  // the subarray we need to remove should have this remainder
        if (rem == 0) {
            return 0;  // Already divisible by p, no subarray needs to be removed
        }

        int result = nums.length;  // Initialize result as the max length of the array
        int cur_sum = 0;
        // Holds the removable prefix sum and the index till which the subarray is
        Map<Integer, Integer> remIdxMap = new HashMap<>();
        remIdxMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            cur_sum = (cur_sum + nums[i]) % p;
            // cur_sum - x = remainder --> x is the thing we need to remove 
            int prefix = (cur_sum - rem + p) % p;
            if (remIdxMap.containsKey(prefix)) {
                int len = i - remIdxMap.get(prefix);  // length of the subarray to be removed
                result = Math.min(result, len);
            }
            remIdxMap.put(cur_sum, i);
        }

        return result == nums.length ? -1 : result;  // If no valid subarray, return -1
    }
}

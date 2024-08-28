package com.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/3sum/
//Time O(N ^2)  --> O(n 2 ) dominates 𝑂 ( 𝑛 log ⁡ 𝑛 ) O(nlogn) for large n, the overall time complexity of your threeSum function is O(n²).
public class ThreeSum {

}

class Solution445efsd{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int lptr, rptr, sum;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // check if the number is a duplicate
            if (i > 0 && nums[i - 1] == nums[i]) {
                // skip
                continue;
            }
            // perform sorted two sum
            lptr = i + 1;
            rptr = nums.length - 1;
            while (lptr < rptr) {
                List<Integer> triplet = new ArrayList<>();
                sum = nums[i] + nums[lptr] + nums[rptr];
                if (sum > 0) {
                    // reduce the sum // since the array is sorted reduce the right
                    rptr--;
                } else if (sum < 0) {
                    // increase the sum
                    lptr++;
                } else {
                    triplet.add(nums[i]);
                    triplet.add(nums[lptr]);
                    triplet.add(nums[rptr]);
                    ans.add(triplet);
                    while (lptr < rptr && nums[lptr] == nums[lptr + 1]) {
                        lptr++;
                    }
                    while (lptr < rptr && nums[rptr] == nums[rptr - 1]) {
                        rptr--;
                    }
                    lptr++;
                    rptr--;
                }
            }
        }
        return ans;
    }

}
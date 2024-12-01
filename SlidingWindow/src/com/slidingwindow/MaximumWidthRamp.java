package com.slidingwindow;


/**
* https://leetcode.com/problems/maximum-width-ramp/
*
*/

public class MaximumWidthRamp {

}
class Solutionjewhruihu432u4h {
    public int maxWidthRamp(int[] nums) {
        int[] max_r = new int[nums.length];
        int prev_max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            max_r[i] = Math.max(nums[i], prev_max);
            prev_max = max_r[i];
        }
        int res = 0;
        int l = 0, r = 1;
        while (r < nums.length) {
            if (nums[l] > max_r[r]) {
                l = l + 1;
            }
            res = Math.max(res, r - l);
            r = r + 1;
        }

        return res;
    }
}

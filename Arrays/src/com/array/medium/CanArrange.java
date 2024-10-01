package com.array.medium;
/**
 * https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k
 * Intuition
The Base Problem is find the sum pair that should be divisible by k.
The Sum of pair can be expressed as:
a+b=(q1⋅k+r1)+(q2⋅k+r2)=(q1+q2)⋅k+(r1+r2)
From the expression is clear that the sum of pair to be divisible by k remainder sum also should be divisible by the k.
This is the condition for our problem that is
(a % k + b % k) % k == 0).

Approach
So to check the condition we can have a keep track of the remainder of all elements.Now we need to check is there a pair exists. Which can be seen in the base condition itself.
(r1+r2​)%k=0 --> for this to happen r1 should have a pair (k - r2)
So in the remainder array check for the index r1 and k-r2 this will give our answer

Complexity
Time complexity: O(n)
Space complexity: O(k)

 * 
 */
public class CanArrange {

}
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for(int num : arr){
            int rem = ((num % k)+k) % k;
            count[rem]++;
        }
        for(int i = 1;i<k;i++){
            if(count[i] != count [k-i])
                 return false;
        }
        return count[0]%2==0;
    }
}
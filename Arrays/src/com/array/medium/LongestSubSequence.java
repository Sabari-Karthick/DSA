package com.array.medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * 
 * 
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 * O(N) --> Both Time and Space
 * 
 */
public class LongestSubSequence {

}

class SSolution {
    public int longestConsecutive(int[] nums) {
       if(nums.length==0) return 0;
       Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
       int sequenceLength  = 1;
       for(Integer num : numSet){
           if(!numSet.contains(num -1)){//executes only if it is the start of the sequence 
              int count = 1;
              while(numSet.contains(num + 1 )){//iterates only if it has the sequence numbers in the set
                num ++;
                count++;
              }
              sequenceLength = Math.max(sequenceLength,count);
           }
           if(sequenceLength > nums.length/2){
            break;
           }
       }
       return sequenceLength;
    }
}
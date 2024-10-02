package com.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * https://leetcode.com/problems/rank-transform-of-an-array
 * 
 * 
 */
public class RankTranform {

}
class Solution0958htegr{
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        Map<Integer,Integer> map = new HashMap<>();
        int rank=1;
        for(int n : arr){
            if(map.get(n)!=null)
                continue;
            map.put(n,rank++);
        }
        for(int i=0;i<copy.length;i++){
            copy[i] = map.get(copy[i]);
        }
        return copy;
    }
}
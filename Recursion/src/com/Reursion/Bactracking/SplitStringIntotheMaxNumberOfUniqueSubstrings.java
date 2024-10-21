package com.Reursion.Bactracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description
 * 
 * At looking at the problem we get one thing we need a HashSet to identify Duplicates.
 * 
 * But at initial if you go you are directed to use greedy approach to choose the maximum split by splitting each character.
 * 
 * Even though it may seems works it wont satisfy all cases which gets to you revert some of your decision which will get you to backtracking.
 * 
 * For backtracking since we can include the character ins substring or not so binary decision so O (2 ^ N);
 * 
 * For outer loop it runs O(N) and for each recursive call behave like a nested loop to generate substring for subproblems which go up to O(N)
 *  
 *  So O( N * N * 2 ^N) :: Time Complexity
 * 
 */
public class SplitStringIntotheMaxNumberOfUniqueSubstrings {

}

class Solutionfadsf2134125 {
    public int maxUniqueSplit(String s) {
        Set<String> result = new HashSet<>();
        return dfs(0,result,s);
    }

    public int dfs(int index , Set<String> set,String s){
        if(index == s.length()) 
             return 0;
        int res = 0; // max split we can do
        for(int i = index ; i< s.length();i++){
            String subString = s.substring(index,i+1);
            if(set.contains(subString))
                 continue;

            set.add(subString);
            int size = dfs(i+1,set,s);
            res = Math.max(res,size+1);// The +1 is to include the first substring because we jump into the subproblem by choosing a first substring only
            set.remove(subString);
        }

        return res;
    }
}

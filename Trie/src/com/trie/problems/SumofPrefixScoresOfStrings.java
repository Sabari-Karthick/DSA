package com.trie.problems;

import java.util.HashMap;
import java.util.Map;
/**\
 * 
 * https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description
 * It is a working solution but not optimized 
 * It needs to be optimized with trie
 */
public class SumofPrefixScoresOfStrings {

}
class Solution15rgwer {
    public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        Map<String,Integer> count = new HashMap<>();
        for(String word : words){
            int i=0;
            int j=1;
            while(j <= word.length()){
                String prefix = word.substring(i,j);
                j++;
                count.merge(prefix,1,Integer::sum);//Now we have all the prefix count 
            }
        }
        int index=0;
        //Now we need to calculate the score
        for(String word: words){
            int i=0;
            int j=1;
            int score = 0;
            while(j <= word.length()){
                String prefix = word.substring(i,j);
                j++;
                score += count.get(prefix);
            }
            res[index++] = score;
        }
        return res;
    }
}
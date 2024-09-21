package com.Recursion;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 * https://leetcode.com/problems/lexicographical-numbers/description
 */
public class LexicalOrder {

}
class Solution123321fwdf {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<10;i++){
            DFS(n,i);// Start DFS for each number from 1 to 9
        }
        return ans;
    }

    public void DFS(int n,int cur){
        if(cur >n){ // we no need to expand over the n because n is the range 
            return;
        }
        ans.add(cur);
        cur *=10; // Move to the next digit place by multiplying by 10 (e.g., 1 -> 10) say if we already added 1 we need to find the next from 10 to 19
        for(int i=0;i<10;i++){  // Explore all possible numbers by adding digits 0 to 9 to cur. like take 1 the next is 10 add 0 to 9 to 10 to get 10,11,12... to find their respective children.
            DFS(n, cur+ i);// Recursively build next numbers (e.g., 10, 11, 12...)
        }
    }
}
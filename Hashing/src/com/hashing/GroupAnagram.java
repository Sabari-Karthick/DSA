package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/group-anagrams/
/*
 * 
 * 
 * O(N∗KlogK)+O(N)+O(N)=O(N∗KlogK) it is complexity 
 * https://leetcode.com/problems/group-anagrams/submissions/1308469612/
 */
public class GroupAnagram {
	public static void main(String[] args) {
		
	}
}

class Solution237498234 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

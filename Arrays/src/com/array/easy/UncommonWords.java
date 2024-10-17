package com.array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWords {
	public static void main(String[] args) {
//		String s1 = "this apple is sweet", s2 = "this apple is sour";
//		Set<String> s1Words = Arrays.stream(s1.split(" ")).collect(Collectors.toSet());
//		Map<String, Integer> hashMap = new HashMap<>();
//		int n = 7434;
//       String[] split = String.valueOf(n).split("");
//       List<Integer> list = Arrays.stream(split).map(Integer::parseInt).toList();
	}
}

class Solution24gsjfsjdf {
    public String[] uncommonFromSentences(String s1, String s2) {// the word with size only 1 is our ans
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : s1.split(" ")) {
            cnt.merge(s, 1, Integer::sum);
        }
        for (String s : s2.split(" ")) {
            cnt.merge(s, 1, Integer::sum);
        }
        List<String> ans = new ArrayList<>();
        for (var e : cnt.entrySet()) {
            if (e.getValue() == 1) {
                ans.add(e.getKey());
            }
        }
        return ans.toArray(new String[0]);//To ensure the type and size of the return array
        //return ans.toArray(new String[ans.size()]); alternative
        /**
         * 
         * \
         *if the array a passed as an argument is large enough to hold all elements, the collection's elements are copied into this array.
If the array a is not large enough (including if its size is 0), the method creates a new array of the same type as a and with the size of the collection, then fills it with the collection's elements.
         * 
         * 
         */
    }
}
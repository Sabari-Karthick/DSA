package com.hashing;

import java.util.Map;


// This Problem is straightforward HashMap problem.
// We need to create a mapping of Roman numerals to their integer values.
// Then we traverse the string, and for each character, we check if the next character is larger than the current one.
// If it is, we subtract the current value from the total, else we add it to the total.
// Finally, we return the total.

// https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {

    // Use Switch case to avoid the Map creation and Unboxing overhead. It reduces the space complexity to O(1).
    // Plus it is faster.

    private static final Map<Character, Integer> romanMap = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s)); // Output: 1994
    }

    private static int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer value = romanMap.get(s.charAt(i));

            // We cant just add the value, we need to check if the next character is larger than the current one.
            // Why means lets In Roman numerals, if a smaller numeral appears before a larger numeral, it is subtracted from the larger numeral.

            if (((i + 1) < s.length()) && (romanMap.get(s.charAt(i + 1)) > value)) {
                total -= value; // If the next character is larger, we subtract the current value.
            } else {
                total += value; // If it is continuing to be smaller one after another, we just add them up.
            }
        }
        return total;
    }


}

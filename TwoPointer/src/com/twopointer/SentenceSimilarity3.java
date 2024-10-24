package com.twopointer;
/**
 * 
 * https://leetcode.com/problems/sentence-similarity-iii/
 * 
 * 
 * For splitting O(n+m) and for checking O(Minimum(n,m)) 
 * Space and time :: O(n + m)
 * 
 */
public class SentenceSimilarity3 {

}

class Solutionsgfsdfg7 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        if (s1.length > s2.length) {  // Ensure the sentence 1 is always small
            return areSentencesSimilar(sentence2, sentence1);
        }


        // The main logic is that sentence 1 must be a suffix or prefix or combination of both suffix and prefix of s2

        int l1 = 0;
        while (l1 < s1.length && s1[l1].equals(s2[l1])) { // Prefix
            l1 = l1 + 1;
        }

        int r1 = s1.length - 1 , r2 = s2.length - 1;
        while(r1 >=  l1 &&  r2 >= 0 && s1[r1].equals(s2[r2])){// Suffix
            r1 = r1 - 1;
            r2 = r2 - 1;
        }

          return l1 > r1; // If it crosses there is a prefix or there is a suffix otherwise some word is in between so we cannot match the sentence 
    }
}
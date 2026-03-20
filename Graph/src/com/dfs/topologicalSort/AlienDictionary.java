package com.dfs.topologicalSort;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        System.out.println(Solution1dfh3rw54.foreignDictionary(new String[]{"hrn","hrf","er","enn","rfnn"})); // hernf
    }
}
class Solution1dfh3rw54 {
    public static String foreignDictionary(String[] words) {

        String result = "";

        Map<Character, Set<Character>> rules = new HashMap<>();

        Map<Character,Integer> degreeMap = new HashMap<>();

       Set<Character> chars = new HashSet<>();

        for(String word : words){
            for(int c = 0 ; c < word.length();c++){
                rules.putIfAbsent(word.charAt(c),new HashSet<>());
                degreeMap.putIfAbsent(word.charAt(c),0);
                chars.add(word.charAt(c));
            }
        }


        for (int i = 0 ; i < words.length - 1 ; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)){ // bat , at is valid  abc, ab is invalid
                return result;
            }

            char[] rule = getRule(word1,word2);

            if(rule.length == 0) continue;

            Set<Character> characters = rules.get(rule[0]);
            characters.add(rule[1]); // Rule[0] comes before rule[1] So rule[0]'s dependents increase


            // So rule[1] have a dependency
            degreeMap.put(rule[1],degreeMap.get(rule[1])+1); // increase the dependent


        }

        Queue<Character> queue = new ArrayDeque<>();


        // We should scan the map only once the next update should happen at the same time the map gets updated
        for(Map.Entry<Character, Integer> entry : degreeMap.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()){
            Character character = queue.poll();

            updateDegreeMap(character,rules,degreeMap,queue);

            result += character;

        }

        if(chars.size() != result.length()) return  "";
        return result;


    }

    private static void updateDegreeMap(Character character, Map<Character, Set<Character>> rules, Map<Character, Integer> degreeMap,Queue<Character> queue) {
        Set<Character> characters = rules.get(character);

        for (Character c : characters){
            degreeMap.put(c,degreeMap.get(c)-1);

            if(degreeMap.get(c) == 0){
                queue.add(c);
            }

        }

    }


    private static char[] getRule(String word1, String word2) {
        int l = 0;
        while (l < word1.length()) {
            if(word1.charAt(l) == word2.charAt(l)){
                l++;
            }else{
                return new char[]{word1.charAt(l), word2.charAt(l)};
            }
        }

        return new char[]{};
    }


}


package com.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/
 * 
 * 
 */
public class DividePlayersIntoTeamsOfEqaulSkills {

}
class Solutionaerhieuwr1242 {
    public long dividePlayers(int[] skill) {
        long sum = Arrays.stream(skill).sum();
        if ((2 * sum) % skill.length != 0) 
            return -1; // We cannot form groups
        Map<Long,Long> count = new HashMap<>();
        for (long i : skill) {
            count.merge(i, 1l, Long::sum);
        }
        long result = 0;
        long target = (2 * sum) / skill.length; // the sum each pair to form/contain
        for (long i : skill) {
            if (count.get(i) == 0)// As processing the count of the number may becomes zero
                continue;// We may already paired it up so no need to consider further
            long diff = target - i;
            if (count.get(diff) == null || count.get(diff) == 0) // if the pair not exist
                return -1;

            result += i * diff;
            count.put(i, count.get(i) - 1);
            count.put(diff, count.get(diff) - 1);
        }

        return result;
    }
}
package com.batman.dp1;

import java.util.ArrayList;
import java.util.Arrays;

public class RussianDollEnvelopes {
    // The n^2 way of doing this is for every envelope we can check all envelopes to see where it can fit so that it can gain the max envelope chain it already holds.
    // Naive recursive version of that (ask every bigger envelope for its chain length, with no caching) is actually O(2^n) -
    // each envelope re-derives every envelope above it from scratch, so the same sub-chain gets recomputed over and over.
    // Caching each envelope's chain length once drops that to O(n^2): n envelopes, each still doing an O(n) scan to find who it can sit next to.
    // AHA #1: the real problem, once you fix the nesting condition (both w AND h must be strictly greater), reduces to
    // "sort by width, then find the Longest Increasing Subsequence of heights" - IF ties are handled correctly (see below).

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) ->
                a[0] != b[0]
                        ? Integer.compare(a[0], b[0])
                        : Integer.compare(b[1], a[1]) // If w same sort h by descending so that the smaller height override it during pile.
        );
        // Integer.compare to avoid overflow.
        // AHA #2: same-width envelopes can NEVER nest inside each other (width must be strictly greater, not equal).
        // If we broke ties by height ascending (or left them unsorted), the LIS-on-heights step below would wrongly
        // treat two same-width envelopes with increasing heights as a valid 2-chain.
        // Sorting ties by height DESCENDING forces the larger height to be processed first (so it starts/sits on a pile),
        // then the smaller height immediately overwrites that same pile on the very next step - collapsing same-width
        // groups down to occupying only one "slot" in the chain, never two.

        // Why this stands true? if say two envelope 3,4 and 3,5 where 3,5 joining a 4,6 guarantee a long chain , 3,4 will also get that and it also may have more chance
        // This turns the problem into Longest Increasing Subsequence on Heights

        ArrayList<Integer> piles = new ArrayList<>();
        for(int[] envelope : envelopes){
            makePile(piles, envelope[1]);
        }
        // AHA #3: piles.size() is NOT "how many separate/independent chains we found." Each pile represents a length
        // bucket - piles.get(i) is the smallest height currently known to end a valid nesting chain of length i+1.
        // The total number of piles IS the length of the best chain found so far (patience-sorting / tails trick).

        return piles.size();

    }

    private void makePile(ArrayList<Integer> piles, int h) {
        int l = 0;
        int r = piles.size();

        // Binary search for the leftmost pile whose current top is >= h.
        // AHA #4: it must be the LEFTMOST (smallest) qualifying top, not just any qualifying one - overwriting a
        // larger-top pile instead would silently break the ascending-sorted invariant the piles rely on, and inflate
        // the final count (claims a longer chain exists than actually does).
        while (l < r) {
            int m = l + (r - l) / 2;

            if (piles.get(m) < h) { // Need a new pile
                l = m + 1;
            } else {
                r = m;
            }

        }

        if (r == piles.size()) {
            // No pile has a top >= h, meaning h is bigger than every chain-ending height seen so far -
            // it genuinely extends the best chain by one, so it gets its own new pile.
            piles.add(h);
        } else {
            // Found a pile we can shrink: h becomes the new (smaller) tail for that chain length.
            // This is always safe/never a loss - anything that could extend the old (bigger) tail could extend this
            // smaller one too, so keeping the smaller tail only ever gives equal or better future options.
            piles.set(r, h);
        }

    }

    public static void main(String[] args) {
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}})); // Output: 3
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(new int[][]{{1,1},{1,1},{1,1}})); // Output: 1
    }
}

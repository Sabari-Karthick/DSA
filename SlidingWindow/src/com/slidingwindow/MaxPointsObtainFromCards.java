package com.slidingwindow;

public class MaxPointsObtainFromCards {
}

class Solutionk34yvre {
    // At every step we can pick either one from the start or at the end
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;

        for(int i = 0 ; i < k ; i ++){ // We first get a points of the k lefts
            max+= cardPoints[i];
        }

        int last = max;

        for(int i = cardPoints.length - 1 ; i > 0 && k > 0 ; i--){
            k--;
            last +=  cardPoints[i] - cardPoints[k]; // Then we just remove one left and add one right
            max= Math.max(last,max);
        }

        return max;
    }
}
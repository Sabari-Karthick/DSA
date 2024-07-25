package com.binary;

public class ArrangeCoins {

}
class Solution368hf {
    public int arrangeCoins(int n) {
      long start = 0;
      long end = n;
      while(start <= end){
        long mid = start + (end - start)/2;
        long curr = mid * (mid +1) /2;//the same natural number sum is followed here
        if(curr == n){
            return (int)mid;
        }else if(curr > n){
            end = mid -1;
        }else{
            start = mid +1;
        }
      }
      return (int)end;//If n were not an exact sum, right would be the last valid count of rows that can be completely formed with n coins.
    }
}
class Solutionv4517 { // O(sqrt(N)) it runs like 1+2+3+ ...... + k = n // use sum of natural numbers to solve
    public int arrangeCoins(int n) {
     int count = 1;
     while(n!=0){
        if(n < count){
            break;
        }
        n = n -count;
        count++;
     }  
     return count-1;
    }
}
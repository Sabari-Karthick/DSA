package com.batman;
/**
 * 
 * Dynamic Programming : 
 * 
 * For 1 Dp problems :: 
 *   Steps : 
 *         --> Understand Whether the problem needs DP. 
 *                    --> Patterns : 
 *                             1.Count Total number of ways (Distinct) , 
 *                             2.Problems where the result can be arrived in multiple ways but the question ask may be max or min results   
 * 
 * 
 * Whenever Try all possible ways comes in (count,best in the count)  --> it is where recursion comes in.
 * So first Decide whether the problem is a recursive problem to be solved
 * 
 * A way to do Recursion in one of the simple way : 
 *        1. Try to represent the problem in terms of index (for not an array problem also and for array as well)
 *        2. Do all possible stuffs(operations) in that index as per or as said in the problem (Explore all possible ways)
 *        3. if sum -> sum of all stuffs 
 *           if min -> min of all stuffs
 *           if max -> max of all stuffs
 *           
 *           x = f(y) where x is the result  f() is the required action while y is the action on all the possible ways of that action
 * 
 * With these we can write recursion then we can memorize to convert to DP then we can tabulate the redundant results to use later then we can space optimise.
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Notes {

}

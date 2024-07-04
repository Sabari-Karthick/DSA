package com.Time;
/*
 * 
 * Time Complexity is not equal to time taken to run the program
 * Time Complexity is a function that gives the relationship about how the time grows as the input grows
 *        ->simply in naive terms the graph between size and time taken
 * 
 * Things to consider when thinking about time Complexity:
 *    ->Always look for worst case complexity
 *    ->Look at complexity  for large infinity data
 *    ->We do not need the exact time needed we just need the relationship whether it grows linearly,exponentially so we ignore the constants
 *    ->Always ignore less dominating terms because the value of less dominating is nothing compared to the dominating one
 *   
 *    
 * Big-O:
 * 
 *     In simple : It is the upperBound -> it will never exceed this limit
 *     
 *     Mathematically:
 *          f(x) = O(g(x))
 *          
 *          limit x -> infinity f(x)/g(x) < infinity -> it has some finite value
 *          
 * Big- Omega:
 *   Opposite of Big O
 *   Lower Bound -> Omega(N^3) means never less than N^3 
 *    
 *    
 *     Mathematically:
 *          f(x) = O(g(x))
 *          
 *          limit x -> infinity f(x)/g(x) > 0
 *          
 *          
 *  Question:
 *     How to express that an algorithm has LB and UB as N^2
 *         O(N^2) & OMEGA(N^2)
 *         
 *         There comes the THETA notation 
 *          
 *           0 <  limit x -> infinity f(x)/g(x) < infinity ->Average
 *           
 *           
 * We always look for Big O , because it is the worst case
 * 
 *    
 * Little O:
 *    This also gives the upper bound -> but it is not strict upper bound rather a loose upperbound
 *    
 * Big O vs Little O:
 *     if f=O(g) -> f<=g -> f is not faster that g
 *     and f=o(g)-> f<g  -> f is strictly slow -> it is a stronger statement
 *     
 * Little Omega is similar to that.
 * 
 *    
 *   
 *      
 *    
 * 
 * 
 * 
 */
public class TimeComplexity {

}

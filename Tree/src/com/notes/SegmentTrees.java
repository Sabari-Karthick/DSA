package com.notes;


/**
 * 
 * 
 * @author _karthick
 * 
 * 
 *  When the complexity of O(N) is not enough and we need something in O(log n) we can go for segment tree
 *  
 *  Segment Tree 
 *            ->It is a binary tree which has information about the interval as well as the operation we are performing 
 *            -> When to perform a query/function within a range in  O(log n) we can go with this ( range -> is an important factor)
 *    
 *                     Here the update function of the segment Tree is also O(log n)
 *      Space Complexity is not good
 *      Segment tree is a full binary tree which means except the leaf node all have two children
 *                           -> Leaf = N
 *                           -> Internal = N - 1
 *                           Total Nodes = 2N - 1
 *                           
 *                            
 * Possible Cases :
 *     -> Node interval totally inside/fits the query interval -> return the value
 *     -> Node interval which is outside the query interval that is (node start index) > (query end index) -> return the default value
 *     -> Overlapping -> the node interval overlaps/within/over/contain the query interval -> ask the left and right nodes
 *                                  
 *  
 *  Update :
 *     Check whether the index lies in the interval
 *     If Yes -> check child nodes 
 *                        -> if child range is out -> just return 
 *                        -> if in the range -> we will reach the leaf -> update the leaf -> which automatically update the tree
 *
 */
public class SegmentTrees {
	
	
	
}

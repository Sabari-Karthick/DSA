package com.notes;
/**
 * @author _karthick
 * 
 * Self Balancing Binary Search Tree :
 *  
 *  AVL Tree: 
 *  
 *   In binary search tree if the input coming is sorted the tree becomes skewed and the operations became O(N) instead of O(log(N))
 *      For Every Node the H(R)-H(L) can be +1,-1,0     
 *      If for every node the above condition is true then the tree is balanced 
 *      
 *   To make a unbalanced tree to make it balanced we need self balancing tree and one of the tree is AVL
 * 
 * 
 * Adeleson-Velski-Lendis(AVL) : 
 * 
 * 
 *  Algorithm:
 *   1.Insert Normally Node N
 *   2.Start from  Node N and find the Node that makes the tree unbalanced (Bottom-Up)
 *   3.Using one of the four rules and rotate the tree
 *   
 * 
 *   Four Rules:
 *      
 *      Rule 1 -> Left-Left   -> child and grand child are on the same left side or line   -> do a right rotate
 *      Rule 2 -> Left-Right  -> child on the left and the Grand Child on right -->ZigZag  -> do a  left rotate -> it brings them in line then rule 1
 *      Rule 3 -> Right-Right -> child and grand child are on the same Right side or line  -> do a Left rotate
 *      Rule 4 -> Right-Left  -> child on the right and the Grand Child on left -->ZigZag  -> do a right rotate-> it brings them in line then rule 3
 * 
 *  Since we traveling from the bottom it make sure that the subtrees are balanced 
 * 
 * 
 * If the entire a  tree is balanced which is by the definition of AVL and if the insertion of one node makes the tree unbalanced and 
 *                             -> by finding the node of subtree which makes the tree unbalance and makes that subtree will resolve the entire tree 
 * 
 * 
 * 
 * Time Complexity:
 *   For adding -> since the tree is always balanced log(N) + O(1)-> for rotation -> rotation is constant is because at max only two rotation
 * 
 */
public class AVL {

}

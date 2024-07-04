package com.notes;

public class Notes {

}
/**
 * 
 * One two will point to two another nodes and can have any type of data in it
 * 
 * Why we need trees:
 * 
 *          -> O(logn) 
 *          -> Ordered Storage 
 *          -> Cost Efficient
 * 
 * We can do any time of operations in O(log n) times 
 * Efficient Insertion and deletion. 
 * 
 * In linked list it may vary mostly O(N) 
 * In BST the left sub tree is smaller and root will be greater and the right tree is greater than the root
 * 
 * 
 * Limitation :
 *  Unbalanced Tree.-> Here the time complexity become O(N)
 *  We need to create trees in nature with that they are self balancing
 *  It is inefficient with sorted data --> it makes the tree unbalanced
 *  
 *  
 *  Where it is used:
 *     To represent file system.
 *     In databases for fast retrieval
 *     In network routing like path-finding algorithms
 *     To Complex mathematical problems which to represent mathematical equation in Tree form
 *     In machine learning for decision trees
 *     File Compression Huffman Coding
 *     It is a directed acyclic graph which indicate trees are a sort of graphs
 *     
 *     
 *  Binary Tree:
 *   In these the node have 
 *             -> a data
 *             -> a left pointer
 *             -> a right pointer
 *             
 *  Properties:
 *    Size = Total number of nodes
 *    Child Parent relationship
 *    Two nodes having same parents are siblings
 *    Leaf nodes -> Nodes at the end of tree -> a node with no children
 *    Height -> Maximum Number of edges from the node and the leaf node ( that node to the leaf)
 *    Level -> The difference of height between the root and that node
 *                           -> level of root is always zero
 *    Degree -> number of children 
 *    For a tree the degree is the maximum of degree of all nodes which is 2                
 *    If there is a path to reach from a node to  a particular node then that start node is ancestor and the end is desendent
 *    
 *                           
 *  Types:
 *       Complete Binary Tree        
 *                -> All the levels are filled apart from the  last level but the last level should be or be filled from left to right
 *                -> Example : Heaps
 *                
 *       Full/Strict BT:
 *                 -> In this each node have either zero children or two children   
 *                 ->Example: Segment Tree 
 *                 -> this is used in compression
 *              
 *       Perfect BT:
 *                 -> All Nodes in all levels are filled   
 *                 
 *                           
 *       Height Balanced :
 *                Has Average Height of O(log n)
 *                
 *       Skewed BT:
 *                 Every node have only one child 
 *                 Height O(N)     
 *                 Like Linked List   
 *                
 *       Ordered BT:
 *                 Every Node have some Property/Condition
 *                 Example: BST
 *                                              
 *                             
 *  Properties:
 *          
 *    Total no of nodes in a perfect binary tree ->   2 ^(h+1) -1  -> since with each level the nodes will be doubled -> this results in a geometric progression
 *                   It has the max number of nodes compare with other trees
 *                   
 *    Total no of leaf nodes in a perfect binary trees -> 2 ^ h 
 *    Total no of Internal  nodes in a perfect binary trees -> 2 ^ h  -1 
 *    
 *    
 *    If there are n number of leafs the number of levels is log(n) + 1 levels at least
 *    
 *    If n nodes are there there are log(n+1) levels minimum 
 *    
 *    
 *    In Strict binary trees:
 *         If there are N leaf nodes -> internal nodes = N-1
 *          
 *    
 *    Number of leaf node = 1+ number of internal nodes with two children apart from the root(not including root)
 *    
 *           
 *    For every Node Height difference between any two nodes in the same level (the left and right subtree)  should be <= 1 for the tree to be balanced
 *     For Every Node the H(R)-H(L) can be +1,-1,0         
 *         
 *    Why insertion in binary search tree takes log(n) for all operations 
 *       -> in a balanced tree the average size is log n and when we do any operations we compare only one node in each level so total log(n) levels *1  so log(n)                  
 * 
 * 
 * 
 *  Traversal : 
 *    
 *  --> Pre-Order Traversal:'
 *          
 *              Root -> Left -> Right
 * 
 *   When to use:
 *      When to copy the binary tree
 *      To Evaluate a mathematical expression
 *      To serialize array,string to tree ans vice versa
 *      
 *  -> In-Order Traversal:
 *         
 *              Left -> Root -> Right
 *              
 *     When to use:
 *         In BST, if it is used we can visit the node in sorted manner         
 *        
 *  --> Post Order Traversal:
 *  
 *           Left -> Right -> Root
 *           
 *           
 *    When to Use:
 *       Delete from binary tree post order is used -> Take care of the children first
 *       While perform bottom up tasks like height calculations
 *       
 *       
 *       
 *   
 *   
 *      
 * 
 * 
 * 
 * 
 * 
 * 
 **/
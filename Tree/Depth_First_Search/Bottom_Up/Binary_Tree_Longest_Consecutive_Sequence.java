/*
Binary Tree Longest Consecutive Sequence
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
Hide Company Tags Google
Hide Tags Tree
Hide Similar Problems (H) Longest Consecutive Sequence
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root==null){return 0;}
        //it is tree, only one path to every node -> only one path to every leaves.
        int l = dfs(root.left,1,1,root.val);
        int r = dfs(root.right,1,1,root.val);
        return Math.max(l,r);
    }
    
    //when it reaches the leaf, return the max of the #
    public int dfs(TreeNode cNode, int cMaxNum,int cNum,int fatherVal){
        if(cNode==null){return cMaxNum;} //return the MaxNum at leaves nodes
        
        if(fatherVal == (cNode.val-1)){
            cNum++;
            cMaxNum = (cNum>cMaxNum) ? cNum:cMaxNum; // it should also change
        }
        else{
            cMaxNum = (cNum>cMaxNum) ? cNum:cMaxNum; 
            cNum=1; //the start should be 1
        }
        int l = dfs(cNode.left,cMaxNum,cNum,cNode.val);
        int r = dfs(cNode.right,cMaxNum,cNum,cNode.val);        
        return Math.max(l,r);
    }
}
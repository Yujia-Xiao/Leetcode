/*
 Path Sum
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Hide Tags Tree Depth-first Search
Hide Similar Problems (M) Path Sum II (H) Binary Tree Maximum Path Sum (M) Sum Root to Leaf Numbers
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
    public boolean hasPathSum(TreeNode root, int sum) {
        int currentSum = 0;
        return dfs(root,sum,currentSum);
    }
    public boolean dfs(TreeNode root, int sum, int currentSum){
        if(root==null)return false;
        
        currentSum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==currentSum)return true;
            else return false;
        }
        boolean left = dfs(root.left,sum,currentSum);
        boolean right = dfs(root.right,sum,currentSum);
        return (left || right);
    }
}
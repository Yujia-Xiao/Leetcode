/*
Closest Binary Search Tree Value
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Hide Company Tags Microsoft Google Snapchat
Hide Tags Tree Binary Search
Hide Similar Problems (M) Count Complete Tree Nodes (H) Closest Binary Search Tree Value II
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
    public int closestValue(TreeNode root, double target) {
        int close = root.val;
        while(root!=null){
            
            if(target == root.val){return root.val;}
            
            if(Math.abs(root.val-target)<Math.abs(close-target)){
                close=root.val;
            }           
            if(target<root.val){
                root=root.left;
            }
            else{root=root.right;}
        }
        return close;
    }
}

class Solution {
    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int val = 0;
        // Iteration
        while(root != null){
            System.out.println(min);
            if(Math.abs(target - root.val) < min ) {
                min = Math.abs(target - root.val);
                val = root.val;
                System.out.println(val);
            }
            if(root.val > target) root = root.left;
            else if(root.val < target) root = root.right;
            else return root.val;
        }
        return val;
    }
}
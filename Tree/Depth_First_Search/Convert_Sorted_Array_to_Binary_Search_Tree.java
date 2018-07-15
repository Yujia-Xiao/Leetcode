/*
108. Convert Sorted Array to Binary Search Tree My Submissions QuestionEditorial Solution
Total Accepted: 77839 Total Submissions: 206567 Difficulty: Medium
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

Hide Company Tags Airbnb
Hide Tags Tree Depth-first Search
Hide Similar Problems (M) Convert Sorted List to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0) return null;
        TreeNode root = dfs(nums,0,nums.length-1);
        return root; 
    }
    public TreeNode dfs(int[] nums,int s,int e){
        int mid = s+(e-s)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if((mid-s)!=0)root.left=dfs(nums,s,mid-1);
        if((e-mid)!=0)root.right=dfs(nums,mid+1,e);
        return root;
    }
}
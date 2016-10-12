/*
404. Sum of Left Leaves  QuestionEditorial Solution  My Submissions
Total Accepted: 3760
Total Submissions: 8015
Difficulty: Easy
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
Hide Company Tags Facebook
Hide Tags Tree
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
    private int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,0,false);
        return ans;
    }
    public void dfs(TreeNode root, int culSum,boolean isLeft){
        if(root==null)return;
        if(root.left==null && root.right==null){if(isLeft)ans+=root.val;return;}
        dfs(root.left,culSum,true);
        dfs(root.right,culSum,false);
    }
}
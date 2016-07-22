/*
222. Count Complete Tree Nodes  QuestionEditorial Solution  My Submissions
Total Accepted: 38220
Total Submissions: 147432
Difficulty: Medium
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Hide Tags Tree Binary Search
Hide Similar Problems (E) Closest Binary Search Tree Value
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
    public int countNodes(TreeNode root) {
        int leftDepth = rightDepth(root);
        int rightDepth = leftDepth(root);
        if(leftDepth==rightDepth){
            //return (1<<leftDepth -1);
            return (1<<leftDepth)-1;
        }else{
            return (1+countNodes(root.left)+countNodes(root.right));
        }
    }
    private int rightDepth(TreeNode root) {
        // TODO Auto-generated method stub
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private int leftDepth(TreeNode root) {
        // TODO Auto-generated method stub
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }
}
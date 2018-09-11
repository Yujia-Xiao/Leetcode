/*
94. Binary Tree Inorder Traversal  QuestionEditorial Solution  My Submissions
Total Accepted: 145672
Total Submissions: 349091
Difficulty: Medium
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

Hide Company Tags Microsoft
Hide Tags Tree Hash Table Stack
Hide Similar Problems (M) Validate Binary Search Tree (M) Binary Tree Preorder Traversal (H) Binary Tree Postorder Traversal (M) Binary Search Tree Iterator (M) Kth Smallest Element in a BST (H) Closest Binary Search Tree Value II (M) Inorder Successor in BST
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        dfs(ans,root);
        return ans;
    }
    public void dfs(List<Integer> ans, TreeNode root){
        if(root==null)return;
        if(root.left!=null)dfs(ans,root.left);
        ans.add(root.val);
        if(root.right!=null)dfs(ans,root.right);
        return;
    }
}
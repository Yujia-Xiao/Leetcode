/*
Lowest Common Ancestor of a Binary Search Tree 
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Hide Company Tags Amazon Facebook
Hide Tags Tree
Hide Similar Problems (M) Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        if(root.val==p.val)return p;
        if(root.val==q.val)return q;
        TreeNode small = (p.val>=q.val)?q:p;
        TreeNode big = (p.val>=q.val)?p:q;
        if(root.val>small.val && root.val<big.val)return root;
        else if(root.val>big.val)return lowestCommonAncestor(root.left,p,q);
        else if(root.val<small.val)return lowestCommonAncestor(root.right,p,q);
        return null;    }
}
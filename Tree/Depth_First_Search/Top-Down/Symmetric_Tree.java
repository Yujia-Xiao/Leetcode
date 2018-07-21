/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return dfs(root.left, root.right);
    }
    
    public boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null)return true;
        if(left == null || right == null)return false;
        if(left.val != right.val)return false;
        
        boolean l = dfs(left.left, right.right);
        boolean r = dfs(left.right, right.left);
        
        return (l && r);
    }
}
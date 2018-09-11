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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return dfs(root);
        }
    
    public TreeNode dfs(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
         
        TreeNode ans = dfs(root.left); //This will solve all the problem
        
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return ans;
    }
}
/*
Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Hide Company Tags Uber
Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Balanced Binary Tree (E) Minimum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        return dfs(root,1);
    }
    
    public int dfs(TreeNode currentRoot, int currentMax){
        if(currentRoot==null)return 0;
        if(currentRoot.left==null && currentRoot.right==null)return currentMax;
        currentMax++;
        int leftMax = dfs(currentRoot.left,currentMax);
        int rightMax = dfs(currentRoot.right,currentMax);
        return ((leftMax>rightMax)?leftMax:rightMax);
    };
}



// 07/04/2018
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
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int[] ans = new int[1];
        dfs(root, 0, ans);
        return ans[0];
    }
    
    public void dfs(TreeNode root, int cul, int[] ans){
        if(root == null) return;
        cul++;
        if(root.left == null && root.right == null && cul > ans[0]){
            ans[0] = cul;
        }
        dfs(root.left, cul, ans);
        dfs(root.right, cul, ans);
        return;
    }
}
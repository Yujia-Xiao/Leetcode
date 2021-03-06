/*
Binary Tree Maximum Path Sum 
Given a binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (M) Sum Root to Leaf Numbers
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
    public int maxPathSum(TreeNode root) {
	    int max[] = new int[1]; 
	    max[0] = Integer.MIN_VALUE; // pass by reference
	    calculateSum(root, max);
	    return max[0];
    }
 
    public int calculateSum(TreeNode root, int[] max) {
	    if (root == null) return 0;
	    int left = calculateSum(root.left, max);
	    int right = calculateSum(root.right, max);
	    int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
	    //the node val can be negative
	    max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
	    return current;
    }
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
 
 return the max value to the root.
 when compare, try to get longest 
 
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        dfs(root, ans);
        return ans[0];
    }
    
    public int dfs(TreeNode root, int[] ans ){
        if(root == null) return 0;
        
        int l = dfs(root.left, ans);
        int r = dfs(root.right, ans);
        
        int max = Math.max(l+root.val, Math.max(root.val, Math.max(l+root.val+r, r+root.val)));
        if(max > ans[0]) ans[0] = max;
        
        return Math.max(l+root.val, Math.max(r+root.val, root.val));
    }
}

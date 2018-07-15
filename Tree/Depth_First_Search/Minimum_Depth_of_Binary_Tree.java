/*
Minimum Depth of Binary Tree My Submissions Question
Total Accepted: 93049 Total Submissions: 308475 Difficulty: Easy
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Hide Tags Tree Depth-first Search Breadth-first Search
Hide Similar Problems (E) Binary Tree Level Order Traversal (E) Maximum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        
        int min = Integer.MAX_VALUE;
        min=dfs(root,min,0);
        return min;
    }
    public int dfs(TreeNode node,int min,int current){
        if(node==null)return Integer.MAX_VALUE;
        current++;
        if(node.left==null && node.right==null){
            if(current<min)min=current;
            return min;
        }
        int left=dfs(node.left,min,current);
        int right=dfs(node.right,min,current);
    
        return Math.min(left,right);
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
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(root, 0, ans);
        return ans[0];
    }
    
    public void dfs(TreeNode root, int cul, int[] ans){
        if(root == null)return;
        cul++;
        if(root.left == null && root.right == null){
            if(cul < ans[0])ans[0] = cul;
        }
        dfs(root.left, cul, ans);
        dfs(root.right, cul, ans);
        return;
    }
}

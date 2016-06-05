/*
105. Construct Binary Tree from Preorder and Inorder Traversal My Submissions QuestionEditorial Solution
Total Accepted: 65319 Total Submissions: 225386 Difficulty: Medium
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Hide Company Tags Bloomberg
Hide Tags Tree Array Depth-first Search
Hide Similar Problems (M) Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,0,inorder,0,inorder.length-1);    
    }
    
    public TreeNode dfs(int[] preorder, int idx, int[] inorder, int start, int end){
        if(idx>preorder.length-1 || start>end)return null;
        TreeNode root = new TreeNode(preorder[idx]);
        int i=start;
        for(;i<=end;i++){
            if(inorder[i]==preorder[idx])break;
        }
        root.left=dfs(preorder,idx+1,inorder,start,i-1); //recursion part
        root.right=dfs(preorder,idx+i-start+1,inorder,i+1,end);
        return root;
    };
}
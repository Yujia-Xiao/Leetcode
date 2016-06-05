/*
Construct Binary Tree from Inorder and Postorder Traversal My Submissions QuestionEditorial Solution
Total Accepted: 56674 Total Submissions: 193651 Difficulty: Medium
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Hide Company Tags Microsoft
Hide Tags Tree Array Depth-first Search
Hide Similar Problems (M) Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(postorder,postorder.length-1,inorder,0,inorder.length-1);    
    }
    
    public TreeNode dfs(int[] postorder, int idx, int[] inorder, int start,int end){
        if(idx<0 || start>end)return null;
        TreeNode root = new TreeNode(postorder[idx]);
        int i = start;
        for(;i<=end;i++){
            if(postorder[idx]==inorder[i])break;
        }
        System.out.println(i);
        root.left=dfs(postorder,idx-(end-i)-1,inorder,start,i-1);
        root.right=dfs(postorder,idx-1,inorder,i+1,end);
        return root;
    };
}
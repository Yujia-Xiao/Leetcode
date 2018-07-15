/*
114. Flatten Binary Tree to Linked List My Submissions QuestionEditorial Solution
Total Accepted: 84211 Total Submissions: 268784 Difficulty: Medium
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hide Company Tags Microsoft
Show Tags
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
    public void flatten(TreeNode root) {
        dfs(root);
    }
    public TreeNode dfs(TreeNode root){
        if(root==null)return root;
        TreeNode l = dfs(root.left);
        TreeNode r = dfs(root.right);
        root.left=null;
        if(l!=null){
            root.right=l;
            TreeNode cur = root;
            while(cur.right!=null){
                cur=cur.right;
            }
            cur.right=r;
        }
        return root;
    }
}


// 7/6/2018
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 This is an in-order traversal
 
 root.right = left
 root.left = null
 
 return the last value
 left.end.right = r
 
 
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)return;
        dfs(root);
        return;
    }
    public void dfs(TreeNode root){
        if(root.left == null && root.right == null) return;
        
        if(root.left!=null)dfs(root.left);
        if(root.right!=null)dfs(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode cul = root;
        
        if(left!=null){
            cul = left;
            while(cul.right!=null)cul = cul.right;
            cul.right = right;
            root.left = null;
            root.right = left;
        }
        
        
        return;
    }
}
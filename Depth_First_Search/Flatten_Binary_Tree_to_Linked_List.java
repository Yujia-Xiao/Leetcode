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
*/
Invert Binary Tree
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
Hide Tags Tree
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
    public TreeNode invertTree(TreeNode root) {
        TreeNode CNode = root;
        invert(root);
        return root;
    }
    
    public void invert(TreeNode CRoot){
        if(CRoot==null)return;
        TreeNode tmp = null;
        tmp = CRoot.left;
        CRoot.left = CRoot.right;
        CRoot.right = tmp;
        invert(CRoot.left);
        invert(CRoot.right);
        return;
    }
}



public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        if(root.left==null && root.right==null)return root;
        TreeNode left = invertTree(root.left);
        TreeNode right= invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
/*
285. Inorder Successor in BST  QuestionEditorial Solution  My Submissions
Total Accepted: 13094
Total Submissions: 36015
Difficulty: Medium
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Hide Company Tags Pocket Gems Microsoft Facebook
Hide Tags Tree
Hide Similar Problems (M) Binary Tree Inorder Traversal (M) Binary Search Tree Iterator

*/

public TreeNode successor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val <= p.val) {
    return successor(root.right, p);
  } else {
    TreeNode left = successor(root.left, p);
    return (left != null) ? left : root;
  }
}
Predecessor

public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}


//2018

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        
        TreeNode pre = null;
        TreeNode cul = root;
        
        while(!stack.isEmpty() || cul!= null){
            // go deep to the left
            while(cul != null){
                stack.push(cul);
                cul = cul.left;
            }
            // pop out the middel
            cul = stack.pop();
            if(pre!=null && pre.val == p.val)return cul;
            pre = cul;
            
            //go to right
            cul = cul.right;
            
        };
        
        return null;
        
    }
}

//07/15/2018
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)return null;
        if(root.val<=p.val)return inorderSuccessor(root.right , p);
        else{
            TreeNode left = inorderSuccessor(root.left , p);
            return (left==null ? root:left);
        }
        
    }
}
/*
Binary Tree Upside Down
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Hide Tags Tree
Hide Similar Problems (E) Reverse Linked List
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
       TreeNode p = root, parent = null, parentRight = null;
        while (p!=null) {
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = left;
        }
        return parent; 
    }
}


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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null)return root;
        if(root.left==null && root.right==null)return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left=root.right;
        root.left.right=root;
        root.left=null;
        root.right=null;
        return newRoot; 
    }
}

/*
    1
   /\
  2  3
 /\
4 5 

    1
   /
  2 -3
 /
4 - 5 


*/
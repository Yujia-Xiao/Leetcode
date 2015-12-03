/*
Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags LinkedIn Google Facebook
Hide Tags Tree Stack Design
Hide Similar Problems (M) Binary Tree Inorder Traversal (M) Flatten 2D Vector (M) Zigzag Iterator (M) Peeking Iterator (M) Inorder Successor in BST
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty());       
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int value = node.val;
        if(node.right != null){
            node=node.right;
            while(node!=null){
                stack.push(node);
                node=node.left;
            }
        }        
        return value;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
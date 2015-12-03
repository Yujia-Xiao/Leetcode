/*
Kth Smallest Element in a BST 
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Tree Binary Search
Hide Similar Problems (M) Binary Tree Inorder Traversal
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
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public int kthSmallest(TreeNode root, int k) {
        int count = k;
        int ans = root.val;
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        while(count!=0){
            TreeNode node = stack.pop();
            count --;
            ans=node.val;
            if(node.right!=null){
                node=node.right;
                while(node!=null){
                    stack.push(node);
                    node = node.left;
                }
            }           
        }
        return ans;
    }
}

/*
145. Binary Tree Postorder Traversal  QuestionEditorial Solution  My Submissions
Total Accepted: 112161
Total Submissions: 301935
Difficulty: Hard
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?

Hide Tags Tree Stack
Hide Similar Problems (M) Binary Tree Inorder Traversal
Have you met this question in a real interview? Yes  No
Discuss Pick One

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
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.empty()){
        root = stack.pop();
        list.add(0, root.val);
        if(root.left != null) stack.push(root.left);
        if(root.right != null) stack.push(root.right);
    }
    return list;
    }
}
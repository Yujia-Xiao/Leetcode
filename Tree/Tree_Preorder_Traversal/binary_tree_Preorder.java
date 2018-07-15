/*
144. Binary Tree Preorder Traversal  QuestionEditorial Solution  My Submissions
Total Accepted: 141556
Total Submissions: 338937
Difficulty: Medium
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

Hide Tags Tree Stack
Hide Similar Problems (M) Binary Tree Inorder Traversal (M) Verify Preorder Sequence in Binary Search Tree
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        dfs(ans,root);
        return ans;
    }
    public void dfs(List<Integer> ans, TreeNode root){
        if(root==null)return;
        ans.add(root.val);
        dfs(ans,root.left);
        dfs(ans,root.right);
    }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tem = stack.pop();
            if(tem!=null){
                ans.add(tem.val);
                stack.push(tem.right);
                stack.push(tem.left);
            }
        }
        return ans;
    }

}
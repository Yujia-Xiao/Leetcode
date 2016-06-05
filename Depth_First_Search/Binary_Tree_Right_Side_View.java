/*
199. Binary Tree Right Side View My Submissions QuestionEditorial Solution
Total Accepted: 43967 Total Submissions: 124975 Difficulty: Medium
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

Hide Company Tags Amazon
Hide Tags Tree Depth-first Search Breadth-first Search
Hide Similar Problems (M) Populating Next Right Pointers in Each Node
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
public class Solution{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        return dfs(root,ans,0);
    }
    
    public List<Integer> dfs(TreeNode root, List<Integer> ans,int level){
        if(root==null)return ans;
        if(ans.size()==level)ans.add(root.val);
        dfs(root.right,ans,level+1);
        dfs(root.left,ans,level+1);
        return ans;
    }
}
/*
107. Binary Tree Level Order Traversal II My Submissions QuestionEditorial Solution
Total Accepted: 83016 Total Submissions: 242183 Difficulty: Easy
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
Hide Tags Tree Breadth-first Search
Hide Similar Problems (E) Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        dfs(ans,root,0);
        Collections.reverse(ans);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, TreeNode root, int level){
        if(root==null)return;
        if(level==ans.size()){
            List<Integer> list = new LinkedList<Integer>();
            ans.add(list);
        }
        List<Integer> levelList = ans.get(level);
        levelList.add(root.val);
        dfs(ans,root.left,level+1);
        dfs(ans,root.right,level+1);
    }
}


class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if(root != null){
            que.offer(root);
        }
        TreeNode nd;
        int size=0;
        while(!que.isEmpty()){
            size=que.size();
            List<Integer> list = new ArrayList<Integer>();
            while(size-->0){
                nd = que.poll();
                list.add(nd.val);
                if(nd.left != null){
                    que.offer(nd.left);
                }
                if(nd.right != null){
                    que.offer(nd.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }
}
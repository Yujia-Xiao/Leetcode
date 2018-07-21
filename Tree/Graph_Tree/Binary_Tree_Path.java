/*
Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google Facebook
Hide Tags Tree Depth-first Search
Hide Similar Problems (M) Path Sum II
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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if(root == null){return ans;}
        
        String currentPath = root.val+"";
        if(root.left ==null && root.right == null){
            ans.add(currentPath);
        }            
        dfs(root.left,currentPath,ans);
        dfs(root.right,currentPath,ans);      
        return ans;
    }
    
    public void dfs(TreeNode currentRoot, String currentPath,List<String> ans){
        if(currentRoot==null) return;
        currentPath = currentPath+"->"+currentRoot.val;
        if(currentRoot.left ==null && currentRoot.right == null){
            ans.add(currentPath);
        }
        dfs(currentRoot.left,currentPath,ans);
        dfs(currentRoot.right,currentPath,ans);
        return;
    }
}
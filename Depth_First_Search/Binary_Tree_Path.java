/*
257. Binary Tree Paths  QuestionEditorial Solution  My Submissions
Total Accepted: 57026
Total Submissions: 187248
Difficulty: Easy
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

Hide Company Tags Google Apple Facebook
Hide Tags Tree Depth-first Search
Hide Similar Problems (M) Path Sum II

*/

public class Solution {
    
    public List<String> binaryTreePaths(TreeNode root){
        List<String> ans = new ArrayList<String>();
        
        dfs(root,"",ans);
        return ans;
    }
    
    public void dfs(TreeNode currentRoot, String currentPath,List<String> ans){
        if(currentRoot==null) return;
        currentPath = currentPath+currentRoot.val+"->";
        if(currentRoot.left ==null && currentRoot.right == null){
            int n=currentPath.length()-1;
            ans.add(currentPath.substring(0,n-1));
        }
        dfs(currentRoot.left,currentPath,ans);
        dfs(currentRoot.right,currentPath,ans);
        return;
    }
}
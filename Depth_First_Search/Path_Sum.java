/*

Notes Auto Saved.
|||

Type here...(Markdown is enabled)
​
113. Path Sum II  QuestionEditorial Solution  My Submissions
Total Accepted: 88561
Total Submissions: 303494
Difficulty: Medium
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
Hide Company Tags Bloomberg
Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (E) Binary Tree Paths

*/

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathlist=new ArrayList<List<Integer>>();
        List<Integer> sumlist = new ArrayList<Integer>();
        pathSumHelper(root,sum,sumlist,pathlist);
        return pathlist;       
    }
    public void pathSumHelper(TreeNode root, int sum, List <Integer> sumlist, List<List<Integer>> pathlist){
          if(root==null) return;
          sumlist.add(root.val);
          sum = sum-root.val;
          if(root.left==null && root.right==null)
              if(sum==0)pathlist.add(new ArrayList<Integer>(sumlist));
    
          pathSumHelper(root.left,sum,sumlist,pathlist);
          pathSumHelper(root.right,sum,sumlist,pathlist);

          sumlist.remove(sumlist.size()-1);
     }
         
    
}
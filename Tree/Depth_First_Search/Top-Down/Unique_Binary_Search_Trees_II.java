/*
95. Unique Binary Search Trees II  QuestionEditorial Solution  My Submissions
Total Accepted: 59349
Total Submissions: 202288
Difficulty: Medium
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Hide Tags Tree Dynamic Programming
Hide Similar Problems (M) Unique Binary Search Trees (M) Different Ways to Add Parentheses
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
    
    public List<TreeNode> generateTrees(int n) {
        if(n==0)return new LinkedList<TreeNode>();
        return helper(1,n);
    }
    public List<TreeNode> helper(int s, int e){
        List<TreeNode> ans = new LinkedList<TreeNode>();
        if(s>e){ans.add(null);return ans;}
        for(int i=s;i<=e;i++){
            List<TreeNode> leftSub = helper(s,i-1);
            List<TreeNode> rightSub = helper(i+1,e);
            
            for(int a=0;a<leftSub.size();a++){
                for(int b=0;b<rightSub.size();b++){
                    TreeNode root = new TreeNode(i);
                    root.left=leftSub.get(a);
                    root.right=rightSub.get(b);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
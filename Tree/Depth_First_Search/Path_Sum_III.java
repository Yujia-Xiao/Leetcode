/*
437. Path Sum III   QuestionEditorial Solution  My Submissions
Total Accepted: 5073
Total Submissions: 13321
Difficulty: Easy
Contributors: Stomach_ache
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
Hide Tags Tree
Hide Similar Problems (E) Path Sum (M) Path Sum II
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
    
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        return dfs(root,0,sum,map);
    }
    
    public int dfs(TreeNode cul, int culSum, int target, Map<Integer,Integer> map){
        if(cul==null)return 0;
        culSum+=cul.val;
        int res = map.getOrDefault(culSum-target,0);
        map.put(culSum,map.getOrDefault(culSum,0)+1);
        res+=dfs(cul.left,culSum,target,map)+dfs(cul.right,culSum,target,map);
        map.put(culSum,map.getOrDefault(culSum,0)-1);
        return res;
    }
}
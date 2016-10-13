/*
Balanced Binary Tree My Submissions QuestionEditorial Solution
Total Accepted: 114459 Total Submissions: 333673 Difficulty: Easy
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Hide Company Tags Bloomberg
Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Maximum Depth of Binary Tree
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

    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int[] ans = dfs(root);
        if(ans[1]==1)return true;
        return false;
    }
    
    public int[] dfs(TreeNode cur){
        int[] ans = new int[2];
        if(cur==null){ans[0]=1;ans[1]=1;return ans;}
        int[] L = dfs(cur.left);
        int[] R = dfs(cur.right);
        ans[0]=Math.max(L[0],R[0])+1;
        if(Math.abs(L[0]-R[0])<2 && L[1]==1 && R[1]==1)ans[1]=1;
        return ans;
    }
}

// method 2

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

    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int l = dfs(root.left,0,0);
        int r = dfs(root.right,0,0);
        if(Math.abs(l-r)<2 && isBalanced(root.left) && isBalanced(root.right)) return true;
        else return false;
    }
    
    public int dfs(TreeNode root, int culMax, int max){
        if(root==null){
            if(max<culMax)max=culMax;
            return max;
        }
        culMax++;
        int l = dfs(root.left,culMax,max);
        int r = dfs(root.right,culMax,max);
        return Math.max(l,r);
    }
}

public boolean isBalanced(TreeNode root) {
    if(root==null){
        return true;
    }
    return height(root)!=-1;
    
}
public int height(TreeNode node){
    if(node==null){
        return 0;
    }
    int lH=height(node.left);
    if(lH==-1){
        return -1;
    }
    int rH=height(node.right);
    if(rH==-1){
        return -1;
    }
    if(lH-rH<-1 || lH-rH>1){
        return -1;
    }
    return Math.max(lH,rH)+1;
}
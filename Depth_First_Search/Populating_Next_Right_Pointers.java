/*
Populating Next Right Pointers in Each Node My Submissions QuestionEditorial Solution
Total Accepted: 89701 Total Submissions: 245234 Difficulty: Medium
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
Hide Company Tags Microsoft
Hide Tags Tree Depth-first Search
Hide Similar Problems (H) Populating Next Right Pointers in Each Node II (M) Binary Tree Right Side View
*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)return;
        dfs(root.left,root,true);
        dfs(root.right,root,false);
    }
    
    public void dfs(TreeLinkNode cur, TreeLinkNode parent, boolean left){
        if(cur==null)return;
        
        if(!left && parent.next!=null){ 
            if(parent.next.left!=null)cur.next=parent.next.left;
            else cur.next=parent.next.right;}
        if(left){
            cur.next=parent.right;
        }

        dfs(cur.left,cur,true);
        dfs(cur.right,cur,false);
    }
}
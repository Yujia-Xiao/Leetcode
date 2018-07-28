/*
109. Convert Sorted List to Binary Search Tree My Submissions QuestionEditorial Solution
Total Accepted: 71892 Total Submissions: 233676 Difficulty: Medium
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Hide Company Tags Zenefits
Hide Tags Depth-first Search Linked List
Hide Similar Problems (M) Convert Sorted Array to Binary Search Tree
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        return dfs(head,null);
    }
    
    public TreeNode dfs(ListNode head,ListNode tail){
        if(head==tail)return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=tail && fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left=dfs(head,slow);
        root.right=dfs(slow.next,tail);
        return root;
    }
}
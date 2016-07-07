/*
141. Linked List Cycle  QuestionEditorial Solution  My Submissions
Total Accepted: 115470
Total Submissions: 316589
Difficulty: Easy
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

Hide Company Tags Amazon Microsoft Bloomberg Yahoo
Hide Tags Linked List Two Pointers
Hide Similar Problems (M) Linked List Cycle II
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null && slow!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)return true;
        }
        return false;
    }
}
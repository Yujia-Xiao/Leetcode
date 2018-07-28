/*
142. Linked List Cycle II  QuestionEditorial Solution  My Submissions
Total Accepted: 80350
Total Submissions: 257035
Difficulty: Medium
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

Hide Tags Linked List Two Pointers
Hide Similar Problems (E) Linked List Cycle (H) Find the Duplicate Number
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
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;
        while(fast!=null && slow!=null){
            fast=fast.next;
            if(fast==null)return null;
            fast=fast.next;
            slow=slow.next;
            if(slow==fast){isCycle=true;break;}
        }
        if(!isCycle)return null;
        slow=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
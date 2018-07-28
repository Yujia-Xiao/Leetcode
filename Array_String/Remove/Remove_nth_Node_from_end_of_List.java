/*
19. Remove Nth Node From End of List  QuestionEditorial Solution  My Submissions
Total Accepted: 117624
Total Submissions: 388831
Difficulty: Easy
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

Hide Tags Linked List Two Pointers
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        for(int i=0;i<n;i++){
            if(head!=null)fast=fast.next;
            else return head;
        }
        
        while(fast!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next;
        }
        if(pre!=null)pre.next=slow.next;
        else head=slow.next;
        return head;
    }
}


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummy;
        
        for(int i=0;i<n;i++){
            if(fast!=null)fast=fast.next;
            else return dummy.next;
        }
        
        while(fast!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next;
        }
        
        pre.next=slow.next;
       
        return dummy.next;
    }
}
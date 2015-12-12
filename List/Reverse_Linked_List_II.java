/*
LeetCode OJ
Reverse Linked List II 
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

Hide Tags Linked List
Hide Similar Problems (E) Reverse Linked List
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m>=n || head==null)return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        head=dummy;
        
        for(int i=0;i<m-1;i++)head=head.next;
        
        ListNode prem = head;
        ListNode nodem= head.next;
        ListNode noden=nodem;
        ListNode postn=nodem.next;
        
        for(int i=m;i<n;i++){
            if(postn==null)return null;
            ListNode tmp=postn.next;
            postn.next=noden;
            noden=postn;
            postn=tmp;
        }
        
        prem.next=noden;
        nodem.next=postn;
        return dummy.next;
        
    }
}
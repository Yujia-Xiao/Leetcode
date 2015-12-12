/*
Reverse Linked List 
Reverse a singly linked list.

click to show more hints.

Hide Company Tags Amazon Uber Facebook
Hide Tags Linked List
Hide Similar Problems (M) Reverse Linked List II (M) Binary Tree Upside Down (E) Palindrome Linked List
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
    public ListNode reverseList(ListNode head) {
        //head->node(should keep this)->node.... '->' to '<-' ....O(n), n=size of the list
        //tmp=head.next
        //head.next=null; node.next=head;head=temp
        //end condition: head.next==null
        //...->node(head)->null
        if(head==null || head.next==null){return head;}
        
        ListNode temp1 = head.next;
        ListNode temp2 = temp1.next;
        head.next=null;
        temp1.next=head;
        while(temp2!=null){
            head=temp1;
            temp1=temp2;
            temp2=temp2.next;
            temp1.next=head;
        }
        temp1.next=head;
        head=temp1;
        
        return head;
    }
}
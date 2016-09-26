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
        if(head==null)return head;
        ListNode pre = null;
        ListNode cul = head;
        ListNode post = head.next;
        while(post!=null){
            cul.next=pre;
            pre=cul;
            cul=post;
            post=post.next;
        }
        cul.next=pre;
        return cul;

    }
}
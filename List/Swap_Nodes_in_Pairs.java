/*
Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Hide Tags Linked List
Hide Similar Problems (H) Reverse Nodes in k-Group
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
    public ListNode swapPairs(ListNode head) {
        //1(tmp1)->2(head)->3(tmp2)-> 4 -> 5
        //            0          1    2    3
        //                   2        1
        //head.next=tmp2;
        //tmp1.next=head;
        //head=tmp2;tmp1=tmp2.next;tmp2=tmp1.next
        if(head==null || head.next==null){return head;}
        ListNode tmp0 = head;
        head=head.next;
        ListNode tmp1=tmp0.next;
        ListNode tmp2=tmp1.next;
        tmp0.next=tmp2;tmp1.next=tmp0;
        if(tmp2==null){return head;}
        tmp1=tmp2;
        tmp2=tmp1.next;
        if(tmp2==null){return head;}
        ListNode tmp3=tmp2.next;

        //assume list size == even
        while(tmp3!=null){
            tmp0.next=tmp2;
            tmp2.next=tmp1;
            tmp1.next=tmp3;
            tmp0=tmp1;
            tmp1=tmp3;
            tmp2=tmp1.next;
            if(tmp2==null){return head;}
            tmp3=tmp2.next;
        }
         tmp0.next=tmp2;
         tmp2.next=tmp1;
         tmp1.next=null;
     return head;   
    }
}
/*
148. Sort List  QuestionEditorial Solution  My Submissions
Total Accepted: 76795 Total Submissions: 298783 Difficulty: Medium
Sort a linked list in O(n log n) time using constant space complexity.

Hide Tags Linked List Sort
Hide Similar Problems (E) Merge Two Sorted Lists (M) Sort Colors (M) Insertion Sort List
*/

public class Solution {
    
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode pre=null,slow=head,fast=head;
        
        while(fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        pre.next=null;
        
        ListNode l = sortList(head);
        ListNode h = sortList(slow);
     
        return merge(l,h);
    }
    public ListNode merge(ListNode l, ListNode h){
        ListNode d = new ListNode(0),c = d;
        
        while(l!=null && h!=null){
            if(l.val<h.val){
                c.next=l;
                l=l.next;
            }else{
                c.next=h;
                h=h.next;
            }
            c=c.next;
        }
        if(l!=null)c.next=l;
        
        if(h!=null)c.next=h;
        
        return d.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        
        ListNode slow=head,fast=head;
        
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tem = slow.next;
        slow.next=null;
        
        fast = sortList(head);
        slow = sortList(tem);
     
        return merge(fast,slow);
    }
    public ListNode merge(ListNode l, ListNode h){
        ListNode d = new ListNode(0),c = d;
        while(l!=null && h!=null){
            if(l.val<h.val){
                c.next=l;
                l=l.next;
            }else{
                c.next=h;
                h=h.next;
            }
            c=c.next;
        }
        if(l!=null)c.next=l;
        
        if(h!=null)c.next=h;
        
        return d.next;
    }
}
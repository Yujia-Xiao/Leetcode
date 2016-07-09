/*
61. Rotate List  QuestionEditorial Solution  My Submissions
Total Accepted: 74156
Total Submissions: 319466
Difficulty: Medium
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

Hide Tags Linked List Two Pointers
Hide Similar Problems (E) Rotate Array
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        int len = 0;
        
        ListNode fast = head;
        ListNode slow = head;
        //find the last k ListNode
        
        for(int i=0;i<k;i++){
            if(fast!=null)fast=fast.next;
            else{
                len=i;
                int newK = k % len;
                //System.out.println(newK);
                fast=head;
                for(int j=0;j<newK;j++){
                    fast=fast.next;
                }
                break;
            }
        }
        
        if(fast==null)return head;
        
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        
        fast.next=head;
        head=slow.next;
        slow.next=null;
        
        return head;
    }
}
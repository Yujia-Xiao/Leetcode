/*
86. Partition List  QuestionEditorial Solution  My Submissions
Total Accepted: 70621
Total Submissions: 234463
Difficulty: Medium
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        
        ListNode dummy1 = new ListNode(0); //smaller
        ListNode cul1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode cul2 = dummy2;
        ListNode cul = head;
        
        while(cul!=null){
            if(cul.val<x){
                cul1.next=cul;
                cul1=cul;
                cul=cul.next;
            }
            else{
                cul2.next=cul;
                cul2=cul;
                cul=cul.next;
            }
        }
        
        if(dummy1!=null && dummy2!=null){
            cul1.next=dummy2.next;
            cul2.next=null;
            return dummy1.next;
        }
        else if(dummy1==null && dummy2==null)return null;
        else if(dummy1==null){
            cul2.next=null;
            return dummy2.next;
        }
        else{ 
            cul1.next=null;
            return dummy1.next;
        }
    }
}
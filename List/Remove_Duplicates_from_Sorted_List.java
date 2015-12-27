/*
Remove Duplicates from Sorted List 
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

Hide Tags Linked List
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
    public ListNode deleteDuplicates(ListNode head) {
        return Recursive(head,head);
    }
    
    public ListNode Recursive(ListNode root, ListNode head){
        if(head==null || head.next==null)return head;
        ListNode nextN = head.next;
        if(nextN.next==null){
            //delete last
            if(nextN.val==head.val){
                head.next=null;
            }
            return root;
        }
        else{
            //delete and connect and recursive
            ListNode NnextN = nextN.next;
            if(nextN.val==head.val){
                head.next=NnextN;
                return Recursive(root,head);
            }
            return Recursive(root,head.next);
        }
    }
}
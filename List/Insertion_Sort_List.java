/*
147. Insertion Sort List  QuestionEditorial Solution  My Submissions
Total Accepted: 75341
Total Submissions: 250419
Difficulty: Medium
Sort a linked list using insertion sort.

Hide Tags Linked List Sort
Hide Similar Problems (M) Sort List
*/
//Solution1：
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1); // new list;
        ListNode cul = head;
        ListNode sort = null;
        ListNode pre = dummy;
        dummy.next=sort; //new head
        
        while(cul!=null){
            sort=dummy.next;
            pre=dummy;
            // find place to insert
            while(sort!=null && sort.next!=null && sort.next.val<cul.val){
                pre=pre.next;
                sort=sort.next;
            }
             ListNode tem = null;
            if(sort!=null && sort.val<cul.val){ //insert after
                tem=sort.next;
                sort.next=cul;
                cul=cul.next;
                sort.next.next=tem;
            }else{//replace
                tem=(sort==null)?null:sort;
                pre.next=cul;
                sort=cul;
                cul=cul.next;
                sort.next=tem;                
            }
        }
        return dummy.next;
    }
}

//solution2：
 public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }
        
        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        
        return helper.next;
    }
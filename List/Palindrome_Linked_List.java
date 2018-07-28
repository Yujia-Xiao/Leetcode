/*
234. Palindrome Linked List  QuestionEditorial Solution  My Submissions
Total Accepted: 55103
Total Submissions: 188668
Difficulty: Easy
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

Hide Company Tags Amazon Facebook
Hide Tags Linked List Two Pointers
Hide Similar Problems (E) Palindrome Number (E) Valid Palindrome (E) Reverse Linked List
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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        boolean even = false;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode tem = slow.next;
        fast=fast.next;//at least two node, balanced
        slow.next=null;//important, change slow will change fast if they all point to head!!!!
        //System.out.println(fast.val+" "+slow.val);
        
        while(fast!=null && slow!=null){//can enter first time
            //System.out.println(fast.val+" "+slow.val);
            fast=fast.next;
            if(fast==null){
                //System.out.println("ok");
                even=true;
                break;}
            ListNode before = slow;
            slow = tem;
            tem = slow.next;
            slow.next=before;
            //both walked on step
            
            fast=fast.next;

        }
        System.out.println(even);
        if(!even)slow=slow.next;//back one step
        fast=tem;
        while(slow.val==fast.val){
            System.out.println(slow.val+" "+fast.val);
            slow=slow.next;
            fast=fast.next;
            if(slow==null || fast==null)return true;
        }
        return false;
    }
}
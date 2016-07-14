/*
203. Remove Linked List Elements  QuestionEditorial Solution  My Submissions
Total Accepted: 70480
Total Submissions: 239475
Difficulty: Easy
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Hide Tags Linked List
Hide Similar Problems (E) Remove Element (E) Delete Node in a Linked List
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cul = head;
        ListNode pre = dummy;
        while(cul!=null){
            if(cul.val==val){
                pre.next=cul.next;
            }else{
                pre=pre.next;
            }
            cul=cul.next;
        }
        return dummy.next;
    }
}
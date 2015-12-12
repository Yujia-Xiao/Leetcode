/*
Add Two Numbers 
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Hide Tags Linked List Math
Hide Similar Problems (M) Multiply Strings (E) Add Binary
*/
public class Solution{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode head = new ListNode(0);
		ListNode point = head;
		if(l1==null && l2==null)return null;
		int carry=0;
		while(l1!=null && l2!=null){
			int sum=carry+l1.val+l2.val;
			point.next=new ListNode(sum%10);
			carry=sum/10;
			l1=l1.next;
			l2=l2.next;
			point=point.next;
		}
		while(l1!=null){
			int sum=carry+l1.val;
			point.next=new ListNode(sum%10);
			carry=sum/10;
			l1=l1.next;
			point=point.next;
		}
		while(l2!=null){
			int sum=carry+l2.val;
			point.next=new ListNode(sum%10);
			carry=sum/10;
			l2=l2.next;
			point=point.next;
		}
		if(carry!=0){
			point.next=new ListNode(carry);
		}

		return head.next;		
	}
}
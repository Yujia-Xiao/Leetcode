/*
Merge k Sorted Lists 
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Hide Company Tags LinkedIn Google Uber Airbnb Facebook Twitter Amazon
Hide Tags Divide and Conquer Linked List Heap
Hide Similar Problems (E) Merge Two Sorted Lists (M) Ugly Number II
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
    public ListNode mergeKLists(ListNode[] lists) {        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2) {return (n1.val-n2.val);}
        });
        
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){minHeap.offer(lists[i]);}
        }
        ListNode head;
        ListNode pre;
        ListNode cur;
        head=pre=cur=minHeap.poll();
        if(cur!=null) if(cur.next!=null)minHeap.offer(cur.next);
        while(minHeap.size()>0){
            cur = minHeap.poll();
            pre.next=cur;
            pre=cur;
            if(cur.next!=null)minHeap.offer(cur.next);
        }
        return head;
    }
}
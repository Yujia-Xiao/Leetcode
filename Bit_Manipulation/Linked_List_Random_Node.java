/*
382. Linked List Random Node  QuestionEditorial Solution  My Submissions
Total Accepted: 5484
Total Submissions: 11908
Difficulty: Medium
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
Hide Company Tags Google
Hide Tags Reservoir Sampling
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
    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head=head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cul = head;
        int ans = cul.val; int num = 1; int ran = 0;
        while(cul.next!=null){
            cul=cul.next;
            ran = (int)Math.round(Math.random()*num+1); //[1,num]
           // System.out.println(ran);
            if(ran==1)ans=cul.val;
            num++;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
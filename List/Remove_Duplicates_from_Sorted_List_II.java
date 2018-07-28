/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        // delete O(n), pre cul post/   pre(head), cul(head.next),post
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        ListNode cul = head;
        ListNode post = head.next;//the end of the duplicate:    
        /*
            1(pre), 2(cul), 2(post), 2, 2, 3
            1(pre), 2, 2, 2, 2(cul), 3(post)
            
            1(pre), 2(cul), 2(post), 2, 2, null
            1(pre), 2, 2, 2, 2(cul), null(post)
        */
        // pre(), cul(last node), post(null)
        
        while(cul!=null){
            //step1: is dup and move
            if(post!=null && cul.val==post.val){
                //step2: if yes, remove: pre->cul->post. : pre->post
                
                cul=cul.next;
                post=post.next;
            }
            else if(pre.next!=cul){//connect
                pre.next=post;
                cul=post;
                if(post!=null)post=post.next;

            }   
            else{
                pre=pre.next;
                cul=cul.next;
                if(post!=null)post=post.next;
            }
            //step3: move to next
            
        }
        return dummy.next;
    }
}
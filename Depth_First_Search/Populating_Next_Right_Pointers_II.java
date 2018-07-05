/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)return;
        TreeLinkNode head = null; TreeLinkNode pren = null; TreeLinkNode cul = root;
        while(cul != null){
            //finish current level
            while(cul != null){
                //left
                if(cul.left != null){
                    if(pren != null)pren.next = cul.left;
                    else head = cul.left;
                    pren = cul.left;
                }
                //right
                if(cul.right != null){
                    if(pren != null) pren.next = cul.right;
                    else head = cul.right;
                    pren = cul.right;
                }
                //move
                cul = cul.next;
            }
            //move to next level
            cul = head;
            // clean
            head = null; pren = null;
        }
    }
    
    
}
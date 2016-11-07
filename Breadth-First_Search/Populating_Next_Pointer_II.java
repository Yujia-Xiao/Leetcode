/*
117. Populating Next Right Pointers in Each Node II  QuestionEditorial Solution  My Submissions
Total Accepted: 70017
Total Submissions: 211410
Difficulty: Hard
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
Hide Company Tags Microsoft Bloomberg Facebook
Hide Tags Tree Depth-first Search
Hide Similar Problems (M) Populating Next Right Pointers in Each Node
*/

public class Solution {

    public void connect(TreeLinkNode root) {
        TreeLinkNode head=root;//The left most node in the lower level
        TreeLinkNode prev=null;//The previous node in the lower level
        TreeLinkNode curr=null;//The current node in the upper level
        while (head!=null){
            curr=head;
            prev=null;
            head=null;
            while (curr!=null){
                if (curr.left!=null){
                    if (prev!=null)
                        prev.next=curr.left;
                    else 
                        head=curr.left;
                    prev=curr.left;
                }
                if (curr.right!=null){
                    if (prev!=null)
                        prev.next=curr.right;
                    else 
                        head=curr.right;
                    prev=curr.right;
                }
                curr=curr.next;
            }
        }
    }
}


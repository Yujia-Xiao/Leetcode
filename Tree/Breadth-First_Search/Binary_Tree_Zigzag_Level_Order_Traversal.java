/*
Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
Hide Company Tags LinkedIn Bloomberg Microsoft
Hide Tags Tree Breadth-first Search Stack
Hide Similar Problems (E) Binary Tree Level Order Traversal
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root==null)return ans;
        int level=0; //0 - l to r; 1- r to l
        Queue<TreeNode> lr = new LinkedList<TreeNode>();
        Queue<TreeNode> rl = new LinkedList<TreeNode>();
        lr.add(root);
        while(lr.peek()!=null || rl.peek()!=null){
            List<Integer> list = new LinkedList<Integer>(); // each level has one answer to add
            if(level==0){
                while(lr.peek()!=null){
                    TreeNode n = lr.poll();
                    if(n.left!=null)rl.add(n.left);
                    if(n.right!=null)rl.add(n.right);
                    list.add(n.val);
                }
                if(list==null || list.size()==0)return ans;
                ans.add(list);
                level=1;
                continue;
            }
            if(level==1){
                while(rl.peek()!=null){
                    TreeNode n = rl.poll();
                    if(n.left!=null)lr.add(n.left);
                    if(n.right!=null)lr.add(n.right);
                    list.add(0,n.val);
                }
                if(list==null || list.size()==0)return ans;
                ans.add(list);
                level=0;
                continue;
            }
        }
        return ans;
    }
}


// 07/05/2018
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ans = new LinkedList<List<Integer>>();
       
        if(root == null) return ans;
        
        Queue<TreeNode> queueL = new LinkedList<TreeNode>();
        Queue<TreeNode> queueR = new LinkedList<TreeNode>();
        
        List<Integer> level = new LinkedList<Integer>();
        
        TreeNode node = new TreeNode(0);
        
        queueL.offer(root);
        boolean left = true; // which queue has value
        while(!queueL.isEmpty() || !queueR.isEmpty()){
            if(left){
                while(!queueL.isEmpty()){
                    node = queueL.poll(); 
                    level.add(node.val);
                    if(node.left!=null)queueR.offer(node.left);
                    if(node.right!=null)queueR.offer(node.right);
                }
                ans.add(new LinkedList<Integer>(level));
                level = new LinkedList<Integer>();
                left = false;
            }
            else{
                while(!queueR.isEmpty()){
                    node = queueR.poll(); 
                    level.add(0, node.val);
                    if(node.left!=null)queueL.offer(node.left);
                    if(node.right!=null)queueL.offer(node.right);
                }
                ans.add(new LinkedList<Integer>(level));
                level = new LinkedList<Integer>();
                left = true;
            }
        }
        return ans;
    }
}
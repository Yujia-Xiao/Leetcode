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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
       
        if(root == null) return ans;
        
        Queue<TreeNode> queueL = new LinkedList<TreeNode>();
        Queue<TreeNode> queueR = new LinkedList<TreeNode>();
        
        List<Integer> level = new LinkedList<Integer>();
        
        TreeNode node = new TreeNode(0);
        
        queueL.offer(root);
        boolean left = true; // which queue has value
        
        while(!queueL.isEmpty() || !queueR.isEmpty())
        {
            if(left)
            {
                while(!queueL.isEmpty())
                {
                    node = queueL.poll(); 
                    level.add(node.val);
                    if(node.left!=null)queueR.offer(node.left);
                    if(node.right!=null)queueR.offer(node.right);
                }
                ans.add(0, new LinkedList<Integer>(level));
                level = new LinkedList<Integer>();
                left = false;
            }
            else
            {
                while(!queueR.isEmpty())
                {
                    node = queueR.poll(); 
                    level.add(node.val);
                    if(node.left!=null)queueL.offer(node.left);
                    if(node.right!=null)queueL.offer(node.right);
                }
                ans.add(0, new LinkedList<Integer>(level));
                level = new LinkedList<Integer>();
                left = true;
            }
        }
        return ans;
    
    }
}
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        
        TreeNode pre = null;
        TreeNode cul = root;
        
        while(!stack.isEmpty() || cul!= null){
            // go deep to the left
            while(cul != null){
                stack.push(cul);
                cul = cul.left;
            }
            // pop out the middel
            cul = stack.pop();
            if(pre!=null && pre.val == p.val)return cul;
            pre = cul;
            
            //go to right
            cul = cul.right;
            
        };
        
        return null;
        
    }
}
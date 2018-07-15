/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
class Solution {
    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int val = 0;
        // Iteration
        while(root != null){
            System.out.println(min);
            if(Math.abs(target - root.val) < min ) {
                min = Math.abs(target - root.val);
                val = root.val;
                System.out.println(val);
            }
            if(root.val > target) root = root.left;
            else if(root.val < target) root = root.right;
            else return root.val;
        }
        return val;
    }
}

*/

Class Solution{
    public int closestValue(TreeNode root, double target) {
        // Recursive
        
    }
}
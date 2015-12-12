/*
Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

Hide Company Tags Amazon LinkedIn Uber Facebook
Hide Tags Tree Breadth-first Search
Hide Similar Problems (M) Binary Tree Zigzag Level Order Traversal (E) Binary Tree Level Order Traversal II (E) Minimum Depth of Binary Tree (M) Binary Tree Vertical Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> eachLevel = new ArrayList<Integer>();
        if(root==null)return ans;
        
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
        
        while(!current.isEmpty()){
            TreeNode node = current.remove();
            if(node.left!=null){next.add(node.left);}
            if(node.right!=null){next.add(node.right);}
            eachLevel.add(node.val);
            if(current.isEmpty()){
                current=next;
                next = new LinkedList<TreeNode>();
                ans.add(eachLevel);
                eachLevel = new ArrayList<Integer>();
            }
        }
        
        return ans;
    }
}

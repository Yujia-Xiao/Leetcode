/*
Binary Tree Vertical Order Traversal 
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]
Hide Company Tags Facebook
Hide Tags Hash Table
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null)return ans;
        int min=0; int max=0;
        //level order traversal -> BFS
        Map<Integer,List<Integer>> temp = new HashMap<Integer,List<Integer>>();
        Queue<TreeNode> node = new LinkedList<TreeNode>();//keep the same step
        Queue<Integer> col = new LinkedList<Integer>();
        node.offer(root);col.offer(0);
        while(!node.isEmpty()){
            TreeNode n = node.poll();
            int c = col.poll();
            if(!temp.containsKey(c))temp.put(c,new LinkedList<Integer>());
            temp.get(c).add(n.val);
            if(n.left!=null){
                node.offer(n.left);
                col.offer(c-1);
                if(min>c-1)min=c-1;
            }
            if(n.right!=null){
                node.offer(n.right);
                col.offer(c+1);
                if(max<c+1)max=c+1;
            }
        }
        for(int i=min;i<=max;i++)ans.add(temp.get(i));
        return ans;

    }
}
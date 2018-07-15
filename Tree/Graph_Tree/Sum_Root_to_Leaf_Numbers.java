/*
Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

Hide Tags Tree Depth-first Search
Hide Similar Problems (E) Path Sum (H) Binary Tree Maximum Path Sum
*/
public class Solution{
	public int sumNumbers(TreeNode root){
		int sum=0;
		int finalNum=0;
		sum=dfs(root,finalNum,sum);
		return sum;
	}

	public int dfs(TreeNode root, int finalNum, int sum){
		if(root==null)return sum;
		finalNum=finalNum*10+root.val;
		if(root.left==null && root.right==null){
			sum+=finalNum;
			return sum;
		}
		sum=dfs(root.left, finalNum, sum)+dfs(root.right,finalNum,sum);
		return sum;
	}
}

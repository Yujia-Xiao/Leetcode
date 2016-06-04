/*
128. Longest Consecutive Sequence My Submissions QuestionEditorial Solution
Total Accepted: 66803 Total Submissions: 205010 Difficulty: Hard
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Hide Company Tags Google Facebook
Hide Tags Array Union Find
Hide Similar Problems (M) Binary Tree Longest Consecutive Sequence
*/
public class Solution {
    public class TreeNode{
        public TreeNode parent;
        public int rank;
        
        public TreeNode(int r){
            rank=r;
            parent=this;
        }
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1)return nums.length;
        Map<Integer,TreeNode>map = new HashMap<Integer,TreeNode>();
        int ans = 1;
        for(int i:nums){
            if(!map.containsKey(i))map.put(i,new TreeNode(1));
        }
        for(int i:nums){
            int rank = 1;
            if(map.containsKey(i+1)){
                rank=union(map.get(i),map.get(i+1));}
            if(map.containsKey(i-1)){
                rank=union(map.get(i),map.get(i-1));}
            //TreeNode h = find(map.get(i));
            ans = Math.max(ans,rank);   
        }
        return ans;
    }

    public int union(TreeNode a, TreeNode b){
        TreeNode repreA = find(a);
        TreeNode repreB = find(b);
        int rankA = repreA.rank;
        int rankB = repreB.rank;
        if(repreA==repreB)return rankA;
        if(rankA<rankB){
            repreA.rank+=rankB;
            repreB.parent=repreA;
            return repreA.rank;
        }
        else{
            repreB.rank+=rankA;
            repreA.parent=repreB;
            return repreB.rank;
        }
    }
    
    public TreeNode find(TreeNode a){
        if(a.parent!=a)a.parent=find(a.parent);
        return a.parent;
    }
}

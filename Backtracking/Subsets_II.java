/*
Subsets II My Submissions QuestionEditorial Solution
Total Accepted: 70326 Total Submissions: 226375 Difficulty: Medium
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Hide Company Tags Facebook
Hide Tags Array Backtracking
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        boolean[] dp = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(ans,new LinkedList<Integer>(),nums,0,dp);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> temList, int[] nums, int start,boolean[] dp){
        ans.add(new LinkedList<Integer>(temList));//[];
        for(int i=start;i<nums.length;i++){
            dp[i]=false;
            if(i>0 && nums[i-1]==nums[i] && dp[i-1]){dp[i]=true;continue;}
            temList.add(nums[i]);
            backtrack(ans,new LinkedList<Integer>(temList),nums,i+1,dp);
            temList.remove(temList.size()-1);
            dp[i]=true;
        }
    }
}
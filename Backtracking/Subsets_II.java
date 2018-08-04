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


//8/1/2018
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        nums: {1,6,7,22,4} duplicates: all distinct combinations, size:0-nums.length
        backtracking with duplicate filtering algorithm
            - Sort nums
            - if nums[i]==nums[i-1] and nums[i-1] is not taken(means position i-1 already finished) --> do not have to see position i
        */
        
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(nums==null || nums.length==0)return ans;
        Arrays.sort(nums);
        backtracking(ans,new LinkedList<Integer>(), 0, nums,new boolean[nums.length]);
        return ans;
    }
    
    public void backtracking(List<List<Integer>> ans, List<Integer> tem, int index, int[] nums, boolean[] state){
        ans.add(new LinkedList<Integer>(tem));//no constrains for tem to be added
        //filter duplicates
        for(int i=index;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !state[i-1])continue; 
                /* 
                nums: {......, nums[i-1] (true, still in tem), ....
                tem:{ ......, nums[i-1],........}
                
                nums: {......, nums[i-1] (false, finished all combination), ....
                
                tem:{ ......, nums[i],........}
                */
            tem.add(nums[i]);state[i]=true;
            backtracking(ans,tem,i+1,nums,state);
            tem.remove(tem.size()-1);state[i]=false;
        }
        return;
    }
}
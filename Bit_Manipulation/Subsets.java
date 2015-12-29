/*
Subsets 
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Hide Company Tags Amazon Uber Facebook
Hide Tags Array Backtracking Bit Manipulation
Hide Similar Problems (M) Generalized Abbreviation
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //possiblit1ies: 2^n
        //for every possibility: create answer
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(nums==null || nums.length==0)return ans;
        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> temp = new LinkedList<Integer>();
            int possibility = i;
            for(int j=0;j<nums.length;j++){
                if((possibility&1)==1)temp.add(nums[j]);
                possibility>>=1;
            }
            Collections.sort(temp);
            ans.add(temp);
        }
        return ans;
    }
}
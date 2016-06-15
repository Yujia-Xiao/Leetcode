/*
39. Combination Sum My Submissions QuestionEditorial Solution
Total Accepted: 95889 Total Submissions: 304005 Difficulty: Medium
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
Hide Company Tags Snapchat Uber
Hide Tags Array Backtracking
Hide Similar Problems (M) Letter Combinations of a Phone Number (M) Combination Sum II (M) Combinations (M) Combination Sum III (M) Factor Combinations
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(ans,new LinkedList<Integer>(), candidates,target,0);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> temList, int[] candidates, int remain, int start){
        if(remain<0)return;
        else if(remain==0){
            ans.add(new LinkedList<Integer>(temList));}
        else{
            for(int i=start;i<candidates.length;i++){
                temList.add(candidates[i]);
                backtrack(ans,new LinkedList<Integer>(temList),candidates,remain-candidates[i],i);
                temList.remove(temList.size()-1);
            }
        }
    }
}

/*
Combination Sum II My Submissions QuestionEditorial Solution
Total Accepted: 71889 Total Submissions: 256014 Difficulty: Medium
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Hide Tags Array Backtracking
Hide Similar Problems (M) Combination Sum
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        boolean[] state = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(ans,new LinkedList<Integer>(),candidates,target,0);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> temList, int[] candidates, int remain, int start){
        if(remain<0)return;
        if(remain==0)ans.add(new LinkedList<Integer>(temList));
        else{
            for(int i=start;i<candidates.length;i++){
                if(i>start && candidates[i-1]==candidates[i]){continue;}
                temList.add(candidates[i]);
                backtrack(ans,new LinkedList<Integer>(temList),candidates,remain-candidates[i],i+1);
                temList.remove(temList.size()-1);
            }
        }
    }
}
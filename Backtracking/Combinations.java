/*
77. Combinations My Submissions QuestionEditorial Solution
Total Accepted: 78190 Total Submissions: 223494 Difficulty: Medium
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Hide Tags Backtracking
Hide Similar Problems (M) Combination Sum (M) Permutations
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        backtrack(ans,new LinkedList<Integer>(),k,n,1);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> temList, int remainNum,int n, int start){
        if(remainNum==0)ans.add(new LinkedList<Integer>(temList));
        else{
            for(int i=start;i<=n;i++){
                temList.add(i);
                backtrack(ans,new LinkedList<Integer>(temList),remainNum-1,n,i+1);
                temList.remove(temList.size()-1);
            }
        }
    }
}
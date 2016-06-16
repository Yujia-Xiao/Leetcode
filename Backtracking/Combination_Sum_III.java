/*
216. Combination Sum III My Submissions QuestionEditorial Solution
Total Accepted: 34775 Total Submissions: 94432 Difficulty: Medium
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Hide Tags Array Backtracking
Hide Similar Problems (M) Combination Sum
*/
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        backtrack(ans,new LinkedList<Integer>(), n,k,1);
        return ans;
    }
    
    public void backtrack(List<List<Integer>> ans, LinkedList<Integer> temList, int remainTarget,int remainNum, int start){
        if(remainTarget<0 || remainNum<0)return;
        if(remainTarget==0 && remainNum==0)ans.add(new LinkedList<Integer>(temList));
        else{
            for(int i=start;i<10;i++){
                temList.add(i);
                backtrack(ans,new LinkedList<Integer>(temList),remainTarget-i,remainNum-1,i+1);
                temList.remove(temList.size()-1);
            }
        }
    }
}
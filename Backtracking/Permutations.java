/*
Permutations
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

Hide Company Tags LinkedIn Microsoft
Hide Tags Backtracking
Hide Similar Problems (M) Next Permutation (M) Permutations II (M) Permutation Sequence (M) Combinations
*/
public class Solution {
   	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(nums==null || nums.length==0)return ans;
        ans.add(new LinkedList<Integer>());
        ans=backtrack(ans,0,nums);
        return ans;
    }
    public List<List<Integer>> backtrack(List<List<Integer>> ans,int index,int[] nums){
        if(index>=nums.length)return ans;
        List<List<Integer>> newAns = new LinkedList<List<Integer>>(ans);
        for(List<Integer> list: ans){
            List<Integer> temp = new LinkedList<Integer>(list);
            newAns.remove(list);
            for(int i=0;i<=list.size();i++){
                List<Integer> newTemp = new LinkedList<Integer>(temp);
                newTemp.add(i,nums[index]);
                newAns.add(newTemp);
            }  
        }
        return backtrack(newAns,index+1,nums);     
    }

}
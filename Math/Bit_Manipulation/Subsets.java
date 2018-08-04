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

// 8/1/2018
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /* {12,4,7,9,0,1} distinct number list, get all combinations.
        - std method: backtracking
        - special method: bit manipulation, since: a) full conbination b) no other constrains
            nums length 5 ----> from 00000 - 11111.   0 is not pick, 1 is pick
        */
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(nums==null || nums.length==0)return ans;
        int end = (int)Math.pow(2,nums.length)-1; // 11111
        for(int i=0; i<=end; i++){
            List<Integer> tem = new LinkedList<Integer>();
            for(int j=0;j<nums.length;j++){
                int bit = i>>j & 1; //if the j th bit is 1 or 0
                if(bit==1)tem.add(nums[j]);//if bit==1, we pick jth number
            }
            ans.add(tem);
        }
        return ans;
    }
}
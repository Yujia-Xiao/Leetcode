class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /* {12,4,7,9,0,1} distinct number list, get all combinations.
        - std method: backtracking
        - special method: bit manipulation, since: a) full conbination b) no other constrains
            nums length 5 ----> from 00000 - 11111.   0 is not pick, 1 is pick
        */
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(nums==null || nums.length==0)return ans;
        backtracking(ans, new LinkedList<Integer>(), 0, nums);
        return ans;
    }
    
    public void backtracking(List<List<Integer>> ans, List<Integer> tem, int index, int[] nums){
        // end condition
        ans.add(new LinkedList(tem));
        
        for(int j=index; j<nums.length;j++){
            tem.add(nums[j]);
            backtracking(ans,tem,j+1,nums);
            tem.remove(tem.size()-1);
        }
        
        return;
    }
}
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0;2*i<nums.length;i++){
            ans+=nums[2*i];
        }
        return ans;
    }
}
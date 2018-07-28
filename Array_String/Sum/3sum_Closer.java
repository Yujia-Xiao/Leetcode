class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int ans = 0;

        if(nums==null || nums.length<3)return ans;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            int s = i+1;
            int e = nums.length-1;
            int tem = 0;
            while(s<e){
                tem = nums[s]+nums[e];
                if(diff>Math.abs(tem+nums[i]-target)){
                    diff = Math.abs(tem+nums[i]-target);
                    ans=tem+nums[i];
                }
                if(tem+nums[i]==target)break;
                else if(tem+nums[i]<target)s++;
                else e--;
            }
        }
        return ans;
    }
}
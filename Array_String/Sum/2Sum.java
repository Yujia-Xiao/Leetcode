class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];    
        if(nums==null || nums.length==0)return ans;
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        
        return ans;
        
    }
}

//
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];    
        if(nums==null || nums.length==0)return ans;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0]=i;
                ans[1]=map.get(target-nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        
        return ans;
        
    }
}
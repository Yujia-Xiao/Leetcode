/*
Majority Element 
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags Zenefits
Hide Tags Divide and Conquer Array Bit Manipulation
Hide Similar Problems (M) Majority Element II
*/
public class Solution {
    public int majorityElement(int[] nums) {
        int threshold = nums.length/2;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i])+1>threshold)return nums[i];
                map.put(nums[i],map.get(nums[i])+1);
            }
            else {
                if(1>threshold)return nums[i];
                map.put(nums[i],1);}
        }
        return 0;
    }
}

    public int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++) 
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }

    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0)return -1;
        int ans = nums[0];int count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                ans=nums[i];
                count=1;
            }else{
                if(ans==nums[i])count++;
                else count--;
            }
        }
        if(count>0){
            count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==ans)count++;
            }
            if(count>nums.length/2)return ans;
        }
        return -1;
    } 
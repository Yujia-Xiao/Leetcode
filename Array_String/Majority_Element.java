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
/*
229. Majority Element II  QuestionEditorial Solution  My Submissions
Total Accepted: 36615
Total Submissions: 136144
Difficulty: Medium
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
Do you have a better hint? Suggest it!
Hide Company Tags Zenefits
Hide Tags Array
Hide Similar Problems (E) Majority Element
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new LinkedList<Integer>();
        if(nums==null || nums.length==0)return ans;
        if(nums.length==1){ans.add(nums[0]);return ans;}

        int can1 = -1; int count1 = 0;
        int can2 = -1; int count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==can1)count1++;
            else if(nums[i]==can2)count2++;
            else if(count1==0){
                can1=nums[i];count1=1;
            }else if(count2==0){
                can2=nums[i];count2=1;
            }else{
                count1--;count2--;
            }
        }
        
        count1=0;count2=0;
        for(int i=0;i<nums.length;i++){
            if(can1==nums[i])count1++;
            else if(can2==nums[i])count2++;
        }
        if(count1>nums.length/3)ans.add(can1);
        if(count2>nums.length/3)ans.add(can2);
        return ans;
    }
}
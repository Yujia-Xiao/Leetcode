/*
164. Maximum Gap  QuestionEditorial Solution  My Submissions
Total Accepted: 34860
Total Submissions: 127091
Difficulty: Hard
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

Credits:
Special thanks to @porker2008 for adding this problem and creating all test cases.

Hide Tags Sort
*/
public class Solution {
    public int maximumGap(int[] nums) {
        //bucket sort
        if(nums==null || nums.length<2)return 0;
        int min=nums[0],max=nums[0];
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }
        int gap=(int)Math.ceil((double)(max-min)/(nums.length-1));
        int[] Bmin = new int[nums.length-1];
        int[] Bmax = new int[nums.length-1];
        Arrays.fill(Bmin,Integer.MAX_VALUE);
        Arrays.fill(Bmax,Integer.MIN_VALUE);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==min || nums[i]==max)continue;
            int id=(nums[i]-min)/gap;
            Bmin[id]=Math.min(Bmin[id],nums[i]);
            Bmax[id]=Math.max(Bmax[id],nums[i]);
        }
        
        int maxGap=0;
        for(int i=0;i<nums.length-1;i++){
            if(Bmin[i]==Integer.MAX_VALUE && Bmax[i]==Integer.MIN_VALUE)continue;
            maxGap=Math.max(maxGap,Bmin[i]-min);
            min=Bmax[i];
        }
        //System.out.println(Bmax[0]+" "+Bmin[0]);
        //System.out.println(Bmax[1]+" "+Bmin[1]);
        maxGap=Math.max(maxGap,max-min);
        return maxGap;
    }
}
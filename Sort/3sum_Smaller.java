/*
3Sum Smaller
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]
Follow up:
Could you solve it in O(n2) runtime?

Hide Company Tags Google
Hide Tags Array Two Pointers
Hide Similar Problems (M) 3Sum (M) 3Sum Closest
*/
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        //find all different range (l,imax,h),where l<imax<h; ans=sigma(imax-l)
        int ans = 0;
        if(nums == null || nums.length<3){return ans;}
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length-3; i++) {
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi) {
                if(nums[i] + nums[lo] + nums[hi] < target) {
                    ans += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }        
        return ans;
    }
}
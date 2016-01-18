/*
Minimum Size Subarray Sum 
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Hide Company Tags Facebook
Hide Tags Array Two Pointers Binary Search
Hide Similar Problems (H) Minimum Window Substring (E) Maximum Size Subarray Sum Equals k
*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int[] sum = new int[nums.length];
        int left=0; int minLength = 0; int cuLength = 0;
        int cSum = 0;
        for(int i=0;i<nums.length;i++){
            cSum+=nums[i];
            sum[i]=(i==0)?nums[i]:sum[i-1]+nums[i];
            if(cSum>=s){
                cuLength=i-left+1;
                while(left<=i && sum[i]-sum[left]>=s){
                    cSum=sum[i]-sum[left];
                    left++;
                    cuLength--;
                }
                if(minLength==0 || cuLength<minLength)minLength=cuLength;
                
            }
        }
        return minLength;
    }
}
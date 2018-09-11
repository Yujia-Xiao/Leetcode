/*
Maximum Size Subarray Sum Equals k My Submissions QuestionEditorial Solution
Total Accepted: 6826 Total Submissions: 17103 Difficulty: Easy
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

Hide Company Tags Palantir Facebook
Hide Tags Hash Table
Hide Similar Problems (M) Minimum Size Subarray Sum (E) Range Sum Query - Immutable
*/
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        int[] cul = new int[nums.length+1];cul[0]=0;
        for(int i=1;i<nums.length+1;i++){
            cul[i]=cul[i-1]+nums[i-1];
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,0);
        for(int i=1;i<nums.length+1;i++){
            map.put(cul[i],i);
        }
        for(int left=0;left<nums.length;left++){
            if(map.containsKey(cul[left]+k))
                max=Math.max(max,map.get(cul[left]+k)-left);
        }
        return max;
    }
}

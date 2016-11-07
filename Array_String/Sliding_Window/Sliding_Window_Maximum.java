/*
239. Sliding Window Maximum   QuestionEditorial Solution  My Submissions
Total Accepted: 40661
Total Submissions: 133449
Difficulty: Hard
Contributors: Admin
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window’s size.
Remove redundant elements and the queue should store only elements that need to be considered.
Hide Company Tags Amazon Google Zenefits
Hide Tags Heap
Hide Similar Problems (H) Minimum Window Substring (E) Min Stack (H) Longest Substring with At Most Two Distinct Characters (H) Paint House II
*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k<1 || nums.length<k)return new int[0];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] ans = new int[nums.length-k+1];
        
        for(int i=0;i<nums.length;i++){
            if(deque.peek()!=null && deque.peek()<i-k+1)
                deque.poll();
            while(deque.peekLast()!=null && nums[deque.peekLast()]<nums[i])
                deque.pollLast();
            deque.offer(i);
            if(i>=k-1)ans[i-k+1]=nums[deque.peek()];
        }
        
        return ans;
    }
}
/*
11. Container With Most Water  QuestionEditorial Solution  My Submissions
Total Accepted: 84257
Total Submissions: 239374
Difficulty: Medium
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

Hide Company Tags Bloomberg
Hide Tags Array Two Pointers
Hide Similar Problems (H) Trapping Rain Water
*/
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
    
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
    
        return maxArea;
    }
}
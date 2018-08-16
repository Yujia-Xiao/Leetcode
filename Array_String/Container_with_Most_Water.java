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


///
class Solution {
    public int maxArea(int[] height) {
        //1. volumn is controlled by the smaller edge of the container.
        if(height==null || height.length==0)return 0;
        int max = 0;
        int s = 0;
        int e = height.length-1;
        while(s<e){
            max = Math.max(max,Math.min(height[s],height[e])*(e-s));
            if(height[s]<=height[e]){
                int temL = height[s];
                while(height[s]<=temL && s<e)s++;
            }else{
                int temL = height[e];
                while(height[e]<=temL && s<e)e--;
            }
        }
        return max;
    }
}
/*
84. Largest Rectangle in Histogram  QuestionEditorial Solution  My Submissions
Total Accepted: 71046
Total Submissions: 282380
Difficulty: Hard
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

Hide Tags Array Stack
Hide Similar Problems (H) Maximal Rectangle
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
       if(height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            //System.out.print(i+"::");
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
                //System.out.println(i+":");
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                //System.out.println(i+": "+maxArea);
                i--;
            }
        }
        return maxArea; 
    }
}
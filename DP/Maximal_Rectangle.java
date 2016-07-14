/*
Maximal Rectangle  QuestionEditorial Solution  My Submissions
Total Accepted: 45201
Total Submissions: 188673
Difficulty: Hard
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

Hide Company Tags Facebook
Hide Tags Array Hash Table Stack Dynamic Programming
Hide Similar Problems (H) Largest Rectangle in Histogram (M) Maximal Square
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)return 0;
        int[] h = new int[matrix[0].length];
        
        int max=0;
        for(int i=0;i<matrix.length;i++){
            getHight(h,matrix,i);
            max=Math.max(max,getMaxS(h));
        }
        return max;
    }
    
    public void getHight(int[] h, char[][] matrix, int index){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[index][i]=='1')h[i]+=1;
            else h[i]=0;
        }
    }
    
    public int getMaxS(int[] height){
        
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
        /*
        int max=0;
        System.out.println("OK----------------");
        Stack<Integer> DiffH = new Stack<Integer>();
        for(int i=0;i<=h.length;i++){
            int culHeight = (i==h.length)?0:h[i];
            System.out.println("OK:"+culHeight);
            if(!DiffH.isEmpty() && h[DiffH.peek()]>culHeight){
                while(!DiffH.isEmpty() && h[DiffH.peek()]>culHeight){
                    int tem = DiffH.pop();
                    System.out.println(tem);
                    max=Math.max(max,h[tem]*(i-tem));
                    if(i<h.length)max=Math.max(max,h[i]*(i-tem+1));
                }
            }
            else if(!DiffH.isEmpty() && h[DiffH.peek()]<culHeight){
                DiffH.push(i);
            }
            else{
                DiffH.push(i);
            }
        }
        return max;
        */
    }
}
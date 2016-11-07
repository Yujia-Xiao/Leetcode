/*
73. Set Matrix Zeroes   QuestionEditorial Solution  My Submissions
Total Accepted: 81821
Total Submissions: 235535
Difficulty: Medium
Contributors: Admin
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Hide Company Tags Microsoft Amazon
Hide Tags Array
Hide Similar Problems (M) Game of Life
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)return;
        int row0 = -1;

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0)row0=0;
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=1;j--){
                if(matrix[0][j]==0 || matrix[i][0]==0)matrix[i][j]=0;
            }
            if(row0==0)matrix[i][0]=0;
        }
    }
}
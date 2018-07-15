/*
Search a 2D Matrix II My Submissions Question
Total Accepted: 21037 Total Submissions: 67556 Difficulty: Medium
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

Hide Company Tags Google
Hide Tags Divide and Conquer Binary Search
Hide Similar Problems (M) Search a 2D Matrix
*/
public class Solution {
    private int[][] Arr;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.Arr=matrix;
        int n = Arr[0].length-1;//# of colums
        int m = Arr.length-1;//# of rows
        int maxsize = Math.max(n,m);
        for(int i=0;i<=maxsize;i++){
            int j = 0;
            while(j<i){
                if(i<=m && j<=n){if(matrix[i][j] == target){return true;}}
                if(j<=m && i<=n){if(matrix[j][i] == target){return true;}}
                j++;
            }
            
            if(i<=n && i<=m){if(matrix[i][i] == target){return true;}}
            else if(i>n && i<=m){if(matrix[i][n] == target){return true;}}
            else if(i<=n && i>n){if(matrix[m][i] == target){return true;}}
            else if(i>n && i>m){if(matrix[m][n] == target){return true;}}   
        }       
        return false;
    }    
}
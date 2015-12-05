/*
Search a 2D Matrix My Submissions Question
Total Accepted: 62745 Total Submissions: 193029 Difficulty: Medium
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

Hide Tags Array Binary Search
Hide Similar Problems (M) Search a 2D Matrix II
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //implement two binary search
        int startRow=0; int endRow=matrix.length-1; 
        int middleRow = 0;
        int Row=0;
        while(startRow<=endRow){
            middleRow = (startRow+endRow)/2;
            if(matrix[middleRow][0]==target){return true;}
            else if(matrix[middleRow][0]>target){endRow=middleRow-1;}
            else{startRow=middleRow+1;}
        }
        if(startRow==0){return false;}
        Row=startRow-1;       
        int startColumn=0; int endColumn=matrix[Row].length-1;
        int middleColumn=(startColumn+endColumn)/2;
        while(startColumn<=endColumn){
            middleColumn=(startColumn+endColumn)/2;
            if(matrix[Row][middleColumn]==target){return true;}
            else if(matrix[Row][middleColumn]>target){endColumn=middleColumn-1;}
            else{startColumn=middleColumn+1;}
        }
        return false;
        
    }
}
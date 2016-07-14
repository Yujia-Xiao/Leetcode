/*
64. Minimum Path Sum  QuestionEditorial Solution  My Submissions
Total Accepted: 76771
Total Submissions: 215508
Difficulty: Medium
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Unique Paths (H) Dungeon Game
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;// row
        int n = grid[0].length; // column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                            + grid[i][j];
                }
            }
        }
    
        return grid[m - 1][n - 1];    
    }
}
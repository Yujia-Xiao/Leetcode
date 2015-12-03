/*
Number of Islands 
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Hide Company Tags Amazon Google Facebook Zenefits
Hide Tags Depth-first Search Breadth-first Search Union Find
Hide Similar Problems (M) Surrounded Regions (M) Walls and Gates (H) Number of Islands II
*/
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int numIsland = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    numIsland++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    private void dfs(char[][] grid, int i, int j){
        grid[i][j] = '2'; // mark as visited

        if (i > 0 && grid[i-1][j] == '1') dfs(grid, i-1, j);
        if ((i < grid.length - 1) && grid[i + 1][j] == '1') dfs(grid, i+1, j);
        if (j > 0 && grid[i][j-1] == '1') dfs(grid, i, j-1);
        if ((j < grid[0].length - 1) && grid[i][j+1] == '1') dfs(grid, i, j + 1);
    }
}
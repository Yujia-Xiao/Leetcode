
class Solution {
    public int numIslands(char[][] grid) {
        // start a dfs when encounter '1'. visit adjacent, and mark them as visited (-1)
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ans ++;
                    /*
                    for(int a =0;a<grid.length;a++){
            
                        for(int b =0; b<grid[a].length;b++){
                            System.out.print(grid[a][b]);
                        }
                        System.out.println();
                    } */
        
                }
            }
        }
        return ans;
    }
    
    public void dfs(char[][] grid, int i, int j){
        grid[i][j] = '2';
        if(i > 0 && grid[i-1][j] == '1') dfs(grid, i-1, j);
        if(j < grid[i].length - 1 && grid[i][j+1] == '1') dfs(grid, i, j+1);
        if(i < grid.length - 1 && grid[i+1][j] == '1') dfs(grid, i+1, j);
        if(j > 0 && grid[i][j-1] == '1') dfs(grid, i, j-1);
        return;
    }
}
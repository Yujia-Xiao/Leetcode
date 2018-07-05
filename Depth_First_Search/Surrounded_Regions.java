class Solution {
    public void solve(char[][] board) {
        // start a dfs from boarder, flip O into A
        // then do dfs again, flip O to X
        // flip A back to O
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        for(int a =0;a<board.length;a++){
            for(int b =0; b<board[a].length;b++){
                System.out.print(board[a][b]);
            }
            System.out.println();
        }
        System.out.println();
        
        for(int i = 0 ; i < board.length ; i++){
            if(board[i][0] == 'O')dfs(board, i, 0, 'A');
            if(board[i][board[0].length-1] == 'O') dfs(board, i, board[0].length-1, 'A');
        }
     
        for(int j = 0 ; j < board[0].length ; j++){
            if(board[0][j] == 'O')dfs(board, 0, j, 'A');
            if(board[board.length-1][j] == 'O') dfs(board, board.length - 1, j, 'A');
        }
        
        for(int a =0;a<board.length;a++){
            for(int b =0; b<board[a].length;b++){
                System.out.print(board[a][b]);
            }
            System.out.println();
        }
        System.out.println();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O') dfs(board, i, j, 'X');
            }
        }
        /*
        for(int a =0;a<board.length;a++){
            for(int b =0; b<board[a].length;b++){
                System.out.print(board[a][b]);
            }
            System.out.println();
        }
        System.out.println();
        */
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
        
        return;
    }
    
    public void dfs(char[][] grid, int i, int j, char ch){
        grid[i][j] = ch;
        if(i > 0 && grid[i-1][j] == 'O') dfs(grid, i-1, j, ch);
        if(j < grid[i].length - 1 && grid[i][j+1] == 'O') dfs(grid, i, j+1, ch);
        if(i < grid.length - 1 && grid[i+1][j] == 'O') dfs(grid, i+1, j, ch);
        if(j > 0 && grid[i][j-1] == 'O') dfs(grid, i, j-1, ch);
        return;
    }
}
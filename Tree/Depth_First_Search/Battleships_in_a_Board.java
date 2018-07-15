/*
419. Battleships in a Board   QuestionEditorial Solution  My Submissions
Total Accepted: 3074
Total Submissions: 5121
Difficulty: Medium
Contributors: ben65
Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is not a valid board - as battleships will always have a cell separating between them.
Your algorithm should not modify the value of the board.

Hide Company Tags Microsoft
*/
public class Solution {
    public int countBattleships(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0)return 0;
        int ans=0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X' && !visited[i][j]){
                    ans++;
                    dfs(board,visited,i,j,0);//0 for both, 1 for horizontal, 2 for vertical
                }
            }
        }
        return ans;
    }
    
    public void dfs(char[][] board, boolean[][] visited, int x, int y,int direction){
        visited[x][y]=true;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int start=0;int end=3;
        if(direction==1)end=1;
        if(direction==2)start=2;
        for(int i=start;i<=end;i++){
            int newI = x+dirs[i][0];
            int newJ = y+dirs[i][1];
            if(newI<0 || newI>=board.length || newJ<0 || newJ>=board[0].length)continue;
            if(board[newI][newJ]=='X' && !visited[newI][newJ])dfs(board,visited,newI,newJ,i/2+1);
        }
    }
}
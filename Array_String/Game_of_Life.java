/*
Game of Life 
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Company Tags Google TinyCo
Hide Tags Array
Hide Similar Problems (M) Set Matrix Zeroes
*/
public class Solution {
    public void gameOfLife(int[][] board) {
        //update at the same time --> new int[][]ans
        //8 neighbour, a. 1 live -> die b.2 or 3 live -> liv3 c.>3 live -> die d.3 live: dead->life
        //O(n^2)
        if(board==null || board.length==0){return;}
        int row = board.length;
        int column = board[0].length;
        int count = 0;
        int[][] ans = new int[row][column];
        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                count = countLiveNeighbor(r, c, board);
                if(board[r][c]==1 && count==1){ans[r][c]=0;}
                else if(board[r][c]==1 && (count==2 || count==3)){ans[r][c]=1;}
                else if(board[r][c]==1 && count>3){ans[r][c]=0;}
                else if(board[r][c]==0 && count==3){ans[r][c]=1;}
            }
        }
        for(int r=0;r<row;r++){
            for(int c=0;c<column;c++){
                board[r][c]=ans[r][c];
            }
        }
        return;
    }
    
    public int countLiveNeighbor(int r,int c, int[][]board){
        int ans = 0;
        int[][] neighbor = {
            {r+1,c-1},{r,c-1},{r-1,c-1},{r+1,c},{r-1,c},{r+1,c+1},{r,c+1},{r-1,c+1}
        };        
        for(int[] i : neighbor){
            try{
                if(board[i[0]][i[1]]==1){ans++;}
            }catch(ArrayIndexOutOfBoundsException e){}
        }
        return ans;
    }    
}
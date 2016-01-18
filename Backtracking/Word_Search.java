/*
Word Search 
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
Hide Company Tags Microsoft Bloomberg Facebook
Hide Tags Array Backtracking
Hide Similar Problems (H) Word Search II
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0)return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j]=0;
                    if(backtrack(board,i,j,word,1))return true;
                    board[i][j]=word.charAt(0);
                }
            }
        }
        return false;
    }
    
    public boolean backtrack(char[][] board, int i,int j,String word,int index){
        int n = word.length();
        if(index>n-1)return true;
        char ch = word.charAt(index);
        if(i-1>=0 && board[i-1][j]==ch){
            board[i-1][j]=0;
            if(backtrack(board,i-1,j,word,index+1))return true;
            board[i-1][j]=ch;
        }
        if(i+1<board.length && board[i+1][j]==ch){
            board[i+1][j]=0;
            if(backtrack(board,i+1,j,word,index+1))return true;
            board[i+1][j]=ch;
        }
        if(j-1>=0 && board[i][j-1]==ch){
            board[i][j-1]=0;
            if(backtrack(board,i,j-1,word,index+1))return true;
            board[i][j-1]=ch;
        }
        if(j+1<board[0].length && board[i][j+1]==ch){
            board[i][j+1]=0;
            if(backtrack(board,i,j+1,word,index+1))return true;
            board[i][j+1]=ch;
        }
        return false;
    }
}
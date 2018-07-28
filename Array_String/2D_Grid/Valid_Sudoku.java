//Sudoku Verifier
// others
        public boolean isValidSudoku(char[][] board){
                if(board.length != 9 || board[0].length != 9) return false;
                for(int i = 0; i < 9; i++){
                        boolean[] row = new boolean[10];
                        boolean[] col = new boolean[10];
                        boolean[] box = new boolean[10];
                        for(int j = 0; j < 9; j++){
                                if(!isValid(row, board[i][j]) || !isValid(col, board[j][i]) || !isValid(box, board[3 * (i/3) + (j/3)][3 *(i%3) + (j%3)])){
                                        return false;
                                }
                        }
                }
                return true;
        }
        public boolean isValid(boolean[] num, char c){
                if(c == '.') return true;
                if(c-'0' > 9) return false;
                if(num[c - '0']) return false;
                else{
                        num[c-'0'] = true;
                        return true;
                }
        }

//mine
        public boolean isValidSudoku(char[][] board){
                if(board.length != 9 || board[0].length != 9) return false;
                for(int i = 0; i < 9; i++){
                        boolean[] row = new boolean[10];
                        boolean[] col = new boolean[10];
                        boolean[] box = new boolean[10];
                        for(int j = 0; j < 9; j++){
                                if(!isValid(row, board[i][j]) || !isValid(col, board[j][i]) || !isValid(box, board[3 * (i/3) + (j/3)][3 *(i%3) + (j%3)])){
                                        return false;
                                }
                        }
                }
                return true;
        }
        public boolean isValid(boolean[] num, char c){
                //if(c == '.') return true;
                if(c-'0' > 9 || c-'0'<0) return false;
                if(num[c - '0']) return false;
                else{
                        num[c-'0'] = true;
                        return true;
                }
        }

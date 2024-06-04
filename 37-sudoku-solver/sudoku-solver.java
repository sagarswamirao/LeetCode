class Solution {
    public void solveSudoku(char[][] board) {
        computeSudoku(board);
    }

    public boolean computeSudoku(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.'){
                    for(char val='1';val<='9';val++){
                        if(validateIfPlacable(board, i, j, val)){
                            board[i][j]= val;
                            if(computeSudoku(board)){
                                return true;
                            }else{
                                board[i][j]= '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateIfPlacable(char[][] board,int i, int j,char value){
        int row_tile= Math.floorDiv(i, 3);
        int col_tile= Math.floorDiv(j, 3);

        for(int ti=0;ti<board.length;ti++){
            if(board[ti][j]==value){
                return false;
            }
            if(board[i][ti]==value){
                return false;
            }

            if(board[3*row_tile + (ti/3)][3*col_tile + (ti%3)]==value){
                return false;
            }
        }
        return true;
    }
}
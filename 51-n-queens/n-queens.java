class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] board=new int[n][n];
        List<List<String>> boardAns=new ArrayList<>();
        compute(board, 0, n, boardAns, new int[n],new int[(2*n -1)],new int[(2*n -1)]);
        return boardAns;
    }

    public void compute(int[][] board, int i, int n, List<List<String>> boardAns, int[] columnHash, int[] urHash, int[] ulHash){
        if(i==n){
           List<String> tempS=new ArrayList<>();
            for(int bi=0;bi<n;bi++){
                StringBuilder sb=new StringBuilder();
                for(int bj=0;bj<n;bj++){
                    if(board[bi][bj]==1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                tempS.add(sb.toString());          
            }
            boardAns.add(tempS);
            return;
        }
        for(int tj=0;tj<n;tj++){
            if(validate(board, i, tj, n, columnHash, urHash, ulHash)){
                board[i][tj]=1;
                setHashes(i, tj, n, columnHash, urHash, ulHash, 1);
                compute(board, i+1, n, boardAns, columnHash, urHash, ulHash);
                setHashes(i, tj, n, columnHash, urHash, ulHash, 0);
                board[i][tj]=0;
            }
        }
    }

    public void setHashes(int i, int j, int n, int[] columnHash, int[] urHash, int[] ulHash, int value){
        columnHash[j]=value;
        urHash[i+j]=value;
        ulHash[(n-1)+(j-i)]=value;
    } 

    public boolean validate(int[][] board, int i, int j, int n, int[] columnHash, int[] urHash, int[] ulHash){
        if(columnHash[j]==1){
            return false;
        }

         if(urHash[i+j]==1){
            return false;
        }

        if(ulHash[(n-1)+(j-i)]==1){
            return false;
        }

        return true;
    }       
 
}
// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         int[][] board=new int[n][n];
//         List<List<String>> boardAns=new ArrayList<>();
//         compute(board, 0, n, boardAns);
//         return boardAns;
//     }

//     public void compute(int[][] board, int i, int n, List<List<String>> boardAns){
//         if(i==n){
//            List<String> tempS=new ArrayList<>();
//             for(int bi=0;bi<n;bi++){
//                 StringBuilder sb=new StringBuilder();
//                 for(int bj=0;bj<n;bj++){
//                     if(board[bi][bj]==1){
//                         sb.append("Q");
//                     }else{
//                         sb.append(".");
//                     }
//                 }
//                 tempS.add(sb.toString());          
//             }
//             boardAns.add(tempS);
//             return;
//         }
//         for(int tj=0;tj<n;tj++){
//             if(validate(board, i, tj, n, n)){
//                 board[i][tj]=1;
//                 compute(board, i+1, n, boardAns);
//                 board[i][tj]=0;
//             }
//         }
//     }
//     public boolean validate(int[][] board, int i, int j, int row, int column){
//         //move diagonally top and bottom
//         //move vertically and horizontally

//         //COLUMNS of the row
//         for(int temp_j=0;temp_j<column;temp_j++){
//             if(board[i][temp_j]==1){
//                 return false;
//             }
//         }
//         // ROWS of the column
//         for(int temp_i=0;temp_i<i;temp_i++){
//             if(board[temp_i][j]==1){
//                 return false;
//             }
//         }

//         // DIAGONAL UP LEFT
//         int x_i=i,x_j=j;
//         while(x_i>=0 && x_j>=0){
//             if(board[x_i][x_j]==1){
//                 return false;
//             }
//             x_i--;
//             x_j--;
//         }

//         // DIAGONAL UP RIGHT
//         x_i=i;
//         x_j=j;
//         while(x_i>=0 && x_j<column){
//             if(board[x_i][x_j]==1){
//                 return false;
//             }
//             x_i--;
//             x_j++;
//         }

//         // NO NEED TO USE IT AS WE ARE GOING ROW BY ROW, AND WE UNDERSTAND THAT LOWER LEVELS WON'T YET HAVE ANY QUEEN
//         //BOTTOM RIGHT
//         // x_i=i;
//         // x_j=j;
//         // while(x_i<row && x_j<column){
//         //     if(board[x_i][x_j]==1){
//         //         return false;
//         //     }
//         //     x_i++;
//         //     x_j++;
//         // }

//         // BOTTOM LEFT 
//         // x_i=i;
//         // x_j=j;
//         // while(x_i<row && x_j>=0){
//         //     if(board[x_i][x_j]==1){
//         //         return false;
//         //     }
//         //     x_i++;
//         //     x_j--;
//         // }



//         return true;
//     }
// }
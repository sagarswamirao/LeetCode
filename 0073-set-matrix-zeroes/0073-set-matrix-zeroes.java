class Solution {
    public void setZeroes(int[][] matrix) {
        int row0var=1;
        int col0var=1;

        // check through each cell, and mark 0th columns of that row as 0 and 0th row of that column. If r==0 or c==0, then set row_val & col_val to 0
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    
                    if(i==0){
                        row0var=0;
                    }else{
                       matrix[i][0]=0;
                    }

                    if(j==0){
                        col0var=0;
                    }else{
                       matrix[0][j]=0;
                    }
                }
            }
        }
        // now lets mark the cells in range(1,n) as 0, if grid[r][0] or grid[0][c]
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        // if the row0var is 0, then set grid[0][c] to 0
        if(row0var==0){
            for(int j=0;j<matrix[0].length;j++){
                    matrix[0][j]=0;
            }
        }
        // if the col0var is 0, then set grid[0][c] to 0
        if(col0var==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}
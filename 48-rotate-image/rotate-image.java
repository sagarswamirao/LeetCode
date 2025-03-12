class Solution {
    public void rotate(int[][] matrix) {
        //transpose
        transpose(matrix);
        //reverse each row
        for(int i=0;i<matrix.length;i++){
            int left=0;
            int right=matrix[i].length-1;
            while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
    }
    public static void transpose(int[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=i+1;j<cols;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix,target);
    }

    public boolean search(int[][] matrix, int target) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        int left=0,right=rows * columns -1;
        while(left<=right){
            int mid=(right-left)+left/2;
            int mid_row=mid/columns;
            int mid_col=mid%columns;
            if(target>matrix[mid_row][mid_col]){
                left=mid+1;
            }else if(target<matrix[mid_row][mid_col]){
                right=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
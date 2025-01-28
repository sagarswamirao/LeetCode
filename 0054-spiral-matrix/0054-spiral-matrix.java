class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int left=0,right=cols-1,top=0,bottom=rows-1;
        List<Integer> newList=new ArrayList<>();
        while(left<=right && top<=bottom){
            for(int j=left;j<=right;j++){
                newList.add(matrix[top][j]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                newList.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    newList.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    newList.add(matrix[i][left]);
                }
                left++;
            }
        }
        return newList;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image,sr,sc,image[sr][sc],color);
        image[sr][sc]=color;
        return image;
    }

    public void dfs(int[][] image,int sr,int sc, int initialColor, int repColor){
        int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] direction:directions){
            int nextSr=sr+direction[0];
            int nextSc=sc+direction[1];

            if(nextSr>=0 && nextSr<image.length && nextSc>=0 && nextSc<image[0].length && image[nextSr][nextSc]==initialColor && initialColor!=repColor){
                image[nextSr][nextSc]=repColor;
                dfs(image,nextSr,nextSc,initialColor,repColor);
            }
        }
    }
}
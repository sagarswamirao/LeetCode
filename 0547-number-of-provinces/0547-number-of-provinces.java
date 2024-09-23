class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[][] visited=new boolean[isConnected.length][isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1 && !visited[i][j]){
                    count+=1;
                    // visited[i][j]=true;
                    // visited[j][i]=true;
                    callRecursive(isConnected, visited, i);       
                }
            }
        }
        return count;
    }

    public void callRecursive(int[][] isConnected, boolean[][] visited, int i){
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !visited[i][j]){
                visited[i][j]=true;
                visited[j][i]=true;
                callRecursive(isConnected, visited, j);
            }
        }

    }
}
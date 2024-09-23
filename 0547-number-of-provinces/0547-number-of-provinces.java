class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                count+=1;
                callRecursive(isConnected, visited, i);       
            }
        }
        return count;
    }

    public void callRecursive(int[][] isConnected, boolean[] visited, int currNode){
        visited[currNode]=true;
        for(int neighbor=0;neighbor<isConnected.length;neighbor++){
            if(isConnected[currNode][neighbor]==1 && !visited[neighbor]){
                callRecursive(isConnected, visited, neighbor);
            }
        }
    }
}
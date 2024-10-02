class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> pQueue=new PriorityQueue<>((k1,k2)->{
            return k1[0]-k2[0];
        });
        for(int i=0;i<arr.length;i++){
            pQueue.add(new int[]{arr[i],i});
        }
        int rank=1;
        int prev=Integer.MIN_VALUE;
        while (!pQueue.isEmpty()) {
            int[] curr=pQueue.poll();
            if(prev!=curr[0]){
                arr[curr[1]]=rank;
                rank++;
            }else{
                arr[curr[1]]=rank-1;
            }   
            prev=curr[0];
        }
        return arr;
    }
}
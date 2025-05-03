class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue=new PriorityQueue<>((a,b)->b-a);
        for(int stone:stones){
            pQueue.offer(stone);
        }
        while(pQueue.size()>1){
            int y=pQueue.poll();
            int x=pQueue.poll();
            if(x==y){
                continue;
            }
            pQueue.offer(y-x);
        }
        return pQueue.size()==1? pQueue.poll() : 0;
    }
}
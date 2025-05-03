class KthLargest {
    private PriorityQueue<Integer> pQueue;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.pQueue=new PriorityQueue<>();
        this.k=k;
        for(int num:nums){
            this.add(num);
        }
    }
    
    public int add(int val) {
        this.pQueue.offer(val);
        if(this.pQueue.size()>k){
            this.pQueue.poll();
        }
        return this.pQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
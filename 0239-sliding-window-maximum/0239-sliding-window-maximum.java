class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        int[] ans=new int[nums.length-k+1];
        for(int right=0;right<nums.length;right++){
            //if next element is <= current element inserted; then add;
            //else remove from begining until next element is higher than eveything
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[right]){
                queue.pollLast();
            }
            queue.offer(right);
            if(right-queue.peekFirst()>=k){
                queue.poll();
            }
            if(right>=k-1){
                ans[right-k+1]=nums[queue.peekFirst()];
            }
        }

        return ans;
    }
}
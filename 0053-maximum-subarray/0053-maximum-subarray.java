class Solution {
    public int maxSubArray(int[] nums) {
        //reset to new subarray upon curr_sum<=0
        int curr_sum=0,maximum_sum=nums[0];
        for(int i=0;i<nums.length;i++){
            if(curr_sum<=0){
                curr_sum=0;
            }
            curr_sum+=nums[i];
            maximum_sum=Math.max(maximum_sum, curr_sum);
        }
        return maximum_sum;
    }
}
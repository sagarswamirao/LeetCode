class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_sum=0, min_sum=0, curr_sum=0;
        for(int num:nums){
            if(curr_sum<0){
                curr_sum=0;
            }
            curr_sum+=num;
            max_sum=Math.max(max_sum, curr_sum);
        }
        curr_sum=0;
        for(int num:nums){
            if(curr_sum>0){
                curr_sum=0;
            }
            curr_sum+=num;
            min_sum=Math.min(min_sum, curr_sum);
        }
        return Math.max(max_sum,-min_sum);
    }
}
class Solution {
    public int[] runningSum(int[] nums) {
        int[] alpha= new int[nums.length];
        int index=0;
        int curr_sum=0;
        for(int num:nums){
            curr_sum+=num;
            alpha[index]=curr_sum;
            index+=1;
        }
        return alpha;
    }
}
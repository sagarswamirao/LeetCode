class Solution {
    public int maximumCount(int[] nums) {
        int pos=0;
        int neg=0;
        int i=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
            if(nums[i]<0){
                neg+=1;
            }else{
                break;
            }
        }
        pos=nums.length-(i);
        return Math.max(pos, neg);
    }
}
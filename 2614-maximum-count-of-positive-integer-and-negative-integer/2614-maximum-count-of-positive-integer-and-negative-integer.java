class Solution {
    public int maximumCount(int[] nums) {
        int pos=0;
        int neg=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
            if(nums[i]<0){
                neg+=1;
            }else{
                pos+=1;
            }
        }
        return Math.max(pos, neg);

    }
}
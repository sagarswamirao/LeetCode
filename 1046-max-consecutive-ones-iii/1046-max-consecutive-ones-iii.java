class Solution {
    public int longestOnes(int[] nums, int k) {
        int max_len=0;
        
        int count=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                count+=1;
            }
            while(count>k){
                if(nums[left]==0){
                    count-=1;
                }
                left++;
            }
            max_len=Math.max(max_len,right-left+1);
        }
        return max_len;
    }
}
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length-1;
        if(nums[0]<nums[n]){
            return nums[0];
        }

        int l=0, r=n;
        int ans=Integer.MAX_VALUE;;
        while(l<=r){
            int mid= l + (r-l)/2;
            if(nums[mid]>nums[r]){ //use condition such that the target is on right part
                
                l=mid+1;
            }else{
                ans=Math.min(ans, nums[mid]);
                r=mid-1;
            }
        }
        return ans;
    }
}
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length-1;
        if(nums[0]<nums[n]){
            return nums[0];
        }

        int l=0, r=n;

        while(l<r){
            int mid= l + (r-l)/2;
            if(nums[mid]<nums[0]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];
    }
}
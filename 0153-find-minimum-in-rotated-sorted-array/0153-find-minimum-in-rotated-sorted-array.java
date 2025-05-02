class Solution {
    public int findMin(int[] nums) {
        int n=nums.length-1;
        if(nums[0]<nums[n]){
            return nums[0];
        }

        int low=0, high=n;
        while(low<high){
            int mid=low + (high-low)/2;
            if(nums[mid]>nums[high]){
                // we for sure knwo that smallest is on the right side
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return nums[low];

    }
}
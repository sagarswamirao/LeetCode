class Solution {
    public int maximumCount1(int[] nums) {
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
        pos=nums.length-i;
        return Math.max(pos, neg);
    }
    
    // Helper to find the first index of positive number
    private int firstPositive(int[] nums) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= 0) {
                low = mid + 1; // move right if mid is zero or negative
            } else {
                high = mid; // mid could be our answer, move left
            }
        }
        return low;
    }

    // Helper to find the last index of negative number
    private int lastNegative(int[] nums) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < 0) {
                low = mid + 1; // move right to find last negative
            } else {
                high = mid; // mid is zero or positive, move left
            }
        }
        return low - 1; // adjust because loop stops at first non-negative
    }

    public int maximumCount(int[] nums) {
        int posCount = nums.length - firstPositive(nums);
        int negCount = lastNegative(nums) + 1;
        return Math.max(posCount, negCount);
    }


}
class Solution {
    public void nextPermutation(int[] nums) {
        int brk_idx=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>=nums[i+1]){
                continue;
            }
            brk_idx=i;
            break;
        }
        if(brk_idx==-1){
            this.reverseArray(nums, 0, nums.length-1);
        }else{

            for(int i=nums.length-1;i>=brk_idx;i--){
                if(nums[i]>nums[brk_idx]){
                    this.swap(nums, brk_idx, i);
                    break;
                }
            }

            this.reverseArray(nums, brk_idx+1, nums.length-1);
            
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void reverseArray(int[] nums, int i, int j){
        while(i<j){
            this.swap(nums, i, j);
            i++;
            j--;
        }
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int unique_idx=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[unique_idx++]=nums[i];
            }
        }
        return unique_idx;
    }
}


























        // int new_nums_index=1;
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i] != nums[i-1]){
        //         nums[new_nums_index++]=nums[i];
        //     }
        // }
        // return new_nums_index;
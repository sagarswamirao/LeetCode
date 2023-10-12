class Solution {
    public int removeDuplicates(int[] nums) {
        int new_nums_index=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[new_nums_index]=nums[i];
                new_nums_index++;
            }
        }
        return new_nums_index;
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int insert_index=0;
        for(int num:nums){
            if(num!=val){
                nums[insert_index]=num;
                insert_index++;
            }
        }
        return insert_index;
    }
}
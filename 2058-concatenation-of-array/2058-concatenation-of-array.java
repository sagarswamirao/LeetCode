class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] new_nums=new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            new_nums[i]=nums[i];
            new_nums[nums.length+i]=nums[i];
        }
        return new_nums;
    }
}
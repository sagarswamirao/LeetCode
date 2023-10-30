class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] resultArray=new int[nums.length];
        int left=0;
        int right= n-1;
        for(int i=n-1;i>=0;i--){
            int sq;
            if(Math.abs(nums[left])<Math.abs(nums[right])){
                sq=nums[right];
                right--;
            }else{
                sq=nums[left];
                left++;
            }
            resultArray[i]=sq*sq;
        }
        return resultArray;
    }
}
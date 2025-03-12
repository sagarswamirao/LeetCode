class Solution {
    public int findDuplicate(int[] nums) {
        int ans=-1;
        //negative marking the value of indexes, and later reverting
        for(int i=0;i<nums.length;i++){
            //already marked once
            if(nums[Math.abs(nums[i])]<0){
                ans=Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i])]*=-1;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=Math.abs(nums[i]);
        }
        return ans;

    }
    // public int findDuplicate(int[] nums) {
    //     HashSet<Integer> hs=new HashSet<>();
    //     for(int num:nums){
    //         if(hs.contains(num)){
    //             return num;
    //         }else{
    //             hs.add(num);
    //         }
    //     }
    //     return -1;
    // }
}
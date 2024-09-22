class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[] {i,hm.get(target-nums[i])};
            }
            hm.put(nums[i],i);
        }
        return null;
    }
}

//Using Arrays
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] val=new int[2];
//         for(int i=0;i<nums.length;i++){
//             if(i!=nums.length-1){
//                 for(int j=i+1;j<nums.length;j++){
//                     if(nums[i]+nums[j]==target){
//                         val[0]=i;
//                         val[1]=j;
//                         return val;
//                     }
//                 }
//             }
//         }
//         return null;
//     }
// }
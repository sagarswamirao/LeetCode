class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hMap.containsKey(nums[i])){
                hMap.put(nums[i], i);
            }else{
                int value=hMap.get(nums[i]);
                if(Math.abs(value-i)<=k){
                    return true;
                }else{
                    hMap.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> hMap=new HashMap<>(){{
            put(0,1);
            }};
        int total=0;
        int curr=0;

        for(int num:nums){
            curr+=num%2;
            total+=hMap.getOrDefault(curr-k, 0);
            hMap.put(curr,hMap.getOrDefault(curr, 0)+1);
        }
        return total;
    }
}
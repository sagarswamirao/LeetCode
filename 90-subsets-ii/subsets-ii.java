class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        HashSet<List<Integer>> ans= new HashSet<>();
        Arrays.sort(nums);
        computeSubsets(nums, 0, nums.length, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }

    public void computeSubsets(int[] nums,int i, int n, List<Integer> curr_dp, HashSet<List<Integer>> ans) {
        if(i==n){
            List<Integer> tmp=new ArrayList<>(curr_dp);
            // Collections.sort(tmp);
            ans.add(tmp);
            return;
        }
        computeSubsets(nums, i+1,  n,  curr_dp,  ans);

        curr_dp.add(nums[i]);
        computeSubsets(nums, i+1,  n,  curr_dp,  ans);
        curr_dp.removeLast();
    }
}
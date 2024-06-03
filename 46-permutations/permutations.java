class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        compute(nums, 0, new ArrayList<>(), ans, new boolean[nums.length]);
        return ans;
    }

    public void compute(int[] nums, int i, List<Integer> dp, List<List<Integer>> ans,boolean[] taken){
        if(dp.size()==nums.length){
            ans.add(new ArrayList<>(dp));
            return;
        }
        for(int t=0;t<taken.length;t++){
            if(taken[t]==true) continue;
            dp.add(nums[t]);
            taken[t]=true;
            compute(nums, t,dp, ans, taken);
            taken[t]=false;
            dp.removeLast();
        }
    }
}
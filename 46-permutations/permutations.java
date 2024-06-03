class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        // compute(nums, 0, new ArrayList<>(), ans, new boolean[nums.length]);
        List<Integer> dp = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            dp.add(nums[i]);
        }
        computeSwapApproach(0, dp, ans);
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

    public void computeSwapApproach(int i, List<Integer> dp, List<List<Integer>> ans){
        if(i==dp.size()){
            ans.add(new ArrayList<>(dp));
            return;
        }
        for(int t=i;t<dp.size();t++){
            swap(dp,i,t);
            computeSwapApproach(i+1,dp, ans);
            swap(dp,i,t);
        }
    }

    public void swap(List<Integer> dp, int i, int j){
        int temp=dp.get(i);
        dp.set(i, dp.get(j));
        dp.set(j, temp);
    }
}
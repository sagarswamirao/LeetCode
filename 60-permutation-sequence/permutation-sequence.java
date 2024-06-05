class Solution {
    public String getPermutation(int n, int k) {
        char[] nums = new char[n];
        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            nums[i-1]=(char)(i + '0');
        }

        compute(0, nums, new StringBuilder(), ans, new boolean[n], k);
        return ans.getLast();
    }

    public boolean compute(int index, char[] nums, StringBuilder dp, List<String> ans, boolean[] taken, int k){
        if(index==nums.length){
            ans.add(dp.toString());
            if(k==ans.size()){
                return true;
            }
            return false;
        }

        for(int i=0;i<nums.length;i++){
            if(taken[i]==true) continue;
            dp.append(nums[i]);
            taken[i]=true;
            if(compute(index+1, nums, dp, ans, taken, k)){
                return true;
            }
            taken[i]=false;
            dp.deleteCharAt(dp.length()-1);
        }

        return false;
    }
}
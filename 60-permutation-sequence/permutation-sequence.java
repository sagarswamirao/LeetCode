class Solution {
    public String getPermutation(int n, int k) {
        char[] nums = new char[n];
        List<List<Character>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            nums[i-1]=(char)(i + '0');
        }

        compute(0, nums, new ArrayList<>(), ans, new boolean[n], k);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(ans.getLast().get(i).toString());
        }
        return sb.toString();
    }

    public boolean compute(int index, char[] nums, ArrayList<Character> dp, List<List<Character>> ans, boolean[] taken, int k){
        if(index==nums.length){
            ans.add(new ArrayList<>(dp));
            if(k==ans.size()){
                return true;
            }
            return false;
        }

        for(int i=0;i<nums.length;i++){
            if(taken[i]==true) continue;
            dp.add(nums[i]);
            taken[i]=true;
            if(compute(index+1, nums, dp, ans, taken, k)){
                return true;
            }
            taken[i]=false;
            dp.removeLast();
        }

        return false;
    }
}
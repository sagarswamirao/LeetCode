class Solution {
    //USING PARTITIONING
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums=new ArrayList<>();
        int fact=1;
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<n;i++){
            fact*=i;
            nums.add(i);
        }
        //we want n-1 fact
        // all numbers from 1 to n
        nums.add(n);

        // as we are doing it on 0 index, so we will need to find the k-1 permutation
        k-=1;
        while(true){
            // get the number in the range. As 0 indexing, we get the excess number :)
           sb.append(nums.get(k/fact));
           // the number at the index is taken, so remove it from the existing list of available nums
            nums.remove(k/fact);

            // if no available nums, then exit
            if(nums.size()==0){
                break;
            }

            // here we want the delta left over excess for the next round
            k=k% fact;
            // reducing it TO n-1 for the next round
            fact=fact/nums.size();
        }
        return sb.toString();
    }

    // METHOD 2: NORMAL WAY (RECURSION)
    public String getPermutation2(int n, int k) {
        int[] nums = new int[n];
        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            nums[i-1]=i;
        }

        compute(0, nums, new StringBuilder(), ans, new boolean[n], k);
        return ans.getLast();
    }

    public boolean compute(int index, int[] nums, StringBuilder dp, List<String> ans, boolean[] taken, int k){
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
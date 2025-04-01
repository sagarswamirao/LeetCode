
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    ans.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k])));
                    while(j<k && nums[j]==nums[j+1]){
                        j+=1;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k-=1;
                    }
                    j+=1;
                    k-=1;
                }else if(sum>0){
                    k-=1;
                }else{
                    j+=1;
                }
            }
        }
        return ans;
    }
}



 
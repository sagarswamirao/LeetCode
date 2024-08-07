class Solution {
    int count=0;
    public int climbStairs(int n) {
        int one=1, two=1;
        for(int i=n-2;i>=0;i--){
            int val=one + two;
            two=one;
            one=val;
        }
        return one;
    }

    public void climbStairsRecursively(int curr, int target){
        if(curr==target){
            count+=1;
            return;
        }
        if(curr>target){
            return;
        }
        climbStairsRecursively(curr+1, target);
        climbStairsRecursively(curr+2, target);
    }
}
class Solution {
    public int maximumWealth(int[][] accounts) {
        int high_val=0;
        for(int[] i:accounts){
            int sum=0;
            for(int j:i){
                sum+=j;
            }
            if(sum>high_val){
                high_val=sum;
            }
        }
        return high_val;
    }
}
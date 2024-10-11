class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int curr: piles){
            max = Math.max(max, curr);
        }
        int left=1,right=max;
        int min_hrs=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(computeHours(piles,mid)<=h){
                right=mid-1;
                min_hrs=Math.min(min_hrs,mid);
            }else{
                left=mid+1;
            }
        }
        return min_hrs;
    }
    public int computeHours(int[] piles, int eat_rate){
        int total=0;
        for(int i:piles){
            total+=Math.ceil((double)i/(double)eat_rate);
        }
        return total;
    }
}
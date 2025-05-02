class Solution {
    public int hammingWeight(int n) {
        int one_count=0;
        int num=n;
        while(num!=0){
            num= (num & (num-1));
            one_count+=1;
        }
        return one_count;
    }
}
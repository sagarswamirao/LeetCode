class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Long> hset=new HashSet<>();
        if(c<1){
            return true;
        }
        for(int i=1;i<=Math.sqrt(c);i++){
            long value=i*i;
            if(hset.contains(c-value) || (c%i==0 && Long.compare(i, c/i)==0) || Long.compare(value+value, c)==0){
                return true;
            }else{
                hset.add(value);
            }
        }

        return false;
    }
}
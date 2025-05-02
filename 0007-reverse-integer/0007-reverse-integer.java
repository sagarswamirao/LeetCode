class Solution {
    public int reverse(int x) {
        int number=x;
        long rev_number=0;
        while(number!=0){
            rev_number=(rev_number*10) + (number%10);
            number=number/10;
        }
        if(rev_number<Integer.MIN_VALUE || rev_number>Integer.MAX_VALUE){
            return 0;
        }else{
            return (int) rev_number;
        }
    }
}
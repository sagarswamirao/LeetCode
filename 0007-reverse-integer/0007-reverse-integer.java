class Solution {
    public int reverse(int x) {
        int number=x;
        int rev_number=0;
        while(number!=0){
            if(rev_number<Integer.MIN_VALUE/10 || rev_number>Integer.MAX_VALUE/10){
                return 0;
            }
            rev_number=(rev_number*10) + (number%10);
            number=number/10;
        }
        // else{
            return (int) rev_number;
        // }
    }
}
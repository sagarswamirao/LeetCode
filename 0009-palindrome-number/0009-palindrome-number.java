class Solution {
    public boolean isPalindrome(int x) {
        int reverse_num=0;
        int forward_num=x;
        if(forward_num<0){
            return false;
        }
        while(forward_num!=0){
            reverse_num=(reverse_num*10)+forward_num%10;
            forward_num=forward_num/10;
        }
        if(x==reverse_num){
            return true;
        }else{
            return false;
        }
    }
}
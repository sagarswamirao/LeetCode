class Solution {
    public int[] plusOne(int[] digits) {
        int carry=0;
        for(int i=digits.length-1;i>=0;i--){
            int num=digits[i]+carry;
            if(i==digits.length-1){
                num=digits[i]+1;
            }
            carry=num/10;
            digits[i]=num%10;
        }
        if(carry!=0){
            int[] new_digits=new int[digits.length+1];
            new_digits[0]=carry;
            for(int i=0;i<digits.length;i++){
                new_digits[i+1]=digits[i];
            }
            return new_digits;
        }
        return digits;
    }
}